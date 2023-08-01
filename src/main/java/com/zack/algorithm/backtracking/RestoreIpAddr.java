package com.zack.algorithm.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class RestoreIpAddr {

    List<String> result=new ArrayList<>();

    LinkedList list=new LinkedList();

    public List<String> restoreIpAddresses(String s) {
        if(s.length()<4){
            return null;
        }
        backtracking(s,0);
        return result;
    }


    public void backtracking(String s,int startIndex){
        if(list.size()==4&&startIndex>=s.length()){
            result.add(String.join(".",list));
            return;
        }
        if(list.size()==4&&startIndex<s.length()){
            return;
        }
        for(int i=startIndex;i<s.length();i++){
            String str=s.substring(startIndex,i+1);
            if(str.length()>1&&str.startsWith("0")){
                break;
            }
            int strInt=Integer.valueOf(str);
            if(strInt>255){
                break;
            }
            list.add(str);
            backtracking(s,i+1);
            list.removeLast();
        }
    }

}
