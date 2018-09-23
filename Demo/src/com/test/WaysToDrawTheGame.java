package com.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class WaysToDrawTheGame {

	  static int noOfWaysToDrawTheGame(int totalScore) {
	        if(totalScore<2)
	            return 0;
	        
	       int[] totalWays = new int[totalScore+1];
	       totalWays[0]=0;
	       totalWays[1]=0;
	       for(int i=2;i<=totalScore;i++)
	    	   totalWays[i] = 0;
	        return noOfWaysToDrawTheGameUtil(totalScore, totalWays);
	    }

	    static int noOfWaysToDrawTheGameUtil(int totalScore, int[] totalWays) {
	    	if(totalScore<2)
	            return 0;
	    	if(totalWays[totalScore]>0){
	    		return totalWays[totalScore];
	    	}
	        totalWays[totalScore] = 1+noOfWaysToDrawTheGameUtil(totalScore-2, totalWays)+noOfWaysToDrawTheGameUtil(totalScore-4, totalWays)+noOfWaysToDrawTheGameUtil(totalScore-6, totalWays);
	        return totalWays[totalScore];
	    }
	    public static void main(String[] args) throws IOException {
	        Scanner in = new Scanner(System.in);
	        final String fileName = System.getenv("OUTPUT_PATH");
	        BufferedWriter bw = null;
	        if (fileName != null) {
	            bw = new BufferedWriter(new FileWriter(fileName));
	        }
	        else {
	            bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        }

	        int res;
	        int totalScore;
	        totalScore = Integer.parseInt(in.nextLine().trim());

	        res = noOfWaysToDrawTheGame(totalScore);
	        bw.write(String.valueOf(res));
	        bw.newLine();
	        bw.close();
	    }
}
