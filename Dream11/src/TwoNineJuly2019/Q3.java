package TwoNineJuly2019;

import java.util.List;

public class Q3 {

	public static String plusMult(List<Integer> A) {

		long rEven, rOdd;
		boolean isMul = true;
		// Size of list >= 10
		rEven = A.get(0);
		rOdd = A.get(1);
		for (int i = 2; i < A.size(); i += 2) {
			if (isMul) {
				rEven = rEven * A.get(i);
				isMul = !isMul;
			} else {
				rEven = rEven + A.get(i);
				isMul = !isMul;
			}
		}
		isMul = true;
		for (int i = 3; i < A.size(); i += 2) {
			if (isMul) {
				rOdd = rOdd * A.get(i);
				isMul = !isMul;
			} else {
				rOdd = rOdd + A.get(i);
				isMul = !isMul;
			}
		}
		long evenMod = rEven % 2;
		long oddMod = rOdd % 2;
		if (evenMod > oddMod)
			return "EVEN";
		else if (evenMod < oddMod)
			return "ODD";
		else
			return "NEUTRAL";
	}

	public static void main(String[] args) {

		
	}

}
