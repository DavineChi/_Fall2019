import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class CustomWritable implements WritableComparable<CustomWritable> {
	
	private int first;
	private int second;
	
	/**
	 * Empty constructor - required for serialization.
	 */
	public CustomWritable() {
		
		
	}
	
	public CustomWritable(int first, int second) {
		
		this.first = first;
		this.second = second;
	}
	
	public int getFirst() {
		
		return first;
	}
	
	public int getSecond() {
		
		return second;
	}
	
	@Override
	public void readFields(DataInput input) throws IOException {
		
		first = input.readInt();
		second = input.readInt();
	}
	
	@Override
	public void write(DataOutput output) throws IOException {
		
		output.writeInt(first);
		output.writeInt(second);
	}
	
	@Override
	public int compareTo(CustomWritable otherWritable) {
		
		int result = -1;
		
		if (this.first > otherWritable.first) {
			
			result = 1;
		}
		
		else if (this.first < otherWritable.first) {
			
			result = -1;
		}
		
		else if (this.first == otherWritable.first) {
			
			if (this.second > otherWritable.second) {
				
				result = 1;
			}
			
			else if (this.second < otherWritable.second) {
				
				result = -1;
			}
			
			else {
				
				result = 0;
			}
		}
		
		return result;
	}
	
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		
		result = prime * result + first;
		result = prime * result + second;
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {
			
			return true;
		}
		
		if (obj == null) {
			
			return false;
		}
		
		if (this.getClass() != obj.getClass()) {
			
			return false;
		}
		
		CustomWritable other = (CustomWritable)obj;
		
		if (this.first != other.first) {
			
			return false;
		}
		
		if (this.second != other.second) {
			
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		
		return "" + first + "," + second;
	}
}
