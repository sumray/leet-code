package algorithm.list;

import java.util.Arrays;

public class ReversePrint {

	public int[] reversePrint(ListNode head) {
		if (head == null) {
			return new int[0];
		}
		ListNode pre = null;
		ListNode cur = head;
		int size = 0;
		while (cur != null) {
			size++;
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		int[] res = new int[size];
		int i = 0;
		while (pre != null) {
			res[i] = pre.val;
			i++;
			pre = pre.next;
		}
		return res;
	}

	public static void main(String[] args) {
		ReversePrint r = new ReversePrint();
		ListNode head = new ListNode(1);
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(2);
		head.next = n1;
		n1.next = n2;
		int[] ints = r.reversePrint(head);
		System.out.println(Arrays.toString(ints));
	}

}
