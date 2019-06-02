import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Interval {
	  int start;
	  int end;

	  public Interval(int start, int end) {
	    this.start = start;
	    this.end = end;
	  }
};

public class HackerRank01 {

	private static final Scanner scanner = new Scanner(System.in);
	
	public static List<Interval> merge(List<Interval> intervals) {
	    if (intervals.size() < 2)
	      return intervals;

	    Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

	    List<Interval> mergedIntervals = new ArrayList<Interval>();
	    Iterator<Interval> intervalItr = intervals.iterator();
	    Interval interval = intervalItr.next();
	    int start = interval.start;
	    int end = interval.end;

	    while (intervalItr.hasNext()) {
	      interval = intervalItr.next();
	      if (interval.start <= end) { 
	        end = Math.max(interval.end, end);
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
		int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < n; tItr++) {
        	String[] inter = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            int st = Integer.parseInt(inter[0]);
    		int end = Integer.parseInt(inter[1]);
    		Interval it = new Interval(st, end);
    		input.add(it);
        }
        int result=0;
        ArrayList<Interval> output = (ArrayList<Interval>) merge(input);
        for(Interval i:output){
        	result+=(i.end-i.start+1);
        	
        }
        System.out.println(result);
        scanner.close();

	}

}
