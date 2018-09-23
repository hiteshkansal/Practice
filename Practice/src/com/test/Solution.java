package com.test;

public class Solution {
	
	public static void main(String s[]){
		int A[]={0,0,0,0, 3, 5 };
		//System.out.println(plusOne(A).toString());
		int b[] = plusOne(A);
		for(int i: b)
			System.out.print(i+" ");
	}
    public static int[] plusOne(int[] A) {
        int carry=0;
        int len = A.length;
        A[len-1] = A[len-1]+1;
        for(int i=A.length-1;i>=0;i--){
            A[i]=A[i]+carry;
            if(A[i]==10){
                A[i]=0;
                carry=1;
            }
            else
                carry=0;
        }
        if(carry==1){
            int arr[] = new int[A.length+1];
            arr[0]=1;
            for(int j=1;j<arr.length;j++)
                arr[j]=A[j-1];
            return arr;
        }
        if(A[0]==0){
        	int zeros=1;
        	for(int t=1;t<len;t++){
        		if(A[t]!=0)
        			break;
        		zeros++;
        	}
        	int arr1[] = new int[A.length-zeros];
            for(int k=0;k<arr1.length;k++){
                arr1[k]=A[k+zeros];
            }
            return arr1;
        }
        return A;
    }
}
