package String;

public class LengthOfLastWord {

	public static int lengthOfLastWord(final String A) {
	       String B = A.trim();
	        int count=0, size= B.length();
	        if(size==0)
	            return 0;
	        
	        int i=size-1;
	        while(i>=0 && B.charAt(i)!=' '){
	            count++;
	            i--;
	        }
	        return count;
	    }
	
	public static void main(String[] args) {

		System.out.println(lengthOfLastWord("Hello World"));
	}

}
