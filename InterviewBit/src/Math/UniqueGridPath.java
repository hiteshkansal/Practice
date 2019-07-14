package Math;

public class UniqueGridPath {

	public static int uniquePaths(int A, int B) {
        int ar[][] = new int[A][B];
        
        for(int i=0;i<A;i++)
            ar[i][0]=1;
        for(int i=0;i<B;i++)
            ar[0][i]=1;
        for(int i=1;i<A;i++)
            for(int j=1;j<B;j++)
                ar[i][j] = ar[i-1][j]+ar[i][j-1];
        
        return ar[A-1][B-1];
    }
	
	public static void main(String[] args) {

		System.out.println(uniquePaths(2,2));
		
	}

}
