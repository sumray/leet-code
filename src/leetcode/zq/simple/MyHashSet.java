package leetcode.zq.simple;

class MyHashSet {

	private Node[] arr;

	/** Initialize your data structure here. */
	public MyHashSet() {
		arr = new Node[10009];
	}

	public void add(int key) {
		Node cur = arr[index(key)];
		Node pre = null;
		if (cur != null) {
			while (cur != null) {
				if (cur.key == key) {
					return;
				}
				pre = cur;
				cur = cur.next;
			}
		}
		Node node = new Node(pre, null, key);
		if (pre == null) {
			arr[index(key)] = node;
		} else {
			pre.next = node;
		}
	}

	public void remove(int key) {
		Node cur = arr[index(key)];
		Node pre = null;
		if (cur == null) {
			return;
		}
		pre = cur.pre;
		while (cur != null) {
			if (cur.key == key) {
				if (pre == null) {
					arr[index(key)] = null;
				} else {
					pre.next = cur.next;
				}
				return;
			}
			pre = cur;
			cur = cur.next;
		}
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		Node cur = arr[index(key)];
		if (cur == null) {
			return false;
		}
		while (cur != null) {
			if (cur.key == key) {
				return true;
			}
			cur = cur.next;
		}
		return false;
	}

	private int index(int key) {
		int hash = Integer.valueOf(key).hashCode();
		hash ^= hash >>> 16;
		return (arr.length - 1) & hash;
	}

	private static class Node {
		Node pre;
		Node next;
		int key;

		Node(Node pre, Node next, int key) {
			this.pre = pre;
			this.next = next;
			this.key = key;
		}

	}

	public static void main(String[] args) {
		MyHashSet m = new MyHashSet();
//		["MyHashSet","add","add","contains","contains","add","contains","remove","contains"]
//[[],[1],[2],[1],[3],[2],[2],[2],[2]]
		m.add(1);
		m.add(2);
		System.out.println(m.contains(1));
		System.out.println(m.contains(3));

		

	}

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */