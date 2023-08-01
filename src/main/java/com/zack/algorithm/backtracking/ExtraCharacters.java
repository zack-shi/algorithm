package com.zack.algorithm.backtracking;


import java.util.*;

/**
 * 2707. 字符串中的额外字符
 */
public class ExtraCharacters {

    Set<String> words=new HashSet<>();

    public int minExtraChar(String s, String[] dictionary) {
        for (String str : dictionary) {
            words.add(str);
        }
        int i = 0;
        int j = 1;
        int containWordLen=0;
        while (i < s.length()) {
            if (words.contains(s.substring(i, j))) {
                containWordLen+=j-i;
                i=j;
                j++;
            }else {
                j++;
            }
            if(j>s.length()){
                i++;
                j=i+1;
            }
        }
        return s.length()-containWordLen;
    }


}
