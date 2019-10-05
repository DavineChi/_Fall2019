package edu.metrostate.ICS411.assignment3;

public class Driver {

	public static void main(String[] args) {
		
		String test = "10.223.157.186 - - [15/Jul/2009:14:58:59 -0700] \"GET / HTTP/1.1\" 403 202";
		String[] splitLine = test.split(" ");
		String key = splitLine[0];
	}
}
