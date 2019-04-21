package Trees;

import java.util.Stack;

public class BSTIterator {

	Stack<TreeNode> st;

	public BSTIterator(TreeNode root) {
		st = new Stack<>();
		while (root != null) {
			st.push(root);
			root = root.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !(st.isEmpty());
	}

	/** @return the next smallest number */
	public int next() {

		TreeNode temp = st.pop();
		int val = temp.val;
		temp = temp.right;
		while (temp != null) {
			st.push(temp);
			temp = temp.left;
		}
		return val;
	}

	public static void main(String[] args) {
		TreeNode A = new TreeNode(4);
		A.left = new TreeNode(2);
		A.right = new TreeNode(6);
		A.left.left = new TreeNode(1);
		A.left.right = new TreeNode(3);
		A.right.left = new TreeNode(5);
		A.right.right = new TreeNode(7);

		BSTIterator tt = new BSTIterator(A);
		while (tt.hasNext()) {
			System.out.println(tt.next());
		}

	}
}
/**
 * Your Solution will be called like this: Solution i = new Solution(root);
 * while (i.hasNext()) System.out.print(i.next());
 */