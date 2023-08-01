package com.zack.algorithm.stack;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> tempStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        tempStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (tempStack.isEmpty() || (x <= tempStack.peek())) {
            tempStack.push(x);
        }
    }

    public void pop() {
        if (stack.pop().intValue() == tempStack.peek()) {
            tempStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return tempStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
