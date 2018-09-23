package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Chegg {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);  //Scanner for taking input from User
		List<Integer> result = new ArrayList<Integer>();	//ArrayList for Storing the input from User
		
		System.out.println("How Long is the List?");
		int len = sc.nextInt();	//Getting total length of the list entered by user and storing it into int variable
		
		for(int i=1;i<=len;i++){
			System.out.println("Enter "+i+"th element in the list");
			result.add(sc.nextInt()); 	//Getting the list elements from user and directly adding into list by using List.add() method.
		}
		System.out.println("Before Sorting: "+result.toString());
		Collections.sort(result);	//Sorting the array by using sort method
		System.out.println("After Sorting: "+result.toString());
		sc.close();
		
	}
}
		/*int rating[] = { 84, 93, 61, 50, 95};
		DecimalFormat df2 = new DecimalFormat(".##");
		df2.setMinimumFractionDigits(2);
		df2.setRoundingMode(RoundingMode.HALF_UP);
		int totalEmp = rating.length;
		double totalAbove90 = 0.0, totalAbove90Rating = 0.0;

		for (int i = 0; i < totalEmp; i++) {
			if (rating[i] >= 90) {
				totalAbove90++;
				totalAbove90Rating += rating[i];
			}
		}
		double result = 95.344;
		System.out.print(df2.format(result));*/

		/*
		 * String regex = ".*\\d{3}-\\d{3}-\\d{4}.*"; String regex1 =
		 * ".*[(]\\d{3}[)]\\s\\d{3}-\\d{4}.*";
		 * 
		 * String text = "(fgh)h(30f0) (234) 145-3445-4d512"; StringBuilder sb =
		 * new StringBuilder(); if (text.matches(regex)) { int index = 2; for
		 * (int i = 0; i < text.length(); i += index) { index =
		 * text.indexOf("-", index + 1); if (index < 3) { continue; } else { if
		 * (!(Character.isDigit(text.charAt(index - 1))) ||
		 * !(Character.isDigit(text.charAt(index - 2))) ||
		 * !(Character.isDigit(text.charAt(index - 3))) ||
		 * !(Character.isDigit(text.charAt(index + 1))) ||
		 * !(Character.isDigit(text.charAt(index + 2))) ||
		 * !(Character.isDigit(text.charAt(index +3))) ||
		 * !(Character.isDigit(text.charAt(index + 5))) ||
		 * !(Character.isDigit(text.charAt(index + 6))) ||
		 * !(Character.isDigit(text.charAt(index + 7))) ||
		 * !(Character.isDigit(text.charAt(index + 8)))) continue;
		 * sb.append(text.substring(index - 3, index + 9)); break; } }
		 * 
		 * } else if (text.matches(regex1)) { int index = 0; for (int i = 0; i <
		 * text.length(); i += index) { index = text.indexOf("(", index+1); if
		 * (!(Character.isDigit(text.charAt(index + 1))) ||
		 * !(Character.isDigit(text.charAt(index + 2))) ||
		 * !(Character.isDigit(text.charAt(index + 3))) ||
		 * !(Character.isDigit(text.charAt(index + 6))) ||
		 * !(Character.isDigit(text.charAt(index + 7))) ||
		 * !(Character.isDigit(text.charAt(index + 8))) ||
		 * !(Character.isDigit(text.charAt(index + 10))) ||
		 * !(Character.isDigit(text.charAt(index + 11))) ||
		 * !(Character.isDigit(text.charAt(index + 12))) ||
		 * !(Character.isDigit(text.charAt(index + 13)))) continue;
		 * sb.append(text.substring(index, index + 14)); break; }
		 * 
		 * } else { sb.append("NONE"); } System.out.println(sb.toString());
		 */
		/*
		 * int array[] = {-3,-2,-1,5,6,7,9,11,12,13,15,16}; int count=0; String
		 * start=""; StringBuilder output = new StringBuilder(""); boolean first
		 * = true; int length = array.length; for(int i=0;i<length;i++){
		 * if(i<length-1 && array[i+1]-array[i]==1){ count++; if(first){ start =
		 * array[i]+""; first=false; } if(count==2){ output.append(start);
		 * output.append("-"); start=""; } } else{ first=true;
		 * output.append(start);
		 * 
		 * if(count==1) output.append(",");
		 * 
		 * output.append(array[i]);
		 * 
		 * if(i<length-1){ output.append(","); } count=0; } }
		 * System.out.println(output.toString());
		 */