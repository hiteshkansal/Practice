package com.hackerrank;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Alice decides on an encryption scheme involving two large strings where encryption is dependent on 
 * the minimum number of character deletions required to make the two strings anagrams. 
 */
public class String01 {

	// Complete the makeAnagram function below.
	static int makeAnagram(String a, String b) {

		int result=0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i=0;i<a.length();i++){
			int v = map.getOrDefault(a.charAt(i), 0);
			map.put(a.charAt(i), ++v);
		}
		for(int i=0;i<b.length();i++){
			int v = map.getOrDefault(b.charAt(i), 0);
			map.put(b.charAt(i), --v);
		}
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			int val = entry.getValue();
			if(val!=0){
				result+=Math.abs(val);
			}
		}
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String a = scanner.nextLine();
		String b = scanner.nextLine();
		int res = makeAnagram(a, b);
		System.out.println(res);
		scanner.close();
	}
}
