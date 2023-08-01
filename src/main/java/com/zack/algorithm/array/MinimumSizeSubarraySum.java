package com.zack.algorithm.array;

/**
 * https://leetcode.cn/problems/minimum-size-subarray-sum/
 * 长度最小的子数组
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        int [] nums={1,1,1,1,1,1,1,1};
        int target=11;
        System.out.println(minSubArrLen(target,nums));
    }

    /**
     * 暴力
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen_force(int target, int[] nums) {
        int a[]=new int[nums.length];
        int x=0;
        for(int i=0;i<nums.length;i++){
            int temp=nums[i];
            if(temp>=target){
                return 1;
            }
            int count=1;
            for(int j=i+1;j<nums.length;j++){
                temp=temp+nums[j];
                count=count+1;
                if(temp>=target){
                    a[x]=count;
                    x++;
                    break;
                }
            }
        }
        int min=a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]==0){
                break;
            }
            if(min>a[i]){
                min=a[i];
            }
        }
        return min;
    }

    /**
     * 滑动窗口
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums){
        int sum=0;
        int i=0;
        int minlen=nums.length;
        boolean hasSum=false;
        for(int j=0;j<nums.length;j++){
            sum=sum+nums[j];
            while (sum>=target){
                int len=j-i+1;
                minlen=len<minlen?len:minlen;
                sum=sum-nums[i];
                ++i;
                hasSum=true;
            }
        }
        if(!hasSum){
            return 0;
        }
        return minlen;
    }



    public static int minSubArrLen(int target, int[] nums) {
        //前缀和加二分查找
        int n=nums.length;
        int sums[]=new int[n+1];//申请一个n+1长度大小的数组存储前缀和
        sums[0]=0;
        for(int i=0;i<n;i++){
            sums[i+1]=sums[i]+nums[i]; //循环计算并保存前缀和
        }
        int minlen=n+1;
        for(int j=0;j<n;j++){
            int val= sums[j]+target;
            //在前缀和数组sums 中二分查找 >=val 最小的索引
            int index=binarySearch(sums,val);
            if(index<0){
                continue;
            }
            int len=index-j;
            minlen=len<minlen?len:minlen;
        }
        return minlen==n+1?0:minlen;
    }

    /**
     *  查找第一个大于或等于val的位置
     */
    public static int binarySearch(int a[],int val){
        int left=0;
        int right=a.length-1;
        while(left<=right){
            int mid =(left+right)/2;
            if(a[mid]>=val){
                if(mid==0||a[mid-1]<val){
                    return mid;
                }
                if(a[mid-1]>=val){
                    right=mid-1;
                }
            }else {
                left=mid+1;
            }
        }
        return -1;
    }






















}
