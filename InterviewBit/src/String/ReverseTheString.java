package String;

public class ReverseTheString {

	public static String reverseWords(String a) {
        String spl[] = a.trim().split(" ");
        StringBuilder sss = new StringBuilder();
        for(int j=0; j<spl.length;j++){
            if("".equals(spl[j])){
                continue;
            }
            sss.append(wordRev(spl[j]).trim());
            sss.append(" ");
        }
        return wordRev(sss.toString()).trim();
    }
    
    public static String wordRev(String s){
        int len = s.length();
        int i=0;
        StringBuilder sb = new StringBuilder();
        for(i=len-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    
	public static void main(String[] args) {

		System.out.println(reverseWords("the sky is blue"));
	}

}
