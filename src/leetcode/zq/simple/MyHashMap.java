package leetcode.zq.simple;

public class MyHashMap {

	private Node[] arr;

	/** Initialize your data structure here. */
	public MyHashMap() {
		arr = new Node[10009];
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		int idx = index(key);
		Node cur = arr[idx];
		if (cur == null) {
			arr[idx] = new Node(key, value);
			return;
		}
		Node pre = null;
		while (cur != null) {
			if (cur.key == key) {
				cur.val = value;
				return;
			}
			pre = cur;
			cur = cur.next;
		}
		if (pre == null) {
			arr[idx] = new Node(key, value);
		} else {
			pre.next = new Node(key, value);
		}
	}

	/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
	public int get(int key) {
		int idx = index(key);
		Node cur = arr[idx];
		if (cur == null) {
			return - 1;
		}
		while (cur != null) {
			if (cur.key == key) {
				return cur.val;
			}
			cur = cur.next;
		}
		return -1;
	}

	/** Removes the mapping of the specified value key if this map contains a mapping for the key */
	public void remove(int key) {
		int idx = index(key);
		Node cur = arr[idx];
		if (cur == null) {
			return;
		}
		Node pre = null;
		while (cur != null) {
			if (cur.key != key) {
				pre = cur;
				cur = cur.next;
				continue;
			}
			if (pre == null) {
				arr[idx] = cur.next;
			} else {
				pre.next = cur.next;
			}
			return;
		}
	}

	private int index(int key) {
		int hash = Integer.hashCode(key);
		hash ^= (hash >>> 16);
		return hash % arr.length;
	}

	static class Node {
		int key;
		int val;
		Node next;

		Node(int key, int val) {
			this.key = key;
			this.val = val;
		}

	}

	public static void main(String[] args) {
		MyHashMap m = new MyHashMap();
		m.put(1, 1);
		m.put(2, 2);
		System.out.println(m.get(1));
		System.out.println(m.get(3));
		m.put(2, 1);
		System.out.println(m.get(2));
		m.remove(2);
		System.out.println(m.get(2));
	}

}
