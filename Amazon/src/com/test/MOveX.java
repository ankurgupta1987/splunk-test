package com.test;

public class MOveX {
    public static void main(String[] args) {
        String a = "xhixhix";
        System.out.println(endX(a));
    }
    public static String endX(String str) {
        if(str == null || str.isEmpty()) return str;
        if(str.charAt(0) == 'x'){
            char[] charArr = str.toCharArray();
            for(int i=1;i<charArr.length ; i++){
                if(charArr[i] != 'x'){
                    char temp = charArr[i];
                    charArr[i] = charArr[0];
                    charArr[0] = temp;
                    break;
                }
            }
            str = String.valueOf(charArr);
        }
        return str.charAt(0) + endX(str.substring(1));
    }
}
