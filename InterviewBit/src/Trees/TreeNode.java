package Trees;

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
	
	public void preorder(TreeNode r){
		if(r==null)
			return;
		System.out.print(r.val+"  ");
		preorder(r.left);
		preorder(r.right);
	}
	
	public void postorder(TreeNode r){
		if(r==null)
			return;
		postorder(r.left);
		postorder(r.right);
		System.out.print(r.val+"  ");
	}
}
