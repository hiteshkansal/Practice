package Trees;

public class PathSum {

	public static void main(String[] args) {
		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		A.right = new TreeNode(3);
		A.left.left = new TreeNode(4);
		A.left.right = new TreeNode(5);
		A.right.left = new TreeNode(6);
		A.right.right = new TreeNode(7);
		
		int re = hasPathSum(A,8);
		System.out.println(re);
	}
	
	public static int hasPathSum(TreeNode A, int B) {
		
		if(A==null){
			if(B==0)
				return 1;
			else
				return 0;
		}
		int subsum = B-A.val;
		if(subsum==0 && A.left==null && A.right==null)
			return 1;
		
		return Math.max(hasPathSum(A.left, subsum), hasPathSum(A.right, subsum));
    }
}
