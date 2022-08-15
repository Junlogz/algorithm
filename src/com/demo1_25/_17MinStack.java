package com.demo1_25;

import java.util.Stack;

/**
 * @author: JunLog
 * @Description: 带有min函数的栈
 * Date: 2022/8/11 11:10
 */
public class _17MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || x <= min()) min.push(x);
    }

    public void pop() {
        if (stack.peek() == min()) min.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
