package com.hackerrank;

import java.util.HashMap;
import java.util.Scanner;

public class Search01 {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i=0;i<cost.length;i++){
    		Integer val = map.get(money-cost[i]);
    		if(val!=null){
    			System.out.println(val+" "+(i+1));
    		} else{
    			map.put(cost[i], i+1);
    		}
    	}
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
