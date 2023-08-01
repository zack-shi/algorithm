package com.zack.algorithm.greedy;

/**
 * 贪心算法
 * <p>
 * 种花问题
 */
public class PlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count=0;
        for (int i = 0; i < flowerbed.length; i++) {
            //1.该位置已种  2.相邻位置已种 3.该位置未中且相邻位置未种
            if (flowerbed[i] == 1) {
                i = i + 1;
                continue;
            }
            if (i+1 < flowerbed.length && flowerbed[i + 1] == 1) {
                i = i + 2;
                continue;
            }
            count++;
            i=i+1;
        }
        return count>=n;
    }

}
