package com.zack.algorithm.array;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 */
public class ReverseLeftWords {


    public String reverseLeftWords(String s, int n) {
        if (n >= s.length())
            return s;
        //双指针
        char[] chars = s.toCharArray();
        reverse(chars,0,n-1);
        reverse(chars,n,chars.length-1);
        reverse(chars,0,chars.length-1);
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j)
            swap(chars, i++, j--);
    }

    private void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }

    public static void main(String[] args) {
        String words="abcdefg";
        System.out.println(new ReverseLeftWords().reverseLeftWords(words,3));;
    }
}
