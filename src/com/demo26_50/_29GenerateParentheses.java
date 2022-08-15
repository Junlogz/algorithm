package com.demo26_50;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: JunLog
 * @Description: 括号的合法性
 * Date: 2022/8/14 13:43
 */
public class _29GenerateParentheses {

    void generate(List<String> result, String str, int left, int right){
        if (left == 0 && right ==0) {
            result.add(str);
        }
        if (left > 0) generate(result, str + '(', left - 1, right);
        if (right > left) generate(result, str + ')', left, right - 1);
    }

    // Time:O（4^n / sqrt(n)） space：O（n）
    public List<String> generateParentheses(int n) {
        if (n < 0) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        generate(result, "", n, n);
        return result;
    }

}
