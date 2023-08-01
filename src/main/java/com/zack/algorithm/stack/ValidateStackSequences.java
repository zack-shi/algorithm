package com.zack.algorithm.stack;

import java.util.Stack;

public class ValidateStackSequences {


    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(popped.length==0&&pushed.length==0){
            return true;
        }
        if(popped.length==0||pushed.length==0){
            return false;
        }
        if(popped.length!=pushed.length){
            return false;
        }
        Stack<Integer> stack = new Stack();
        int p = 0;
        for (int i = 0; i < pushed.length; i++) {
            int pushItem = pushed[i];
            stack.push(pushItem);
            while (!stack.isEmpty()&&stack.peek()== popped[p]) {
                stack.pop();
                p++;
            }
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != popped[p]) {
                return false;
            }
            p++;
        }
        return true;
    }

}
