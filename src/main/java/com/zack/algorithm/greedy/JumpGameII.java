package com.zack.algorithm.greedy;

public class JumpGameII {

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int i = 0;
        int step = 1;
        while (i + nums[i] < nums.length - 1) {
            int currJumpMaxIndex = i + nums[i];
            int maxIndex = currJumpMaxIndex;
            int betterIndex = i;
            for (int j = currJumpMaxIndex; j > i; j--) {
                int midJumpMaxIndex = j + nums[j];
                if (midJumpMaxIndex >= nums.length - 1) {
                    step++;
                    return step;
                }
                if (midJumpMaxIndex > currJumpMaxIndex) {
                    if (midJumpMaxIndex > maxIndex) {
                        maxIndex = midJumpMaxIndex;
                        betterIndex = j;
                    }
                }
            }
            i = betterIndex;
            step++;
        }
        return step;
    }


    public static void main(String[] args) {
        int nums[] = {2, 3, 1, 1, 4};
        new JumpGameII().jump(nums);
    }
}
