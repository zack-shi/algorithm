package com.zack.algorithm.string;


/**
 *
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果needle 不是 haystack 的一部分，则返回 -1 。
 */
public class StrStr {


    public static void main(String[] args) {
        System.out.println(strStr("mississippi","issi"));
    }

    public static int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length()){
            return -1;
        }
        char [] a=haystack.toCharArray();
        char [] b=needle.toCharArray();
        for(int i=0;i<a.length;i++){
            int index=i;
            int j=0;
            for(;j<b.length;j++){
                if(i>=a.length){
                    return -1;
                }
                if(a[i]==b[j]){
                    i++;
                }else {
                    i=index;
                    break;
                }
            }
            if(j==b.length){
                return index;
            }
        }
        return -1;
    }

    public static int strStrKMP(String haystack, String needle) {
        return 0;
    }
}
