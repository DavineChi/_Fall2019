import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Job1Reducer extends Reducer<Text, CustomWritable, IntWritable, IntWritable> {
	
	@Override
	public void reduce(Text key, Iterable<CustomWritable> values, Context context) throws IOException, InterruptedException {
		
		List<CustomWritable> collection = new ArrayList<CustomWritable>();
		
		int zipCode = 0;
		
		for (CustomWritable item : values) {
			
			if (item.getFirst() == 1) {
				
				zipCode = item.getSecond();
				break;
			}
		}
		
		for (CustomWritable item : values) {
			
			int productId = 0;
			
			if (item.getFirst() == 2) {
				
				productId = item.getSecond();
				
				collection.add(new CustomWritable(zipCode, productId));
			}
		}
		
		for (CustomWritable item : collection) {
			
			int first = item.getFirst();    // zipCode
			int second = item.getSecond();  // productId
			
			context.write(new IntWritable(first), new IntWritable(second));
		}
	}
}
