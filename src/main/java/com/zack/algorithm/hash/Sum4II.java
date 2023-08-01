package com.zack.algorithm.hash;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.cn/problems/4sum-ii/ 四数相加 II
 *
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 *
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 */
public class Sum4II {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> map=new HashMap();
        for(int i=0;i<nums1.length;i++){
            for (int j=0;j<nums2.length;j++){
                int num=nums1[i]+nums2[j];
                if(map.containsKey(num)){
                    map.put(num,map.get(num)+1);
                }else{
                    map.put(num,1);
                }
            }
        }
        int count=0;
        for(int i=0;i<nums3.length;i++){
            for (int j=0;j<nums4.length;j++){
                int key=-(nums3[i]+nums4[j]);
                if(map.containsKey(key)){
                    count=count+map.get(key);
                }
            }
        }
        return count;
    }
}
