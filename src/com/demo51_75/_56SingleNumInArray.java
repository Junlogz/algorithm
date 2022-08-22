package com.demo51_75;

/**
 * @author: JunLog
 * @Description: 有序数组中的单一元素
 * Date: 2022/8/20 10:36
 */
public class _56SingleNumInArray {

    public int singleNumInArray1(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    // Time：O(log(n)), Space：O(1)
    public int singleNumInArray2(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid - 1 >= 0 && nums[mid - 1] == nums[mid]) {
                --mid;
            } else if (mid + 1 < nums.length && nums[mid + 1] == nums[mid]){
            } else {
                return nums[mid];
            }
            if ((mid - low) % 2 == 1) high = mid - 1;
            else low = mid + 2;
        }
        return -1;
    }

}
