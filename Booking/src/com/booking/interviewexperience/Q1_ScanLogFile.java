package com.booking.interviewexperience;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* 1. We have a log file, can grow pretty big.
Each line is a trace-log, and the first field is the RequestID.
We need to scan the file, and print all the logs for requests which resulted in error ..
*/
public class Q1_ScanLogFile {

	public static void main(String[] args) {

		/*
		 * try { Scanner scanner = new Scanner(new File(
		 * "C:\\Users\\Hitesh\\workspace\\Test\\Booking\\src\\com\\booking\\interviewexperience\\Q1_Logs.txt"
		 * )); while (scanner.hasNextLine()) {
		 * System.out.println(scanner.nextLine()); } scanner.close(); } catch
		 * (FileNotFoundException e) { e.printStackTrace(); }
		 */

		try {
			BufferedReader reader = new BufferedReader(new FileReader(
					"C:\\Users\\Hitesh\\workspace\\Test\\Booking\\src\\com\\booking\\interviewexperience\\Q1_Logs.txt"));
			String line;
			Map<String, ArrayList<String>> result = new TreeMap<String, ArrayList<String>>();

			line = reader.readLine();
			while (line != null) {
				String reqID = line.substring(0, 3);
				if (line.contains("ERROR")) {
					if (!result.containsKey(reqID)) {
						ArrayList<String> errors = new ArrayList<String>();
						errors.add(line);
						result.put(reqID, errors);
					} else {
						ArrayList list = result.get(reqID);
						list.add(line);
						result.put(reqID, list);
					}
				}
				line = reader.readLine();
			}
			Set set = result.entrySet();
			Iterator iterator = set.iterator();
			while (iterator.hasNext()) {
				Map.Entry mentry = (Map.Entry) iterator.next();
				System.out.println(mentry.getValue());
			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
