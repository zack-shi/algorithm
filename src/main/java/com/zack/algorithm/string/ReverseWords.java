package com.zack.algorithm.string;

/**
 * https://leetcode.cn/problems/reverse-words-in-a-string/ 反转字符串中的单词
 */
public class ReverseWords {

    public static void main(String[] args) {
        String s = "  Bob    Loves  Alice   ";
        System.out.println(reverseWordsBetterI(s));

    }

    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        char[] new_chars = new char[n];
        int i = n - 1, j = n - 1, k = 0;
        while (i >= 0 && j >= 0) {
            while (i >= 0 && j >= 0 && chars[i] == ' ' && chars[j] == ' ') {
                i--;
                j--;
            }
            while (i >= 0 && j >= 0 && chars[i] != ' ' && chars[j] != ' ') {
                j--;
            }
            if (i >= 0 && j >= 0 && chars[i] != ' ' && chars[j] == ' ') {
                k = copy(chars, new_chars, j + 1, i, k);
                new_chars[k] = ' ';
                i = j;
                k++;
            }
        }
        if (j < 0 && i < 0) {
            k = k - 1;
        }
        if (j < 0 && i >= 0) {
            k = copy(chars, new_chars, j + 1, i, k);
        }
        return new String(new_chars, 0, k);
    }

    public static int copy(char[] A, char[] B, int begin, int end, int k) {
        for (; begin <= end; begin++) {
            B[k] = A[begin];
            k++;
        }
        return k;
    }


    public static String removeExtraSpaces(String s) {
        int fast = 0;
        //去掉字符串前面的空格
        while (fast < s.length() && s.charAt(fast) == ' ') {
            fast++;
        }
        //去掉字符串中间多余的空格
        StringBuilder sb = new StringBuilder();
        for (; fast < s.length(); fast++) {
            if (fast - 1 > 0 && s.charAt(fast - 1) == s.charAt(fast) && s.charAt(fast) == ' ') {
                continue;
            } else {
                sb.append(s.charAt(fast));
            }
        }
        //去掉字符串后面的空格
        if (sb.charAt(sb.length() - 1) == ' ') {
            return sb.deleteCharAt(sb.length() - 1).toString();
        } else {
            return sb.toString();
        }
    }

    public static String reverse(char[] chars, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }

    public static String reverseWordsBetterI(String s) {
        s=removeExtraSpaces(s);
        s = reverse(s.toCharArray(), 0, s.length() - 1);
        char [] chars=s.toCharArray();
        int start=0;
        for(int i=0;i<=s.length();i++){
            if(i==s.length()||s.charAt(i)==' '){
                reverse(chars,start,i-1);
                start=i+1;
            }
        }
        return new String(chars);
    }

}
