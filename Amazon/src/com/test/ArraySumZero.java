package com.test;

import java.util.HashMap;
import java.util.Map;

public class ArraySumZero {
    public static void main(String[] args) {
//    int[] arr = {1,2,-5,1,2,-1};
        int[] arr = {2,4,6,-2,4,-1,-1,-1};
        findSubArrayWithSumZero(arr);
    }

    private static int[] findSubArrayWithSumZero(int[] inputArr){
        if(inputArr == null || inputArr.length == 0)return new int[]{};
        if(inputArr.length == 1){
            if(inputArr[0] != 0)
                return new int[]{};
            else
                return new int[]{0};
        }
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0 ; i < inputArr.length ; i++){
            count += inputArr[i];
            if(map.get(count) != null){
                int index = map.get(count);
                return new int[] {index+1, i};
            }else{
                map.put(count,i);
            }
        }
        return new int[]{};
    }
//
//    private static int[] findSubArrayWithSumZero1(int[] inputArr){
//
//        if(inputArr == null || inputArr.length == 0)return new int[]{};
//        if(inputArr.length == 1){
//            if(inputArr[0] != 0)
//                return new int[]{};
//            else
//                return new int[]{0};
//        }
//        int start = 0;
//        int count = inputArr[0];
//        for(int i=1; i< inputArr.length;i++){
//            if(inputArr[i] + count > count){
//                count = count - inputArr[start] + inputArr[i];
//                start = start + 1;
//            }else{
//                count = count + inputArr[i];
//            }
//            if(count == 0){
//                return new int[]{start, i};
//            }
//        }
//        return new int[]{};
//    }
}
