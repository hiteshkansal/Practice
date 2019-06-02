package String;

public class PalindromeString {

	public static boolean isAlphaNumeric(Character c){
        return Character.isDigit(c)||Character.isLetter(c);
    }
	
    public static int isPalindrome(String A) {
        int len = A.length();
        int i=0, j=len-1;
        while(i<j){
            Character c = Character.toLowerCase(A.charAt(i));
            Character c1 = Character.toLowerCase(A.charAt(j));
            if(isAlphaNumeric(c) && isAlphaNumeric(c1)){
                if(c!=c1)
                    return 0;
                i++;
                j--;
                continue;
            }
            
            if(!isAlphaNumeric(c1))
                j--;
            
            if(!isAlphaNumeric(c))
                i++;
        }
        return 1;
    }
    
	public static void main(String[] args) {

		String s = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(s));
	}

}
