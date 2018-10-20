package com.hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * A string is said to be a special palindromic string if either of two conditions is met:

All of the characters are the same, e.g. aaa.
All characters except the middle one are the same, e.g. aadaa.
Find all the palindrome substring
 */

public class String04 {

	static class Pair {
		char c;
		long cnt;

		public Pair(char c, long cnt) {
			this.c = c;
			this.cnt = cnt;
		}
	}

	// Complete the substrCount function below.
	static long substrCount(int n, String s) {
		long count = 0;
		List<Pair> list = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			int j = i + 1;
			while (j < s.length() && s.charAt(j) == s.charAt(i))
				j++;
			list.add(new Pair(s.charAt(i), j - i));
			i = j - 1;
		}

		for (int i = 0; i < list.size(); i++) {
			Pair pair = list.get(i);
			count += (1 + pair.cnt) * pair.cnt / 2;
			if (pair.cnt == 1 && i > 0 && i < list.size() - 1) {
				Pair pre = list.get(i - 1);
				Pair next = list.get(i + 1);
				if (pre.c == next.c) {
					count += Math.min(pre.cnt, next.cnt);
				}
			}
		}

		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String s = scanner.nextLine();

		long result = substrCount(n, s);

		System.out.println(String.valueOf(result));

		scanner.close();
	}
}
