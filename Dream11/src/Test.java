

/* package whatever; // don't place package name! */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class check implements Comparable<check>{
	String name;
	int marks, roll;
	
	public check(String name, int marks, int roll){
		this.marks=marks;
		this.name=name;
		this.roll=roll;
	}
	@Override
	public int compareTo(check o) {
		if(this.marks!=o.marks){
			return o.marks-this.marks;
		}
		if(!this.name.equals(o.name)){
			return this.name.compareTo(o.name);
		}
		return this.roll-o.roll;
	}
	@Override
	public String toString() {
		return "check [name=" + name + ", marks=" + marks + ", roll=" + roll + "]";
	}

}
class Test
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int t;
		BufferedReader input = new BufferedReader (new InputStreamReader (System.in));
		t =Integer.parseInt(input.readLine());
		List<check> records = new ArrayList<check>();
		while(t > 0)
		{
			String a = input.readLine();
			List<String> temp = Arrays.asList(a.split(","));
			String name = temp.get(0);
			int marks = Integer.parseInt(temp.get(1).trim());
			int roll = Integer.parseInt(temp.get(2).trim());
			records.add(new check(name, marks, roll));
			t--;
		}
		Collections.sort(records);
		for(check c:records)
			System.out.println(c);
		//int []arr = {4,2,1,4,8,8,5};
		/*int []arr = {1,4,5,4,8,8,5};
		ArrayList<Integer> records = new ArrayList<Integer>();
		for(int i=0;i<arr.length;i++)
			records.add(arr[i]);
		
		Collections.sort(records);
		
		ArrayList<Integer> set1 = new ArrayList<Integer>();
		ArrayList<Integer> set2 = new ArrayList<Integer>();
		int sum1=0, sum2=0, diff = Integer.MAX_VALUE;
		int k=3, j=0;
		for(int i=records.size()-1;i>=1;i=i-2){
			if(j==k){
				break;
			}
			sum1+=records.get(i);
			sum2+=records.get(i-1);
			if(sum1-sum2>0){
				set1.add(records.get(i-1));
				set2.add(records.get(i));
				sum1-=records.get(i);
				sum2-=records.get(i-1);
				sum1+=records.get(i-1);
				sum2+=records.get(i);
			}
			else{
				set1.add(records.get(i));
				set2.add(records.get(i-1));
			}
			j++;
		}
		
		System.out.println(sum1+"  "+sum2);
		for(int i=0; i<set1.size(); i++)
			System.out.print(set1.get(i)+"   ");
		System.out.println();
		for(int i=0; i<set2.size(); i++)
			System.out.print(set2.get(i)+"   ");*/
		
	}
}