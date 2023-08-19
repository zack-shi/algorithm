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

    /**
     * 思路：快慢指针，快指针寻找新数组需要的元素，然后把元素赋给新数组即慢指针，然后快慢指针都+1
     * 快指针遇到要移除的值则跳过
     */
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
