package com.zack.algorithm.search;

/**
 * https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 */
public class ExchangeOddAndEvenNum {

    /**
     * 选择排序
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]%2!=0){
                swap(nums,i,j);
                i++;
            }
        }
        return nums;
    }


    private void swap(int nums[],int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
