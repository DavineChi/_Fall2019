import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WebLogCount {

	public static void main(String[] args) throws Exception {
		
		Job job = new Job();
	    job.setJarByClass(WebLogCount.class);
	    job.setJobName("Web Log Count");
	    
	    // The HDFS input and output directories during run time.
	    FileInputFormat.addInputPath(job, new Path(args[0]));
	    FileOutputFormat.setOutputPath(job, new Path(args[1]));
	    
	    // Set the Mapper and Reducer classes.
	    job.setMapperClass(WebLogMapper.class);
	    job.setReducerClass(WebLogReducer.class);
	    
	    // Set the output data type classes (K/V).
	    job.setOutputKeyClass(Text.class);
	    job.setOutputValueClass(IntWritable.class);
	    
	    // Set the Combiner class (can reuse the Reducer class).
	    job.setCombinerClass(WebLogReducer.class);
	    
	    // Set the Partitioner class.
	    job.setPartitionerClass(WebLogPartitioner.class);
	    job.setNumReduceTasks(12);
	    
	    System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
