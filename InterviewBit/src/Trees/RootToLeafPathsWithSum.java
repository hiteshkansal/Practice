package Trees;

import java.util.ArrayList;

public class RootToLeafPathsWithSum {

	public static void main(String[] args) {
		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		A.right = new TreeNode(3);
		A.left.left = new TreeNode(4);
		A.left.right = new TreeNode(5);
		A.right.left = new TreeNode(6);
		A.right.right = new TreeNode(4);

		RootToLeafPathsWithSum tt = new RootToLeafPathsWithSum();
		tt.print(tt.pathSum(A, 8));
		
	}

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path = new ArrayList<>();
		res = pathSumRec(root, path, 0, sum, res);
		return res;
	}

	public ArrayList<ArrayList<Integer>> pathSumRec(TreeNode root, ArrayList<Integer> path, int ind, int sum, ArrayList<ArrayList<Integer>> res) {
		if (root == null)
			return null;
		path.add(ind, root.val);
		ind++;
		int subsum = sum - root.val;
		if (subsum == 0 && root.left == null && root.right == null) {
			res.add(new ArrayList<Integer>(path));
		} else {
			pathSumRec(root.left, path, ind, subsum, res);
			pathSumRec(root.right, path, ind, subsum, res);
		}
		path.remove(new Integer(root.val));
		return res;
	}
	
	public void print(ArrayList<ArrayList<Integer>> res){
		for (int i = 0; i < res.size(); i++) {
			for (int j = 0; j < res.get(i).size(); j++) {
				System.out.print(res.get(i).get(j)+"  ");
			}
			System.out.println();
		}
	}
}
