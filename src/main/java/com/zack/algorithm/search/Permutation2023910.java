package com.zack.algorithm.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/
 * 剑指 Offer 38. 字符串的排列  ——回溯
 */
public class Permutation2023910 {

    boolean used[];

    String s;

    List<String> res = new ArrayList<>();

    public String[] permutation(String s) {
        this.s = s;
        used = new boolean[s.length()];
        backtrack(s.toCharArray(), new StringBuilder(s.length()));
        return res.toArray(new String[]{});
    }

    void backtrack(char[] a, StringBuilder path) {
        if (path.length() >= s.length()) {
            res.add(path.toString());
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if (used[i]) {  //注意这里，要先判断索引位置是否被使用 垂直剪枝
                continue;
            }
            if (!set.add(a[i])) {//再判断元素值是否重复 水平剪枝，
                // 如果这个判断放前面， aab中的第一个a添加入set，但是位置被使用了，第二个a位置往未被使用，但是a重复了，也跳过了，这是不对的
                continue;
            }
            used[i] = true;//标记为已使用
            path.append(a[i]);//添加到字符串组合
            backtrack(a, path); //继续寻找下一个字符组合
            used[i] = false;//，最后的字符都已经组合完成，回撤操作
            path.deleteCharAt(path.length() - 1); //同样回撤字符组合
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        String[] res = new Permutation2023910().permutation(s);
        System.out.println(res.length);
    }

}