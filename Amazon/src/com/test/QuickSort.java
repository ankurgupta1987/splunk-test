package com.test;

public class QuickSort {
    public static void main(String[] args){
        int[] arr = {5,6,3,4,7,2,8,9,1};
        quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(int[] arr, int start, int end){
        if(arr == null || arr.length <1 || start > end){
            return;
        }

        int pIndex = partition(arr, start, end);
        quickSort(arr, start, pIndex-1);
        quickSort(arr, pIndex+1, end);

    }

    private static int partition(int[] arr, int start, int end){

        int pivot = arr[end];
        int pIndex = start;

        for(int i=start; i < end; i++){
            if(arr[i] <= pivot){
                int temp = arr[pIndex];
                arr[pIndex] = arr[i];
                arr[i] = temp;
                pIndex++;
            }
        }
        int temp = arr[end];
        arr[end] = arr[pIndex];
        arr[pIndex] = temp;

        return pIndex;
    }
}
