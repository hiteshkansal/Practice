package Graphs;

class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class SortedLinkedListToBST {

	public static void main(String[] args) {

		ListNode a = new ListNode(1);
		ListNode b = new ListNode(4);
		ListNode c = new ListNode(8);
		a.next = b;
		b.next = c;
		TreeNode tn = sortedListToBST(a);
		new TreeNode().inorder(tn);
	}

	public static TreeNode sortedListToBST(ListNode a) {
		int n = counTreeNodes(a);
		System.out.println(n);
		return sortedListToBSTRecur(a, 0, n-1);
	}

	public static TreeNode sortedListToBSTRecur(ListNode head, int st, int end) {
		if (st > end)
			return null;

		int mid = (st+end)/2;
		TreeNode left = sortedListToBSTRecur(head, st, mid-1);
		TreeNode root = new TreeNode(head.val);
		head = head.next;
		TreeNode right = sortedListToBSTRecur(head, mid+1, end);
		root.left = left;
		root.right = right;
		return root;
	}

	static int counTreeNodes(ListNode head) {
		int count = 0;
		ListNode temp = head;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}
}
