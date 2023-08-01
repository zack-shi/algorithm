package com.zack.algorithm.string;

/**
 * https://leetcode.cn/problems/reverse-string-ii/
 * 541. 反转字符串 II
 * <p>
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */
public class ReverseStringII {

    public static void main(String[] args) {
        System.out.println(reverseStr("krmyfshbspcgtesxnnljhfursyissjnsocgdhgfxubewllxzqhpasguvlrxtkgatzfybprfmmfithphckksnvjkcvnsqgsgosfxc",20));
    }

    public static String reverseStr(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        if (n < k) {
            reverseStrBylen(chars,0,n-1);
        } else if (n >= k && n < 2 * k) {
            reverseStrBylen(chars, 0, k-1);
        } else {
            int size=2*k;
            int num=n/size;
            int i = 0;
            for (; i < num; i++) {
                int start=i*2*k;
                int end=start+k-1;
                reverseStrBylen(chars,start,end);
            }
            int start=i*2*k;
            int end=0;
            int res=n%size;
            //剩余字符少于 k 个，则将剩余字符全部反转
            if(res>0&&res<k){
                 end=start+res-1;
                //小于 2k 但大于或等于 k 个，则反转前 k
            }else if(res>=k&&res<2*k){
                 end=start+k-1;
            }else {
                return new String(chars);
            }
            reverseStrBylen(chars,start,end);
        }
        return new String(chars);
    }


    /**
     * 反转前i到j字符
     *
     * @param s
     * @return
     */
    public static void reverseStrBylen(char[] s, int i, int j) {
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}