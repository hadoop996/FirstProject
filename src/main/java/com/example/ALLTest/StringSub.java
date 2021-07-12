package com.example.ALLTest;

public class StringSub {
    public static void main(String[] args) {
        String a = "13036055393\n" +
                "13111912221\n" +
                "13215791777\n" +
                "13215872280\n" +
                "15501907799\n" +
                "15607500070\n" +
                "15607667066\n" +
                "18089797321\n" +
                "18508928038\n" +
                "18608909927\n" +
                "18689998508";

        String[] newStr = a.split("\n");
        String str = "in (";
        for (String string : newStr) {
            str +=  "\"" +string + "\",";
        }
        str += ")";
        System.out.println(str);
    }
}
