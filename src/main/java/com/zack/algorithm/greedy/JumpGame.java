package com.zack.algorithm.greedy;

/**
 * 55. 跳跃游戏
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
        int i=0;
        while(i+nums[i]<nums.length-1){
            int currJumpMaxIndex=i+nums[i];
            int maxIndex=currJumpMaxIndex;
            int betterIndex=i;
            boolean hasBetterIndex=false;
            for(int j=currJumpMaxIndex;j>i;j--){
                int midJumpMaxIndex=j+nums[j];
                if(midJumpMaxIndex>=nums.length-1){
                    return true;
                }
                if(midJumpMaxIndex>currJumpMaxIndex){
                    hasBetterIndex=true;
                    if(midJumpMaxIndex>maxIndex){
                        maxIndex=midJumpMaxIndex;
                        betterIndex=j;
                    }
                }
            }
            if(!hasBetterIndex){
                return false;
            }
            i=betterIndex;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums={5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println(new JumpGame().canJump(nums));
    }


    public boolean canJumpNew(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int cover=0;
        for(int i=0;i<=cover;i++){
            cover=Math.max(i+nums[i],cover);
            if(cover>=nums.length-1){
                return true;
            }
        }
        return false;
    }


}
