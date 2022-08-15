package com.demo1_25;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: JunLog
 * @Description: 力扣136.单身数字
 * Date: 2022/8/9 10:41
 */
public class _06SingleNum {

    public int singleNum1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0, uniqueSum = 0;
        for (int num : nums) {
            if (!set.contains(num)) {
                uniqueSum += num;
                set.add(num);
            }
            sum += num;
        }
        return 2 * uniqueSum - sum;
    }

    public int singleNum2(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }



}
