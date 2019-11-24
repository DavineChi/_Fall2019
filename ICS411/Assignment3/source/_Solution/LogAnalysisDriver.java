import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class LogAnalysisDriver {

	public static void main(String[] args) throws Exception {

		@SuppressWarnings("deprecation")
		Job job = new Job();
		job.setJarByClass(LogAnalysisDriver.class);
		job.setJobName("Log Analysis");

		// to accept the hdfs input and output dir at run time
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		// setting the class names
		job.setMapperClass(LogAnalysisMapper.class);
		job.setReducerClass(LogAnalysisReducer.class);

		// Sets the combiner class, this could be commented if combiner is not
		// required
		job.setCombinerClass(LogAnalysisCombiner.class);

		// Sets the partition class and number, one for each month
		// this could be commented if reducer is not required
		job.setPartitionerClass(LogAnalysisPartitioner.class);
		job.setNumReduceTasks(12);

		// setting the output data type classes
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}