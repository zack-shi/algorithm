package com.zack.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/ransom-note/ . 赎金信
 *
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> mapA=new HashMap<>();
        for(char c:ransomNote.toCharArray()){
            mapA.put(c,mapA.getOrDefault(c,0)+1);
        }
        Map<Character,Integer> mapB=new HashMap<>();
        for(char c:magazine.toCharArray()){
            mapB.put(c,mapB.getOrDefault(c,0)+1);
        }
        for(char cc:mapA.keySet()){
            if(mapA.get(cc)>mapB.getOrDefault(cc,0)){
                return false;
            }
        }
        return true;
    }

    public boolean construct(String ransomNote, String magazine) {
        int [] charArray=new int[26];
        for(char c:ransomNote.toCharArray()){
            int ascii =(int) c;
            int numericValue = ascii - 97; // 'a'的ASCII码值为97，
            charArray[numericValue]++;
       }
        for(char c:magazine.toCharArray()){
            int ascii =(int) c;
            int numericValue = ascii - 97;
            charArray[numericValue]--;
        }
        for(int num:charArray){
            if(num>0){
                return false;
            }
        }
        return true;
    }

}
