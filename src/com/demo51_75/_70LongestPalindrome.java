package com.demo51_75;

/**
 * @author: JunLog
 * @Description: 409. 最长回文串
 * Date: 2022/8/22 13:43
 */
public class _70LongestPalindrome {

    // Time：O(n), Space：O(m) m：数组的字符数量
    public int lengthOfPalindrome(String s) {
        int[] d = new int[256];
        int oddNum = 0;
        for (char c : s.toCharArray()) {
            ++d[c];
        }
        for (int count : d) {
            if (count % 2 == 1)
                ++oddNum;
        }
        int unUsed = Math.max(0, oddNum - 1);
        return s.length() - unUsed;
    }

}
