package String;

public class MinimumCharactersRequiredToMakeStringPalindromic {

	public static void main(String[] args) {

		System.out.println(solve("AACECAAAA"));
	}

	public static boolean isPal(String A){
        if(A!=null){
            StringBuilder s = new StringBuilder(A);
            return s.reverse().toString().equals(A);
        }
        return false;
    }
    public static int solve(String A) {
        int start=0, end=0,count=0;
        
        String cp = new StringBuilder(A).reverse().toString();
        if(isPal(A)) return count;
        while(true){
            if(isPal(cp.substring(start, end)+A)) break;
            end++;
            count++;
        }
        return count;
    }
}
