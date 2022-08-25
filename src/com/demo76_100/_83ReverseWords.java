package com.demo76_100;

/**
 * @author: JunLog
 * @Description: 557. 反转字符串中的单词 III
 * Date: 2022/8/24 8:53
 */
public class _83ReverseWords {

    // Time：O(n), Space：O(n)
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        char[] c = s.toCharArray();
        int start = 0, end = 0;
        while (start < c.length) {
            while (end < c.length && c[end] != ' ') ++end;
            for (int i = start, j = end - 1; i < j; ++i, --j) {
                char tmp = c[i];
                c[i] = c[j];
                c[j] = tmp;
            }
            start = end + 1;
            end = start;
        }
        return new String(c);
    }

}
