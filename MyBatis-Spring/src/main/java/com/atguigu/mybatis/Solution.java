package com.atguigu.mybatis;

import sun.misc.Regexp;

public class Solution {
    public static void main(String[] args) {
        String a = "aa";
          String b = "a*";
        System.out.println(isMatch(a,b));
    }
    public static boolean isMatch (String s, String p) {
        // write code here
        int m = s.length();
        int n = p.length();
        int i = 0;
        int j = 0;
        boolean flag = true;
        int count = 0;
        while (i < m && j <n){
            if (j+1<n && p.charAt(j+1)=='*'){
                if (s.charAt(i)==p.charAt(j)){
                    char ch = s.charAt(i);
                    while (i+1<s.length() && s.charAt(i+1)==ch){
                        i++;
                    }
                    i++;
                    j=j+2;
                    continue;
                }else {
                    j=j+2;
                    continue;
                }
            }
            if (s.charAt(i)==p.charAt(j)){
                System.out.println();
                i++;
                j++;
                continue;
            }
            if (p.charAt(j)=='.'){
                i++;
                j++;
                continue;
            }
            if (s.charAt(i)!=p.charAt(j)){
                flag=false;
                break;
            }
        }
        if (i!=m-1 || j!=n-1){
            flag = false;
        }
        return flag;
    }
    public boolean isMonotonic (int[] nums) {
        // write code here
        if (nums.length<2){
            return false;
        }
        boolean flag = true;
        if (nums[0] > nums[1]){
            for (int i = 0;i < nums.length;i++){
                if ((i+1)<nums.length&&nums[i]<=nums[i+1]){
                    flag = false;
                }
            }
        }else if (nums[0] < nums[1]){
            for (int i = 0;i < nums.length;i++){
                if ((i+1)<nums.length&&nums[i]>=nums[i+1]){
                    flag = false;
                }
            }
        }else {
            flag = false;
        }
        return flag;

    }
}
