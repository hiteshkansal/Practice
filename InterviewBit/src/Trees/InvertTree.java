package Trees;

public class InvertTree {

	public static void main(String[] args) {
		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		A.right = new TreeNode(3);
		A.left.left = new TreeNode(4);
		A.left.right = new TreeNode(5);
		A.right.left = new TreeNode(6);
		A.right.right = new TreeNode(7);
		
		TreeNode re = invertTree(A);
		
		new TreeNode().inorder(re);
	}
	
	public static TreeNode invertTree(TreeNode A) {
		if(A==null)
            return null;
        TreeNode l = invertTree(A.left);
        TreeNode r = invertTree(A.right);
        
        A.left=r;
        A.right=l;
        return A;
	}
	
}
