package algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLevelTraversal {

	public static void levelTraversal(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(treeNode);
		int levelSize = 0;
		while (queue.size() > 0) {
			levelSize = queue.size();
			for (int i = 0; i < levelSize; i++) {
				TreeNode cur = queue.poll();
				System.out.print(cur.val);
				if (cur.left != null) {
					queue.add(cur.left);
				}
				if (cur.right != null) {
					queue.add(cur.right);
				}
			}
			System.out.println();
		}
	}


	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		TreeNode fl1 = new TreeNode(2);
		TreeNode fr1 = new TreeNode(3);
		TreeNode sl1 = new TreeNode(4);
		TreeNode sl2 = new TreeNode(5);
		TreeNode sr1 = new TreeNode(6);
		TreeNode sr2 = new TreeNode(7);
		
		node.left = fl1;
		node.right = fr1;
		fl1.left = sl1;
		fl1.right = sl2;
		fr1.left = sr1;
		fr1.right = sr2;

		levelTraversal(node);
	}
	
}
