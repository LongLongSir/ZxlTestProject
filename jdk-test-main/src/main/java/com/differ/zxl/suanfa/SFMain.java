package com.differ.zxl.suanfa;

/**
 * @auth zhangxl
 * @date 2022/3/4
 */
public class SFMain {

    public static void main(String[] args) {
        int m=3,n=7;
//        p(m,n)=p(m-1,n)+p(m,n-1);
//
//        p(1,1)=0;
//        p(m,1)=1;
//        p(1,n)=1;
//
//        p(3,2)=p(2,2)+p(3,1)=3

        System.out.println(p2(10,10));




    }

    /**
     *
     * @param m  行
     * @param n   列
     */
    public static int p(int m,int n){
        if(m==1) return 1;
        if(n==1) return 1;
        return p(m-1,n)+p(m,n-1);
    }

    public static int p2(int m,int n){
        if(m==1) return 1;
        if(n==1) return 1;
        int[][] statusSum=new int[m][n];
        for (int i=0;i<n;i++){
            statusSum[0][i]=1;
        }
        for(int j=0;j<m;j++){
            statusSum[j][0]=1;
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                statusSum[i][j]=statusSum[i-1][j]+statusSum[i][j-1];
            }
        }
        return statusSum[m-1][n-1];
    }


}
