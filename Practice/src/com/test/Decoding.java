package com.test;

public class Decoding {

	public static int countDecoding(String str, int n){
		int count[] = new int[n+1];
		
		count[0]=1;
		count[1]=1;
		
		for(int i=2;i<=n;i++){
			count[i]=0;
			//If the last digit is not 0, then last digit must add to
		    // the number of words
			if(str.charAt(i-1) > '0')
				count[i]=count[i-1];
			
			// If the last two digits form a number smaller than or equal to 26,
		    // then consider last two digits and recur
			if(str.charAt(i-2)=='1' || str.charAt(i-2)=='2' && str.charAt(i-1)<'7')
				count[i]+=count[i-2];
		}
		return count[n];
	}
	
	
	public static void main(String[] args) {

		String inp = "27";
		int n = inp.length();
		System.out.println(countDecoding(inp, n));
		
	}
}
