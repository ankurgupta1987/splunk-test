package com.test;
import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
       int[] arr = {-1,0,1,2,-1,-4};
        threeSum(arr);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length <3 ){
            return null;
        }

        Arrays.sort(nums);
        List<List<Integer>> listOfListTriplets = new ArrayList<>(nums.length);

        for(int i=0; i<nums.length-2;i++){
            int start = i+1;
            int end = nums.length - 1;

            while(start<end){
                if(nums[i] + nums[start] + nums[end] == 0){
                    List<Integer> listOfTriplets = new ArrayList<Integer>(3);
                    listOfTriplets.add(nums[i]);listOfTriplets.add(nums[start]);listOfTriplets.add(nums[end]);
                    listOfListTriplets.add(listOfTriplets);
                    start++;end--;
                }
                else if(nums[i] + nums[start] + nums[end] < 0){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return listOfListTriplets;
    }
}
