package Trees;

public class IsSymmetricTree {

	public static void main(String[] args) {

		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		A.right = new TreeNode(2);
		A.left.left = new TreeNode(4);
		A.left.right = new TreeNode(5);
		A.right.left = new TreeNode(5);
		A.right.right = new TreeNode(4);
		
		
		if(isSymmetric(A)==1)
			System.out.println("Mirror");
		else
			System.out.println("Not Mirror");
		
	}
	
	public static int isSymmetric(TreeNode A) {
		if(isMirror(A,A))
			return 1;
		return 0;
    }
	
	public static boolean isMirror(TreeNode A, TreeNode B) {
        if(A==null && B==null)
            return true;
        
        if(A!= null && B!=null && A.val==B.val){
        	return (isMirror(A.left, B.right) && isMirror(A.right, B.left));
        }
       return false;    
    }

}
