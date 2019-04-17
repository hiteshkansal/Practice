package com.test;

import java.util.Scanner;

public class Demo {
    
    static long unset_bit(long n){
        long res=0;
        for(long x=1;x<=n;x=x<<1){
            if((x & n)==0)
                res++;
        }
        return res;
    }
    
    static long set_bit(long n){
        long res=0;
        while(n>0){
            res++;
            n &= n-1;
        }
        return res;
    }
    
    static void fun1(int A[], int l, int r){
        long ans=1;
        for(int i=0;i<31;i+=1){
            int count=0;
            for(int j=l;j<=r;j+=1){
                if(unset_bit(A[j-1])==i)
                    count++;
            }
            if(count>0){
                ans = (ans*count)%1000000007;
            }
        }
        System.out.println(ans);
    }
    
    static void fun2(int A[], int l, int r){
    	long ans=1;
        for(int i=0;i<31;i+=1){
            int count=0;
            for(int j=l;j<=r;j+=1){
                if(set_bit(A[j-1])==i)
                    count++;
            }
            if(count>0){
                ans = (ans*count)%1000000007;
            }
        }
        System.out.println(ans);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        String nq[] = inp.split(" ");
        int n = Integer.parseInt(nq[0]);
        int A[] = new int[n];
        String arr[] = sc.nextLine().split(" ");
        
        for(int j=0;j<n;j++){
            A[j]=Integer.parseInt(arr[j]);
        }
        for(int i=0;i<Integer.parseInt(nq[1]);i++){
            String qry[] = sc.nextLine().split(" ");
            if(Integer.parseInt(qry[0])==1){
                A[Integer.parseInt(qry[1])-1]=Integer.parseInt(qry[2]);
                continue;
            }
            else if(Integer.parseInt(qry[0])==2){
                fun1(A,Integer.parseInt(qry[1]), Integer.parseInt(qry[2]));
            }
            else if(Integer.parseInt(qry[0])==3){
                fun2(A,Integer.parseInt(qry[1]), Integer.parseInt(qry[2]));
            }
        }
        
    }
}