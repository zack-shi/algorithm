package com.zack.algorithm.stack;

import java.util.Stack;
//https://leetcode.cn/problems/evaluate-reverse-polish-notation/
public class ReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (!isMathOp(s)) {
                stack.push(Integer.parseInt(s));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int opResult=mathOpr(num1,num2,s.charAt(0));
                stack.push(opResult);
                continue;
            }
        }
        return stack.pop();
    }

    boolean isMathOp(String s) {
        if (s.length() > 1) {
            return false;
        }
        char c = s.charAt(0);
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    int mathOpr(int num1, int num2, char op) {
        if (op == '+') {
            return num1 + num2;
        }
        if (op == '-') {
            return num1 - num2;
        }
        if (op == '*') {
            return num1 * num2;
        }
        if (op == '/') {
            return num1 / num2;
        }
        return 0;
    }
}
