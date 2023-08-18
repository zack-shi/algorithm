package com.zack.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 连续的整数和
 */
public class FindContineSeq {


    public int[][] findContinuousSequence(int target) {
        //双指针滑动窗口
        //思路
        //小于target 往右滑动一格 i++,j++
        //== 记录结果 左边界往右滑动一格 i++
        //大于 左边界往右滑动一格 i++

        List<int[]> res = new ArrayList<>();
        int i = 1;
        int j = 2;
        int sum = i + j;
        while (i < j) {
            if (sum < target) {
                j++;
                sum += j;
            } else if (sum == target) {
                int[] arr=new int[j-i+1];
                int x=0;
                for (int n = i; n <= j; n++) {
                    arr[x]=n;
                    x++;
                }
                res.add(arr);
                sum -= i;
                i++;
            }else {
                sum-=i;
                i++;
            }
        }
       return res.toArray(new int[res.size()][]);
    }

}
