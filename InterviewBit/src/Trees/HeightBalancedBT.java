package Trees;

class Height{
	int h;
}

public class HeightBalancedBT {

	public static void main(String[] args) {
		TreeNode A = new TreeNode(4);
		A.left = new TreeNode(2);
		A.right = new TreeNode(6);
		A.left.left = new TreeNode(1);
		A.left.right = new TreeNode(3);
		A.right.left = new TreeNode(5);
		A.right.right = new TreeNode(7);

		HeightBalancedBT tt = new HeightBalancedBT();
		System.out.println((tt.isBalanced(A)));

	}

	public int isBalanced(TreeNode A) {
        Height h= new Height();
        return isBalancedTree(A, h);
    }
    
    public int isBalancedTree(TreeNode A, Height h) {
        if (A == null){
            h.h=0;
            return 1;
        }
        Height lht = new Height();
        Height rht = new Height();
        
        int l = isBalancedTree(A.left, lht);
        int r = isBalancedTree(A.right, rht);
        
        int lh = lht.h;
        int rh = rht.h;
        h.h= Math.max(lh, rh)+1;
        
        if (Math.abs(lh-rh) > 1) {
            return 0;
        }
        else if(l==1 && r==1)
            return 1;
        else
            return 0;
    }}
