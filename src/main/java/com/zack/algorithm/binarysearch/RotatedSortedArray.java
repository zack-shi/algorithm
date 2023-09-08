package com.zack.algorithm.binarysearch;

/**
 * https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/description/
 * <p>
 * 剑指 Offer 11. 旋转数组的最小数字
 * <p>
 * 思路： 二分法
 * 1、对半分，一半肯定是排序从小到大，一半是非排序的，即头大于尾
 * 2、那么最小的数一定在那一半头大于的数组中，
 * 3、然后继续二分
 */
public class RotatedSortedArray {

    public int minArray(int[] numbers) {
        int i = 0; //起始位置
        int j = numbers.length-1; //结束位置

        while (i < j) {
            int m = (i + j) / 2;//对半分
            if (numbers[m] > numbers[j]) {
                i = m + 1;
            } else  if(numbers[m] < numbers[j]) {
                j=m;
            }else {
                j=j-1;
            }
        }
        return numbers[i];
    }

}
