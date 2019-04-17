package com.practice;

import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Heap05_LRU {

	static Deque<Integer> dq;
	static HashMap<Integer, Integer> map;
	static int cacheSize;
	
	public Heap05_LRU(int capacity) {
		dq = new LinkedList<Integer>();
		map = new HashMap<>();
		cacheSize = capacity;
    }
    
	public int get(int key) {
		
		if(map.containsKey(key)){
			dq.remove(key);
			dq.addFirst(key);
			return map.get(key);
		} else {
			return -1;
		}
	}
    
    public void set(int key, int value) {
    	if(!map.containsKey(key)){
			if(dq.size() == cacheSize){
				int last = dq.removeLast();
				map.remove(last);
			}
			dq.addFirst(key);
			map.put(key, value);
		} else {
			dq.remove(key);
			dq.addFirst(key);
			map.put(key, value);
		}
    }
    
	public static void main(String arg[]) {
		
		Heap05_LRU ca=new Heap05_LRU(2); 
		
        ca.set(2,1);
		ca.set(2,2);
		System.out.println(ca.get(2));
        ca.set(1,1);  
        ca.set(4, 1);  
        System.out.println(ca.get(2));  
		ca.display();
	}
	
	public void display() 
    { 
        Iterator<Integer> itr = dq.iterator(); 
        System.out.print("Dequeue Content: ");
        while(itr.hasNext()) 
        { 
            System.out.print(itr.next()+" "); 
        } 
    } 
}
