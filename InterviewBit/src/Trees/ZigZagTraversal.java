package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagTraversal {

	public static void main(String[] args) {
		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		A.right = new TreeNode(3);
		A.left.left = new TreeNode(4);
		A.left.right = new TreeNode(5);
		A.right.left = new TreeNode(6);
		A.right.right = new TreeNode(7);
		ArrayList<ArrayList<Integer>> rrr = zigzagLevelOrder(A);

		for (int i = 0; i < rrr.size(); i++) {
			List<Integer> t = rrr.get(i);
			for (int j = 0; j < t.size(); j++) {
				System.out.print(t.get(j) + "  ");
			}
			System.out.println();
		}
	}
	
	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (A == null)
			return result;
		Stack<TreeNode> current = new Stack<>();
		Stack<TreeNode> next = new Stack<>();
		boolean leftToRight = true;
		current.push(A);
		ArrayList<Integer> t = new ArrayList<>();
		
		while (!current.isEmpty()) {
			TreeNode temp = current.pop();
			t.add(temp.val);
			
			if(!leftToRight){
				if(temp.right!=null)
					next.push(temp.right);
				if(temp.left!=null)
					next.push(temp.left);
			} else {
				if (temp.left != null)
					next.push(temp.left);
				if (temp.right != null)
					next.push(temp.right);
			}
			
			if(current.isEmpty()){
				result.add(t);
				t = new ArrayList<>();
				Stack<TreeNode> s = current;
				current = next;
				next = s;
				leftToRight = !leftToRight;
			}
		}
		return result;
    }
}
