package LevelClearProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestConsecutiveSequence {

	public int longestConsecutive(final List<Integer> A) {
		int result = Integer.MIN_VALUE;
		Map<Integer, Boolean> hm = new HashMap<>();
		int temp, localSeq;
		for(int i=0;i<A.size();i++){
			temp = A.get(i);
			localSeq=1;
			int t = temp;
			hm.put(temp, true);
			while(hm.get(--t)!=null){
				hm.put(t, true);
				localSeq++;
			}
			t = temp;
			while(hm.get(++t)!=null){
				hm.put(t, true);
				localSeq++;
			}
			if(localSeq>=result)
				result = localSeq;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Integer a[] = {100, 4, 200, 1, 3, 2};
		ArrayList<Integer> ar = new ArrayList<>(Arrays.asList(a));
		System.out.println(new LongestConsecutiveSequence().longestConsecutive(ar));
	}

}
