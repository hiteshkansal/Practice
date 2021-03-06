package com.hackerrank;

/*
 * Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each of the array element between two given indices, inclusive. 
 * Once all operations have been performed, return the maximum value in your array.

For example, the length of your array of zeros is 10. Your list of queries is as follows:

    a b k
    1 5 3
    4 8 7
    6 9 1
Add the values of  between the indices  and  inclusive:

index->	 1 2 3  4  5 6 7 8 9 10
	[0,0,0, 0, 0,0,0,0,0, 0]
	[3,3,3, 3, 3,0,0,0,0, 0]
	[3,3,3,10,10,7,7,7,0, 0]
	[3,3,3,10,10,8,8,8,1, 0]
The largest value is 10 after all operations are performed.
 * 
 */
public class Array05 {

	public static void main(String[] args) {

		int queries[][]={{1,5,3},{4,8,7},{6,9,1}};
		//long queries[][]={{1,2,100},{2,5,100},{3,4,100}};
		int n=10;
		long max=Integer.MIN_VALUE, value;
		long a,b;
		
		long count[] = new long[n+1];
		for(int i=0;i<queries.length;i++){
			a=queries[i][0];
			b=queries[i][1];
			value=queries[i][2];
			count[(int) a]+=value;
			if(b+1<=n)
				count[(int) (b+1)]-=value;
			
		}
		value=0;
		for(int i=1;i<=n;i++){
			value+=count[i];
			if(max<value)
				max=value;
		}
		//Using HashMap
		/*Map<Long, Long> count = new HashMap<Long, Long>();
		long a,b, value;
		for(int i=0;i<queries.length;i++){
			a=queries[i][0];
			b=queries[i][1];
			value=queries[i][2];
			for(long j=a;j<=b;j++){
				if(count.get(j)==null)
					count.put(j, value);
				else{
					long v = count.get(j);
					v+=value;
					count.put(j, v);
					if(max<v)
						max=v;
				}
			}
		}*/
		System.out.println(max);
	}

}
