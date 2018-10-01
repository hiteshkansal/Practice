package com.hackerrank;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Given the size of the group of friends, the number of flowers they want to purchase and the original prices of the flowers,
 *  determine the minimum cost to purchase all of the flowers.
 */
public class Greedy03 {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, Integer[] c) {

    	int totalFlower = c.length;
    	int result=0, l=totalFlower-1;
    	
    	Arrays.sort(c);
    	for(int i=0;i<(totalFlower/k)+1;i++){
    		for(int j=0;j<k;j++){
    			if(l==-1)
        			break;
    			int temp = (i+1)*c[l];
    			result+=temp;
    			l--;
    		}
    	}
    	return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        Integer[] c = new Integer[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        System.out.println(String.valueOf(minimumCost));

    }
}

