package com.demo76_100;

/**
 * @author: JunLog
 * @Description: 344. 反转字符串
 * Date: 2022/8/24 8:37
 */
public class _81ReverseString {

    // Time：O(n), Space：O(n)
    public String reverseString(String s) {
        if (s == null) return null;
        char[] c = s.toCharArray();
        for (int i = 0, j = c.length - 1; i < j ; ++i, --j) {
            char tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
        }
        return new String(c);
    }

}
