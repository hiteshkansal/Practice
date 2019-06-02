package String;

public class LongestPalindromeSubstring {

	public static void main(String[] args) {

		System.out.println(longestPalindromeEfficient("aaaabaaa"));

	}

	//Space complexity=O(n^2)
	public static String longestPalindrome(String A) {
		int len = A.length();
		boolean table[][] = new boolean[len][len];
		int maxLength = 1, start = 0;

		for (int i = 0; i < len; i++)
			table[i][i] = true;

		for (int i = 0; i < len - 1; i++) {
			if (A.charAt(i) == A.charAt(i + 1)) {
				table[i][i + 1] = true;
				start = i;
				maxLength = 2;
			}
		}

		for (int k = 3; k <= len; k++) {
			for (int i = 0; i < len - k + 1; i++) {
				int j = i + k - 1;
				if (table[i + 1][j - 1] && A.charAt(i) == A.charAt(j)) {
					table[i][j] = true;
					if (k > maxLength) {
						start = i;
						maxLength = k;
					}
				}
			}
		}
		return A.substring(start, start + maxLength);
	}
	
	//Space complexity=O(1)
	public static String longestPalindromeEfficient(String A) {
		int len = A.length();
		int maxLength=1, start=0;
		int low, high;
		for(int i=1;i<len;i++){
			low=i-1;
			high=i;
			while(low>=0 && high<len && (A.charAt(low) == A.charAt(high))){
				if(high-low+1>maxLength){
					start=low;
					maxLength = high-low+1;
				}
				low--;
				high++;
			}
			
			low=i-1;
			high=i+1;
			while(low>=0 && high<len && (A.charAt(low) == A.charAt(high))){
				if(high-low+1>maxLength){
					start=low;
					maxLength = high-low+1;
				}
				low--;
				high++;
			}
		}
		return A.substring(start, start + maxLength);
	}
}
