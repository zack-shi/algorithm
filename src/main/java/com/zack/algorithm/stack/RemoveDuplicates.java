package com.zack.algorithm.stack;

import java.util.Stack;
//https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/
public class RemoveDuplicates {

    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        Stack stack = new Stack<>();
        for (char c : chars) {
            if (stack.size() != 0 && (char) stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        int n=stack.size();
        char [] new_chars=new char[n];
        for(int i=n-1;i>=0;i--){
            new_chars[i]=(char)stack.pop();
        }
        return new String(new_chars);
    }
}
