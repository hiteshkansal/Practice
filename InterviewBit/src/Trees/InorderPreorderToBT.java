package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InorderPreorderToBT {

	public Map<Integer, Integer> map = new HashMap<>();
	public int preIndex=0;
	
	public static void main(String[] args) {

		ArrayList<Integer> inOrder = new ArrayList<>();
		ArrayList<Integer> preOrder = new ArrayList<>();
		inOrder.add(3);
		inOrder.add(2);
		inOrder.add(4);
		inOrder.add(1);
		inOrder.add(5);
		
		preOrder.add(1);
		preOrder.add(2);
		preOrder.add(3);
		preOrder.add(4);
		preOrder.add(5);
		
		InorderPreorderToBT tt = new InorderPreorderToBT();
		new TreeNode().inorder(tt.buildTree(inOrder, preOrder));
		
	}
	
	public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B){
		for(int i=0;i<A.size();i++){
			map.put(A.get(i), i);
		}
		
		return constructBT(A, B, 0, A.size()-1);
	}
	
	public TreeNode constructBT(ArrayList<Integer> A, ArrayList<Integer> B, int st, int end){

		if(st>end)
			return null;
		int data = B.get(preIndex++);
		TreeNode nd = new TreeNode(data);
		if(st==end)
			return nd;
		
		int id = map.get(data);
		nd.left = constructBT(A, B, st, id-1);
		nd.right = constructBT(A, B, id+1, end);
		
		return nd;
		
	}

}
