package com.zack.algorithm.string;

/**
 * https://leetcode.cn/problems/ti-huan-kong-ge-lcof/ 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        char [] chars=s.toCharArray();
        char [] new_chars=new char[chars.length*3];
        int j=0;
        for(int i=0;i<chars.length;i++){
            if(chars[i]==32){
                new_chars[j]='%';
                new_chars[j+1]='2';
                new_chars[j+2]='0';
                j=j+3;
            }else {
                new_chars[j]=chars[i];
                j=j+1;
            }
        }
        char [] resultChar=new char[j];
        for(int i=0;i<j;i++){
            resultChar[i]=new_chars[i];
        }
        return new String(resultChar);
    }

    public static String replaceSpaceNew(String s) {
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            if(c==32){
                sb.append(" ");
                sb.append(" ");
            }
        }
        String newStr=s+sb;
        char [] newChars=newStr.toCharArray();
        int i=s.length()-1;
        int j=newStr.length()-1;
        while (i>=0&&j>=0){
            if(newChars[i]==' '){
                newChars[j]='0';
                newChars[j-1]='2';
                newChars[j-2]='%';
                j=j-3;
                i--;
            }else {
                newChars[j]=newChars[i];
                i--;
                j--;
            }
        }
        return new String(newChars);
    }

    public static String replaceSpaceBetter(String s) {
        int i=s.length()-1;
        for(char c:s.toCharArray()){
            if(c==32){
                s+="  ";
            }
        }
        int j=s.length()-1;
        char [] chars=s.toCharArray();
        while (i>=0&&j>=0){
            if(chars[i]==' '){
                chars[j]='0';
                chars[j-1]='2';
                chars[j-2]='%';
                j=j-3;
                i--;
            }else {
                chars[j]=chars[i];
                i--;
                j--;
            }
        }
        return new String(chars);
    }



}
