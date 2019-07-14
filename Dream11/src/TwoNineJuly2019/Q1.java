package TwoNineJuly2019;

import java.util.ArrayList;
import java.util.List;

public class Q1 {

	public static void finalPrice(List<Integer> prices) {

		int n = prices.size();
		if (n == 1) {
			System.out.println(prices.get(0));
			System.out.println(0);
			return;
		}
		int cost = 0, val;
		boolean flag = true;
		List<Integer> out = new ArrayList<Integer>();
		for (int i = 0; i < n - 1; i++) {
			flag = true;
			val = prices.get(i);
			for (int j = i + 1; j < n; j++) {
				if (val >= prices.get(j)) {
					cost += (val - prices.get(j));
					flag = false;
					break;
				}
			}
			if (flag) {
				cost += val;
				out.add(i);
			}
		}

		cost += prices.get(n - 1);
		out.add(n - 1);
		System.out.println(cost);
		for (int j : out)
			System.out.print(j + " ");
	}

	public static void main(String[] args) {

		List<Integer> l = new ArrayList<>();
		l.add(1);
		l.add(3);
		l.add(3);
		l.add(2);
		l.add(5);
		finalPrice(l);

	}

}
