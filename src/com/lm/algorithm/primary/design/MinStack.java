package com.lm.algorithm.primary.design;

import java.util.Stack;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-29 13:40
 * @Description:设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */

public class MinStack {

    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> minstack = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (minstack.isEmpty() || x <= minstack.peek()) {
            minstack.push(x);
        }
        return;
    }

    public void pop() {
        int x = stack.pop();
        if (x == minstack.peek())
            minstack.pop();
        return;
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }

    public static void main(String[] args) {

    }

}
