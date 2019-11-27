import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class Job2Reducer extends Reducer<CustomWritable, IntWritable, CustomWritable, IntWritable> {
	
	@Override
	public void reduce(CustomWritable key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
		
		int sum = 0;
		
		for (IntWritable value : values) {
			
			sum = sum + value.get();
		}
		
		context.write(key, new IntWritable(sum));
	}
}
