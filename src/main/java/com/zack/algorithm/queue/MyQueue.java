package com.zack.algorithm.queue;


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

import java.util.Stack;

/**
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 */
class MyQueue {

    Stack<Integer> pQueue;
    Stack<Integer> dQueue;


    public MyQueue() {
        pQueue = new Stack();
        dQueue = new Stack();
    }

    public void push(int x) {
        pQueue.push(x);
    }

    /**
     * 如果出队栈没有元素，要先把入队栈元素 出栈 并放入出队栈
     * @return
     */
    public int pop() {
        if(empty()){
            return -1;
        } else if (dQueue.size()!=0) {
            int element = dQueue.pop();
            return element;
        }else {
            while (pQueue.size()!=0){
                dQueue.push(pQueue.pop());
            }
            return dQueue.pop();
        }
    }

    public int peek() {
        if(empty()){
            return -1;
        } else if (dQueue.size()!=0) {
            int element = dQueue.peek();
            return element;
        }else {
            while (pQueue.size()!=0){
                dQueue.push(pQueue.pop());
            }
            return dQueue.peek();
        }
    }

    public boolean empty() {
        if(dQueue.size()==0&&pQueue.size()==0){
            return true;
        }
        return false;
    }
}

