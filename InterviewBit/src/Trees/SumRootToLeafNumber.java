package Trees;

public class SumRootToLeafNumber {

	public static void main(String[] args) {
		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		A.right = new TreeNode(3);
		A.left.left = new TreeNode(4);
		A.left.right = new TreeNode(5);
		A.right.left = new TreeNode(6);
		A.right.right = new TreeNode(4);

		SumRootToLeafNumber tt = new SumRootToLeafNumber();
		System.out.println(tt.sumNumbers(A));
		
	}

	public int sumNumbers(TreeNode A) {
        return sum(A, 0)%1003;
    }

	public int sum(TreeNode root, int mul) {
        if (root == null)
            return 0;
        
        if (root.left == null && root.right == null) 
            return (mul*10+root.val)%1003;
        
        int num = (mul*10+root.val)%1003;
        num = sum(root.left, num) + sum(root.right, num);        
        return num%1003;
    }
}
