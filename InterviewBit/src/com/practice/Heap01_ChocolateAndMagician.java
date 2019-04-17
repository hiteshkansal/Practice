package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Heap01_ChocolateAndMagician {

	public static int nchoc(int A, ArrayList<Integer> B) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		long result=0;
		int choc;
		for(int i=0;i<B.size();i++){
			pq.add(B.get(i));
		}
		for(int j=0;j<A;j++){
			choc=pq.remove();
			result+=choc;
			pq.add(choc/2);
		}
		System.out.println(result);
		return (int) (result%(1000000007));
    
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> ar = new ArrayList<>();
		ar.add(2147483647);
		ar.add(2000000014);
		ar.add(2147483647);
		System.out.println(nchoc(10,ar));
	}

}
