package com.hackerrank;

import java.util.HashMap;
import java.util.Map;

/* It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride! 
 There are a number of people queued up, and each person wears a sticker indicating their initial position in the queue. 
 Initial positions increment by  from  at the front of the line to  at the back.
 Any person in the queue can bribe the person directly in front of them to swap positions. 
 If two people swap positions, they still wear the same sticker denoting their original places in line. One person can bribe at most two others. 
 Fascinated by this chaotic queue, you decide you must know the minimum number of bribes that took place to get the queue into its current state!
*/

public class Array03 {

	public static void main(String[] args) {

		int q[] = {3, 1, 5, 6, 2, 4};
		int n = q.length;
		int bribe=0;
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		boolean flag = true, chaoticFlag=false;
		for(int i=0;i<n;i++){
			flag=true;
			for(int j=0;j<n-i-1;j++){
				if(q[j]>q[j+1]){
					flag = false;
					swap(q,j,j+1);
					Integer value = count.get(q[j+1]);
					if(value==null){
						count.put(q[j+1], 1);
					}
					else if(value==2){
						chaoticFlag=true;
						break;
					}
					else
						count.put(q[j+1], ++value);
					bribe++;
				}
			}
			if(chaoticFlag||flag)
				break;
		}
		if(chaoticFlag)
			System.out.println("Too chaotic");
		else
			System.out.println(bribe);
		
		System.out.println("Size: "+count.size());
		for(Map.Entry<Integer, Integer> me : count.entrySet()){
			System.out.println(me.getKey()+"--"+me.getValue());
		}
		
	}

	static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}
