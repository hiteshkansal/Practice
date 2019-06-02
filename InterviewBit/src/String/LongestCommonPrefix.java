package String;

import java.util.ArrayList;

public class LongestCommonPrefix {

	public static String longestCommonPrefix(ArrayList<String> A) {
        StringBuffer result = new StringBuffer("");
        if(A.size()==0)
            return "";
        if(A.size()==1)
            return A.get(0);
        int i=0,j=0, size = A.size();
        while(true){
            String s1 =  A.get(0);
            if(i==s1.length())
            	return result.toString();
        	Character c = s1.charAt(i);
            for(j=1;j<size;j++){
                String s = A.get(j);
                if(i==s.length())
                    return result.toString();
                Character c1 = s.charAt(i);
                if(c!=c1)
                    return result.toString();
            }
            result.append(c);
            i++;
        }
    }
	
	public static void main(String[] args) {
		
		ArrayList<String> s = new ArrayList<>();
		s.add("aaaaaaaaaaaaaaaaaaaaaaaaaa");
		s.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		s.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		s.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		s.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		s.add("aaaaaaaaaaaa");
		s.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		s.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		s.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		s.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		s.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		System.out.println(longestCommonPrefix(s));
	}

}
