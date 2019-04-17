package com.hackerrank;

public class Greedy05 {

   // Complete the reverseShuffleMerge function below.
    static String reverseShuffleMerge(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int[] used = new int[26], rem = new int[26];
        for (int i = 0; i < count.length; i++) {
            rem[i] = count[i];
        }
        
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (sb.length() == 0) {
                sb.append(c);
                used[c - 'a']++;
            }else {
                if (2 * used[c - 'a'] == count[c - 'a']) {
                    rem[c - 'a']--;
                    continue;
                }
                
                while (sb.length() > 0) {
                    char last = sb.charAt(sb.length() - 1);
                    if (c < last && 2 * (rem[last - 'a'] + used[last - 'a']) > count[last - 'a']){
                        used[last - 'a']--;
                        sb.deleteCharAt(sb.length() - 1);
                    }else {
                        break;
                    }
                }
                
                sb.append(c);
                used[c - 'a']++;
            }
            rem[c - 'a']--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
     
    	System.out.println(reverseShuffleMerge("aeiouuoiea"));

    }
}
