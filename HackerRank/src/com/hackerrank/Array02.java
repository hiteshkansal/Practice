package com.hackerrank;

/*
 *A left rotation operation on an array shifts each of the array's elements  unit to the left. 
 *For example, if 2 left rotations are performed on array 1,2,3,4,5, then the array would become 3,4,5,1,2.
 *So rotate array to d ponits
 */
public class Array02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,3,4,5,6,7,8};
		int d = 8;
		int n = a.length;
		if(d>n)
			return ;
	
		int temp,j,k;
		for (int i=0;i<gcd(d, n);i++){
			temp = a[i];
			j=i;
			while(true){
				k=d+j;
				if(k>=n)
					k-=n;
				if(k==i)
					break;
				a[j]=a[k];
				j=k;
			}
			a[j] = temp;
		}

		for(int l:a)
			System.out.print(l+" ");
	}
	
	public static int gcd(int a, int b) 
    {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

}
