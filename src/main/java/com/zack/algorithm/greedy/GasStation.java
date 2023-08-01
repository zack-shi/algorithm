package com.zack.algorithm.greedy;

/**
 * 134. 加油站
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int i=0;
        int sum=0;
        while (i<n){
            sum+=gas[i]-cost[i];
            i++;
        }
        if(sum<0){
            return -1;
        }
        int j=0;
        while (j<n){
            int cos=0;
            int len=n;
            if(gas[j]==0){
                j++;
                continue;
            }
            if(gas[j]-cost[j]>=0){
                int k=j;
                while (len>0){
                    cos+=gas[k%n]-cost[k%n];
                    if(cos<0){
                        break;
                    }
                    len--;
                    k++;
                }
                if(len<=0){
                    return k%n;
                }
            }
            j++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas={3,3,2,2}; int[] cost={3,4,3,0};
        System.out.println(new GasStation().canCompleteCircuit(gas,cost));
    }
}
