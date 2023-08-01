package com.zack.algorithm.array;

/**
 * https://leetcode.cn/problems/remove-element/
 * 移除元素
 */
public class RemoveElement {


    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int len = removeElementNew(nums, val);
        System.out.println(len);
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
            } else {
                i++;
            }
        }
        return j + 1;
    }

    public static int removeElementNew(int[] nums, int val) {
        int slow=0;
        int fast=0;
        while(fast<nums.length){
            if(nums[fast]==val){
                fast++;
            }else {
                nums[slow]=nums[fast];
                fast++;
                slow++;
            }
        }
        return slow;
    }

}
