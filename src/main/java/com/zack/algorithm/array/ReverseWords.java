package com.zack.algorithm.array;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 */
public class ReverseWords {

    public String reverseWords(String s) {
        //思路 双指针，快慢指针
        char[] chars=s.toCharArray();
        //
        int slow=0;
        for(int fast=0;fast<s.length();fast++) {
            if (chars[fast] != ' ') {
                if(slow!=0){
                    chars[slow] = ' ';
                    slow++;
                }
            }
            while (fast < s.length() && chars[fast] != ' ') {
                chars[slow] = chars[fast];
                slow++;
                fast++;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<slow;i++){
            sb.append(chars[i]);
        }
        char[] newChars=sb.toString().toCharArray();
        reverseString(newChars,0,newChars.length-1);
        reverseEachWord(newChars);
        return new String(newChars);
    }

    public void reverseString(char[] chars, int start, int end) {
        while (start < end) {
            char temp=chars[start];
            chars[start]=chars[end];
            chars[end]=temp;
            start++;
            end--;
        }
    }

    private void reverseEachWord(char[] chars) {
        int start = 0;
        int end = 1;
        int n = chars.length;
        while (start < n) {
            while (end < n && chars[end] != ' ') {
                end++;
            }
            reverseString(chars, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }



    public static void main(String[] args) {
        String str=" wo how head  fefe ereewfw   ";
        System.out.println(new ReverseWords().reverseWords(str));
    }

}
