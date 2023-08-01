package com.zack.algorithm.greedy;

import java.util.Arrays;

public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int [] changeRes = new int[2];
        for (int bill : bills) {
            if(bill!=20){
                changeRes[bill/5-1]++;
            }
            int needChange = bill - 5;
            if (needChange == 15) {
                if (changeRes[1] > 0) {
                    changeRes[1]--;
                    if (changeRes[0] > 0) {
                        changeRes[0]--;
                    } else {
                        return false;
                    }
                } else {
                    if (changeRes[0] >= 3) {
                        changeRes[0] = changeRes[0] - 3;
                    } else {
                        return false;
                    }
                }
            }
            if (needChange == 5) {
                if (changeRes[0] >= 0) {
                    changeRes[0]--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
