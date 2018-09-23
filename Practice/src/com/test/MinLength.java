package com.test;

public class MinLength {

	public static int smallestSubWithSum(int arr[], int len, int x){
		int start=0, end=0;
		int currSum=0, minLen=len+1;
		
		while(end<len) {
			while(currSum<=x && end<len){
				if (currSum <= 0 && x > 0)
	            {
	                start = end;
	                currSum = 0;
	            }
				currSum += arr[end++];
			}
			while(currSum>x && start<len){
				if(end-start < minLen){
					minLen = end-start;
				}
				currSum -= arr[start++];
			}
		}
		return minLen;
	}

	public static void main(String[] args) {
		int arr1[] = {-1, -10, 5, -2, 7};
        int x = 9;
        int n1 = arr1.length;
        int res1 = smallestSubWithSum(arr1, n1, x);
        if (res1 == n1+1)
           System.out.println("Not Possible");
        else
           System.out.println(res1);
	}

}
