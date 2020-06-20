package leetcode.zq.middle;

public class CircularDeque {
	private int head;
	private int tail;
	private int count;
	private volatile Integer[] arr;

	/** Initialize your data structure here. Set the size of the deque to be k. */
	public CircularDeque(int k) {
		arr = new Integer[k];
		head = 0;
		tail = arr.length - 1;
		count = 0;
	}

	/** Adds an item at the front of Deque. Return true if the operation is successful. */
	public boolean insertFront(int value) {
		if (isFull()) {
			return false;
		}
		arr[head] = value;
		if (++head == arr.length) {
			head = 0;
		}
		count++;
		return true;
	}

	/** Adds an item at the rear of Deque. Return true if the operation is successful. */
	public boolean insertLast(int value) {
		if (isFull()) {
			return false;
		}
		arr[tail] = value;
		if (--tail == -1) {
			tail = arr.length - 1;
		}
		count++;
		return true;
	}

	/** Deletes an item from the front of Deque. Return true if the operation is successful. */
	public boolean deleteFront() {
		if (isEmpty()) {
			return false;
		}
		if (--head == -1) {
			head = arr.length - 1;
		}
		arr[head] = null;
		count--;
		return true;
	}

	/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
	public boolean deleteLast() {
		if (isEmpty()) {
			return false;
		}
		if (++tail == arr.length) {
			tail = 0;
		}
		arr[tail] = null;
		count--;
		return true;
	}

	/** Get the front item from the deque. */
	public int getFront() {
		int idx;
		if (head - 1 == -1) {
			idx = arr.length - 1;
		} else {
			idx = head - 1;
		}
		return arr[idx] == null ? -1 : arr[idx];
	}

	/** Get the last item from the deque. */
	public int getRear() {
		int idx;
		if (tail + 1 == arr.length) {
			idx = 0;
		} else {
			idx = tail + 1;
		}
		return arr[idx] == null ? -1 : arr[idx];
	}

	/** Checks whether the circular deque is empty or not. */
	public boolean isEmpty() {
		return count == 0;
	}

	/** Checks whether the circular deque is full or not. */
	public boolean isFull() {
		return count == arr.length;
	}

	public static void main(String[] args) {
		CircularDeque d = new CircularDeque(5);
		d.insertFront(7);
		d.insertLast(0);
		System.out.println(d.getFront());
		d.insertLast(3);
		System.out.println(d.getFront());
		d.insertFront(9);
		System.out.println(d.getRear());
		System.out.println(d.getFront());
		System.out.println(d.getFront());
		d.deleteLast();
		System.out.println(d.getRear());
	}
}
