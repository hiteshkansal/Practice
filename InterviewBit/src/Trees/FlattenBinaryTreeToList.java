package Trees;

public class FlattenBinaryTreeToList {

	TreeNode head = new TreeNode(-1);
	TreeNode curr = head;

	public static void main(String[] args) {

		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		A.right = new TreeNode(5);
		A.left.left = new TreeNode(3);
		A.left.right = new TreeNode(4);
		A.right.left = new TreeNode(6);
		A.right.right = new TreeNode(7);

		FlattenBinaryTreeToList tt = new FlattenBinaryTreeToList();
		TreeNode res = tt.flatten(A);
		tt.display(res);
	}

	public TreeNode flatten(TreeNode a) {
		preorder(a);
		return head.right;
	}

	public void preorder(TreeNode A) {
		if (A == null)
			return;
		curr.right = new TreeNode(A.val);
		curr.left = null;
		curr = curr.right;

		preorder(A.left);
		preorder(A.right);
	}
	
	public void display(TreeNode a){
		
		while(a!=null){
			System.out.print(a.val+" -> ");
			a = a.right;
		}
	}

}
