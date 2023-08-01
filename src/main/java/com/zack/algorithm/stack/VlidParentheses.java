package com.zack.algorithm.stack;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/valid-parentheses 有效的括号
 */
public class VlidParentheses {

    public boolean isValid(String s) {
        Stack stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '{' || c == '[' | c == '(') {
                stack.push(c);
                continue;
            }
            if (c == '}') {
                if(stack.size()==0){
                    return false;
                }
                if ((char) stack.peek() != '{') {
                    return false;
                } else {
                    stack.pop();
                    continue;
                }
            }
            if (c == ']') {
                if(stack.size()==0){
                    return false;
                }
                if ((char) stack.peek() != '[') {
                    return false;
                } else {
                    stack.pop();
                    continue;
                }
            }
            if (c == ')') {
                if(stack.size()==0){
                    return false;
                }
                if ((char) stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                    continue;
                }
            }
        }
        if(stack.size()!=0){
            return false;
        }
        return true;
    }
}
