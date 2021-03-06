package com.hackerrank;

import java.io.IOException;
import java.util.Scanner;

/*
 We define an hourglass in  to be a subset of values with indices falling in this pattern in 's graphical representation:

a b c
  d
e f g
print hourglass in 6*6 matrix
 */
public class Array01 {

    static int hourglassSum(int[][] arr) {

        int sum=0, max=Integer.MIN_VALUE, temp=1;
        for(int i=0;i<4;i++){
	        for(int j=0;j<4;j++){
	            temp=0;
	            sum=0;
	            for(int k=i;k<i+3;k++){
	                for(int l=j;l<j+3;l++){
	                	temp++;
	                	if(temp==4||temp==6)
	                        continue;
	                    sum+=arr[k][l];
	                }
	            }
                if(sum>max)
                    max=sum;
	        }
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

       System.out.println(result);

        scanner.close();
    }
}

