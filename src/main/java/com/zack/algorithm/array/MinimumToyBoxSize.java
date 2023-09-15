package com.zack.algorithm.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 一个整数数组toys，其中toys[i]表示第i个玩具颜色，准备一个箱子，从toys中选择连续的玩具放入箱子中，使得箱子中至少有两个玩具有相同的颜色，返回准备箱子的最小大小
 */
public class MinimumToyBoxSize {

    /**
     * 每次固定滑动窗口向右滑动，比如每次滑动窗口大小为2，找到结果直接返回，如果没有则窗口大小加1为3，又从头开始滑动
     *
     * @param toys
     * @return
     */
    public static int minBoxSizeFixSlideWindow(int[] toys) {
        int len = toys.length;
        int wLen = 2;
        while (wLen <= len) {
            int i = 0, j = wLen - 1;
            Set<Integer> set = null;
            while (i < j && j < len) {
                if (i == 0) {
                    set = new HashSet<>();
                    for (int k = i; k <= j; k++) {
                        if (!set.add(toys[k])) {
                            return wLen;
                        }
                    }
                } else {
                    set.remove(toys[i - 1]);
                    if (!set.add(toys[j])) {
                        return wLen;
                    }
                }
                i++;
                j++;
            }
            wLen++;
        }
        return -1;
    }


    /**
     * 变动的滑动窗口，窗口从短到长，寻找满足条件的长度，找到后左边界不断缩短，同时判断每次缩短后的窗口是否满足条件
     * 满足继续缩短，不满足则右边界往右滑动变长
     * @param toys
     * @return
     */
    public static int minBoxSizeSlideWindow(int[] toys) {
        int len = toys.length;
        int i = 0;
        int minLen=Integer.MAX_VALUE;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int j = 0; j < len; j++) {
            countMap.put(toys[j], countMap.getOrDefault(toys[j], 0) + 1);
            while (countMap.get(toys[j]) == 2) {
                countMap.put(toys[i],countMap.get(toys[i])-1);
                minLen=Math.min(minLen,j-i+1);
                i++;
            }
        }
        return minLen==Integer.MAX_VALUE?-1:minLen;
    }

    public static void main(String[] args) {
        int[] toys = {6, 2, 3, 6, 1, 3};
        int result = minBoxSizeSlideWindow(toys);

        if (result == -1) {
            System.out.println("无法准备箱子");
        } else {
            System.out.println("准备箱子的最小大小为：" + result);
        }
    }

}
