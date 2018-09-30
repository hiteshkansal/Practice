package com.hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * If Lena loses no more than k important contests, what is the maximum amount of luck she can have 
 * after competing in all the preliminary contests? This value may be negative.
 */

public class Greedy02 {

	// Complete the luckBalance function below.
	static int luckBalance(int k, int[][] contests) {
		int luck=0, len = contests.length, total=0;
		ArrayList<Integer> impLuck = new ArrayList<>();
		
		for(int i=0;i<len;i++){
			total+=contests[i][0];
			if(contests[i][1]==1)
				impLuck.add(contests[i][0]);
		}
		Collections.sort(impLuck);
		for(int i=0;i<impLuck.size()-k;i++){
			luck+=impLuck.get(i);
		}
		return total-2*luck;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[][] contests = new int[n][2];

		for (int i = 0; i < n; i++) {
			String[] contestsRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 2; j++) {
				int contestsItem = Integer.parseInt(contestsRowItems[j]);
				contests[i][j] = contestsItem;
			}
		}

		int result = luckBalance(k, contests);

		System.out.println(result);
		scanner.close();
	}
}
