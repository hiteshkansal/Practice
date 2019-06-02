package Array;

public class MaxSumContiguousSubarray {

	public static void main(String[] args) {
		int x[] = {-1,4,6,0,-11,1};

		System.out.println(maxSubArray(x));
	}

	public static int maxSubArray(final int[] A) {
		int localMax = 0, max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			localMax += A[i];
			if (max < localMax)
				max = localMax;
			if (localMax < 0)
				localMax = 0;
		}
		return max;
	}
}
