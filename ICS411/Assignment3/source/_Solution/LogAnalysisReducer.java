import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class LogAnalysisReducer extends
Reducer<Text, IntWritable, Text, IntWritable> {

	@Override
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		int ipHitFinalCnt = 0;

		for (IntWritable value : values) {
			ipHitFinalCnt += value.get(); 
			/*we add the cnt with input value assuming the combiner updated the 
			 * value space with count of hits on an ip, in the absence of combiner
			 * it would the list would be the month ids and in that case  
			 * we should just increment the ipHitFinalCnt for the values in list
			 * ipHitFinalCnt ++; 
			 */			
		}
		context.write(key, new IntWritable(ipHitFinalCnt));

	}

}