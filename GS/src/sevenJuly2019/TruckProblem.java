package sevenJuly2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TruckProblem {

	static List<Integer> findTruckCargo(int maxCargoWeight, List<List<Integer>> cargoList) {
		int n = cargoList.size();
		int wt[] = new int[n];
		int val[] = new int[n];
		int cn[] = new int[n];

		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			cn[i] = cargoList.get(i).get(0);
			wt[i] = cargoList.get(i).get(1);
			val[i] = cargoList.get(i).get(2);
		}

		int i, w;
		int K[][] = new int[n + 1][maxCargoWeight + 1];

		for (i = 0; i <= n; i++) {
			for (w = 0; w <= maxCargoWeight; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (wt[i - 1] <= w)
					K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}

		int res = K[n][maxCargoWeight];
        w = maxCargoWeight;
        for (i = n; i > 0 && res > 0; i--) {
            if (res == K[i - 1][w])
                continue;
            else {

                result.add(cn[i-1]);
                res = res - val[i - 1];
                w = w - wt[i - 1];
            }
        }
        Collections.reverse(result);
        result.add(K[n][maxCargoWeight]);
        return result;
	}

	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public static void main(String[] args) {

		List<List<Integer>> inp = new ArrayList<List<Integer>>();
		
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(38);
		l.add(130);
		l.add(500);
		inp.add(l);
		
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l1.add(21);
		l1.add(280);
		l1.add(1800);
		inp.add(l1);
		
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		l2.add(13);
		l2.add(120);
		l2.add(1500);
		inp.add(l2);
		
		List<Integer> l3 = findTruckCargo(300, inp);
		
		for(int i:l3)
			System.out.println(i);
	}

}
