package com.demo51_100;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: JunLog
 * @Description: 数据流中的第 K 大元素
 * Date: 2022/8/20 11:12
 */
public class _57KthLargestElementInStream {

    private Queue<Integer> minHeap = new PriorityQueue<>();
    private int k;

    // Time：O(n*log(k))
    public _57KthLargestElementInStream(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            add(num);
        }

    }

    // Time：O(log(k))
    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.add(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.add(val);
        }
        return minHeap.peek();
    }

}
