package Graphs;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(){
		
	}
	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
	
	public void inorder(TreeNode r){
		if(r==null)
			return;
		inorder(r.left);
		System.out.print(r.val+"  ");
		inorder(r.right);
	}
}
