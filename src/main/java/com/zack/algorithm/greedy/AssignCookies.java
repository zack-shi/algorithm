package com.zack.algorithm.greedy;

import java.util.Arrays;

/**
 * 455. 分发饼干
 */
public class AssignCookies {

    public static void main(String[] args) {
        int [] g={3,2,3};
        int s[]={1,2};
        System.out.println(new AssignCookies().findContentChildren(g,s));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        int i=0,j=0;
        while (i<g.length&&j<s.length){
            if(s[j]>=g[i]){
                count++;
                i++;
                j++;
            }else {
                j++;
            }
        }
        return count;
    }
}
