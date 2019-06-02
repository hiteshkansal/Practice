package String;

public class CountAndSay {

	public static String countAndSay(int A) {
		if (A <= 0)
			return null;
		int i = 1;
		String result = "1";

		while (i < A) {
			StringBuilder sb = new StringBuilder();
			int count = 1;
			for (int j = 1; j < result.length(); j++) {
				if (result.charAt(j) == result.charAt(j - 1))
					count++;
				else {
					sb.append(count);
					sb.append(result.charAt(j - 1));
					count = 1;
				}
			}
			sb.append(count);
			sb.append(result.charAt(result.length() - 1));
			result = sb.toString();
			i++;
		}
		return result;
	}

	public static void main(String[] args) {

		System.out.println(countAndSay(4));
	}

}
