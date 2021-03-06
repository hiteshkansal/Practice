package com.hackerrank;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Given a string, find the number of pairs of substrings of the string that are anagrams of each other.

For example s="mom", the list of all anagrammatic pairs is [m,m],[mo,om] at positions [[0][2]], [[0,1][1,2]] respectively.
 */
public class HashMap03 {

	static int sherlockAndAnagrams(String s) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int length = s.length();
		int result=0;
		
		for(int i=1;i<length;i++){
			for(int j=0;j<length-i+1;j++){
				Integer key=1;
				String sub = s.substring(j,j+i);
				char[] ar = sub.toCharArray();
				Arrays.sort(ar);
				String sorted = String.valueOf(ar);
				/*for(int k=j;k<j+i;k++){
					int chr = s.charAt(k);
					key*=chr*prime[chr-97];
				}*/
				key = sorted.hashCode();
				int count = map.getOrDefault(key, 0);
				map.put(key, ++count);
			}
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int t = entry.getValue();
			if(t>1){
				result+=(t*(t-1))/2;
		    	System.out.println(entry.getKey() + "/" + entry.getValue());
			}
		}
		return result;
    }

    private static final Scanner scanner = new Scanner(System.in);
    private static final int prime[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
    
    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);
            System.out.println(result);
        }


        scanner.close();
    }
}
