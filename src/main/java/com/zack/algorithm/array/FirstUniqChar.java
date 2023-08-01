package com.zack.algorithm.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 *
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class FirstUniqChar {

    public char firstUniqChar(String s) {
        char[] chars=s.toCharArray();
        for(int i=0;i<chars.length;i++){
            int j;
            for(j=0;j<chars.length;j++){
                if(i==j)continue;;
                if(chars[i]==chars[j]){
                    break;
                }
            }
            if(j==chars.length){
                return chars[i];
            }
        }
        return ' ';
    }


    LinkedHashMap<Character,Boolean> map=new LinkedHashMap<>();

    public char firstUniqCharHash(String s) {
        for(char c:s.toCharArray()){
            map.put(c,map.containsKey(c));
        }
        for(Map.Entry<Character,Boolean> entry:map.entrySet()){
            if(!entry.getValue()){
                return entry.getKey();
            }
        }
        return ' ';
    }




    public static void main(String[] args) {
        System.out.println(new FirstUniqChar().firstUniqChar("leecode"));
    }

}
