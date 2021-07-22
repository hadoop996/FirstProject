package com.example.ALLTest;

public class SubStringInTest {
    public static void main(String[] args) {
        String a = "1100816207\n" +
                "1100816715\n" +
                "1100896381\n" +
                "1100903574\n" +
                "1100917480\n" +
                "1100927684\n" +
                "1100957624\n" +
                "1101050291\n" +
                "1101066747\n" +
                "1101138419\n" +
                "1103295536\n" +
                "1105187845\n" +
                "1105187855\n" +
                "1105187857\n" +
                "1105187866\n" +
                "1105187891\n" +
                "1105187893\n" +
                "1105187897\n" +
                "1107615101\n" +
                "1107615111\n" +
                "1107615516\n" +
                "1107997501";

        String[] aStr = a.split("\n");
        String f = "in (";
        for (int i=0;i<aStr.length;i++) {
            f+="'"+aStr[i]+"',";
        }
        f += ")";
        System.out.println(f);

    }
}
