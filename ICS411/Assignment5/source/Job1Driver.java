import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Job1Driver {
	
	public static void main(String[] args) throws Exception {
		
		Job job = new Job();
	    job.setJarByClass(Job1Driver.class);
	    job.setJobName("Assignment 5 - Job 1");
	    
	    // The HDFS input and output directories during run time.
	    FileInputFormat.addInputPath(job, new Path(args[0]));
	    FileOutputFormat.setOutputPath(job, new Path(args[1]));
	    
	    // Set the Mapper and Reducer classes.
	    job.setMapperClass(Job1Mapper.class);
	    job.setReducerClass(Job1Reducer.class);
	    
	    // Set the Mapper output data type classes (K/V pairs).
	    job.setMapOutputKeyClass(IntWritable.class);
	    job.setMapOutputValueClass(CustomWritable.class);
	    
	    // Set the Reducer output data type classes (K/V pairs).
	    job.setOutputKeyClass(IntWritable.class);
	    job.setOutputValueClass(IntWritable.class);
	    
	    int code = (job.waitForCompletion(true) ? 0 : 1);
	    
	    System.exit(code);
	}
}
