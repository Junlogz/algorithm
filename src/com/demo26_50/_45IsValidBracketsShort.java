package com.demo26_50;

import java.util.Stack;

/**
 * @author: JunLog
 * @Description: 有效括号序列
 * Date: 2022/8/18 9:53
 */
public class _45IsValidBracketsShort {

    // Time:O（n） space：O（n）
    public boolean isValidBracketsShort(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(')');
            else if (s.charAt(i) == '[') stack.push(']');
            else if (s.charAt(i) == '{') stack.push('}');
            else if (stack.isEmpty() || s.charAt(i) != stack.pop()) return false;
        }
        return stack.isEmpty();
    }

}
