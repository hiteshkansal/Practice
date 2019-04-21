package Trees;

public class IsSameTree {

	public static void main(String[] args) {
		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		A.right = new TreeNode(3);
		A.left.left = new TreeNode(4);
		A.left.right = new TreeNode(5);
		A.right.left = new TreeNode(6);
		A.right.right = new TreeNode(7);
		
		TreeNode B = new TreeNode(1);
		B.left = new TreeNode(2);
		B.right = new TreeNode(3);
		B.left.left = new TreeNode(4);
		B.left.right = new TreeNode(5);
		//B.right.left = new TreeNode(6);
		B.right.right = new TreeNode(7);
		
		if(isSameTree(A,B)==1)
			System.out.println("Same");
		else
			System.out.println("Not Same");
	}
	
	public static int isSameTree(TreeNode A, TreeNode B) {
        if(A==null && B==null)
            return 1;
        if(A==null || B==null)
            return 0;
        if(A.val!=B.val)
            return 0;
        if(isSameTree(A.left, B.left)==1 && isSameTree(A.right, B.right)==1)
            return 1;
        return 0;
    }
}
