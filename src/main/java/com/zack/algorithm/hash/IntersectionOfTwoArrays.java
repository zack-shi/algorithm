package com.zack.algorithm.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/intersection-of-two-arrays/  两个数组的交集
 * 两个数组的交集
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        int minLen = set1.size() > set2.size() ? set2.size() : set1.size();
        int a[] = new int[minLen];
        for (int i = 0; i < minLen; i++) {
            a[i] = -1;
        }
        int i = 0;
        for (int num : set2) {
            if (set1.contains(num)) {
                a[i] = num;
                i++;
            }
        }
        int[] b = new int[i];
        i = i - 1;
        for (; i >= 0; i--) {
            b[i] = a[i];
        }
        return b;
    }

    public int[] intersectionNew(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        int n = 0;
        int pre = -1;
        int minLen = nums1.length > nums2.length ? nums2.length : nums1.length;
        int intersectionArray[] = new int[minLen];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (nums1[i] == pre) {
                    i++;
                    j++;
                    continue;
                }
                intersectionArray[n] = nums1[i];
                pre = nums1[i];
                i++;
                j++;
                n++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int newArr[]=new int[n];
        for(int k=0;k<newArr.length;k++){
            newArr[k]=intersectionArray[k];
        }
        return newArr;
    }


}
