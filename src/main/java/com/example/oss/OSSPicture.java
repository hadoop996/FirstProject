package com.example.oss;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 郝少杰
 * @date 2021/4/4 20:53
 */
public class OSSPicture {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("C:\\Users\\10211\\Desktop\\郝少杰\\哇咔.jpg");
//        byte[] bytes = ByteUtils.toByteArray(in);
        AliyunOSSUtil.putFile(in,"哇咔.jpg");
    }
}
