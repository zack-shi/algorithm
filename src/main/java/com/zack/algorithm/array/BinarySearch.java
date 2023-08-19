package com.zack.algorithm.array;

/**
 * https://leetcode.cn/problems/binary-search/
 * 二分查找
 */
public class BinarySearch {


    /**
     * 思路：
     * 1.定义数组的左边界left和右边界right，然后取左右的中间点mid=(left+right)/2
     * 2.判断中间值是否等于目标值
     *   2.1等于则完成查找
     *   2.2小于说明目标值在左边，令right=mid-1
     *   2.3大于说明目标值在右边，令left=mid+1
     * 重复步骤2  
     */
    public static int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid =(left+right)/2;

        if(nums[mid]==target){
            return mid;
        }
        while(left<=right){
             mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target) {
                left=left+1;
            }else {
                right=right-1;
            }
        }
        return -1;
    }

    /**
     * 递归思路跟迭代一样
     */
    public static int binary_search_recursion(int arr[],int target,int left,int right){
        int mid =(left+right)/2;
        if(arr[mid]==target){
            return mid;
        }
        if(left>=right){
            return -1;
        }
        else if(arr[mid]<target){
            left=mid+1;
        }
        else{
            right=mid-1;
        }
        return binary_search_recursion(arr,target,left,right);
    }

    /**
     * 非递归
     * @param arr
     * @param target
     * @param left
     * @param right
     * @return
     */
    public static int  binary_search(int arr[],int target,int left,int right){
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]<target) {
                left=left+1;
            }else {
                right=right-1;
            }
        }
        return -1;
    }


    double sqrt2() {
        double EPSILON = 0.0000000001;
        double low = 1.4, high = 1.5;
        double mid = (low + high) / 2;

        while (high - low > EPSILON) {
            if (mid * mid > 2) {
                high = mid;
            } else {
                low = mid;
            }
            mid = (high + low) / 2;
        }

        return mid;
    }


    public static void main(String[] args) {
        System.out.println(new BinarySearch().sqrt2());
    }


}
