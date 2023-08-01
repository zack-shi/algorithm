package com.zack.algorithm.greedy;

/**
 * 122. 买卖股票的最佳时机 II
 */
public class MaxProfitBuyStockII {

    public int maxProfit(int[] prices) {
        int result=0;
        for(int i=1;i<prices.length;i++){
            result+=Math.max(prices[i]-prices[i-1],0);
        }
        return result;
    }





    public static void main(String[] args) {
        int[]prices={7,1,5,3,6,4};
        System.out.println(new MaxProfitBuyStockII().maxProfit(prices));
    }

}
