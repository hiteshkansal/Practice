package Trees;

import java.util.Stack;

public class KthSmallestInBST {

	public static void main(String[] args) {
		TreeNode A = new TreeNode(4);
		A.left = new TreeNode(2);
		A.right = new TreeNode(6);
		A.left.left = new TreeNode(1);
		A.left.right = new TreeNode(3);
		A.right.left = new TreeNode(5);
		A.right.right = new TreeNode(7);

		KthSmallestInBST tt = new KthSmallestInBST();
		System.out.println((tt.kthsmallest(A, 6)));

	}

	public int kthsmallest(TreeNode A, int k) {
		int count = 0;
		int ksmall = Integer.MIN_VALUE;
		Stack<TreeNode> stack = new Stack<>();

		while (true) {
            if (A != null) {
            	stack.push(A);
            	A = A.left;
            }
            else {
            	if (stack.isEmpty()) {
            		break;
            	}
            	A = stack.pop();
            	count++;
            	if(count==k){
            		ksmall=A.val;
            		return ksmall;
            	}
            	A = A.right;
            }
        }
		return ksmall;
	}
}
