package com.zack.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. 分割回文串
 */
public class PalindromePartitioning {

    List<List<String>> result = new ArrayList<>();

    LinkedList<String> list = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtracking(s,0);
        return result;
    }


    public void backtracking(String str, int splitBegin) {
        if (splitBegin >= str.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = splitBegin; i <str.length(); i++) {
            if (isPalindrome(str, splitBegin, i)) {
                String s = str.substring(splitBegin, i + 1);
                list.add(s);
            } else {
                continue;
            }
            backtracking(str, i + 1);
            list.removeLast();
        }
    }

    public boolean isPalindrome(String s, int begin, int end) {
        for (int i = begin, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("One",
                "Two",
                "Three",
                "Four",
                "Five");

        String stringFromList = String.join("", list);
        System.out.println(stringFromList);
    }

}
