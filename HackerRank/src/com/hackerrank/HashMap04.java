package com.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * You are given an array and you need to find number of tripets of indices (i,j,k) such that the elements at those indices are in geometric progression for a given 
 * common ratio r and i<j<k.

For example, arr[1,4,16,64] . If r=4, we have [1,4,16] and [4,16,64]
 */
public class HashMap04 {

	static long countTriplets(List<Long> arr, long r) {
		
		HashMap<Long, Long> map1 = new HashMap<Long, Long>();
	    HashMap<Long, Long> map2 = new HashMap<Long, Long>();
	    long count = 0;
	    for(int i = arr.size() - 1; i >= 0; i--) {
	        long a = arr.get(i);
	        
	        if(map2.containsKey(a*r))
	            count += map2.get(a*r);

	        if(map1.containsKey(a*r)) {
	            long c = map1.get(a*r);
	            map2.put(a, map2.getOrDefault(a, 0L) + c);
	        }

	        map1.put(a, map1.getOrDefault(a, 0L) + 1);  
	    }
	    return count;
    }
	
	public static void main(String[] args) throws IOException {
        
		/*List<Long> arr = new ArrayList<Long>();
		arr.add(1L);
		arr.add(3L);
		arr.add(9L);
		arr.add(9L);
		arr.add(27L);
		arr.add(81L);
		int r=3;*/
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r1 = Long.parseLong(nr[1]);

        List<Long> arr1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(Collectors.toList());
        long ans = countTriplets(arr1, r1);
       System.out.println(ans);
    }
}
