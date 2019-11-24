import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class LogAnalysisMapper extends
Mapper<LongWritable, Text, Text, IntWritable> {

	// variable declarations
	private final static IntWritable monthid = new IntWritable(0);
	private Text word = new Text();
	private final String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun",
			"Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

	// user defined counter declaration, would be used to count gif. jpg and
	// other files
	public static enum ImageCounter {
		GIF, JPEG, Others
	};

	@Override
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {

		String line = value.toString();
		StringTokenizer tokenizer = new StringTokenizer(line);
		String IPaddr = "", mtemp = "";
		int month = 0;

		/******* parsing of the record/line begins *********/
		while (tokenizer.hasMoreTokens()) {

			String result = tokenizer.nextToken();

			/***** Code extracts the ip and month to emit as key and value *****/
			if (result.startsWith("10.")) {
				IPaddr = result.trim();
				continue;
			}

			if (result.startsWith("[")) {

				String[] dtFields = result.split("/");
				if (dtFields.length > 1) {
					String theMonth = dtFields[1];
					if (Arrays.asList(months).contains(theMonth)) {

						mtemp = theMonth;
					} else
						mtemp = "";
				}
				continue;
			}

			/***** Code increments the counter based on the file type *****/
			if (result.contains("GET")) {
				if (tokenizer.hasMoreTokens()) {
					String result1 = tokenizer.nextToken();
					if (result1.contains(".gif")) {
						context.getCounter(ImageCounter.GIF).increment(1);
						break; // at this point ip and month are already
						// processed so we can exit from loop
					}
					if (result1.contains(".jpeg")) {
						context.getCounter(ImageCounter.JPEG).increment(1);
						break;
					} else {
						context.getCounter(ImageCounter.Others).increment(1);
						break;
					}

				}

			}

		}
		/****** parsing of the record/line complete *******/

		// for the extracted month send the integer equivalent, 0 for Jan , 1
		// for Feb ...11 for Dec
		for (int i = 0; i < 12; i++) {
			int result = mtemp.compareToIgnoreCase(months[i]);
			if (result == 0) {
				month = i;
				break;
			}
		}
		monthid.set(month);

		// now write the ip as key and month in integer as value for as mapper
		// output
		word.set(IPaddr);
		context.write(word, monthid); 
	}
}
