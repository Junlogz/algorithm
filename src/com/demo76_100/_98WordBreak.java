package com.demo76_100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: JunLog
 * @Description: 139. 单词拆分
 * Date: 2022/8/29 11:01
 */
public class _98WordBreak {

    public static void main(String[] args) {
        _98WordBreak p = new _98WordBreak();
        List<String> k = new ArrayList<>();
        k.add("leet");
        k.add("code");
        String s = "leetcode";
        p.wordBreak(s, k);
    }

    // Time：O(n^2), Space：O(n + m)
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] d = new boolean[n + 1];
        d[0] = true;
        Set<String> set = new HashSet<>(wordDict);
        for (int i = 1; i <= n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (d[j] && set.contains(s.substring(j, i))) {
                    d[i] = true;
                    break;
                }
            }
        }
        return d[n];
    }
}
