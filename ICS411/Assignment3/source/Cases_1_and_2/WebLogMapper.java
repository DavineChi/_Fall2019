import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WebLogMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	private final static IntWritable one = new IntWritable(1);
	private Text word = new Text();
	
	public static enum ImageCounter { GIF, JPEG, Others };
	
	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		
		String line = value.toString().toUpperCase();
		String[] array = line.split(" ");
		String ipAddress = array[0];
		
		if (!ipAddress.equals("")) {
			
			word.set(line);
			context.write(word, one);
			
			if (line.contains("GIF")) {
				
				context.getCounter(ImageCounter.GIF).increment(1);
			}
			
			else if (line.contains("JPG") || line.contains("JPEG")) {
				
				context.getCounter(ImageCounter.JPEG).increment(1);
			}
			
			else {
				
				context.getCounter(ImageCounter.Others).increment(1);
			}
		}
	}
}
