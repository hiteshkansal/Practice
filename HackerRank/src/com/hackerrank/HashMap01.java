package com.hackerrank;

import java.util.HashMap;

/*
 * Harold is a kidnapper who wrote a ransom note, but now he is worried it will be traced back to him through his handwriting. 
 * He found a magazine and wants to know if he can cut out whole words from it and use them to create an untraceable replica of his ransom note.
 * The words in his note are case-sensitive and he must use only whole words available in the magazine. 
 * He cannot use substrings or concatenation to create the words he needs.
Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print No.

For example, the note is "Attack at dawn". The magazine contains only "attack at dawn". 
The magazine has all the right words, but there's a case mismatch. The answer is No.
 */
public class HashMap01 {

	public static void main(String[] args) {

		String[] magazine ={"give", "me", "one", "grand", "today", "night", "one"}; 
		String[] note = {"give", "one", "grand", "today", "one"};
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		boolean flag = true;
		for(int i=0;i<magazine.length;i++){
			Integer temp = map.get(magazine[i]);
			if(temp==null)
				map.put(magazine[i], 1);
			else
				map.put(magazine[i], ++temp);
		}
		for(int i=0;i<note.length;i++){
			Integer temp = map.get(note[i]);
			if(temp==null||temp==0)
				flag = false;
			else
				map.put(note[i], --temp);
		}
		if(flag)
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}
