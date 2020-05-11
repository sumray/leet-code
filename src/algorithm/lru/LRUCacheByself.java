package algorithm.lru;

import java.util.HashMap;

/**
 * 手动实现双向链表，时间复杂度O(1)的LRU算法缓存
 */
public class LRUCacheByself<K,V> {
	
	private int size;
	
	private DoubleLinkedList<K,V> linkedList;
	
	private HashMap<K, Node<K,V>> indexes;

	public LRUCacheByself(int size) {
		this.size = size;
		linkedList = new DoubleLinkedList<>();
		indexes = new HashMap<>();
	}

	public V get(K key) {
		if (!indexes.containsKey(key)) {
			return null;
		}
		Node<K,V> cur = indexes.get(key);
		linkedList.moveNodeToTail(cur);
		return cur.value;
	}

	public void put(K key, V value) {
		Node<K, V> ori = indexes.get(key);
		if (ori != null) {
			ori.value = value;
			linkedList.moveNodeToTail(ori);
			indexes.put(key, ori);
			return;
		}
		ori = new Node<>(key, value);
		if (indexes.size() >= size) {
			K firKey = linkedList.removeFirst();
			indexes.remove(firKey);
			linkedList.addToTail(ori);
			indexes.put(key, ori);
		} else {
			indexes.put(key, ori);
			linkedList.addToTail(ori);
		}
	}
	
	private static class Node<K,V> {
		Node<K,V> pre;
		Node<K,V> next;
		K key;
		V value;
		
		Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.pre = null;
			this.next = null;
		}
	}
	
	private static class DoubleLinkedList<K,V> {
		Node<K,V> head;
		Node<K,V> tail;
		
		void moveNodeToTail(Node<K,V> cur) {
			if (tail == cur) {
				return;
			}
			if (head == cur) {
				cur.next.pre = null;
				cur.pre = tail;
				head = cur.next;
				cur.next = null;
				tail = cur;
				return;
			}
			cur.pre.next = cur.next;
			cur.next.pre = cur.pre;
			cur.pre = tail;
			cur.next = null;
			tail = cur;
		}

		void addToTail(Node<K,V> cur) {
			if (tail == null) {
				head = cur;
				tail = cur;
				return;
			}
			tail.next = cur;
			cur.pre = tail;
			tail = cur;
		}

		K removeFirst() {
			if (head == null) {
				return null;
			}
			if (head == tail) {
				head = null;
				tail = null;
				return null;
			}
			K result = head.key;
			head.next.pre = null;
			head = head.next;
			return result;
		}

	}
}
