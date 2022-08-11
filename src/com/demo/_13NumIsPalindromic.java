package com.demo;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/8/10 14:06
 */
public class _13NumIsPalindromic {

    // Time:O（m） space：O（1）
    public boolean isPalindromic1 (int x) {
        String str = String.valueOf(x);
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            ++i;
            --j;
        }
        return true;
    }

    // Time:O（m） space：O（1）
    public boolean isPalindromic2 (int x) {
        if (x < 0) return false;
        int y = 0;
        int tmp = x;
        while (tmp != 0) {
            int num = tmp % 10;
            y = y * 10 + num;
            tmp = tmp / 10;
        }
        return x == y;
    }
}

