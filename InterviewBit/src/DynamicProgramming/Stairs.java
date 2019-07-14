package DynamicProgramming;

public class Stairs {

	public int climbStairs(int A) {
        int n[] = new int[A+1];
        n[0]=0;
        n[1]=1;
        
        for(int i=2;i<=A;i++){
            n[i] = n[i-1]+n[i-2];
        }
        return n[A];
    }
	
	public static void main(String[] args) {
		Stairs s = new Stairs();
		System.out.println(s.climbStairs(6));
	}

}
