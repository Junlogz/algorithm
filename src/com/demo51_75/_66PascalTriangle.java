package com.demo51_75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: JunLog
 * @Description: 杨辉三角
 * Date: 2022/8/22 11:15
 */
public class _66PascalTriangle {

    // Time：O(n^2), Space：O(n)
    public List<List<Integer>> generatePascalTriangle(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < 0) return result;

        for (int i = 0; i < n; i++) {
            List<Integer> list = Arrays.asList(new Integer[i + 1]);
            list.set(0, 1); list.set(i, 1);
            for (int j = 1; j < i; j++) {
                list.set(j, result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            result.add(list);
        }
        return result;
    }


}
