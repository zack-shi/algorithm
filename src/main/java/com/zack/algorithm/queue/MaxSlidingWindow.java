package com.zack.algorithm.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class MaxSlidingWindow {

    public static void main(String[] args) {
        //输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] maxArr = maxSliWindow(nums, 331);
        for (int num : maxArr) {
            System.out.print("," + num);
        }
    }


    /**
     * 数组 逻辑应该没问题，但是超时了。。。
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = k - 1;
        int[] maxArr = new int[n - k + 1];
        int y = 0;
        while (j < n) {
            int maxVal = nums[i];
            for (int x = i; x <= j; x++) {
                maxVal = Math.max(nums[x], maxVal);
            }
            maxArr[y] = maxVal;
            i++;
            j++;
            y++;
        }
        return maxArr;
    }

    /**
     * 栈
     *
     * @return
     */
    public static int[] maxSlideWindow(int[] nums, int k) {
        int [] maxArr=new int[nums.length - k + 1];
        Stack<Integer> stack = new Stack();
        stack.push(Integer.MIN_VALUE);
        int n=0;
        for (int i = k-1; i < nums.length; i++) {
            for (int j = i-k+1; j <= i; j++) {
                if (stack.peek() <= nums[j]) {
                    stack.pop();
                    stack.push(nums[j]);
                }
            }
            maxArr[n]=stack.pop();
            n++;
            stack.push(Integer.MIN_VALUE);
        }
        return maxArr;
    }

    /**
     * PriorityQueue 优先级队列 又叫 “堆”
     * 见都没见过  牛逼！！！
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSliWindow(int[] nums, int k) {
        int n=nums.length;
        int [] maxArr=new int[n-k+1];
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for(int i=0;i<k;i++){
            pq.offer(new int[]{nums[i],i});
        }
        maxArr[0] = pq.peek()[0];
        for(int i=k;i<n;i++){
            pq.offer(new int[]{nums[i],i});
            while (pq.peek()[1]<=i-k){
                pq.poll();
            }
            maxArr[i-k+1]=pq.peek()[0];
        }
        return maxArr;
    }

}
