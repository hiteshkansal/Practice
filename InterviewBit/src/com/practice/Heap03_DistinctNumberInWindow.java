package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Heap03_DistinctNumberInWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(1);
		a.add(3);
		a.add(4);
		a.add(3);
		/*a.add(31);
		a.add(51);
		a.add(31);
		a.add(51);
		a.add(31);
		a.add(31);
		a.add(31);
		a.add(31);
		a.add(31);
		a.add(31);
		a.add(51);
		a.add(31);
		a.add(31);*/
		ArrayList<Integer> b = dNums(a,3);
		
		for(int k:b)
			System.out.println(k);
	}

	public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
		ArrayList<Integer> res = new ArrayList<>();
		
		Map<Integer, Integer> hm = new HashMap<>();
		int start = 0, count=0, j;
		
		for(j=0;j<B;j++){
			int key = A.get(j);
			Integer val = hm.get(key);
			if(val==null){
				hm.put(key, 1);
				count++;
			} else {
				hm.put(key, ++val);
			}
		}
		
		res.add(count);
		
		for(int i=j;i<A.size();i++){
			int key2 = A.get(start);
			Integer rm = hm.get(key2);
			if(rm!=null){
				if(rm > 1){
					hm.put(key2, --rm);
				} else if(rm == 1){
					hm.remove(key2);
					count--;
				}
			}
			int key1 = A.get(i);
			Integer wd = hm.get(key1);
			if(wd==null){
				hm.put(key1, 1);
				count++;
			} else {
				hm.put(key1, ++wd);
			}
			start++;
			res.add(count);
		}
		
		return res;
    }
	
}
