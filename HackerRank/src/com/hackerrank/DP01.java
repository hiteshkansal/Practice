package com.hackerrank;

public class DP01 {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {

        int incl = arr[0]; 
        int excl = 0; 
        int excl_new; 
        for (int i = 1; i < arr.length; i++) 
        { 
            excl_new = (incl > excl) ? incl : excl; 
            incl = excl + arr[i]; 
            excl = excl_new; 
        } 
        return ((incl > excl) ? incl : excl); 
    }

    public static void main(String[] args) {
    	int a[] = {5,-1,3,6,-7,4};
        System.out.println(maxSubsetSum(a));

    }
}
