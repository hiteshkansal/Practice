package com.booking.interviewexperience;

//17. return the longest sequence in array (a,a+1,a+2,...) what  is the best order for it
public class Q17_LongestSeqArray {

	public static void main(String[] args) {

		int ar[] = { 1, 21, 3, 5, 6, 7, 8, 19 };
		int max = 1, endIndex = 0, curMax = 1, i=1;

		for (i = 1; i < ar.length; i++) {
			if (ar[i] == ar[i - 1] + 1) {
				curMax++;
			} else {
				if (curMax > max) {
					max = curMax;
					curMax=1;
					endIndex=i-1;
				}
			}
		}
		if (curMax > max) {
			max = curMax;
			curMax=1;
			endIndex=i-1;
		}
		System.out.println(max+"  "+endIndex);
	}

}
