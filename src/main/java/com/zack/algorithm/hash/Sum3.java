package com.zack.algorithm.hash;

import com.alibaba.fastjson2.JSON;

import java.util.*;

public class Sum3 {

    public static void main(String[] args) {
        int x[] = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        List<List<Integer>> list = threeSum(x);
        System.out.println(JSON.toJSONString(list));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        //当前数组的长度为空，或者长度小于3时，直接退出
        if(nums == null || n <3){
            return result;
        }
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            //排序好后，如果num[i]>0 ,说明最小的数已经大于0，不用再循环了，直接退出
            if (nums[i] > 0) {
                break;
            }
            //去重 当前=前一个值，后面组合结果一样，直接跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //双指针
            int L = i + 1;
            int R = n - 1;
            while (L < R) {
                List<Integer> list = new ArrayList<>();
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    list.add(nums[i]);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    result.add(list);
                    //双指针移动时，发现和前一位值相等
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;
                    //小于0说明L处的值不够大，L指针右移
                } else if (sum < 0) {
                    L++;
                    //大于0说明R处的值太大，R指针左移
                } else {
                    R--;
                }
            }

        }
        return result;
    }

}
