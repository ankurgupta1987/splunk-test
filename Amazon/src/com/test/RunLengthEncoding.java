package com.test;

public class RunLengthEncoding {
    public static void main(String[] args){
        System.out.println(runEncoding("aaaabbccccd"));
    }

    private static String runEncoding(String inputString){
        if(inputString == null || inputString.isEmpty()){
            return inputString;
        }

        int start = 0;
        int count = 1;
        StringBuilder builder = new StringBuilder();
        char[] charArr = inputString.toCharArray();
        char c = inputString.charAt(0);
        for(int i = 1; i < charArr.length ; i++){
            if(charArr[i] != charArr[i-1]){
                c = charArr[i-1];
                buildString(builder, c, count);
                c = charArr[i];
                count=1;
            }else{
                count++;
            }
        }
        buildString(builder, c, count);
        return builder.toString();
    }

    private static void buildString(StringBuilder builder, char c, int count){
        if(count == 1){
            builder.append(c);
        }else{
            builder.append(c);
            builder.append(count);
        }
    }
}
