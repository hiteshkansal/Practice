package com.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
You are given  queries. Each query is of the form two integers described below: 
-1x : Insert x in your data structure. 
-2y : Delete one occurence of y from your data structure, if present. 
-3z : Check if any integer is present whose frequency is exactly . If yes, print 1 else 0.

The queries are given in the form of a 2-D array queries of size q where queries[i][0] contains the operation, 
and queries[i][1] contains the data element. For example

Operation   Array   Output
(1,1)       [1]
(2,2)       [1]
(3,2)                   0
(1,1)       [1,1]
(1,1)       [1,1,1]
(2,1)       [1,1]
(3,2)                   1
Return an array with the output: [0,1]
 */

public class HashMap05 {

	public static void main(String[] args) {

		List<ArrayList<Integer>> queries = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> data = new ArrayList<Integer>();
		data.add(1);
		data.add(3);
		ArrayList<Integer> data1 = new ArrayList<Integer>();
		data1.add(2);
		data1.add(3);
		ArrayList<Integer> data2 = new ArrayList<Integer>();
		data2.add(3);
		data2.add(2);
		ArrayList<Integer> data3 = new ArrayList<Integer>();
		data3.add(1);
		data3.add(4);
		ArrayList<Integer> data4 = new ArrayList<Integer>();
		data4.add(1);
		data4.add(5);
		ArrayList<Integer> data5 = new ArrayList<Integer>();
		data5.add(1);
		data5.add(5);
		ArrayList<Integer> data6 = new ArrayList<Integer>();
		data6.add(1);
		data6.add(4);
		ArrayList<Integer> data7 = new ArrayList<Integer>();
		data7.add(3);
		data7.add(2);
		ArrayList<Integer> data8 = new ArrayList<Integer>();
		data8.add(2);
		data8.add(4);
		ArrayList<Integer> data9 = new ArrayList<Integer>();
		data9.add(3);
		data9.add(2);

		queries.add(data);
		queries.add(data1);
		queries.add(data2);
		queries.add(data3);
		queries.add(data4);
		queries.add(data5);
		queries.add(data6);
		queries.add(data7);
		queries.add(data8);
		queries.add(data9);
		
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
		List<Integer> result = new ArrayList<Integer>();
		
		int oper, dt;
		for(int i=0;i<queries.size();i++){
			oper = queries.get(i).get(0);
			dt = queries.get(i).get(1);
			if(oper==1){
				Integer c = count.get(dt);
				if(c==null){
					count.put(dt, 1);
					Integer fr = freq.get(1);
					if(fr==null||fr==0)
						freq.put(1, 1);
					else
						freq.put(1, ++fr);
				}
				else{
					Integer fr = freq.get(c);
					freq.put(c, --fr);
					count.put(dt, ++c);
					fr = freq.get(c);
					if(fr==null||fr==0)
						freq.put(c, 1);
					else
						freq.put(c, ++fr);
				}
			}else if(oper==2){
				Integer c = count.get(dt);
				if(c!=null && c>0){
					Integer fr = freq.get(c);
					freq.put(c, --fr);
					count.put(dt, --c);
					fr = freq.get(c);
					if(fr==null||fr==0)
						freq.put(c, 1);
					else
						freq.put(c, ++fr);
				}
			}else if(oper==3){
				Integer c = freq.get(dt);
				if(c!=null && c>0){
					result.add(1);
				} else{
					result.add(0);
				}
			}
		}
		for(int k:result)
			System.out.println(k+" ");
	}

}
