package com.coding.lumendata;

public class lumendataMain {

    public static void main ( String[] args ) {
        String s = "Sai123123!";
        String reversed = reverseString(s);

     char searchChar = '3';
        int index = reversed.indexOf(searchChar);
        if(index!=-1){
            System.out.println(" found at index : "+index);
        }else {
            System.out.println("not Found");
        }
    }

    private static String reverseString ( String s ) {
        char [] charArray = s.toCharArray();
        int start = 0;
        int end = charArray.length-1;
        while (start<end){
            char temp  = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
        return  new String(charArray);
    }
}
