package com.zack.algorithm.greedy;

/**
 * 135. 分发糖果
 */
public class Candy {

    public int candy(int[] ratings) {
        if(ratings.length==1){
            return 1;
        }
        int nums[]=new int[ratings.length];
        for(int i=0;i<nums.length;i++){
            nums[i]=1;
        }
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]&&nums[i]<=nums[i-1]){
                nums[i]=nums[i-1]+1;
            }
        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]&&nums[i]<=nums[i+1]){
                nums[i]=nums[i+1]+1;
            }
        }
        int count=0;
        for(int i=0;i<nums.length;i++){
            count+=nums[i];
        }
        return count;
    }

}
