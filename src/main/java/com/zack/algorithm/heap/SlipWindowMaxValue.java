package com.zack.algorithm.heap;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 59. 滑动窗口的最大值
 */
public class SlipWindowMaxValue {

    public int[] maxInWindows(int[] num, int k) {
        if(k>num.length||num.length<=1){
            return num;
        }
        //维护一个大顶堆
        PriorityQueue<Integer> pq=new PriorityQueue((Comparator<Integer>) (o1, o2) -> o2-o1);
        for(int i=0;i<k;i++){
            pq.offer(num[i]);
        }
        int [] ret=new int[num.length-k+1];
        ret[0]=pq.peek();
        int j=k;
        int i=0;
        while (j<num.length){
            pq.remove(num[i]); //窗口向右滑动一个元素，删除左边元素
            pq.offer(num[j]); //入队右边新元素
            j++;
            i++;
            ret[i]=pq.peek();  //收集结果
        }
        return ret;
    }


    public static void main(String[] args) {
        int [] num={1,3,-1,-3,5,3,6,7};
        new SlipWindowMaxValue().maxInWindows(num,3);
        for(int i=0;i<num.length;i++){
            System.out.println(num[i]+",");
        }

    }

}
