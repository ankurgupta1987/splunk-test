package com.test;

public class LongestPlaindrome {

    public static void main(String[] args) {
        String a = "dccaccd";
        longestPalindrome(a);
    }
    public static int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            if(v!=0) {
                ans += v / 2 * 2;
                if (ans % 2 == 0 && v % 2 == 1)
                    ans++;
            }
        }
        return ans;
    }
}
