package com.zack.algorithm.dp;

/**
 * https://www.nowcoder.com/discuss/532518945002205184
 * 变态跳台阶：一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
public class ClimbStairsHarder {

    /**
     * 思路：
     跳到第n个台阶的跳法=跳到第n-1个台阶的跳法+跳到第n-2个台阶的跳法+...跳到第2个台阶的跳法+跳到第1个台阶的跳法+1
     *
     *公式为 dp[n]=dp[n-1]+dp[n-2]+...dp[2]+dp[1]+1;
     *同样dp[n-1]=dp[n-2]+dp[n-3]+...+ dp[2]+dp[1]+1;
     *两公式相减得：dp[n]=dp[n-1]*2
     * @param number int整型
     * @return int整型
     */
    public int jumpFloorII (int number) {
        if(number<=1){
            return 1;
        }
        int [] dp=new int[number];
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<number;i++){
            dp[i]=dp[i-1]*2;
        }
        return dp[number-1];
    }
}
