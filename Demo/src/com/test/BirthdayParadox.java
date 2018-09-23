package com.test;
import java.util.ArrayList;
import java.util.List;

public class BirthdayParadox {
	
	public static void main(String[] args) {
		/*List<Integer> bday = new ArrayList<Integer>();
		for(int i=0;i<23;i++)
			bday.add((int)((Math.random()*365) + 1));
		
		Set<Integer> uniqueSet = new HashSet<Integer>(bday);
		for (int bdayDate : uniqueSet) 
			System.out.println(bdayDate + " with count: " + Collections.frequency(bday, bdayDate));*/
		
/*		ArrayList ar = new ArrayList<>();
		sourabh s = new sourabh();
		ar.add("1");
		ar.add("2");
		ar.add("3");
		Iterator it = ar.iterator();
		while(it.hasNext()){
			String temp = (String) it.next();
			s.testing(temp);
		}
		System.out.println(s.map.toString());
*/		ArrayList<Integer> bday = new ArrayList<Integer>();
	bday.add(5);
	bday.add(24);
	bday.add(54);
	bday.add(74);
	bday.add(14);
	bday.add(14);
	bday.add(14);
	bday.add(14);
	bday.add(14);
	bday.add(10);
	bday.add(11);
	bday.add(12);
	bday.add(13);
	bday.add(14);
	bday.add(15);
	bday.add(16);
	bday.add(17);
	bday.add(18);
	bday.add(19);
	
System.out.println(rotateArray(bday , 56).toString());
		
	}
	
		public static ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
			ArrayList<Integer> ret = new ArrayList<Integer>();
			int size = A.size();
			System.out.println(size);
			int i = (B%size);
			int j = i-1;
			System.out.println(i+"  dfsfs "+j);
			for (; j != i; i++) {
				
				if (i==size)
				    i=0;
				ret.add(A.get(i));
			}
			ret.add(j+1);
			return ret;
		}

}
