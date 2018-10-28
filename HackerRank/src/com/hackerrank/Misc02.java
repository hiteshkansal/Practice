package com.hackerrank;

public class Misc02 {

	// Complete the primality function below. in SQRT(n) time
	static String primality(int n) {
		if (n == 1)
			return "Not prime";
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return "Not prime";
		}
		return "Prime";
	}

	public static void main(String[] args) {
		System.out.println(primality(3456));
	}
}
