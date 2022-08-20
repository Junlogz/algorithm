package com.demo51_100;

/**
 * @author: JunLog
 * @Description: x 的平方根
 * Date: 2022/8/20 9:29
 */
public class _54SqrtBinarySearch {

    // Time：O(log(n)), Space：O(1)
    public int sqrtBinarySearch(int n) {
        long low = 0, high = n;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long mid2 = mid * mid;
            if (mid2 < n) low = mid + 1;
            else if (mid2 > n) high = mid - 1;
            else return (int)mid;
        }
        return (int)high;
    }


}
