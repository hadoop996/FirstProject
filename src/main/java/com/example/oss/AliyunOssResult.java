package com.example.oss;

import lombok.Data;

/**
 * @author: xiehh
 * @Date:2020/11/20 16:40
 * @ClassName:AliyunOssResult
 */
@Data
public class AliyunOssResult {
    /**
     * code：200长传成功
     * code: 400上传失败
     */
    private int code;

    /**
     * 上传成功的返回url
     */
    private String url;

    /**
     * 错误提示
     */
    private String errMsg;

    /**
     * 文件名字
     */
    private String fileName;


    public AliyunOssResult() {

    }

    public AliyunOssResult(int code, String url, String errMsg,String fileName) {
        this.code = code;
        this.url = url;
        this.errMsg = errMsg;
        this.fileName =fileName;
    }


    public AliyunOssResult(int code, String url, String errMsg) {
        this.code = code;
        this.url = url;
        this.errMsg = errMsg;
    }


}
