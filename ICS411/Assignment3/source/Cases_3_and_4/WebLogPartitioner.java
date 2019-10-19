import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class WebLogPartitioner extends Partitioner<Text, IntWritable> {
	
	@Override
	public int getPartition(Text key, IntWritable value, int numReduceTasks) {
		
		String line = key.toString().toUpperCase();
		String[] array = line.split(" ");
		String date = array[3];
		
		Integer reducerNumber = 0;
		
		if (date.contains("JAN")) {
			
			reducerNumber = 0;
		}
		
		else if (date.contains("FEB")) {
					
			reducerNumber = 1;
		}
				
		else if (date.contains("MAR")) {
			
			reducerNumber = 2;
		}
		
		else if (date.contains("APR")) {
			
			reducerNumber = 3;
		}
		
		else if (date.contains("MAY")) {
			
			reducerNumber = 4;
		}
		
		else if (date.contains("JUN")) {
			
			reducerNumber = 5;
		}
		
		else if (date.contains("JUL")) {
			
			reducerNumber = 6;
		}
		
		else if (date.contains("AUG")) {
			
			reducerNumber = 7;
		}
		
		else if (date.contains("SEP")) {
			
			reducerNumber = 8;
		}
		
		else if (date.contains("OCT")) {
			
			reducerNumber = 9;
		}
		
		else if (date.contains("NOV")) {
			
			reducerNumber = 10;
		}
		
		else if (date.contains("DEC")) {
			
			reducerNumber = 11;
		}
		
		return reducerNumber;
	}
}
