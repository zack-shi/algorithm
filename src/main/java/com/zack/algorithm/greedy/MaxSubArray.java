package com.zack.algorithm.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxSubArray {

    int max = Integer.MIN_VALUE;

    int sum = 0;

    public int maxSubArray(int[] nums) {
        greedy(nums);
        return max;
    }


    /**
     * 贪心算法  连续和为负数的时候 放弃，跳到下一位
     */
    public void greedy(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
                continue;
            }
        }
    }


    /**
     * 暴力递归,超时了
     *
     * @param nums
     * @param startIndex
     */
    public void backtracking(int[] nums, int startIndex) {
        if (startIndex == nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            sum += nums[i];
            max = sum > max ? sum : max;
        }
        sum = 0;
        backtracking(nums, startIndex + 1);
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        new MaxSubArray().maxSubArray(nums);

    }

}
