import java.util.Scanner;

public class HackerRank02 {

	private static final Scanner scanner = new Scanner(System.in);

	static int findItems(int[] arr, int n, int temp) {
		int ans = 0;
		for (int i = 0; i < n; i++)
			ans += (temp / arr[i]);
		return ans;
	}

	static int bs(int[] arr, int n, int m, int high)
	{
		int low = 1;

		while (low < high) {
			int mid = (low + high) >> 1;

			int itm = findItems(arr, n, mid);
			if (itm < m)
				low = mid + 1;
			else
				high = mid;
		}

		return high;
	}

	static int minTime(int[] arr, int n, int m) {
		int maxval = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++)
			maxval = Math.max(maxval, arr[i]);

		return bs(arr, n, m, maxval * m);
	}

	public static void main(String[] args) {

		String[] nk = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);

		int input[] = new int[k];
		for (int tItr = 0; tItr < k; tItr++) {
			int time = scanner.nextInt();
			input[tItr] = time;
		}
		int result = minTime(input, k, n);
		System.out.println(result);
		scanner.close();

	}

}
