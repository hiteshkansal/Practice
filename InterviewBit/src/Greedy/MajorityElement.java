package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElement {

	public int majorityElement(final List<Integer> A) {
		int elem = A.get(0);
		int count = 1;
		for (int i = 1; i < A.size(); i++) {
			if (A.get(i) == elem) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				elem = A.get(i);
				count = 1;
			}
		}
		return elem;
	}

	public static void main(String[] args) {
		Integer a[] = { 1, 1, 1, 3, 4, 5, 1 };
		ArrayList<Integer> ar = new ArrayList<>(Arrays.asList(a));
		System.out.println(new MajorityElement().majorityElement(ar));
	}

}
