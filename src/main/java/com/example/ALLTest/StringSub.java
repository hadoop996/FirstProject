package com.example.ALLTest;

public class StringSub {
    public static void main(String[] args) {
        String a = "86b3m36\n" +
                "86b07fq\n" +
                "86b042g\n" +
                "86b2hbn\n" +
                "86b21xn\n" +
                "86b16ns\n" +
                "86b10nn\n" +
                "86b2c2q";


        String[] newStr = a.split("\n");
        String str = "";
        for (String string : newStr) {
            str += ",'"+string + "'";
        }
        System.out.println("in ("+str+")");
    }
}
