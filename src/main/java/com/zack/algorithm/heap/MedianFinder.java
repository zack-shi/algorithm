package com.zack.algorithm.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 41. 数据流中的中位数
 */
public class MedianFinder {

    PriorityQueue<Integer> maxQ;
    PriorityQueue<Integer> minQ;

    /** initialize your data structure here. */
    public MedianFinder() {
         maxQ=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

         minQ=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
    }
    
    public void addNum(int num) {
        if(maxQ.isEmpty()||num<=maxQ.peek()){
            maxQ.offer(num);
        } else if(num>maxQ.peek()){
            minQ.offer(num);
        }
        if(maxQ.size()-minQ.size()>1){
            minQ.offer(maxQ.poll());
        }
        if(minQ.size()-maxQ.size()>1){
            maxQ.offer(minQ.poll());
        }
    }
    
    public double findMedian() {
        if(maxQ.isEmpty()){
            return 0;
        }
        if(maxQ.size()==minQ.size()){
            return (double) maxQ.peek() /2  + (double) minQ.peek() /2;
        }else if(maxQ.size()>minQ.size()) {
            return maxQ.peek();
        }else {
            return minQ.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */