package Array;

import java.util.ArrayList;

public class MaximumAbsoluteDifference {

	public static int maxArr(ArrayList<Integer> A) {
        int size = A.size();
        int[] array = new int[size];
        for(int i=0;i<size;i++)
            array[i]=A.get(i);
    
        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;
 
        for (int i = 0; i < array.length; i++)
        {
            max1 = Math.max(max1, array[i] + i);
            min1 = Math.min(min1, array[i] + i);
            max2 = Math.max(max2, array[i] - i);
            min2 = Math.min(min2, array[i] - i);
        }
 
        return Math.max(max1 - min1, max2 - min2);
    }
	
	public static void main(String[] args) {

		ArrayList<Integer> x = new ArrayList<Integer>();
		x.add(1);
		x.add(3);
		x.add(-1);
		System.out.println(maxArr(x));
	}

}
