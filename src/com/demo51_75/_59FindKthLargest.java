package com.demo51_75;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: JunLog
 * @Description: 数组中的第K个最大元素
 * Date: 2022/8/20 12:23
 */
public class _59FindKthLargest {

    // Time：O(n*log(k)), Space：O(k)
    public int findKthLargest1(int[] nums, int k) {
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

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    int partition(int[] nums, int low, int high) {
        int pivot = nums[low], i = low, j = high;
        while (i < j) {
            while (i < j && nums[j] < pivot) --j;
            if (i < j) swap(nums, i, j);
            while (i < j && nums[i] > pivot) ++i;
            if (i < j) swap(nums, i, j);
        }
        return i;
    }

    // Time：O(n), Space：O(k)
    public int findKthLargest2(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int p = partition(nums, low, high);
            if (p == k - 1) return nums[p];
            else if (p > k - 1) return high = p - 1;
            else low = p + 1;
        }
        return -1;
    }



}
