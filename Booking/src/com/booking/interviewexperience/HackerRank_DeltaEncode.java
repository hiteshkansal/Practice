package com.booking.interviewexperience;

import java.util.ArrayList;
import java.util.List;

public class HackerRank_DeltaEncode {

	static int[] delta_encode(int[] array) {

		List<Integer> result = new ArrayList<Integer>();
		result.add(array[0]);
		for (int i = 1; i < array.length; i++) {
			int diff = array[i] - array[i - 1];
			if (diff <= 127 && diff >= -127) {
				result.add(diff);
			} else {
				result.add(-128);
				result.add(diff);
			}
		}
		return result.stream().mapToInt(i -> i).toArray();

	}

	public static void main(String[] args) {
		int a[] = { 24367, 24267, 16, 100, 2, 7277 };
		int[] r = delta_encode(a);
		for (int k : r)
			System.out.println(k);
	}
}
