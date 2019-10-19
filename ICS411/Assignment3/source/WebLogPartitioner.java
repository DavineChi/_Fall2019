import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class WebLogPartitioner extends Partitioner<Text, IntWritable> {
	
	@Override
	public int getPartition(Text key, IntWritable value, int numReduceTasks) {
		
		Integer reducerNumber = 0;
		String[] array = key.toString().toUpperCase().split(" ");
		String date = array[0];
		
		if (date.contains("JAN")) {
			
			reducerNumber = 1;
		}
		
		else if (date.contains("FEB")) {
					
			reducerNumber = 2;
		}
				
		else if (date.contains("MAR")) {
			
			reducerNumber = 3;
		}
		
		else if (date.contains("APR")) {
			
			reducerNumber = 4;
		}
		
		else if (date.contains("MAY")) {
			
			reducerNumber = 5;
		}
		
		else if (date.contains("JUN")) {
			
			reducerNumber = 6;
		}
		
		else if (date.contains("JUL")) {
			
			reducerNumber = 7;
		}
		
		else if (date.contains("AUG")) {
			
			reducerNumber = 8;
		}
		
		else if (date.contains("SEP")) {
			
			reducerNumber = 9;
		}
		
		else if (date.contains("OCT")) {
			
			reducerNumber = 10;
		}
		
		else if (date.contains("NOV")) {
			
			reducerNumber = 11;
		}
		
		else if (date.contains("DEC")) {
			
			reducerNumber = 12;
		}
		
		else {
			
			reducerNumber = 0;
		}
		
		return reducerNumber;
	}
}
