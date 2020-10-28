package algorithm.lru;

import java.util.HashMap;

/**
 * 手动实现双向链表，时间复杂度O(1)的LRU算法缓存
 */
public class LRUCacheByself {
	
	private int size;
	
	private Node head;
	
	private Node tail;
	
	private HashMap<Integer, Node> indexes;

	public LRUCacheByself(int size) {
		this.size = size;
		head = new Node(0, 0);
		tail = new Node(0, 0);
		indexes = new HashMap<>();
		head.next = tail;
		tail.pre = head;
	}

	public Integer get(int key) {
		Node node = indexes.get(key);
		if (node == null) {
			return null;
		}
		moveToFirst(node);
		return node.value;
	}

	public void put(int key, int value) {
		Node node = indexes.get(key);
		if (node != null) {
			node.value = value;
			moveToFirst(node);
			indexes.put(key, node);
			return;
		}
		node = new Node(key, value);
		if (size == indexes.size()) {
			int removeKey = removeTail();
			indexes.remove(removeKey);
		}
		addFirst(node);
		indexes.put(key, node);
	}

	private void moveToFirst(Node node) {
		removeNode(node);
		addFirst(node);
	}
	
	private void addFirst(Node node) {
		node.next = head.next;
		node.pre = head;
		head.next.pre = node;
		head.next = node;
	}

	private int removeTail() {
		Node node = tail.pre;
		removeNode(node);
		return node.key;
	}

	private void removeNode(Node node) {
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}
	
	static class Node {
		int key;
		int value;
		Node pre;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
}
