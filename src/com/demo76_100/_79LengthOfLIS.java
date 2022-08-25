package com.demo76_100;

/**
 * @author: JunLog
 * @Description: 300. 最长递增子序列
 * Date: 2022/8/24 7:40
 */
public class _79LengthOfLIS {

    // Time：O(n^2), Space：O(n)
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length, max = 1;
        int[] d = new int[n];
        d[0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int cur = nums[i] > nums[j] ? d[j] + 1 : 1;
                d[i] = Math.max(d[i], cur);
            }
            max = Math.max(max, d[i]);
        }
        return max;
    }

    private int binarySearch(int[] d, int len, int x) {
        int low = 0, high = len - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (x < d[mid]) high = mid - 1;
            else if (x > d[mid]) low = mid + 1;
            else return mid;
        }
        return low;
    }

    // Time：O(n*log(n)), Space：O(n)
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length, len = 0;
        int[] d = new int[n];

        for (int x : nums) {
            int i = binarySearch(d, len, x);
            d[i] = x;
            if (i == len) ++len;
        }
        return len;
    }

    public static void main(String[] args) {
        _79LengthOfLIS e = new _79LengthOfLIS();
        int[] nums = {1,8,2,6,4,5};
        e.lengthOfLIS1(nums);
    }
}
