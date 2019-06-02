package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class MergeOverlappingIntervals {

	public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        if (intervals.size() < 2)
            return intervals;
    
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
    
        ArrayList<Interval> mergedIntervals = new ArrayList<Interval>();
        Iterator<Interval> intervalItr = intervals.iterator();
        Interval interval = intervalItr.next();
        int start = interval.start;
        int end = interval.end;
        
        while(intervalItr.hasNext()){
            interval = intervalItr.next();
            if(end>=interval.start){
                end = Math.max(end, interval.end);
            } else {
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        mergedIntervals.add(new Interval(start, end));

    return mergedIntervals;
    }
	public static void main(String[] args) {
		ArrayList<Interval> input = new ArrayList<Interval>();
	    input.add(new Interval(1, 3));
	    input.add(new Interval(2, 5));
	    input.add(new Interval(7, 9));
	    System.out.print("Merged intervals: ");
	    for (Interval interval : merge(input))
	      System.out.print("[" + interval.start + "," + interval.end + "] ");
	    System.out.println();

	    input = new ArrayList<Interval>();
	    input.add(new Interval(6, 7));
	    input.add(new Interval(2, 4));
	    input.add(new Interval(5, 9));
	    System.out.print("Merged intervals: ");
	    for (Interval interval : merge(input))
	      System.out.print("[" + interval.start + "," + interval.end + "] ");
	    System.out.println();

	    input = new ArrayList<Interval>();
	    input.add(new Interval(1, 4));
	    input.add(new Interval(2, 6));
	    input.add(new Interval(3, 5));
	    System.out.print("Merged intervals: ");
	    for (Interval interval : merge(input))
	      System.out.print("[" + interval.start + "," + interval.end + "] ");
	    System.out.println();
	  

	}

}
