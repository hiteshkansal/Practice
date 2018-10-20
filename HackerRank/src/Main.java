import java.io.IOException;

public class Main {

	public static int getIntegerComplement(int number) {
		char[] binary = Integer.toString(number, 2).toCharArray();
		flipBits(binary);
		return Integer.parseInt(String.valueOf(binary), 2);
	}

	private static void flipBits(char[] binary) {
		for (int i = 0; i < binary.length; i++) {
			if (binary[i] == '0')
				binary[i] = '1';
			else
				binary[i] = '0';
		}
	}

	public static void main(String[] args) throws IOException {

		// System.out.println(n1);

		int x = 2, y = 7, z = 10, max = 0;

		int diff = x - y;
		if (Math.abs(diff) > z)
			max = -1;
		else if (diff < 0) {
			z = z - Math.abs(diff);
			max = y + (z / 2);
		} else {
			max = x + (z / 2);
		}
		System.out.println(max);

		/*
		 * Scanner scanner = new Scanner(System.in); int t =
		 * Integer.parseInt(scanner.nextLine()); List<Integer> result = new
		 * ArrayList<>(); // try { while (t > 0) { Integer n =
		 * Integer.parseInt(scanner.nextLine()); if(n<2){ //
		 * System.out.println(0); return; } Integer[] c = new Integer[n];
		 * String[] cItems = scanner.nextLine().split(" "); //
		 * scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?"); for (int i = 0; i <
		 * n; i++) { Integer cItem = Integer.parseInt(cItems[i]); c[i] = cItem;
		 * } if(c[0]<1){ // System.out.println(0); return; } //
		 * System.out.println(); result.add(spread(n, c)); //
		 * System.out.println(); t--; } for (Integer i : result) {
		 * System.out.println(i); } } catch (Exception e) { return; } finally {
		 * scanner.close(); // }
		 */
	}

	private static Integer spread(Integer n, Integer[] c) {
		Integer n_per_affected = 1;
		Integer n_per_can_affect = c[0];
		Integer n_days = 0;

		while (n_per_affected <= n) {
			int i = n_per_affected;
			n_per_affected = n_per_affected + n_per_can_affect;
			if (n - n_per_affected <= 0) {
				return ++n_days;
			}
			while (i < n && i <= n_per_affected) {
				n_per_can_affect = n_per_can_affect + c[i];
				i++;
			}
			n_days++;
		}
		return n_days;
	}
}
