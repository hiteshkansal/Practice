package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class VerticalOrder {

	public static void main(String[] args) {
		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		A.right = new TreeNode(3);
		A.left.left = new TreeNode(4);
		A.left.right = new TreeNode(5);
		ArrayList<ArrayList<Integer>> rrr = verticalOrderTraversal(A);

		for (int i = 0; i < rrr.size(); i++) {
			List<Integer> t = rrr.get(i);
			for (int j = 0; j < t.size(); j++) {
				System.out.print(t.get(j) + "  ");
			}
			System.out.println();
		}

	}

	public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (A == null)
			return result;

		Queue<TreeNode> queue = new LinkedList<>();
		Map<Integer, ArrayList<Integer>> levelNodeMap = new HashMap<>();
		Queue<Integer> levels = new LinkedList<Integer>();

		queue.offer(A);
		levels.offer(0);
		Integer minLevel = 0;
		Integer maxLevel = 0;

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			Integer level = levels.poll();
			minLevel = Math.min(level, minLevel);
			maxLevel = Math.max(maxLevel, level);

			if (!levelNodeMap.containsKey(level)) {
				levelNodeMap.put(level, new ArrayList<Integer>());
			}
			levelNodeMap.get(level).add(node.val);
			if (node.left != null) {
				queue.offer(node.left);
				levels.offer(level - 1);
			}
			if (node.right != null) {
				queue.offer(node.right);
				levels.offer(level + 1);
			}
		}

		for (int level = minLevel; level <= maxLevel; ++level) {
			if (levelNodeMap.containsKey(level)) {
				result.add(levelNodeMap.get(level));
			}
		}
		return result;
	}
}
