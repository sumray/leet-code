package algorithm.dp;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层次遍历二叉树
 */
public class BinaryTreeLevelOrder {
	public static void levelOrder(TreeNode node) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<Integer> allNodes = new ArrayList<>();
		queue.offer(node);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (cur.left != null) {
				queue.offer(cur.left);
			}
			if (cur.right != null) {
				queue.offer(cur.right);
			}
			allNodes.add(cur.val);
		}
		System.out.println(allNodes);
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
		levelOrder(root);
	}

}
