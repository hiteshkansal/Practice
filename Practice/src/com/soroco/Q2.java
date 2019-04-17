package com.soroco;

import java.util.ArrayList;
import java.util.List;

public class Q2 {

	public static int can_give_change(List<Integer> rupee_notes) {
		int res=0, change5=0, change10=0, change20=0, cust=0, ret=0;
		if(rupee_notes.get(0)!=5)
			return 1;
		for (int i = 0; i < rupee_notes.size(); i++) {
			cust = rupee_notes.get(i);
			ret = cust-5;
			if(ret>(change5*5)){
				res=i+1;
				break;
			}
			if(cust==5){
				change5+=1;
				
			}
			if(cust==10){
				change10+=1;
			}
			if(cust==20){
				change20+=1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(5);
		arr.add(5);
		arr.add(5);
		arr.add(20);
		System.out.println(can_give_change(arr));
	}

}
