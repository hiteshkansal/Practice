package com.hackerrank;

public class Misc01 {

	// Complete the 32 bit integer flippingBits function below.
	static long flippingBits(long n) {
		long maxValue = (long) (Math.pow(2, 32) - 1);
		return (n ^ maxValue);
	}

	public static void main(String[] args) {

		System.out.println(flippingBits(2140000000));
	}
}
