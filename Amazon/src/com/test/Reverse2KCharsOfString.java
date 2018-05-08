package com.test;

public class Reverse2KCharsOfString {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg",2));
    }

    public static String reverseStr(String s, int k) {
        if(s==null || s.isEmpty() || k==0){
            return s;
        }

        int start = 0; int end = 0;
        int current = 0;
        int count = 0;
        char[] charArr = s.toCharArray();
        while(current < charArr.length){
            if(current !=0 && current % k == 0){
                end = current-k;
            }
            if(current - start == 2*k){
                reverse(charArr, start, end);
                start=current;end=current;
            }else if(current == charArr.length-1 && current - end < k && end - start == k){
                reverse(charArr, start, end);
                break;
            }else if(current == charArr.length-1 && current - start < k){
                reverse(charArr, start, current);
                break;
            }
            current++;
        }
        return String.valueOf(charArr);
    }

    public static void reverse(char[] arr, int start, int end){
        if(arr.length == 0)return;
        while(start< end){
            char c = arr[start];
            arr[start] =  arr[end];
            arr[end] = c;
            end --;start++;
        }
    }
}
