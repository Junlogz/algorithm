package com.demo1_25;

/**
 * @author: JunLog
 * @Description: 回文子串个数
 * Date: 2022/8/10 13:50
 */
public class _12CountPalindromic {

    int expand(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            ++count;
            --left;
            ++right;
        }
        return count;
    }

    // Time:O（n^2） space：O（1）
    public int countPalindromic(String s) {
        if (s == null || s.length() == 0) return 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expand(s, i, i);
            count += expand(s, i, i + 1);
        }
        return count;
    }

}
