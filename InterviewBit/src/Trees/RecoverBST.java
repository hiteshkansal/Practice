package Trees;

import java.util.ArrayList;
import java.util.Collections;

public class RecoverBST {

    TreeNode pre = null;       
    TreeNode first = null;
    TreeNode second = null;
    ArrayList<Integer> result = new ArrayList<Integer>();
    
	public static void main(String[] args) {
		TreeNode A = new TreeNode(4);
		A.left = new TreeNode(2);
		A.right = new TreeNode(6);
		A.left.left = new TreeNode(1);
		A.left.right = new TreeNode(7);
		A.right.left = new TreeNode(5);
		A.right.right = new TreeNode(3);

		RecoverBST tt = new RecoverBST();
		tt.recoverTree(A);
		
		for(int i: tt.result)
			System.out.println(i);
			
	}

    public ArrayList<Integer> recoverTree(TreeNode a) {
        recoverTreeHelper(a);
        result.add(first.val);
        result.add(second.val);
        Collections.sort(result);
        return result;
    }
    
    public void recoverTreeHelper(TreeNode node) {
        if(node == null){
            return;
        }
        else{
            recoverTreeHelper(node.left);
            if(pre == null)
                pre = node;
            else{
                if(pre.val > node.val){
                    if(first == null){
                        first = pre;
                    }
                    second = node;
                }
                pre = node;
            }
            recoverTreeHelper(node.right);
        }
    }
}
