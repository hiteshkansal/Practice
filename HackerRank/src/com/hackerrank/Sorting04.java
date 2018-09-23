package com.hackerrank;

import java.io.IOException;
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
		
    	return d;
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