package algorithm.lru;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 最近最少使用算法
 * 用一个链表存储数据，存储顺序为使用时间
 */
public class LRUCache<K, V> {
	
	private LinkedList<Node<K,V>> list;
	
	private HashMap<String, Integer> indexes;
	
	private int size;
	
	public LRUCache(int size){
		this.size = size;
		list = new LinkedList<>();
		indexes = new HashMap<>();
	}
	
	public V get(K k){
		Iterator<Node<K,V>> iterator = list.iterator();
		V result = null;
		while (iterator.hasNext()) {
			Node<K,V> cur = iterator.next();
			if (cur.key.equals(k)){
				result = cur.value;
				iterator.remove();
			}
		}
		if (result != null){
			addLast(k, result);
		}
		return result;
	}
	
	public void set(K k, V v){
		Iterator<Node<K,V>> iterator = list.iterator();
		while (iterator.hasNext()) {
			Node<K,V> cur = iterator.next();
			if (cur.key.equals(k)){
				iterator.remove();
				break;
			}
		}
		addLast(k, v);
	}
	
	private void addLast(K k, V v){
		if (list.size() < size){
			list.addLast(new Node<>(k, v));
		} else {
			list.removeFirst();
			list.addLast(new Node<>(k, v));
		}
	}
	
	static class Node<K,V> {
		K key;
		V value;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
}
