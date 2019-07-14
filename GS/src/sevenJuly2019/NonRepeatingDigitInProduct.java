package sevenJuly2019;

import java.util.HashSet;

public class NonRepeatingDigitInProduct {

	static HashSet<Integer> getDigit(int a){
		HashSet<Integer> r = new HashSet<>();
		while(a>0){
			int b = a%10;
			r.add(b);
			a = a/10;
		}
		return r;
		
	}
	static int nonRepeatingDigitProductCount(int x, int y, int z) {

		int res=0;
		HashSet<Integer> hs = new HashSet<>();
		boolean flag = false;
		for(int i = y;i <= z;i++){
			flag = false;
			hs = getDigit(i);
			int temp = i*x;
			while(temp>0){
				int b = temp%10;
				if(hs.contains(b)){
					hs.clear();
					flag = true;
					break;
				}
				temp = temp/10;
			}
			if(!flag)
				res++;
		}
		return res;
    }
	
	public static void main(String[] args) {
		System.out.println(nonRepeatingDigitProductCount(2, 11, 10));

	}

}
