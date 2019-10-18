package edu.metrostate.ICS411.assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
		
		File inputFile = Driver.getFile(".", "weblogs_small");
		
//		String test01 = "10.223.157.186 - - [15/Jul/2009:14:58:59 -0700] \"GET / HTTP/1.1\" 403 202";
//		String test02 = "10.216.113.172 - - [16/Nov/2009:07:26:38 -0800] \"GET /images/filmpics/0000/0173/SNDN3.jpeg HTTP/1.1\" 304 -";
//		String[] splitLine01 = test02.split(" ");
		
		String test = "10.216.113.172 - - [01/Dec/2009:05:28:33 -0800] \"GET /assets/img/banner/ten-years-banner-white.jpg HTTP/1.1\" 304 -";
		
		String[] array = test.split(" ");
		
		String resourceUrl = array[6].toUpperCase();
		
		String nextLine;
		String ipAddress;
		String resource;
		
		int counter = 0;
		
		try {
			
			Scanner input = new Scanner(inputFile);
			
			while (input.hasNextLine()) {
				
				nextLine = input.nextLine();
				
				if (!nextLine.equals("")) {
					
					String[] split = nextLine.split(" ");
					
					if (counter == 40206) {
						
						String stop = "";
					}
					
					ipAddress = split[0];
					resource = split[6].toUpperCase();
					
					System.out.println("ipAddress = " + ipAddress);
					System.out.println("resource  = " + resource);
					
					counter++;
				}
			}
		}
		
		catch (FileNotFoundException ex) {
			
			ex.printStackTrace();
		}
	}
}
