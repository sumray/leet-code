package leetcode.zq.middle;

// https://leetcode-cn.com/problems/implement-trie-prefix-tree/
// 前缀树
public class Trie {

	private Trie[] next;

	private boolean isEnd;

	/** Initialize your data structure here. */
	public Trie() {
		next = new Trie[26];
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		char[] arr = word.toCharArray();
		Trie root = this;
		for (char c : arr) {
			if (root.next[c - 'a'] == null) {
				root.next[c - 'a'] = new Trie();
			}
			root = root.next[c - 'a'];
		}
		root.isEnd = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		Trie root = this;
		char[] arr = word.toCharArray();
		for (char c : arr) {
			if (root.next[c - 'a'] == null) {
				return false;
			}
			root = root.next[c - 'a'];
		}
		return root.isEnd;
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		Trie root = this;
		char[] arr = prefix.toCharArray();
		for (char c : arr) {
			if (root.next[c - 'a'] == null) {
				return false;
			}
			root = root.next[c - 'a'];
		}
		return true;
	}

}
