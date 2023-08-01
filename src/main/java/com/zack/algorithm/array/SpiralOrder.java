package com.zack.algorithm.array;

public class SpiralOrder {

    int ret[];

    public int[] spiralOrder(int[][] matrix) {
        ret = new int[matrix.length * matrix[0].length];
        //定义左 上 右 下 边界
        //并初始化
        int left = 0;
        int up = 0;
        int right = matrix[0].length - 1;
        int down = matrix.length - 1;

        int n = 0;
        //判断条件 左右 上下边界不重合
        while (left <= right && up <= down) {
            //左到右打印最上一行  up+1
            for (int i = left; i <= right; i++) {
                ret[n] = matrix[up][i];
                n++;
            }
            up++;

            //从上到下打印最右一行 right-1
            for (int j = up; j <= down; j++) {
                ret[n] = matrix[j][right];
                n++;
            }
            right--;

            //从右到左打印最下一行 down-1
            if(down>=up){ // 如果上边界和下边界重合甚至 超出，已无法再打印 右到左最下一行
                for (int x = right; x >= left; x--) {
                    ret[n] = matrix[down][x];
                    n++;
                }
                down--;
            }

            //从下到上打印最左一行 left+1
            if(left<=right) { //如果 左右边界已经重合 甚至超出，那也无法从下至上打印最左一行
                for (int y = down; y >= up; y--) {
                    ret[n] = matrix[y][left];
                    n++;
                }
                left++;
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        new SpiralOrder().spiralOrder(matrix);
    }


}
