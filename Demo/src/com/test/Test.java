package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Test {

	public static int threeSumClosest(ArrayList<Integer> A, int B) {
		int n = A.size();
		int min = Integer.MAX_VALUE, result=0;
		Collections.sort(A);
		int a = 0, b = 1, c = n - 1;
		for (a = 0; a < n; a++) {
			c = n - 1;
			b = a + 1;
			while (b < c) {
				int sum = A.get(a) + A.get(b) + A.get(c);
				System.out.println(sum);
				if(Math.abs(sum - B)==0)
					return sum;
				if (Math.abs(sum - B) < min){
					min = Math.abs(sum - B);
					result=sum;
				}
				if (sum > B)
					c--;
				else if (sum < B)
					b++;
			}
		}
		return result;
	}

	public static int gcd(int A, int B) {
		if (A == B)
			return A;
		if (A == 0 || B == 0)
			return 0;
		if (A > B)
			return gcd(A - B, B);
		else
			return gcd(A, B - A);
	}
	/*
	 * static int rotatedSearch(int arr[], int l, int h, int key) { if (l > h)
	 * return -1;
	 * 
	 * int mid = (l+h)/2; if (arr[mid] == key) return mid;
	 * 
	 * if (arr[l] <= arr[mid]) { if (key >= arr[l] && key <= arr[mid]) return
	 * rotatedSearch(arr, l, mid-1, key); else return rotatedSearch(arr, mid+1,
	 * h, key); }
	 * 
	 * if (key >= arr[mid] && key <= arr[h]) return rotatedSearch(arr, mid+1, h,
	 * key); else return rotatedSearch(arr, l, mid-1, key); }
	 */

	static int pivotedBinarySearch(int arr[], int n, int key) {
		int pivot = findPivot(arr, 0, n - 1);

		// If we didn't find a pivot, then
		// array is not rotated at all
		if (pivot == -1)
			return binarySearch(arr, 0, n - 1, key);

		// If we found a pivot, then first
		// compare with pivot and then
		// search in two subarrays around pivot
		if (arr[pivot] == key)
			return pivot;
		if (arr[0] <= key)
			return binarySearch(arr, 0, pivot - 1, key);
		return binarySearch(arr, pivot + 1, n - 1, key);
	}

	/*
	 * Function to get pivot. For array 3, 4, 5, 6, 1, 2 it returns 3 (index of
	 * 6)
	 */
	static int findPivot(int arr[], int low, int high) {
		// base cases
		if (high < low)
			return -1;
		if (high == low)
			return low;

		/* low + (high - low)/2; */
		int mid = (low + high) / 2;
		if (mid < high && arr[mid] > arr[mid + 1])
			return mid;
		if (mid > low && arr[mid] < arr[mid - 1])
			return (mid - 1);
		if (arr[low] >= arr[mid])
			return findPivot(arr, low, mid - 1);
		return findPivot(arr, mid + 1, high);
	}

	/* Standard Binary Search function */
	static int binarySearch(int arr[], int low, int high, int key) {
		if (high < low)
			return -1;
		if (key > arr[arr.length - 1])
			return arr.length;
		if (key < arr[0])
			return 0;
		int mid = (low + high) / 2;
		if (key == arr[mid])
			return mid;
		if (key > arr[mid] && key >= arr[mid + 1])
			return binarySearch(arr, (mid + 1), high, key);
		else if (key < arr[mid] && key <= arr[mid - 1])
			return binarySearch(arr, low, (mid - 1), key);
		else if (key < arr[mid])
			return mid;
		else // if(key>arr[mid])
			return mid + 1;
	}

	public static int binarySearchInsert(List<Integer> a, int b) {
		int n = a.size();

		int start = 0;
		int end = n - 1;

		int mid = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			if (a.get(mid) == b)
				return mid;
			if (a.get(mid) < b)
				start = mid + 1;
			else
				end = mid - 1;
		}

		return start;
	}

	public static String wordRev(String s) {
		int len = s.length();
		int i = 0;
		StringBuilder sb = new StringBuilder();
		for (i = len - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}



	
	public static void main(String[] args) {

		Integer[] v = { -5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3 };
		ArrayList<Integer> l = new ArrayList<Integer>(Arrays.asList(v));
		System.out.println(threeSumClosest(l, -1));
		
		/*TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();

		 Adding elements to TreeMap 
		tmap.put(1, "Data1");
		tmap.put(23, "Data2");
		tmap.put(70, "Data3");
		tmap.put(4, "Data4");
		tmap.put(2, "Data5");
		if (tmap.containsKey(2)) {
			String val = tmap.get(2);
			val = val + "data6";
			tmap.put(2, val);
		}

		Set set = tmap.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry) iterator.next();
			System.out.print("key is: " + mentry.getKey() + " & Value is: ");
			System.out.println(mentry.getValue());
		}*/

		/*
		 * String a = "    This is     a     book   "; String spl[] =
		 * a.trim().split(" "); StringBuilder sss = new StringBuilder(); for(int
		 * j=0; j<spl.length;j++){ if("".equals(spl[j])){ continue; }
		 * sss.append(wordRev(spl[j]).trim()); sss.append(" "); }
		 * System.out.println(wordRev(sss.toString()).trim());
		 */

		

		// String pattern = "(\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-\\d{4}";
		/*
		 * String pattern = "(\\d){2}|(\\d){3}"; //String p1 =
		 * "\\(\\d{3}\\)\\d{3}-\\d{4}"; String input =
		 * "198";//8123-756-7890123(213)123-1234"; Pattern patt =
		 * Pattern.compile(pattern); Matcher matcher = patt.matcher(input); if
		 * (matcher.find()) { System.out.println(matcher.start());
		 * System.out.println(matcher.end()); }
		 * 
		 * 
		 * 
		 * System.out.println(input.matches(pattern));
		 */

		// TODO Auto-generated method stub
		/*
		 * int A = 943566; StringBuilder s = new StringBuilder();
		 * 
		 * while(A>0){ int rem = A%26; if(rem==0){ s.append("Z"); A = (A/26)-1;
		 * } else{ s.append((char)((rem-1)+'A')); A = A/26; } }
		 * System.out.println(s.reverse().toString());
		 */
		// System.out.println(gcd(6,9));

		/*
		 * String A = "AB"; A = A.toUpperCase(); int value = 0; for (int i = 0;
		 * i < A.length(); i++) { int delta = (int)( A.charAt(i));// � 64;
		 * delta-=64; System.out.println("delte: "+delta); value = value*26+
		 * delta; } System.out.println(value);
		 */

		/*
		 * int B=32; List<Integer> A = new ArrayList(); A.add(1); A.add(3);
		 * //A.add(-1); A.add(6); A.add(7); A.add(11); A.add(21); A.add(31);
		 */

		/*
		 * int size = A.size(); int[] array = new int[size]; for(int
		 * i=0;i<size;i++) array[i]=A.get(i);
		 * System.out.println(binarySearchInsert(A,B));
		 */
		/*
		 * int max1 = Integer.MIN_VALUE; int min1 = Integer.MAX_VALUE; int max2
		 * = Integer.MIN_VALUE; int min2 = Integer.MAX_VALUE;
		 * 
		 * for (int i = 0; i < array.length; i++) { max1 = Math.max(max1,
		 * array[i] + i); min1 = Math.min(min1, array[i] + i); max2 =
		 * Math.max(max2, array[i] - i); min2 = Math.min(min2, array[i] - i); }
		 * 
		 * System.out.println(Math.max(max1 - min1, max2 - min2));
		 */

		/*
		 * int low = 0, high = ar.length - 1, mid=0;
		 * 
		 * System.out.println(pivotedBinarySearch(ar, ar.length, 202));
		 */
		/*
		 * boolean flag = false; while (low <= high) { mid = (low+high)/2;
		 * if(ar[mid]==B){ flag = true; break; } else if(ar[mid]<B){ low=mid+1;
		 * } else{ high=mid-1; } } int count = 1;
		 * System.out.println(mid+"  "+flag); if(!flag) return ; else{ int t =
		 * mid-1; while(t>=0 && ar[t]==B ){ count++; t--; } if(t==0 && ar[t]==B)
		 * count++; t=mid+1; while(t!=size-1 && ar[t]==B){ count++; t++; }
		 * if(t==size-1 && ar[t]==B) count++; } System.out.println(count);
		 */
		// return count;
	}

}
