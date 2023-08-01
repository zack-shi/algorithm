package com.zack.algorithm.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/valid-anagram/ 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 */
public class ValidAnagram {

    Map<Character,Integer> sMap=new HashMap<>();
    Map<Character,Integer> tMap=new HashMap<>();

    public boolean isAnagram(String s, String t) {
        if(s.length()==0||t.length()==0){
            return false;
        }
        for(char c:s.toCharArray()){
            if(sMap.containsKey(c)){
                int count= sMap.get(c);
                sMap.put(c,count+1);
            }else {
                sMap.put(c,1);
            }
        }
        for(char c:t.toCharArray()){
            if(tMap.containsKey(c)){
                int count= tMap.get(c);
                tMap.put(c,count+1);
            }else {
                tMap.put(c,1);
            }
        }
        if(sMap.size()!=tMap.size()){
            return false;
        }
        for(Character character:sMap.keySet()){
            if(!tMap.containsKey(character)){
                return false;
            }
        }
        for(Character character:tMap.keySet()){
            if(!sMap.containsKey(character)){
                return false;
            }
        }
        for(Map.Entry<Character,Integer> entry:tMap.entrySet()){
            if(sMap.get(entry.getKey()).intValue()!=entry.getValue().intValue()){
                return false;
            }
        }
        return true;
    }



    public boolean isAnagramNew(String s, String t) {
        if(s.length()==0||t.length()==0){
            return false;
        }
        Arrays.sort(s.toCharArray());
        Arrays.sort(t.toCharArray());
        return Arrays.equals(s.toCharArray(),t.toCharArray());
    }


}
