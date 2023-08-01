package com.zack.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. 用最少数量的箭引爆气球
 */
public class FindMinArrowShots {

    public int findMinArrowShots(int[][] points) {
        //按起始位置排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]>o2[0]){
                    return 1;
                }else if (o1[0]==o2[0]){
                    return 0;
                }else {
                    return -1;
                }
            }
        });
        int count=1;
        int end=points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0]<=points[i-1][1]&&points[i][0]<=end){//后面的元素的起始位置小于等于 前一个元素结束位置，那么说明存在有重合部分 可以一箭引爆
                //那么count不加  但是要更新交叉位置
                end=Math.min(points[i][1],points[i-1][1]);
            }else {
                count++;
                end=points[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int points[][]={{-2147483646,-2147483645},{2147483646,2147483647}};
        new FindMinArrowShots().findMinArrowShots(points);
    }

}
