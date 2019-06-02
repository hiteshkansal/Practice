package Array;

import java.util.Arrays;

public class WaveArray {

	public static void main(String[] args) {
		int x[] = { 1, 2, 3, 4 };

		int y[] = wave(x);
		for (int i : y)
			System.out.print(i);

	}

	public static int[] wave(int[] A) {
		Arrays.sort(A);
		boolean flag = true;
		int temp;
		for (int i = 1; i < A.length; i++) {
			if (flag) {
				if (A[i - 1] < A[i]) {
					temp = A[i];
					A[i] = A[i - 1];
					A[i - 1] = temp;
				}
			} else {
				if (A[i - 1] > A[i]) {
					temp = A[i];
					A[i] = A[i - 1];
					A[i - 1] = temp;
				}
			}
			flag = !flag;
		}
		return A;
	}

}
