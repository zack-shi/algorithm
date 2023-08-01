package com.zack.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {

    Queue<Integer> queueA;
    Queue<Integer> queueB;


    public MyStack() {
        queueA = new ArrayDeque<>();
        queueB = new ArrayDeque<>();
    }

    public void push(int x) {
        if (queueA.size() != 0) {
            queueA.offer(x);
        } else {
            queueB.offer(x);
        }
    }

    public int pop() {
        if (queueA.size() != 0) {
            while (queueA.size() > 1) {
                queueB.offer(queueA.poll());
            }
            return queueA.poll();
        } else {
            while (queueB.size() > 1) {
                queueA.offer(queueB.poll());
            }
            return queueB.poll();
        }
    }

    public int top() {
        if (queueA.size() != 0) {
            while (queueA.size() > 1) {
                queueB.offer(queueA.poll());
            }
            int element = queueA.poll();
            queueB.offer(element);
            return element;
        } else {
            while (queueB.size() > 1) {
                queueA.offer(queueB.poll());
            }
            int element = queueB.poll();
            queueA.offer(element);
            return element;
        }
    }

    public boolean empty() {
        return queueA.size()==0&&queueB.size()==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */