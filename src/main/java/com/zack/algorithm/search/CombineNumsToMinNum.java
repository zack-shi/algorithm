package com.zack.algorithm.search;

/**
 * https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/solutions/190476/mian-shi-ti-45-ba-shu-zu-pai-cheng-zui-xiao-de-s-4/
 * 剑指 Offer 45. 把数组排成最小的数
 */
public class CombineNumsToMinNum {

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        for(int i=0;i<strs.length;i++){
            boolean swapFlag=false;
            for(int j=1;j<strs.length-i;j++){
                if((strs[j-1]+strs[j]).compareTo(strs[j]+strs[j-1])>0){
                    swap(strs,j-1,j);
                    swapFlag=true;
                }
            }
            if(!swapFlag){
                break;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<strs.length;i++){
            sb.append(strs[i]);
        }
        return sb.toString();
    }

    private void swap(String [] nums,int i,int j){
        String temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        System.out.println(new CombineNumsToMinNum().minNumber(new int[]{3,30,34,5,9}));
    }

}
