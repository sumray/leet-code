package leetcode.zq.middle;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/list-of-depth-lcci/
 */
public class ListOfDepth {

	public ListNode[] listOfDepth(TreeNode tree) {
		if (tree == null) {
			return new ListNode[0];
		}
		List<ListNode> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(tree);
		while (queue.size() > 0) {
			int size = queue.size();
			ListNode head = new ListNode(0);
			ListNode res = head;
			for (int i = 0; i < size; i++) {
				TreeNode curTree = queue.poll();
				ListNode next = new ListNode(curTree.val);
				res.next = next;
				res = res.next;
				if (curTree.left != null) {
					queue.add(curTree.left);
				}
				if (curTree.right != null) {
					queue.add(curTree.right);
				}
			}
			result.add(head.next);
		}
		return result.toArray(new ListNode[result.size()]);
	}

	public class TreeNode {
	  int val;
	  TreeNode left;
	  TreeNode right;
	  TreeNode(int x) { val = x; }
	}
	
	
	public class ListNode {
	  int val;
	  ListNode next;
	  ListNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		
	}
}
