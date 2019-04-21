package Trees;

import java.util.LinkedList;
import java.util.Queue;

class TreeLinkNode {
	int val;
	TreeLinkNode left;
	TreeLinkNode right;
	TreeLinkNode next;

	TreeLinkNode(int v) {
		val = v;
		left = null;
		right = null;
		next = null;
	}
}

public class PopulateNextRightPointer {

	public static void main(String[] args) {

		TreeLinkNode A = new TreeLinkNode(4);
		A.left = new TreeLinkNode(2);
		A.right = new TreeLinkNode(6);
		A.left.left = new TreeLinkNode(1);
		A.left.right = new TreeLinkNode(3);
		A.right.left = new TreeLinkNode(5);
		A.right.right = new TreeLinkNode(7);
		connect(A);

		System.out.println(A.next);
		System.out.println(A.left.next.val);
		System.out.println(A.right.next);
		System.out.println(A.left.left.next.val);
		System.out.println(A.left.right.next.val);
		System.out.println(A.right.left.next.val);
		System.out.println(A.right.right.next);
	}

	public static void connect(TreeLinkNode root) {
		if (root == null)
			return;

		Queue<TreeLinkNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		TreeLinkNode temp;
		
		while (!q.isEmpty()) {
			temp = q.remove();
			if (temp != null) {
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
				temp.next = q.peek();
			} else if (temp == null && q.size()>0) {
				q.add(null);
			}
		}
	}
}
