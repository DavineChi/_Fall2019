import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Job1Mapper extends Mapper<LongWritable, Text, Text, CustomWritable> {
	
	private static final String TAB = "\t";
	
	private Text word = new Text();
	
	private String customerId;
	private int productId;
	private int zipCode;
	
	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		
		String line = value.toString();
		
		String[] valuesArray = line.split(TAB);
		
		int size = valuesArray.length;
		
		// If 7 values are found, we know this is Customers data.
		if (size == 7) {
			
			customerId = valuesArray[0];
			zipCode = Integer.parseInt(valuesArray[6]);
			
			word.set(customerId);
			context.write(word, new CustomWritable(1, zipCode));
		}
		
		// If 4 values are found, we know this is Orders data.
		else if (size == 4) {
			
			customerId = valuesArray[1];
			productId = Integer.parseInt(valuesArray[2]);
			
			word.set(customerId);
			context.write(word, new CustomWritable(2, productId));
		}
	}
}