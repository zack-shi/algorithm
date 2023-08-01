package com.zack.algorithm.greedy;

public class MonotoneIncreasingDigits {

    public int monotoneIncreasingDigits(int n) {
        if(n==0){
            return 0;
        }
        int length = (int) Math.log10(n) + 1;
        int intArr []=new int[length];
        for (int i=length-1;i>=0;i--){
            intArr[i]=n%10;
            n=n/10;
        }

        int index = length;
        for(int i=length-2;i>=0;i--){
            if(intArr[i]>intArr[i+1]){
                intArr[i]--;
                index=i;
            }
        }
        for(int i=index+1;i<length;i++){
            intArr[i]=9;
        }
        int num=0;
        for(int i=0;i<intArr.length;i++){
            num=num*10+intArr[i];
        }
        return num;
    }


    public static void main(String[] args) {
        System.out.println(new MonotoneIncreasingDigits().monotoneIncreasingDigits(10120));
    }

}
