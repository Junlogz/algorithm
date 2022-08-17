package com.demo26_50;

/**
 * @author: JunLog
 * @Description: 实现strstr
 * Date: 2022/8/17 14:19
 */
public class _43Strstr {

    public static void main(String[] args) {
        String q = "hello";
        String w = "ll";
        _43Strstr r = new _43Strstr();
        r.strstr1(q,w);
    }


    // Time:O（n×m） space：O（1）
    public int strstr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int n = haystack.length(), m = needle.length();

        for (int i = 0; i < n - m; i++) {
            int j = 0, k = i;
            for (; j < m && k < n & needle.charAt(j) == haystack.charAt(k); ++j, ++k){
                if (j == needle.length()) return i;
            }
        }
        return -1;
    }

    public int strstr1(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    // Time:O（n+m） space：O（m）
    public int strstrKMP(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i))
                j = next[i -1];
            if (needle.charAt(j) == haystack.charAt(i))
                j++;
            if (j == needle.length())
                return i - needle.length() + 1;
        }
        return -1;
    }

    private void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i))
                j = next[j - 1];
            if (s.charAt(j) == s.charAt(i))
                j++;
            next[i] = j;
        }
    }



}
