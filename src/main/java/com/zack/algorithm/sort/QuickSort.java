package com.zack.algorithm.sort;

import java.util.Random;

public class QuickSort {

    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    int partion(int[] nums,int l,int r) {
        int i = l, j = l;
        int pVal = nums[r];
        while (j < r) {
            if (nums[j] < pVal) {
                swap(nums,i,j);
                i++;
                j++;
                continue;
            }
            if (nums[i] < pVal) {
                i++;
            }
            j++;
        }
        swap(nums,i,j);
        return i;
    }

    void quicksort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int i=new Random().nextInt(r-l+1)+l;
        swap(nums, r, i);
        int p = partion(nums,l,r);
        quicksort(nums, l, p - 1);
        quicksort(nums, p + 1, r);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}


