package TwoNineJuly2019;

import java.util.List;

public class Q2 {
	public static int numberOfPaths(List<List<Integer>> a) {
		if (a == null || a.isEmpty())
			return 0;
		int rows = a.size();
		int cols = a.get(0).size();
		int res[][] = new int[rows][cols];
		if (a.get(0).get(0) == 0)
			return 0;

		for (int i = 0; i < rows; i++) {
			if (a.get(i).get(0) == 1)
				res[i][0] = 1;
			else
				break;
		}

		for (int i = 0; i < cols; i++) {
			if (a.get(0).get(i) == 1)
				res[0][i] = 1;
			else
				break;
		}

		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if (a.get(i).get(j) == 0) {
					res[i][j] = 0;
					continue;
				}
				if (a.get(i - 1).get(j) == 1)
					res[i][j] = res[i][j] + res[i - 1][j];
				if (a.get(i).get(j - 1) == 1)
					res[i][j] = res[i][j] + res[i][j - 1];
			}
		}
		return res[rows - 1][cols - 1];
	}

	public static void main(String[] args) {

		
	}

}
