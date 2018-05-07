package com.test;

public class MergeSortArray {
    public static  void main (String[] args){
        int[] arr = {5,6,3,4,7,2,8,9,1};
        sortArrayUsingMergeSort(arr, 0, arr.length);
    }

    private static int[] sortArrayUsingMergeSort(int[] arr, int start, int end){

        if(arr == null || arr.length <1 || start > end){
            return new int[]{};
        }
        int mid = (start+end)/2;

        int[] arrLeft = fillArr(arr, start, mid);
        int[] arrRight = fillArr(arr, mid, end);
        arrLeft = sortArrayUsingMergeSort(arrLeft, start, mid);
        arrRight = sortArrayUsingMergeSort(arrRight, mid, end);

        arr = sortHelper(arr, arrLeft, arrRight);
        return arr;
    }

    private static int[] fillArr(int[] main, int start, int end){

        if(start<end) {
            int[] arr = new int[end - start];
            int k = 0;
            for (int i=start; i< end; i++){
                arr[k++] = main[i];
            }
            return arr;
        }
        return main;
    }

    private static int[] sortHelper(int[] mainArr, int[] arrLeft, int[] arrRight){

        if(arrLeft.length ==0) {
            return arrRight;
        }
        if(arrRight.length == 0){
            return arrLeft;
        }
        int k=0; int i = 0; int j = 0;
        while(i< arrLeft.length && j < arrRight.length){

            if(arrLeft[i] <= arrRight[j]){
                mainArr[k++] = arrLeft[i];
                i++;
            }
            else{
                mainArr[k++] = arrRight[j];
                j++;
            }
        }
        while(i< arrLeft.length){
            mainArr[k++] = arrLeft[i];
            i++;
        }

        while(j < arrRight.length){
            mainArr[k++] = arrRight[j];
            j++;
        }
        return mainArr;
    }
}

