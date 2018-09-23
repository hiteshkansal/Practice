package com.booking.interviewexperience;

import java.io.IOException;
import java.io.RandomAccessFile;

//7. if you have n lines from input and number k, print out only last k lines. 
public class Q7_LastNLines {

	public static void main(String[] args) {

		try {
			StringBuilder builder = new StringBuilder();
			RandomAccessFile raf = new RandomAccessFile(
					"C:\\Users\\Hitesh\\workspace\\Test\\Booking\\src\\com\\booking\\interviewexperience\\Q1_Logs.txt", "r");
			long last = raf.length() - 1;
			int n = 4;

			for(long pointer = last; pointer >= 0; pointer--) {
				raf.seek(pointer);
				char c = (char) raf.read();
				if (c == '\n' && n==0) {
					break;
				}
				if (c == '\n'){
					n--;
					builder.reverse();
					System.out.println(builder.toString());
					builder = new StringBuilder();
					pointer--;
					continue;
				}
				builder.append(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
