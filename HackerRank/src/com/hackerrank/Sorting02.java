package com.hackerrank;

import java.util.Arrays;

/*
 * Mark and Jane are very happy after having their first child. Their son loves toys, so Mark wants to buy some. 
 * There are a number of different toys lying in front of him, tagged with their prices. 
 * Mark has only a certain amount to spend, and he wants to maximize the number of toys he buys with this money.
 */
public class Sorting02 {

	public static void main(String[] args) {

		int prices[]={1, 12, 5, 111, 200, 1000, 10}, k=50;
		int res=0, out=0;

		Arrays.sort(prices);
		for(int i=0;i<prices.length;i++){
			res+=prices[i];
			if(res>=k)
				break;
			out++;
		}
		System.out.println(out);
	}

}
