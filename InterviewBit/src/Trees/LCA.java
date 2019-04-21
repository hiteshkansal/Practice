package Trees;

public class LCA {

    boolean v1=false, v2 = false;
    
	public static void main(String[] args) {
		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		A.right = new TreeNode(3);
		A.left.left = new TreeNode(4);
		A.left.right = new TreeNode(5);
		A.right.left = new TreeNode(6);
		A.right.right = new TreeNode(7);

		LCA tt = new LCA();
		System.out.println((tt.lca(A, 4,5)));
		
	}
	

    public int lca(TreeNode A, int B, int C) {
        TreeNode n = lcaUtil(A, B, C);
        if(v1 && v2)
            return n.val;
        else 
            return -1;
    }
    
    public TreeNode lcaUtil( TreeNode root, int n1, int n2){
        if(root==null)
            return null;
        TreeNode temp=null;
        if(root.val == n1){
            temp = root;
            v1=true;
        }
        if(root.val == n2){
            temp = root;
            v2=true;
        }
        
        TreeNode l = lcaUtil(root.left, n1, n2);
        TreeNode r = lcaUtil(root.right, n1, n2);
        
        if(temp!=null)
            return temp;
        if(l!=null && r!=null)
            return root;

        return l!=null ? l :r;
    }
}
