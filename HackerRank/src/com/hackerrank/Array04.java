package com.hackerrank;

/* 
You are given an unordered array consisting of consecutive integers =>[1, 2, 3, ..., n] without any duplicates. 
You are allowed to swap any two elements. You need to find the minimum number of swaps required to sort the array in ascending order.
*/

public class Array04 {

	public static void main(String[] args) {

		int arr[] = {1, 3, 5, 2, 4, 6, 7};
		//int arr[] = {3, 1, 5, 6, 2, 4};
		//int arr[] = {4, 3, 1, 2};
		//int arr[] = {7,1,3,2,4,5,6};
		int n = arr.length;
		int minSwap=0;
		boolean flag = true;
		while(true){
			flag=true;
			for(int i=0;i<n;i++){
				if(i+1==arr[i])
					continue;
				else{
					swap(arr,i,arr[i]-1);
					minSwap++;
					flag = false;
				}
			}
			if(flag)
				break;
		}
		System.out.println(minSwap);
		
	}
		
	static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}
