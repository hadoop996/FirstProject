package com.example.oss;


import com.aliyun.oss.ClientBuilderConfiguration;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: xiehh
 * @Date:2020/11/20 16:39
 * @ClassName:AliyunOssConfig
 */
@Component
public class AliyunOssConfig {

    private  static  String endpoint = "oss-cn-beijing.aliyuncs.com";

    private static  String accessKeyId = "LTAI5t6XHz5EY1Qe3DCGSKLW";

    private static  String  accessKeySecret = "ug3KXCRgoQ2oe8vCbb13ugvBcd6pdZ";

    /**
     * 是否存储到oss
     */
    public static  boolean attach;

    //文件最大上传大小
    public static long FILE_MAX_SIZE = 1024 * 1024 * 1;
    //图片过期时间 100年
    public static long FILE_EXPIRATION_TIME = 1000 * 3600 * 24 * 365 * 100;

    public static String JAVA_BUCKET_NAME = "waka-is-a-dog";

//    @Value("${oss.bucketName}")
//    public  void setJavaBucketName(String javaBucketName) {
//        JAVA_BUCKET_NAME = javaBucketName;
//    }

//    @Value("${oss.endpoint}")
//    public  void setEndpoint(String endpoint) {
//        AliyunOssConfig.endpoint = endpoint;
//    }
//    @Value("${oss.accessKeyId}")
//    public  void setAccessKeyId(String accessKeyId) {
//        AliyunOssConfig.accessKeyId = accessKeyId;
//    }
//    @Value("${oss.accessKeySecret}")
//    public  void setAccessKeySecret(String accessKeySecret) {
//        AliyunOssConfig.accessKeySecret = accessKeySecret;
//    }
//
//    @Value("${oss.attach}")
//    public  void setAttach(boolean attach) {
//        System.out.println("attach="+attach);
//        AliyunOssConfig.attach = attach;
//    }




    public static OSSClient getOssClient() {

        // 创建ClientConfiguration实例，按照您的需要修改默认参数。
        ClientBuilderConfiguration conf = new ClientBuilderConfiguration();
        // 关闭CNAME选项。
        conf.setSupportCname(false);
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret, conf);

        // 关闭OSSClient。

        return (OSSClient) ossClient;
    }






}
