package com.test;

public class CountBSTs {
    public static void main(String[] args) {
        System.out.println(countBSTWithANumber(3));
    }

    private static int countBSTWithANumber(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int count = 0;
        for(int i=1;i<=n;i++){
            int left = countBSTWithANumber(i-1);
            int right = countBSTWithANumber(n-i);
            if (left == 0) {
                count += right;
            } else if (right == 0) {
                count += left;
            } else {
                count += left * right;
            }
        }
        return count;
    }

    private static int countBSTUtil(int start, int end) {
        if (start > end) return 0;
        if (start == end) return 1;
        int count = 0;
        for (int i = start; i < end; i++) {
            int left = countBSTUtil(start, i - 1);
            int right = countBSTUtil(i + 1, end);

            if (left == 0) {
                count += right;
            } else if (right == 0) {
                count += left;
            } else {
                count += left * right;
            }
        }
        return count;
    }

}
