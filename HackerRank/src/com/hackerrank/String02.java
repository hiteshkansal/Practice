package com.hackerrank;

import java.io.IOException;
import java.util.Scanner;

/*
 * You are given a string containing characters A and B only. Your task is to change it into a string such that there are no matching 
 * adjacent characters. To do this, you are allowed to delete zero or more characters in the string.
 */

public class String02 {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {

    	int min=0;
    	for(int i=1;i<s.length();i++){
    		if(s.charAt(i)==s.charAt(i-1))
    			min++;
    	}
    	return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            System.out.println(String.valueOf(result));
        }
        scanner.close();
    }
}
