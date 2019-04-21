package Trees;

import java.util.HashSet;
import java.util.Set;

public class TwoSetBinaryTree {

	Set<Integer> s = new HashSet<>();
	
    public int t2Sum(TreeNode A, int B) {
        if(A==null)
            return 0;
        
        int l = t2Sum(A.left, B);
        int val = A.val;
        if(s.contains(B-val))
            return 1;
        s.add(val);
        int r = t2Sum(A.right, B);
        return Math.max(l,r);
    }
	public static void main(String[] args) {

		TreeNode A = new TreeNode(4);
		A.left = new TreeNode(2);
		A.right = new TreeNode(6);
		A.left.left = new TreeNode(1);
		A.left.right = new TreeNode(3);
		A.right.left = new TreeNode(5);
		A.right.right = new TreeNode(7);

		TwoSetBinaryTree tt = new TwoSetBinaryTree();
		System.out.println(tt.t2Sum(A, 17));
	}

}
