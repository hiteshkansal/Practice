package com.hackerrank;

import java.util.HashMap;

/*
 * Sherlock considers a string to be valid if all characters of the string appear the same number of times. 
 * It is also valid if he can remove just 1 character at 1 index in the string, and the remaining characters 
 * will occur the same number of times. Given a string s, determine if it is valid. If so, return YES, otherwise return NO.
 */
public class String03 {

	static String isValid(String s) {
	    int prev = Integer.MAX_VALUE;
	    boolean flag = true;
	    int count=0;

	    HashMap<Character ,Integer> map = new HashMap<Character, Integer>();
	    for(char c:s.toCharArray())
	        map.put(c, map.getOrDefault(c,0) + 1);
	    
	    prev = map.get(s.charAt(0));
	    for(Integer i:map.values()){
	        if(i==prev){
	            count++;
	            continue;

	        }else if((Math.abs(i - prev)==1 || (i-1)==0 || (prev-1) ==0) && flag){
	            flag =false;
	            count++;
	        }
	    }
	    if(count==map.size())
	        return "YES";
	    else
	        return "NO";
    }
	
	public static void main(String arg[]) {
		String s = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";
		System.out.println(isValid(s));
	}
}
