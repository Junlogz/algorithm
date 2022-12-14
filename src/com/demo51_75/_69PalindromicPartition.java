package com.demo51_75;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: JunLog
 * @Description: 回文分割
 * Date: 2022/8/22 12:13
 */
public class _69PalindromicPartition {

    public void partition(String s, int start, boolean[][] d,
                          List<List<String>> result, List<String> elem) {
        if (start >= s.length()){
            result.add(new ArrayList<>(elem));
        } else {
            for (int end = start; end < s.length(); end++) {
                if (d[start][end]) {
                    elem.add(s.substring(start, end + 1));
                    partition(s, end + 1, d, result, elem);
                    elem.remove(elem.size() - 1);
                }
            }
        }
    }

    // Time：O(2^n), Space：O(n^2)
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        int n = s.length();
        boolean[][] d = new boolean[n][n];

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                if (i == j) d[i][j] = true;
                else if (i + 1 == j) d[i][j] = s.charAt(i) == s.charAt(j);
                else d[i][j] = s.charAt(i) == s.charAt(j) && d[i + 1][j - 1];
            }
        }

        partition(s, 0, d, result, new ArrayList<>());
        return result;
    }

}
