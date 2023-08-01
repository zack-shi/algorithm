package com.zack.algorithm.string;


/**
 * https://leetcode.cn/problems/reverse-string/
 *
 * 反转字符串
 */
public class ReverseString {

    public static void reverseString(char[] s) {
        int i=0;
        int j=s.length-1;
        while (i<j){
            char temp=s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
        System.out.println(new String(s));
    }

    public static void main(String[] args) {
        char [] s={'h','e','l','l','o'};
        reverseString(s);
    }

}
