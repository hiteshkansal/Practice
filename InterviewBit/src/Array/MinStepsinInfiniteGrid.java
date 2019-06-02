package Array;

public class MinStepsinInfiniteGrid {

	public static int coverPoints(int[] X, int[] Y) {
		int totalDistance = 0;
		for (int i = 0; i < X.length - 1; i++) {
			totalDistance += Math.abs(X[i + 1] - X[i]) > Math.abs(Y[i + 1] - Y[i]) ? Math.abs(X[i + 1] - X[i])
					: Math.abs(Y[i + 1] - Y[i]);
		}
		return totalDistance;
	}

	public static void main(String arg[]) {
		int x[] = {0,1,1};
		int y[] = {0,1,2};
		
		System.out.println(coverPoints(x, y));
	}
}
