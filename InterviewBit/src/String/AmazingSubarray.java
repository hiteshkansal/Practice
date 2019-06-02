package String;

public class AmazingSubarray {

	public int solve(String A) {
        int result=0;
        int len = A.length();
        for(int i=0;i<len;i++){
            Character c = A.charAt(i);
            if(c=='a'||c=='A'||c=='e'||c=='E'||c=='i'||c=='I'||c=='o'||c=='O'||c=='u'||c=='U'){
                int rem = len-i;
                result+=rem;
            }
        }
        return result%10003;
    }
	
	public static void main(String[] args) {

		AmazingSubarray as = new AmazingSubarray();
		System.out.println(as.solve("AedfEr"));
	}

}
