package com.example.ALLTest;

public class StringSub {
    public static void main(String[] args) {
        String a = "30b4820\n" +
                "38b4apy\n" +
                "38b4apx\n" +
                "38b3xah\n" +
                "90b2b3p\n" +
                "75b2qhg\n" +
                "75b1inu\n" +
                "75b1imp\n" +
                "75a4661\n" +
                "75b2m3h\n" +
                "75b3o0w\n" +
                "75b3o0v\n" +
                "75b1jic\n" +
                "75b3wdh\n" +
                "75b1jiu\n" +
                "75b1imm\n" +
                "75b3o0v\n" +
                "75b3o0v\n" +
                "75b14r7\n" +
                "75a4657\n" +
                "75b3o0v\n" +
                "75b1jia\n" +
                "75b22fr\n" +
                "75b1ipf\n" +
                "75b1x3d\n" +
                "10b3gm0\n" +
                "10b3glx\n" +
                "10b3gm1\n" +
                "84b361k\n" +
                "31b28k4\n" +
                "31b28k4\n" +
                "31b28k4\n" +
                "31b28k4\n" +
                "31b28k4\n" +
                "31b28k4\n" +
                "31b28k4\n" +
                "86b21qt\n" +
                "86b3rkn\n" +
                "86b3rkn\n" +
                "86b2w1s\n" +
                "86b2w6r\n" +
                "86b3rkn\n" +
                "86b25wg\n" +
                "97b11hn\n" +
                "30b3joi\n" +
                "30b40vs\n" +
                "30b40ev\n" +
                "86b2w1k\n" +
                "86b2w1s\n" +
                "86b32px\n" +
                "86b2q70\n" +
                "86b3rke\n" +
                "86b1ylo\n" +
                "86b1ql5\n" +
                "86b1jbf\n" +
                "86b2i05\n" +
                "31b28k4\n" +
                "86b2w1o\n" +
                "86b2w15\n" +
                "86b2w1o\n" +
                "86b0dhp\n" +
                "86b3m36\n" +
                "86b2cf5\n" +
                "86b07fq\n" +
                "86b2w1p\n" +
                "86b37r2\n" +
                "86b042g\n" +
                "86b2w18\n" +
                "86b2hbn\n" +
                "86b21xn\n" +
                "86b37r2\n" +
                "86b16ns\n" +
                "86b2dqy\n" +
                "86b10nn\n" +
                "86b2c2q\n" +
                "30b4fcx\n" +
                "86b2w1j\n" +
                "86b1kwh\n" +
                "75b2qhg\n" +
                "91b1fms\n" +
                "36b3f78\n" +
                "74b4zjd\n" +
                "74b4zk1\n" +
                "74b4zjw\n" +
                "74b0e6z\n" +
                "74b107l\n" +
                "74af244\n" +
                "74af077\n" +
                "74b4zk8\n" +
                "74b0c10\n" +
                "74b2djs\n" +
                "74b4z13\n" +
                "74b4ut5\n" +
                "74a3341\n" +
                "74b05al\n" +
                "85b3xu9\n" +
                "30b262l\n" +
                "30b23u5\n" +
                "86b1wm2\n" +
                "75b1eda\n" +
                "74b05lf\n" +
                "74b3yv7\n" +
                "74b4ysv";


        String[] newStr = a.split("\n");
        String str = "";
        for (String string : newStr) {
            str += ",'"+string + "'";
        }
        System.out.println("in ("+str+")");
    }
}
