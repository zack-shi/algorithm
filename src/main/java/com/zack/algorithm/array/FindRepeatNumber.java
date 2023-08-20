package com.zack.algorithm.array;

/**
 * https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * 找出数组中重复的数字。在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 思路：既然所有数字都在 0～n-1 的范围内，
 * 那么可以令nums[i]=i，
 * 一边遍历nums，并使用元素交换swap设置nums[i]=i,
 * 一旦发现nums[i]对应的位置nums[nums[i]]已经有值，说明找到重复的数字了。
 */
class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        for(int i=0;i<nums.length;i++){
            while(nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                swap(nums,i,nums[i]);
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}