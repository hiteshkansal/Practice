package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Permutation {

	public static HashSet<String> permutation(String input, int start, int end, HashSet<String> res) {
		if (start == end) {
			res.add(input);
		} 
		else {
			for (int i = start; i <= end; i++) {
				input = swap(input, start, i);
				permutation(input, start + 1, end, res);
				input = swap(input, start, i);
			}
		}
		 return res;
	}

	public static void main(String arg[]) {
		List<String> inp = new ArrayList<String>();
		inp.add("ABC");
		inp.add("");
		inp.add("aaba");
		inp.add("qwerty");
		
		HashMap<String, HashSet<String>> output = new HashMap<String, HashSet<String>>();
		
		int len=0;
		for(String s:inp) {
			HashSet<String> res = new HashSet<String>();
			len=s.length();
			permutation(s, 0, len-1, res);
			output.put(s, res);
		}
		System.out.println(output.toString());
		
		int a[] = { 5, 1, 3, 2, 4 };
    	wave(a);
    	for(int t:a)
    		System.out.println(t+" ");
	}

	public static String swap(String str, int i, int j) {
		char temp;
		char[] charArray = str.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	    public static int[] wave(int[] A) {
	    	
	    	Arrays.sort(A);
	    	
	        boolean flag = true; //true means >=
	        int temp;
	        for(int i=1; i<A.length; i++){
	            if(flag){
	                if(A[i-1]<A[i]){
	                    temp = A[i];
	                    A[i] = A[i-1];
	                    A[i-1] = temp;
	                }
	            }
	            else{
	                if(A[i-1]>A[i]){
	                    temp = A[i];
	                    A[i] = A[i-1];
	                    A[i-1] = temp;
	                }
	            }
	            flag = !flag;
	        }
	        return A;
	    }
	

}
