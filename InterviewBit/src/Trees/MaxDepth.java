package Trees;

public class MaxDepth {

	public static void main(String[] args) {
		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		A.right = new TreeNode(3);
		A.left.left = new TreeNode(4);
		A.left.right = new TreeNode(5);
		A.right.left = new TreeNode(6);
		A.right.right = new TreeNode(7);
		
		System.out.println(maxDepth(A));

	}
	
	public static int maxDepth(TreeNode root) {
        if (root == null)
            return -1;    //Maximum edges on longest path. return 0 if max nodes
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return 1 + Math.max(l, r);
    }

}
