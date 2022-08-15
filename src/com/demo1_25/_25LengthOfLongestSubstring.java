package com.demo1_25;

import java.util.Arrays;

/**
 * @author: JunLog
 * @Description: 没有重复字符串的字串长度
 * Date: 2022/8/13 21:04
 */
public class _25LengthOfLongestSubstring {

    public int lengthOfLongestSubstring1(String s) {
        int[] counts = new int[256];
        int i = 0, j = 0, maxLen = 0;
        for (; i < s.length(); i++) {
            for (; j < s.length(); j++) {
                // j指向的字符不为0就是已经出现过了
                if (counts[s.charAt(j)] != 0) break;
                // 否则没出现过的话count+1
                counts[s.charAt(j)] += 1;
            }
            maxLen = Math.max(maxLen, j - i);
            counts[s.charAt(i)] -= 1;
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring2(String s) {
        int[] index = new int[256];
        Arrays.fill(index, -1);
        int maxLen = 0;
        for (int i = 0, j = 0; i < s.length(); j++) {
            i = Math.max(index[s.charAt(j)] + 1, i);
            maxLen = Math.max(maxLen, j - i + 1);
            index[s.charAt(j)] = j;
        }
        return maxLen;
    }
}
