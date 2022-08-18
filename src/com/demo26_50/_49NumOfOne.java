package com.demo26_50;

/**
 * @author: JunLog
 * @Description: 二进制中1的个数
 * Date: 2022/8/18 10:59
 */
public class _49NumOfOne {

    // Time:O（m） space：O（1） m：二进制位数
    public int numOfOne1(int n){
        int mask = 1, count = 0;
        while (mask != 0) {
            if ((n & mask) != 0) ++count;
            mask <<= 1;
        }
        return count;
    }

    // Time:O（k） space：O（1） k：1的个数
    public int numOfOne2(int n){
        int count = 0;
        while (n != 0) {
            ++count;
            n &= (n - 1);
        }
        return count;
    }

}
