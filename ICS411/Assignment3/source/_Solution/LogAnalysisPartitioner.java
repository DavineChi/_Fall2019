import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class LogAnalysisPartitioner extends Partitioner<Text, IntWritable> {
	@Override
	public int getPartition(Text key, IntWritable value, int numReduceTasks) {

		// Mapper output arrives at partitioner
		// We know that the value contains the month id, so we
		// can directly forward the monthid as reducer number
		Integer reducerNumber = value.get();
		return reducerNumber;
	}
}
