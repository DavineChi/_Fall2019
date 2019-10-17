package edu.metrostate.ICS411.assignment3;

public class Driver {
	
	public static enum ImageCounter { GIF, JPG, JPEG, Others };
	
	public static void main(String[] args) {
		
		String test01 = "10.223.157.186 - - [15/Jul/2009:14:58:59 -0700] \"GET / HTTP/1.1\" 403 202";
		String test02 = "10.216.113.172 - - [16/Nov/2009:07:26:38 -0800] \"GET /images/filmpics/0000/0173/SNDN3.jpeg HTTP/1.1\" 304 -";
		String[] splitLine01 = test02.split(" ");
		String ipAddress = splitLine01[0];
		String resource = splitLine01[6].toUpperCase();
		
		int jpgCounter = 0;
		
		if (resource.contains("JPEG")) {
			
			jpgCounter = jpgCounter + 1;
			
			String stop = "";
		}
	}
}
