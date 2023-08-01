package com.zack.algorithm.greedy;

import java.util.Arrays;

public class BuyTwoChocolates {

    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int price=prices[0]+prices[1];
        if(price>money){
            return money;
        }else{
            return price-money;
        }
    }

}
