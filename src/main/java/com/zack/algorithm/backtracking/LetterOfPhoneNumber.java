package com.zack.algorithm.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 */
public class LetterOfPhoneNumber {

     List<String> result = new ArrayList<>();
     Map<Character, String>  phoneMap;
     StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<String>();
        }
        phoneMap = getPhoneMap(digits);
        backTracking(digits,0);
        return result;
    }

    public void backTracking(String digits,int startIndex) {
        if (sb.length() == digits.length() || startIndex >  digits.length()) {
            result.add(new String(sb));
            return;
        }
        String str = phoneMap.get(digits.charAt(startIndex));
        for (char c : str.toCharArray()) {
            sb.append(c);
            backTracking(digits,startIndex + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public Map<Character, String> getPhoneMap(String digits) {
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        return phoneMap;
    }

}
