package com.demo51_75;

/**
 * @author: JunLog
 * @Description: 汉明距离
 * Date: 2022/8/20 10:10
 */
public class _55HanMingDistance {

    int numberOfOne(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n &= (n - 1);
        }
        return count;
    }

    public int hanMingDistance(int x, int y) {
        return numberOfOne(x ^ y);
    }

}
