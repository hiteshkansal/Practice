package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {

	public int lis(final List<Integer> A) {
        int n = A.size();
        int lis[] = new int[n+1];
        
        for(int i=0;i<=n;i++)
            lis[i]=1;
        int result = Integer.MIN_VALUE;
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(A.get(j)<A.get(i) && lis[i]<lis[j]+1)
                    lis[i] = lis[j]+1;
            }
        }
        for(int i=0;i<=n;i++){
            if(result<lis[i])
                result = lis[i];
        }
        return result;
    }
	
	public static void main(String[] args) {
		Integer a[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		ArrayList<Integer> ar = new ArrayList<>(Arrays.asList(a));
		System.out.println(new LongestIncreasingSubsequence().lis(ar));
	}

}
