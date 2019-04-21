package Trees;

import java.util.Arrays;
import java.util.List;

public class InorderTraversalofCartesianTree {

	public static void main(String[] args) {

		Integer ar[] = { 1, 2, 3, 4, 5, 6, 7 };
		List<Integer> a = Arrays.asList(ar);
		TreeNode n = buildTree(a);
		new TreeNode().inorder(n);
	}

	public static TreeNode buildTreeUtil(List<Integer> a,int st, int end) {
		
		if(st>end)
			return null;
		int max = max(a,st, end);
		
        TreeNode res= new TreeNode(a.get(max));
        
        res.left = buildTreeUtil(a, st, max-1);
        res.right = buildTreeUtil(a, max+1, end);
        
        return res;
	}
	
	public static TreeNode buildTree(List<Integer> A) {
		return buildTreeUtil(A, 0, A.size()-1);
		
	}
	public static int max(List<Integer> A, int st, int end){
		int maxElement = Integer.MIN_VALUE;
		int maxindex = Integer.MIN_VALUE;
		for(int i=st;i<=end;i++){
			if(A.get(i)>maxElement){
				maxElement = A.get(i);
				maxindex = i;
			}
		}
		return maxindex;
		
	}
}
