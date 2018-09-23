package com.booking.interviewexperience;

import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

//11. Given a directory return k biggest files inside all files and directories from inside given directory.
public class Q11_BiggestFilesinDirectory {

	private static TreeMap<Long, String> map = new TreeMap<>(Collections.reverseOrder());
	
	public static void listFilesAndFilesSubDirectories(String directoryName){
		File directory = new File(directoryName);
		File[] fList = directory.listFiles();
		for (File file : fList) {
			if (file.isFile()) {
				System.out.println(file.getAbsolutePath());
				map.put( file.length(), file.getName());
			} else if (file.isDirectory()) {
				listFilesAndFilesSubDirectories(file.getAbsolutePath());
			}
		}
	}
	public static void main(String[] args) {

		String directory = "H:\\Movies\\Harry.Potter.Complete.Saga. I - VIII .1080p.Bluray.x264.anoXmous";
		listFilesAndFilesSubDirectories(directory);
		Set s = map.entrySet();
		Iterator i = s.iterator();
		
		while(i.hasNext()){
			Map.Entry m = (Map.Entry) i.next();
			System.out.println(m.getKey());
		}
		
	}

}
