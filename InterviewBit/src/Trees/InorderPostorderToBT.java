package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InorderPostorderToBT {

	public Map<Integer, Integer> map = new HashMap<>();
	public int postIndex;
	
	public static void main(String[] args) {

		ArrayList<Integer> inOrder = new ArrayList<>();
		ArrayList<Integer> postOrder = new ArrayList<>();
		inOrder.add(3);
		inOrder.add(2);
		inOrder.add(4);
		inOrder.add(1);
		inOrder.add(5);
		
		postOrder.add(1);
		postOrder.add(2);
		postOrder.add(3);
		postOrder.add(4);
		postOrder.add(5);
		
		InorderPostorderToBT tt = new InorderPostorderToBT();
		TreeNode n = tt.buildTree(inOrder, postOrder);
		System.out.print("Inorder: ");
		new TreeNode().inorder(n);
		System.out.println();
				
	}
	
	public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B){
		for(int i=0;i<A.size();i++){
			map.put(A.get(i), i);
		}
		postIndex = A.size()-1;
		return constructBT(A, B, 0, A.size()-1);
		
	}
	
	public TreeNode constructBT(ArrayList<Integer> A, ArrayList<Integer> B, int st, int end){

		if(st>end)
			return null;
		int data = B.get(postIndex--);
		TreeNode nd = new TreeNode(data);
		if(st==end)
			return nd;
		
		int id = map.get(data);
		nd.right = constructBT(A, B, id+1, end);
		nd.left = constructBT(A, B, st, id-1);
		
		return nd;
		
	}

}
