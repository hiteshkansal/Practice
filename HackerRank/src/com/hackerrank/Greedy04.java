package com.hackerrank;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * You will be given a list of integers, arr , and a single integer k. You must create an array of length k
 *  from elements of arr such that its unfairness is minimized. Call that array subarr. 
 *  Unfairness of an array is calculated as Max(subarr)-min(subarr)
 */

public class Greedy04 {

    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {
    	Arrays.sort(arr);
    	int result=Integer.MAX_VALUE;
    	
    	for(int i=0;i<arr.length-k+1;i++){
    		int diff = arr[i+k-1]-arr[i];
    		if(diff<result)
    			result=diff;
    	}
    	return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = maxMin(k, arr);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
