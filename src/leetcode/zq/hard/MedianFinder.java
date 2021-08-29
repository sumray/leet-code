package leetcode.zq.hard;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/find-median-from-data-stream/
 */
public class MedianFinder {

	private PriorityQueue<Integer> left;

	private PriorityQueue<Integer> right;

	/** initialize your data structure here. */
	public MedianFinder() {
		left = new PriorityQueue<>((a,b) -> b-a);
		right = new PriorityQueue<>((a,b) -> a-b);
	}

	public void addNum(int num) {
		int s1 = left.size();
		int s2 = right.size();
		if (s1 == s2) {
			if (s2 == 0 || num <= right.peek()) {
				left.add(num);
			} else {
				left.add(right.poll());
				right.add(num);
			}
		} else {
			if (num >= left.peek()) {
				right.add(num);
			} else {
				right.add(left.poll());
				left.add(num);
			}
		}
	}

	public double findMedian() {
		int s1 = left.size();
		int s2 = right.size();
		if (s1 == 0 && s2 == 0) {
			return 0;
		}

		if (s1 == s2) {
			return (left.peek() + right.peek()) / 2.0;
		} else {
			return left.peek();
		}
	}

	public static void main(String[] args) {
		MedianFinder f = new MedianFinder();
		f.addNum(40);
		f.addNum(12);
		f.addNum(16);
		System.out.println(f.findMedian());
	}

}
