package com.zack.algorithm.hash;


import java.util.HashSet;

/**
 * https://leetcode.cn/problems/happy-number/ 快乐数
 * 
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> set=new HashSet<>();
        while(n!=1){
            n=sumSqua(n);
            if(!set.add(n)){
                return false;
            }
        }
        return true;
    }

    public int sumSqua(int cur){
        int sum=0;
        while(cur>0){
            int temp=cur%10;
            sum=sum+temp*temp;
            cur=cur/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(1%10);
    }


}
