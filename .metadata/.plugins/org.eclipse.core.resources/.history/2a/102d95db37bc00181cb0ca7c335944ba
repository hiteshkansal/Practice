package com.hackerrank;

import java.util.HashMap;
/*
Given two strings, determine if they share a common substring. A substring may be as small as one character.
For example, the words "a", "and", "art" share the common substring a. The words "be" and "cat" do not share a substring.
 */
public class HashMap02 {

	public static void main(String[] args) {
		
		String s1 = "Hello";
		String s2 = "World";
		HashMap<String, String> map = new HashMap<String, String>();
		boolean flag = false;
		for(int i=0;i<s1.length();i++){
			map.put(s1.charAt(i)+"", s1.charAt(i)+"");
		}
		for(int i=0;i<s2.length();i++){
			String temp = map.get(s2.charAt(i)+"");
			if(temp!=null)
				flag = true;
		}
		if(flag)
			System.out.println("Yes");
		else
			System.out.println("No");

	}

}
