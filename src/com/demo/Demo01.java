package com.demo;

/**
 * @author: JunLog
 * @Description: 回文字符串判断
 * Date: 2022/8/2 23:16
 */
public class Demo01 {
    public boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    public boolean isEqual(char a, char b) {
        // 忽略大小写 如果大写就+32
        if (a >= 'A' && a <= 'Z') a += 32;
        if (b >= 'A' && b <= 'Z') b += 32;
        return a == b;
    }

    // Time：O（n） space：O（1）
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int i = 0, j = s.length() - 1;
        for (;  i < j; ++i, --j) {
            // 不是字母或数字就移动
            while (i < j && !isAlphanumeric(s.charAt(i))) ++i;
            while (i < j && !isAlphanumeric(s.charAt(j))) --i;
            if (i < j && !isEqual(s.charAt(i), s.charAt(j))) return false;
        }
        return true;
    }
}
