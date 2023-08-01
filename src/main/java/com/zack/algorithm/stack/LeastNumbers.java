package com.zack.algorithm.stack;

import com.alibaba.fastjson2.JSON;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 剑指 Offer 40. 最小的k个数
 * <p>
 * 排序 冒泡 选择  插入
 * <p>
 * 单调栈
 */
public class LeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0) {
            return arr;
        }
        //冒泡
//        bubble(arr);

        //选择
//        selectSort(arr);

        //插入
//        insertSort(arr);

        //快排
//        quicksort(arr,0,arr.length-1);

        //大顶堆
        PriorityQueue<Integer> priorityQueue=bigHeap(arr);
        while (priorityQueue.size()>k){
            priorityQueue.poll();
        }
        int resArr[] = new int[k];
        for (int n = 0; n < k; n++) {
            resArr[n] = priorityQueue.poll();
        }
        return resArr;
    }


    public int[] bubble(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            boolean swapFlag = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapFlag = true;
                }
            }
            if (!swapFlag) {
                break;
            }
        }
        return arr;
    }

    public void selectSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int index = select(arr, i, arr.length - 1);
            swap(arr, i, index);
        }
    }

    public void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public int select(int[] arr, int x, int y) {
        int min = arr[x];
        int minIndex = x;
        for (int i = x + 1; i <= y; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }


    public void insertSort(int[] arr) {
        int i = 0;
        int j = 1;
        while (j < arr.length) {
            if (arr[j] < arr[i]) {
                int temp = arr[j];
                int n = i;
                for (; n >= 0; n--) {
                    if (arr[n] > temp) {
                        arr[n + 1] = arr[n];
                    } else {
                        break;
                    }
                }
                arr[n + 1] = temp;
            }
            i++;
            j++;
        }
    }


    /**
     * 自制单调栈  超时
     *
     * @param arr
     */
    public Stack<Integer> increaseStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> helpStack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                helpStack.push(stack.pop());
            }
            stack.push(arr[i]);
            while (!helpStack.isEmpty()) {
                stack.push(helpStack.pop());
            }
        }
        return stack;
    }



    public void quicksort(int a[],int l,int r){
        if(l>r){
            return;
        }
        int p=partion(a,l,r);
        quicksort(a,l,p-1);
        quicksort(a,p+1,r);
    }


    /**
     * quicksort 快排
     *
     * @param a
     */
    public int partion(int a[],int left,int right) {
        int i = left;
        int j = left;
        int pivot=right;
        int p = a[right];
        while (j<=right){
            if(a[j]<p){
                if(i!=j){
                    swap(a,i,j);
                }
                i++;
                j++;
                continue;
            }
            j++;
        }
        swap(a,i,pivot);
        return i;
    }

    //大顶堆
    public PriorityQueue<Integer> bigHeap(int [] a){
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<a.length;i++){
            pq.offer(a[i]);
        }
        return pq;
    }


    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        int[] res = new LeastNumbers().getLeastNumbers(arr, 5);
        System.out.println(JSON.toJSONString(res));
    }

}
