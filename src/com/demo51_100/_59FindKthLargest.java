package com.demo51_100;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: JunLog
 * @Description: 数组中的第K个最大元素
 * Date: 2022/8/20 12:23
 */
public class _59FindKthLargest {

    // Time：O(n*log(k)), Space：O(k)
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.add(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(num);
            }
        }
        return minHeap.peek();
    }

}
