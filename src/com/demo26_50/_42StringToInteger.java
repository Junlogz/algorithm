package com.demo26_50;

/**
 * @author: JunLog
 * @Description: 字符串转整数
 * Date: 2022/8/17 10:27
 */
public class _42StringToInteger {

    public static void main(String[] args) {
        _42StringToInteger s = new _42StringToInteger();
        String t = "-00432";
         int i = s.stringToInteger(t);
        System.out.println(i);
    }

    public int stringToInteger(String str) {
        int start = 0, p = 0, n = str.length();
        boolean negative = false;
        // 如果扫描的都是空串 返回0
        while (p < n && str.charAt(p) == ' ') ++p;
        if (p == n) return 0;

        //正负
        if (str.charAt(p) == '+'){
            ++p;
        } else if (str.charAt(p) == '-') {
            ++p;
            negative = true;
        }

        // 忽略前导0 到达第一个不为0记录start
        while (p < n && str.charAt(p) == '0') ++p;
        start = p;

        // 扫过数字
        while (p < n && str.charAt(p) >= '0' && str.charAt(p) <= '9') ++p;
        // 没有数字
        if (p == start) return 0;

        // 超过int最大或者最小
        if (p - start > 10) {
            if (negative) return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }

        long num = 0;
        for (int i = start; i < p; i++)
            num = num * 10 + (str.charAt(i) - '0');
        num = negative ? -num : num;

        if (num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else return (int)num;
    }

}
