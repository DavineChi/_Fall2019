import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Job2Mapper extends Mapper<LongWritable, Text, CustomWritable, IntWritable> {
	
	private static final IntWritable ONE = new IntWritable(1);
	private static final String TAB = "\t";
	
	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		
		String line = value.toString();
		
		String[] list = line.split(TAB);
		
		int zipCode = Integer.parseInt(list[0]);
		int productId = Integer.parseInt(list[1]);
		
		context.write(new CustomWritable(zipCode, productId), ONE);
	}
}
