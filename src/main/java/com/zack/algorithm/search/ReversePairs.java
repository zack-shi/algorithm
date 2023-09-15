package com.zack.algorithm.search;

/**
 * https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/description/
 *
 * 剑指 Offer 51. 数组中的逆序对
 */
public class ReversePairs {

    int count=0;
    /**
     * 归并排序
     * 思路：归并两个有序的子区间时，当比较时，剩余右子区间的首位为较小的数，统计左区间剩余的个数
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        if(nums.length<=1){
            return 0;
        }
        int left=0;
        int right=nums.length-1;
        int [] temp=new int[nums.length];
        reversePairs(nums,left,right,temp);
        return count;
    }

    void reversePairs(int[] nums,int left,int right,int [] temp){
        if(left==right){
            return;
        }
        int mid=left+(right-left)/2;
        reversePairs(nums,left,mid,temp);
        reversePairs(nums,mid+1,right,temp);
        mergeAndCount(nums,left,mid,right,temp);
    }

    void mergeAndCount(int [] nums,int left,int mid,int right,int [] temp){
        for(int i=left;i<=right;i++){
            temp[i]=nums[i];
        }
        int i=left;
        int j=mid+1;
        int k=left;
        while (i<=mid&&j<=right){
            if(temp[j]<temp[i]){
                nums[k]=temp[j];
                j++;
                count+=mid-i+1;
            }else {
                nums[k]=temp[i];
                i++;
            }
            k++;
        }
        int start=i;
        int end=mid;
        if(j<=right){
            start=j;
            end=right;
        }
        while (start<=end){
            nums[k++]=temp[start++];
        }
    }

}
