package Array;

import java.util.ArrayList;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class MergeIntervals {

	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

		ArrayList<Interval> result = new ArrayList<>();
		for (int i = 0; i < intervals.size(); i++) {
			Interval interval = intervals.get(i);
			if (interval.end < newInterval.start) {
				result.add(interval);
			} else if (newInterval.end < interval.start) {
				result.add(newInterval);
				result.addAll(intervals.subList(i, intervals.size()));
				return result;
			} else {
				int start = Math.min(newInterval.start, interval.start);
				int end = Math.max(newInterval.end, interval.end);
				newInterval.start = start;
				newInterval.end = end;
			}
		}
		result.add(newInterval);
		return result;
	}

	public static void main(String[] args) {
				
		Interval a = new Interval(1,3);
		Interval b = new Interval(6,9);
		Interval c = new Interval(2,5);
		ArrayList<Interval> ar = new ArrayList<Interval>();
		ar.add(a);
		ar.add(b);
		
		ArrayList<Interval> res = insert(ar, c);
		for(Interval i: res){
			System.out.println("Start: "+i.start+" End: "+i.end);
		}
	}

}
