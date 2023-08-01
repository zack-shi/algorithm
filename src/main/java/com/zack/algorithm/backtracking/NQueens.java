package com.zack.algorithm.backtracking;

import com.alibaba.fastjson2.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N 皇后
 */
public class NQueens {

    static int size;

    static int [] q;

    static List<List<String>> res=new ArrayList<>();

    static  public List<List<String>> solveNQueens(int n) {
        size = n;
        q=new int[size];
        backtracking(0);
        System.out.println(JSON.toJSONString(res));
        return res;
    }

    static public boolean backtracking(int row) {
        if(row==size){
            List<String> list=new ArrayList<>();
            for(int i=0;i<q.length;i++){
                StringBuilder sb=new StringBuilder();
                for(int x=1;x<=size;x++){
                    if(q[i]==x){
                        sb.append("Q");
                    }else {
                        sb.append(".");
                    }
                }
                System.out.println(sb);
                list.add(sb.toString());
            }
            System.out.println("--------");
            res.add(list);
            return true;
        }
        for (int j = 1; j <=size; j++) {
            if (isOk(row, j)) {
                q[row]=j;
                if(backtracking(row + 1)){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isOk(int row,int col){
        int ltop=col-1;
        int rtop=col+1;
        for(int i=row-1;i>=0;i--){
            if(q[i]==col||q[i]==ltop||q[i]==rtop){  //正上方、 左上对角 或 右上对角 有棋子
                return  false;
            }
            ltop--;
            rtop++;
        }
        return true;
    }


    public static void main(String[] args) {
        solveNQueens(4);
    }

}
