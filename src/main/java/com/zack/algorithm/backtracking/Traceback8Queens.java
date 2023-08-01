package com.zack.algorithm.backtracking;

/**
 * 回溯算法——八皇后问题
 */
public class Traceback8Queens {

    public static void main(String[] args) {
        int queen [] =new int[8];
        queen= call8Queens(queen,0);

    }


    public static int [] call8Queens(int q[],int row){
        if(row==8){
            for(int i=0;i<q.length;i++){
                System.out.println("第"+i+"行,"+"第"+q[i]+"列");
            }
            return q;
        }
        for(int col=0;col<q.length;col++){
            if(isOK(q,row,col)){
                q[row]=col;
                call8Queens(q,row+1);
            }
        }
        return q;
    }


    public static boolean isOK(int q[], int row, int col){
        int leftup=col-1; //左上
        int rightup=col+1;//右上
        for(int r=row-1;r>=0;r--){  //往上查找每行
            if(q[r]==col) return false;  //正上有棋子
            if(leftup>=0){
                if(q[r]==leftup)return false;//左上有棋子
            }
            if(rightup<8){
                if(q[r]==rightup)return false; //右上有棋子
            }
            leftup--;  //继续往左上 右上延伸看 有没有棋子
            rightup++;
        }
        return true;

    }

}
