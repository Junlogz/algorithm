package com.demo76_100;

/**
 * @author: JunLog
 * @Description: 32. 最长有效括号
 * Date: 2022/8/30 16:32
 */
public class _100LongestValidParentheses {

    // Time：O(n), Space：O(n)
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length(), p = -1, max = 0;
        int[] st = new int[n + 1];
        st[++p] = -1;

        for (int i = 0; i < n; i++) {
            if (st[p] != -1 && s.charAt(st[p]) == '(' && s.charAt(i) == ')') {
                --p;
                max = Math.max(max, i - st[p]);
            } else st[++p] = i;
        }
        return max;
    }

    // Time：O(n), Space：O(n)
    public int longestValidParentheses1(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length(), left = 0, max = 0;
        int[] d = new int[n];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '('){
                ++left;
            } else if (left > 0) {
                d[i] = d[i - 1] + 2;
                d[i] += (i - d[i]) >= 0 ? d[i - d[i]] : 0;
                max = Math.max(max, d[i]);
                --left;
            }
        }
        return max;
    }

}
