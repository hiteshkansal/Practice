package com.hackerrank;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Given an array of integers, 
 * find and print the minimum absolute difference between any two elements in the array. 
 */

public class Greedy01 {

    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {
    	Arrays.sort(arr);
    	int result=Integer.MAX_VALUE, min=0;
    	for(int i=1;i<arr.length;i++){
    		min = Math.abs(arr[i-1]-arr[i]);
    		if(min<result){
    			result=min;
    		}
    	}
    	return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = minimumAbsoluteDifference(arr);
        System.out.println(result);
        scanner.close();
    }
}

