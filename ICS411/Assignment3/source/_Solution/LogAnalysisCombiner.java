import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class LogAnalysisCombiner extends
Reducer<Text, IntWritable, Text, IntWritable> {

	@Override
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		int ipHitCnt = 0;

		/*The combiner can now add the no of hits for a particular ip 
		 * and update it in the value section, as even if the partitioner was used, 
		 * the reducer number would have been allocated by the time it reached combiner, 
		 * so its ok to replace the monthid with actual count for a particular ip from a node
		 **/
		for (IntWritable value : values) {
			ipHitCnt++;
		}
		context.write(key, new IntWritable(ipHitCnt));
	}
}