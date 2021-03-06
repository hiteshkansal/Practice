package com.hackerrank;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * HackerLand National Bank has a simple policy for warning clients about possible fraudulent account activity. 
 * If the amount spent by a client on a particular day is greater than or equal to 2X the client's median spending for a trailing number of days,
 * they send the client a notification about potential fraud. The bank doesn't send the client any notifications 
 * until they have at least that trailing number of prior days' transaction data.
 * Given the number of trailing days  and a client's total daily expenditures for a period of n days,
 * find and print the number of times the client will receive a notification over all n days.
 */

public class Sorting04 {
	
	static int activityNotifications(int[] expenditure, int d) {
		int count = 0;
		int freq[] = new int[201];
		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 0; i < expenditure.length; i++) {
			while (i < d) {
				q.add(expenditure[i]);
				freq[expenditure[i]] = freq[expenditure[i]] + 1;
				i++;
			}

			float median = getMedian(freq, d);
			if (expenditure[i] >= 2 * median)
				count++;

			int elem = q.remove();
			freq[elem] = freq[elem] - 1;
			q.add(expenditure[i]);
			freq[expenditure[i]] = freq[expenditure[i]] + 1;
		}
		return count;
	}

	private static float getMedian(int[] freq, int d) {
		if (d % 2 == 1) {
			int center = 0;
			for (int i = 0; i < freq.length; i++) {
				center = center + freq[i];
				if (center > d / 2)
					return i;
			}
		} else {
			int count = 0;
			int first = -1;
			int second = -1;
			for (int i = 0; i < freq.length; i++) {
				count = count + freq[i];
				if (count == d / 2)
					first = i;
				else if (count > d / 2) {
					if (first < 0)
						first = i;
					second = i;
					return ((float) first + (float) second) / 2;
				}
			}
		}
		return 0f;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] nd = scanner.nextLine().split(" ");
		int n = Integer.parseInt(nd[0]);
		int d = Integer.parseInt(nd[1]);
		int[] expenditure = new int[n];
		String[] expenditureItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		for (int i = 0; i < n; i++) {
			int expenditureItem = Integer.parseInt(expenditureItems[i]);
			expenditure[i] = expenditureItem;
		}

		int result = activityNotifications(expenditure, d);
		System.out.println(result);
		scanner.close();
	}
}
