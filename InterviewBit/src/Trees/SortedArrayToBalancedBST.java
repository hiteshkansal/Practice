package Trees;

import java.util.Arrays;
import java.util.List;

public class SortedArrayToBalancedBST {

	public static void main(String[] args) {

		Integer ar[] = {1, 2, 3, 4, 5, 6, 7 };
		List<Integer> a = Arrays.asList(ar);
		TreeNode n = sortedArrayToBST(a, 0, a.size()-1);
		new TreeNode().inorder(n);
	}

	public static TreeNode sortedArrayToBST(final List<Integer> a, int st, int end) {
        
        if(st>end)
            return null;
        
        int mid = (st+end)/2;
        TreeNode res= new TreeNode(a.get(mid));
        
        res.left = sortedArrayToBST(a, st, mid-1);
        res.right = sortedArrayToBST(a, mid+1, end);
        
        return res;

    }

}
