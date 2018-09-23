package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval {
	Integer start;
	Integer end;

	public Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class ActivitySelection {

	public static void printMaxActivities(ArrayList<Interval> arr, int n) {
		int i, j;
		System.out.print("Following activities are selected : ");
		i = 0;
		System.out.print("(" + arr.get(i).start + "," + arr.get(i).end + ")");
		for (j = 1; j < n; j++) {
			if (arr.get(j).start >= arr.get(i).end) {
				System.out.print("(" + arr.get(j).start + "," + arr.get(j).end + ")");
				i = j;
			}
		}
	}

	public static void main(String[] args) {

		Interval i1 = new Interval(2, 5);
		Interval i2 = new Interval(1, 2);
		Interval i3 = new Interval(5, 6);

		ArrayList<Interval> inter = new ArrayList<>();
		inter.add(i1);
		inter.add(i2);
		inter.add(i3);

		Collections.sort(inter, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return (o1.end).compareTo(o2.end) > 0 ? 1 : -1;
			}
		});
		printMaxActivities(inter, inter.size());
	}
}
