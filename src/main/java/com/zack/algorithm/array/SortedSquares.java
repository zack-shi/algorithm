package com.zack.algorithm.array;

/**
 * https://leetcode.cn/problems/squares-of-a-sorted-array/
 * 有序数组的平方
 */
public class SortedSquares {


    public static void main(String[] args) {
        int[] nums = {1};
        nums = sortedSquares_new2(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }


    /**
     * 输入：nums = [-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]
     * 排序后，数组变为 [0,1,9,16,100]
     *
     * @param nums
     * @return
     */
    public static int[] sortedSquares(int[] nums) {  //插入排序
        int n = nums.length;
        for (int x = 0; x < n; x++) {
            int val = nums[x];
            nums[x] = val * val;
        }
        for (int i = 1; i < n; i++) {
            int value = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] > value) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = value;
        }
        return nums;
    }


    //换个思路 从中间往两边 循环 然后取每个数组里最小的 放到新数组里
    public static int[] sortedSquares_new(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        if (n == 1) {
            nums[0] = nums[0] * nums[0];
            return nums;
        }

        boolean hasNegNum = false;
        boolean positiveNum = false;
        for (int x = 0; x < n; x++) {
            if (nums[x] < 0) {
                hasNegNum = true;
            }
            if (nums[x] >= 0) {
                positiveNum = true;
            }
        }

        //没有负数
        if (!hasNegNum) {
            for (int x = 0; x < n; x++) {
                nums[x] = nums[x] * nums[x];
            }
            return nums;
        }

        int a[] = new int[n];
        int i = 0;
        //全是负数
        if (!positiveNum) {
            for (int y = n - 1; y >= 0; y--) {
                a[i] = nums[y] * nums[y];
                i++;
            }
            return a;
        }

        int left = 0;
        int right = 0;
        for (int x = 0; x < n; x++) {
            if (nums[x] >= 0) {
                left = x - 1;
                right = x;
                break;
            }
        }
        //既有负数，又有非负数
        while (left >= 0 && right < n) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (leftSquare <= rightSquare) {
                a[i] = leftSquare;
                --left;
            } else {
                a[i] = rightSquare;
                ++right;
            }
            ++i;
        }
        while (left >= 0) {
            a[i] = nums[left] * nums[left];
            --left;
            ++i;
        }
        while (right < n) {
            a[i] = nums[right] * nums[right];
            ++right;
            ++i;
        }
        return a;
    }

    //换个思路 两边往中间，因为本来就是有序数组，不管有没有负数，两边的值的平方是最大，往中间则是递减
    //然后赋给新数组
    public static int[] sortedSquares_new2(int[] nums) {
        int n=nums.length;
        int i=0;
        int j=n-1;
        int a[]=new int[n];
        int x=n-1;
        while (i<=j){
            int ii=nums[i]*nums[i];
            int jj=nums[j]*nums[j];
            if(ii>=jj){
                a[x]=ii;
                ++i;
            }else {
                a[x]=jj;
                --j;
            }
            x--;
        }
        return a;
    }


}
