package com.demo26_50;

/**
 * @author: JunLog
 * @Description: 丑数
 * Date: 2022/8/17 10:19
 */
public class _41IsUglyNumber {

    // Time:O（m+n+L） space：O（1）
    public boolean isUglyNumber(int num) {
        if (num <= 0) return false;
        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        return num == 1;
    }

}
