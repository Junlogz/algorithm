package com.demo26_50;

/**
 * @author: JunLog
 * @Description: 最长回文串
 * Date: 2022/8/14 9:40
 */
public class _26LongestPalindromic {

    public static void main(String[] args) {
        _26LongestPalindromic s = new _26LongestPalindromic();
        s.longestPalindromic2("abcbab");
    }

    // Time:O（n^2） space：O（n^2）
    public String longestPalindromic1(String s) {
        if (s == null || s.length() == 0) return "";
        int n = s.length(), start = 0, maxLen = 0;
        boolean[][] d = new boolean[n][n];

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                if (i == j) d[i][j] = true;
                else if (i + 1 == j) d[i][j] = s.charAt(i) == s.charAt(j);
                else d[i][j] = s.charAt(i) == s.charAt(j) && d[i + 1][j - 1];

                if (d[i][j] && (j - i + 1) > maxLen){
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    // Time:O（n） space：O（1）
    int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            --left; ++right;
        }
        // (rgith -1) - (left + 1 ) + 1
        return right - left - 1;
    }

    public String longestPalindromic2(String s) {
        if (s == null || s.length() == 0) return "";
        int start = 0 , maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                start = i - (len - 1) / 2;
                maxLen = len;
            }
        }
        return s.substring(start, start + maxLen);
    }

}
