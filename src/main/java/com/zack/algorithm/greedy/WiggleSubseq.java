package com.zack.algorithm.greedy;

/**
 * 376. 摆动序列
 */
public class WiggleSubseq {

    public int wiggleMaxLength(int[] nums) {
        int preDiff=0;
        int result=1;
        for(int i=0;i<nums.length;i++){
            int currDiff=nums[i+1]-nums[i];
            if((preDiff<=0&&currDiff>0)||preDiff>=0&&currDiff<0){
                result++;
                preDiff=currDiff;
            }
        }
        return result;
    }

}
