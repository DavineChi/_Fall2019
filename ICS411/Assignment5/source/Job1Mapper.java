import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Job1Mapper extends Mapper<LongWritable, Text, IntWritable, CustomWritable> {
	
	private static final String TAB = "\t";
	
	private int customerId;
	private int productId;
	private int zipCode;
	
	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		
		String line = value.toString();
		
		String[] list = line.split(TAB);
		
		int listLength = list.length;
		
		// If 7 values are found, this is Customers data.
		if (listLength == 7) {
			
			customerId = Integer.parseInt(list[0]);   // element at index[0] in this input file
			zipCode = Integer.parseInt(list[6]);      // element at index[6] in this input file
			
			context.write(new IntWritable(customerId), new CustomWritable(1, zipCode));
		}
		
		// If 4 values are found, this is Orders data.
		else if (listLength == 4) {
			
			customerId = Integer.parseInt(list[1]);   // element at index[1] in this input file
			productId = Integer.parseInt(list[2]);    // element at index[2] in this input file
			
			context.write(new IntWritable(customerId), new CustomWritable(2, productId));
		}
	}
}