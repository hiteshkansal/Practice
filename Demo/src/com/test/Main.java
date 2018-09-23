package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Main {

	static String timeConversion(String s) {
		if ("12:00:00AM".equals(s))
			return "00:00:00";
		else if ("12:00:00PM".equals(s))
			return "12:00:00";
		String substring = s.length() > 2 ? s.substring(s.length() - 2) : s;
		String hourString = s.substring(0, 2);
		int hour = Integer.parseInt(hourString);
		String result = s.substring(2, s.length() - 2);
		if ("PM".equals(substring) && hour != 12) {
			hour = hour + 12;
			hourString = hour + "";
		}
		if ("AM".equals(substring) && hour == 12)
			hourString = "00";
		return hourString + result;
	}

	public static void main(String[] args) {
		/*
		 * Scanner in = new Scanner(System.in); String s = in.next(); String
		 * result = timeConversion(s); System.out.println(result);
		 */
		/*
		 * String s[]={"234523","234","12321"}; Arrays.sort(s);
		 * System.out.println(s[0]+" "+s[1]+" "+s[2]);
		 */
		// System.out.println(s.contains("1") && s.contains("2")
		// &&s.contains("3"));

		//int numberArray[] = { 2,123,1231 };
		ArrayList<String> s =  null;
		System.out.println(s+"wewe");
		int numberArray[] = { 1542, 344235, -134, 654, 24561 };
		//System.out.println(findQualifiedNumbers(numberArray));
		//System.out.println(findPossibleSmallestNumberMatchingPattern("NM"));
	}
	
	
	 static int findPossibleSmallestNumberMatchingPattern(String pattern) {

		 if(!pattern.matches("[MN]+"))
		     return -1;

		 String result="";
		 Stack<Integer> s = new Stack<Integer>();
		 
		 for(int i=0; i<=pattern.length(); i++){
			 s.push(i+1);
			 
			 if(i==pattern.length() || pattern.charAt(i)=='N'){
				 while(!s.empty())
					 result += s.pop().toString();
			 }
		 }
		 return Integer.parseInt(result);
	}

	
	
	
	
/*	
	
	static String findQualifiedNumbers(int[] numberArray) {
		int digit, number;
		boolean ones = false, two = false, three = false;
		ArrayList<Integer> res = new ArrayList<Integer>();
		String output = "";
		
		for (int i = 0; i < numberArray.length; i++) {
			number = numberArray[i];
			ones=two=three=false;
			
			while (number != 0) {
				digit = number % 10;
				number = number / 10;
				if (digit == 1 || digit==-1)
					ones = true;
				if (digit == 2 || digit==-2)
					two = true;
				if (digit == 3 || digit==-3)
					three = true;
			}
			if (ones && two && three) {
				res.add(numberArray[i]);
			}
		}
		Collections.sort(res);
		int size = res.size();
		if(res.size()==0)
			return "-1";
		for(int t=0; t<size; t++){
			if(t==size-1)
				output=output+res.get(t);
			else
				output=output+res.get(t)+",";
		}
		return output;

	}
*/
}
