package com.zack.algorithm.string;

public class ReverseLeftWords {


    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg",3));
    }

    public static String reverseLeftWords(String s, int n) {
        char chars []=s.toCharArray();
        char new_chars[]=new char[s.length()];
        int j=0;
        for(int i=n;i<s.length();i++){
            new_chars[j]=chars[i];
            j++;
        }
        for(int i=0;i<n;i++){
            new_chars[j]=chars[i];
            j++;
        }
        return new String(new_chars);

    }


}
