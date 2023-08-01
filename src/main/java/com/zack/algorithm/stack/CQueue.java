package com.zack.algorithm.stack;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 *
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 */
public class CQueue {

    Stack<Integer> addQ;
    Stack<Integer> delQ;

    public CQueue() {
        addQ=new Stack<>();
        delQ=new Stack<>();
    }

    public void appendTail(int value) {
        addQ.push(value);
    }

    public int deleteHead() {
        if(delQ.isEmpty()){
            while (!addQ.isEmpty()){
                delQ.push(addQ.pop());
            }
        }
        if(delQ.isEmpty()){
            return -1;
        }
        return delQ.pop();
    }

}
