package Trees;

public class MinDepth {

	public static void main(String[] args) {
		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		//A.right = new TreeNode(3);
		//A.left.left = new TreeNode(4);
		A.left.right = new TreeNode(5);
		//A.right.left = new TreeNode(6);
		//A.right.right = new TreeNode(7);
		
		System.out.println(minDepth(A));

	}
	
	public static int minDepth(TreeNode A) {
        if (A == null)
            return 0;
        if (A.left == null && A.right==null)
            return 1;
        if (A.left == null)
            return minDepth(A.right)+1;
        if (A.right == null)
            return minDepth(A.left)+1;
        int l = minDepth(A.left);
        int r = minDepth(A.right);
        return 1 + Math.min(l, r);
    }

}
