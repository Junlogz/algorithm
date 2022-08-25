package com.demo76_100;

/**
 * @author: JunLog
 * @Description: 91. 解码方法
 * Date: 2022/8/24 14:34
 */
public class _88NumDecodings {

    private boolean isValidDigit(char a, char b) {
        return (a == '1' && b <= '9') || (a == '2' && b<= '6');
    }

    // Time：O(n), Space：O(n)
    public int numDecodings(String s) {
        int[] d = new int[s.length() + 1];
        d[0] = 1;
        d[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') d[i] += d[i - 1];
            if (isValidDigit(s.charAt(i - 2), s.charAt(i - 1))) d[i] += d[i - 2];
        }
        return d[s.length()];
    }

}
