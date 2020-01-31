package leetcode.zq.simple;


import algorithm.dp.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 */
public class MaximumDepthOfBinaryTree {
	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int depth = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				TreeNode cur = queue.poll();
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
			depth++;
		}
		return depth;
	}

	public static void main(String[] args) {
		/*    2
		 *  3   4
		 *     5
		 *   6   7
		 */
		TreeNode n1 = new TreeNode(7);
		TreeNode n2 = new TreeNode(6);
		TreeNode n3 = new TreeNode(n2, 5, n1);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(n3,4,null);
		TreeNode root = new TreeNode(n4, 2, n5);
		System.out.println(maxDepth(root));
	}

}
