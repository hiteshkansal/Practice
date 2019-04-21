package Trees;

import java.util.ArrayList;
import java.util.Stack;

public class Preorder {

	public static void main(String[] args) {

		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		A.right = new TreeNode(3);
		A.left.left = new TreeNode(4);
		A.left.right = new TreeNode(5);
		
		ArrayList<Integer> re = preorderTraversal(A);
		for(int i:re)
			System.out.println(i);
	}

	public static ArrayList<Integer> preorderTraversal(TreeNode A) {
		
		if(A==null)
			return null;
		ArrayList<Integer> res = new ArrayList<>();
		
		Stack<TreeNode> s = new Stack<>();
		s.push(A);
		while(!s.isEmpty()){
			
			TreeNode nd = s.pop();
			res.add(nd.val);
			
			if(nd.right!=null){
				s.push(nd.right);
			}
			if(nd.left!=null){
				s.push(nd.left);
			}
		}
		
		return res;

	}

}
