package com.demo51_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: JunLog
 * @Description: 三数和
 * Date: 2022/8/19 11:46
 */
public class _53TreeNumSum {

    public List<List<Integer>> treeNumSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int k = nums.length - 1; k >= 2; --k) {
            if (nums[k] < 0) break;
            int target = -nums[k], i = 0, j = k - 1;

            while (i < j) {
                if (nums[i] + nums[j] == target) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (i < j && nums[i + 1] == nums[i]) ++i;
                    while (i < j && nums[j - 1] == nums[j]) --j;
                    ++i; --j;
                } else if (nums[i] + nums[j] < target) {
                    ++i;
                } else {
                    --j;
                }
            }
            while (k >= 2 && nums[k - 1] == nums[k]) --k;
        }

        return result;
    }

}
