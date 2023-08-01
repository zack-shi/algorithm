package com.zack.algorithm.sort;

public class HeapSort {

    public int[] sortArray(int[] nums) {
        return heapSort(nums);
    }

    private int[] heapSort(int[] nums) {
        //1、建堆
        build(nums);
        //2、排序
        return sort(nums);
    }

    void build(int[] nums) {
        int n = nums.length;
        for (int i = n / 2; i >= 1; i--) {
            heapify(nums,n,i);
        }
    }

    private void heapify(int[] nums,int n,int i){
        while (true){
            int minIndex = i-1;
            if (i*2 <=n&&nums[i*2-1] < nums[minIndex]) {
                minIndex = i*2-1;
            }
            if (i *2+1<=n&&nums[i*2]<nums[minIndex]) {
                minIndex=i*2;
            }
            if (minIndex !=  i-1) {
                swap(nums, i-1, minIndex);
                i=minIndex+1;
            }else {
                break;
            }
        }
    }


    int[] sort(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int x = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            arr[x] = nums[0];
            x++;
            nums[0] = nums[i];
            heapify(nums,i,1);
        }
        return arr;
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums={-2,3,-5};
        new HeapSort().heapSort(nums);
    }

}
