import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Job2Driver {
	
	public static void main(String[] args) throws Exception {
		
		Job job = new Job();
	    job.setJarByClass(Job2Driver.class);
	    job.setJobName("Assignment 5 - Job 2");
	    
	    // The HDFS input and output directories during run time.
	    FileInputFormat.addInputPath(job, new Path(args[0]));
	    FileOutputFormat.setOutputPath(job, new Path(args[1]));
	    
	    // Set the Mapper and Reducer classes.
	    job.setMapperClass(Job2Mapper.class);
	    job.setReducerClass(Job2Reducer.class);
	    
	    // Set the output data type classes (K/V pairs).
	    job.setOutputKeyClass(Text.class);
	    job.setOutputValueClass(IntWritable.class);
	    
	    int code = (job.waitForCompletion(true) ? 0 : 1);
	    
	    System.exit(code);
	}
}
