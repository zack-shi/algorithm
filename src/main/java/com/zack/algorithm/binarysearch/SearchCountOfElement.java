package com.zack.algorithm.binarysearch;

/**
 * https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I  (统计一个数字在排序数组中出现的次数。)
 */
public class SearchCountOfElement {

    /**
     * 找到target 最开始出现的位置和最后的位置，即可算出个数
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if(nums.length==0){
            return 0;
        }
        int i=0;
        int j=nums.length-1;
        //5,7,7,8,8,10
        //查找target最后出现的位置

        while (i<=j){
            int m=i+(j-i)/2;
            if(nums[m]<=target){
                i=m+1;
            }else {
                j=m-1;
            }
        }
        int last=i;  //找到为5
        if(j>=0&&nums[j]!=target){
            //这里判断没有找到的情况
            return 0;
        }

        i=0;
        j=nums.length-1;
        //查找target左边界
        while (i<=j){
            int m=i+(j-i)/2;
            if(nums[m]>=target){
                j=m-1;
            }else {
                i=m+1;
            }
        }
        int first=j;//找到为2

        return  last-first-1;
    }

    public static void main(String[] args) {
        new SearchCountOfElement().search(new int[]{5,7,7,8,8,10},8);
    }

}
