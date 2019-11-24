package edu.metrostate.ICS411.assignment3;

import java.io.File;
import java.util.StringTokenizer;

public class Driver {
	
	public static enum ImageCounter { GIF, JPG, JPEG, Others };
	
	/************************************************************************************************************
	 * An accessor method to retrieve a specific file from a given path.
	 * <p>
	 * 
	 * @param pathname
	 *   the resource path from which the file is retrieved
	 * 
	 * @param fileName
	 *   the name of the file to retrieve
	 * 
	 * @return
	 *   A specific station data file.
	 */
	public static File getFile(String pathname, String fileName) {
		
		File result = null;
		File path = new File(pathname);
		
		// Check if the "ghcnd_hcn" path exists before proceeding.
		if (path.listFiles() == null) {
			
			System.out.println("Path not found: " + pathname + " - exiting now.");
			System.exit(1);
		}
		
		for (File file : path.listFiles()) {
			
			if (file.getName().equals(fileName)) {
				
				result = file;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
//		String test01 = "10.223.157.186 - - [15/Jul/2009:14:58:59 -0700] \"GET / HTTP/1.1\" 403 202";
//		String test02 = "10.216.113.172 - - [16/Nov/2009:07:26:38 -0800] \"GET /images/filmpics/0000/0173/SNDN3.jpeg HTTP/1.1\" 304 -";
//		String[] splitLine01 = test02.split(" ");
		
		String customerLine = "1000000	Quentin	Shepard	32092 West 10th Street	Prairie City	SD	57649";
		String orderLine = "5000001	1133938	1273719	2008-06-01 00:03:35.0";
		
		StringTokenizer tokenizer = new StringTokenizer(customerLine);
		
		String[] customerVals = customerLine.split("\t");
		String[] orderVals = orderLine.split("\t");
		
		int cSize = customerVals.length;
		int oSize = orderVals.length;
		
		while (tokenizer.hasMoreTokens()) {
			
			String result = tokenizer.nextToken();
			String[] values = customerLine.split("\t");
			String stop = "";
		}
	}
}
