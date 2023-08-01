package com.zack.algorithm.queue;

import java.util.*;

/**
 * https://leetcode.cn/problems/top-k-frequent-elements/
 * <p>
 * 前 K 个高频元素
 */
public class TopKElements {

    /**
     * 优先级队列 从大到小 队头是最大的值
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (k > nums.length) {
            return new int[0];
        }
        if (k <= 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = pq.poll()[0];
        }
        return topK;
    }


    public int[] topK(int[] nums, int k) {
        if (k > nums.length) {
            return new int[0];
        }
        if (k <= 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //改为从小到大排序
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        //小于等于k
        if (map.size() <= k) {
            int[] topK = new int[k];
            int i = 0;
            for (int key : map.keySet()) {
                topK[i] = key;
                i++;
            }
            return topK;
        }
        //大于k 先构建 k大小的小顶堆
        Iterator iterator = map.entrySet().iterator();
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) iterator.next();
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) iterator.next();
            //如果新元素比堆顶元素还要小直接舍弃
            if (pq.peek()[1] >= entry.getValue()) {
                continue;
            //如果大于堆顶元素，删除堆顶元素，然后新元素入队
            } else {
                pq.poll();
                pq.offer(new int[]{entry.getKey(), entry.getValue()});
            }
        }
        int[] topK = new int[k];
        int i = 0;
        for (int[] elemet : pq) {
            topK[i++] = elemet[0];
        }
        return topK;
    }


}
