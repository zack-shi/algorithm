package com.zack.algorithm.dp;

public class MinCostClimbingStairs {


    public int minCostClimbingStairs(int[] cost) {
        //1.确定dp[i]的含义 ：到达下标i的最小花费体力
        //2.初始化dp数组
        //3.递推公式  dp[i]=min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
        int dp0=0;
        int dp1=0;

        //4.确定遍历顺序
        //5.举例推导dp数组  cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1] ，来模拟一下dp数组的状态变化
        int dpi=0;
        for(int i=2;i<=cost.length;i++){
            dpi=Math.min(dp1+cost[i-1],dp0+cost[i-2]);
            dp0=dp1;
            dp1=dpi;
        }
        return dpi;
    }

    public static void main(String[] args) {
        int[] cost = {10,15,20};
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(cost));

    }
}
