package Trees;

import java.util.ArrayList;
import java.util.Stack;

public class Inorder {

	public static void main(String[] args) {
		
		TreeNode A = new TreeNode(4);
		A.left = new TreeNode(2);
		A.right = new TreeNode(6);
		A.left.left = new TreeNode(1);
		A.left.right = new TreeNode(3);
		A.right.left = new TreeNode(5);
		A.right.right = new TreeNode(7);
		ArrayList<Integer> arr = inorder_iter(A);
		for(int i:arr){
			System.out.print(i+"  ");
		}
	}

	public static ArrayList<Integer> inorder_iter(TreeNode A){
		ArrayList<Integer> arr = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
       
        if (A == null) return arr;
        
        while (true) {
            if (A != null) {
            	stack.push(A);
            	A = A.left;
            }
            else {
            	if (stack.isEmpty()) {
            		break;
            	}
            	A = stack.pop();
            	arr.add(A.val);
            	A = A.right;
            }
        }
        
        return arr;
		
	}
}
