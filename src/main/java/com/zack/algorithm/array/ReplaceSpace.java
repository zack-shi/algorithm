package com.zack.algorithm.array;

public class ReplaceSpace {

    public String replaceSpace(String s) {
        int sc=0;
        for(char c:s.toCharArray()){
            if(c==' '){
                sc=sc+2;
            }
        }
        char [] charArr=new char[s.length()+sc];
        char [] charS=s.toCharArray();
        int j=0;
        for(int i=0;i<charS.length;i++){
            if(charS[i]==' '){
                charArr[j]='%';
                charArr[j+1]='2';
                charArr[j+2]='0';
                j=j+3;
            }else{
                charArr[j]=charS[i];
                j++;
            }
        }
        return new String(charArr);
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(new ReplaceSpace().replaceSpace(s));
    }

}
