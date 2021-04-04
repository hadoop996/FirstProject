package com.example.oss;


import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * @author: xiehh
 * @Date:2020/11/20 16:37
 * @ClassName:AliyunOSSUtil
 */
public class AliyunOSSUtil {

    /**
     * oss 工具客户端
     */
    private static OSSClient ossClient = null;

    /**
     * 上传文件至阿里云 OSS
     * 文件上传成功,返回文件完整访问路径
     *
     * @param file 上传文件
     * @return
     */
//    public static AliyunOssResult upload(MultipartFile file) {
//        if (file == null) {
//            return new AliyunOssResult(400, null, "文件不能为空");
//        }
//        System.out.println("上传文件size" + file.getSize());
//
//        if (file.getSize() <= 0 || file.getSize() > AliyunOssConfig.FILE_MAX_SIZE) {
//            return new AliyunOssResult(400, null, "文件不能大于1M");
//        }
//        //原来文件名称
//        String oldName = file.getOriginalFilename();
//        //文件后缀
//        String postfix = oldName.substring(oldName.lastIndexOf(".") + 1, oldName.length());
//        //新文件名称
//        String fileName = UUID.randomUUID().toString().toUpperCase()
//                .replace("-", "")
//                + "." + postfix;
//        //获取文件类型
//        String fileType = file.getContentType();
//
//        InputStream inputStream = null;
//        try {
//            inputStream = file.getInputStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return new AliyunOssResult(400, null, e.getMessage());
//        }
//        //上传文件
//        AliyunOssResult resoult = putFile(inputStream, fileType, fileName);
//        return resoult;
//    }

    /**
     * 上传文件
     *
     * @param input    文件输入流
     * @param fileName 文件的名字 生成新文件的名字
     * @return
     */
    static AliyunOssResult putFile(InputStream input, String fileName) {
        AliyunOssResult resoult = null;
        //初始化客户端
        ossClient = AliyunOssConfig.getOssClient();
        try {
            // 创建上传Object的Metadata
            ObjectMetadata meta = new ObjectMetadata();
            // 设置上传内容类型  创建上传文件的元信息，可以通过文件元信息设置HTTP header(设置了才能通过返回的链接直接访问)。
            meta.setContentType("image/jpg");
            //被下载时网页的缓存行为
            meta.setCacheControl("no-cache");
            //创建上传请求
            PutObjectRequest request = new PutObjectRequest(AliyunOssConfig.JAVA_BUCKET_NAME, fileName, input, meta);
            //上传文件
            ossClient.putObject(request);
            System.out.println("文件上传oss");
            //code    url                         err    上传oss后生成文件名
            resoult = new AliyunOssResult(200, getOssUrl(ossClient, fileName), null, fileName);

        } catch (OSSException | ClientException e) {
            e.printStackTrace();
            resoult = new AliyunOssResult(400, null, e.getMessage());
            return resoult;
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return resoult;
    }


    /**
     * 根据文件名生成文件的下载地址 下载
     *
     * @param ossClient
     * @param key
     * @return
     */
    private static String getOssUrl(OSSClient ossClient, String key) {
        Date expiration = new Date(new Date().getTime() + AliyunOssConfig.FILE_EXPIRATION_TIME);// 生成URL
        GeneratePresignedUrlRequest generatePresignedUrlRequest;
        generatePresignedUrlRequest = new GeneratePresignedUrlRequest(AliyunOssConfig.JAVA_BUCKET_NAME, key);
        generatePresignedUrlRequest.setExpiration(expiration);
        URL url = ossClient.generatePresignedUrl(generatePresignedUrlRequest);
        return url.toString();
    }


    /**
     * 通过文件名下载文件
     *
     * @param fileNmae      要下载的文件名
     *                      例如：4DB049D0604047989183CB68D76E969D.jpg
     * @param localFileName 本地要创建的文件名
     *                      例如：C:\Users\Administrator\Desktop\test.jpg
     */
//    public static void downloadFile(String fileNmae, String localFileName) {
//        ossClient = ossClient == null ? initOSS() : ossClient;
//        try {
//            // 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
//            ossClient.getObject(new GetObjectRequest(AliyunOssConfig.JAVA_BUCKET_NAME, fileNmae), new File(localFileName));
//        } finally {
//            if (ossClient != null) {
//                ossClient.shutdown();
//            }
//        }
//    }

    /**
     * @param file
     * @param fileType
     * @param oldUrl
     * @return String
     * @MethodName: updateFile
     * @Description: 更新文件:只更新内容，不更新文件名和文件地址。
     * (因为地址没变，可能存在浏览器原数据缓存，不能及时加载新数据，例如图片更新，请注意)
     */
//    public static String updateFile(File file, String fileType, String oldUrl) {
//        String fileName = getFileName(oldUrl);
//        if (fileName == null) return null;
//        return putFile(file, fileType, fileName);
//    }

    /**
     * @param file
     * @param fileType 文件后缀
     * @param oldUrl   需要删除的文件地址
     * @return String 文件地址
     * @MethodName: replaceFile
     * @Description: 替换文件:删除原文件并上传新文件，文件名和地址同时替换
     * 解决原数据缓存问题，只要更新了地址，就能重新加载数据)
     */
//    public static String replaceFile(File file, String fileType, String oldUrl) {
//        boolean flag = deleteFile(oldUrl);        //先删除原文件
//        if (!flag) {
//            //更改文件的过期时间，让他到期自动删除。
//        }
//        return uploadFile(file, fileType);
//    }

    /**
     * 列举 test 文件下所有的文件
     */
//    public static List<String> listFile() {
//        List<String> list = new ArrayList<>();
//        ossClient = ossClient == null ? initOSS() : ossClient;
//        try {
//            // 构造ListObjectsRequest请求。
//            ListObjectsRequest listObjectsRequest = new ListObjectsRequest(AliyunOssConfig.JAVA_BUCKET_NAME);
//
//            // 设置prefix参数来获取fun目录下的所有文件。
////            listObjectsRequest.setPrefix("test/");
//            // 列出文件。
//            ObjectListing listing = ossClient.listObjects(listObjectsRequest);
//            // 遍历所有文件。
//            for (OSSObjectSummary objectSummary : listing.getObjectSummaries()) {
//                //System.out.println(objectSummary.getKey());
//                //把key全部转化成可以访问的url
//                String url = getOssUrl(ossClient, objectSummary.getKey());
//                list.add(url);
//            }
//            // 遍历所有commonPrefix。
////            for (String commonPrefix : listing.getCommonPrefixes()) {
////                System.out.println(commonPrefix);
////            }
//        } finally {
//            if (ossClient != null) {
//                ossClient.shutdown();
//            }
//        }
//        return list;
//    }

    /**
     * @param fileUrls 需要删除的文件url集合
     * @return int 成功删除的个数
     * @MethodName: batchDeleteFiles
     * @Description: 批量文件删除(较慢)：适用于不同endPoint和BucketName
     */
//    private int deleteFiles(List<String> fileUrls) {
//        int count = 0;
//        for (String url : fileUrls) {
//            if (deleteFile(url)) {
//                count++;
//            }
//        }
//        return count;
//    }

    /**
     * @param fileUrls 需要删除的文件url集合
     * @return int 成功删除的个数
     * @MethodName: batchDeleteFiles
     * @Description: 批量文件删除(较快)：适用于相同endPoint和BucketName
     */
//    private int deleteFile(List<String> fileUrls) {
//        ossClient = ossClient == null ? initOSS() : ossClient;
//        int deleteCount = 0;    //成功删除的个数
//        try {
//            //根据url获取fileName
//            List<String> fileNames = getFileName(fileUrls);
//            if (AliyunOssConfig.JAVA_BUCKET_NAME == null || fileNames.size() <= 0) return 0;
//
//            DeleteObjectsRequest request = new DeleteObjectsRequest(AliyunOssConfig.JAVA_BUCKET_NAME).withKeys(fileNames);
//            DeleteObjectsResult result = ossClient.deleteObjects(request);
//            deleteCount = result.getDeletedObjects().size();
//        } catch (OSSException oe) {
//            oe.printStackTrace();
//            throw new RuntimeException("OSS服务异常:", oe);
//        } catch (ClientException ce) {
//            ce.printStackTrace();
//            throw new RuntimeException("OSS客户端异常:", ce);
//        } finally {
//            if (ossClient != null) {
//                ossClient.shutdown();
//            }
//        }
//        return deleteCount;
//
//    }
//
    /**
     * @param fileUrl 需要删除的文件url
     * @return boolean 是否删除成功
     * @MethodName: deleteFile
     * @Description: 单文件删除
     * 例如：http://*.oss-cn-beijing.aliyuncs.com/4DB049D0604047989183CB68D76E969D.jpg
     */
//    public static boolean deleteFile(String fileUrl) {
//        ossClient = ossClient == null ? initOSS() : ossClient;
//        try {
//            //根据url获取fileName
//            String fileName = getFileName(fileUrl);
//            if (AliyunOssConfig.JAVA_BUCKET_NAME == null || fileName == null) return false;
//            GenericRequest request = new DeleteObjectsRequest(AliyunOssConfig.JAVA_BUCKET_NAME).withKey(fileName);
//            ossClient.deleteObject(request);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        } finally {
//            if (ossClient != null) {
//                ossClient.shutdown();
//            }
//        }
//        return true;
//    }

    /**
     * @param fileUrl 文件url
     * @return String fileName
     * @MethodName: getFileName
     * @Description: 根据url获取fileName
     */
//    private static String getFileName(String fileUrl) {
//        String str = "aliyuncs.com/";
//        int beginIndex = fileUrl.indexOf(str);
//        if (beginIndex == -1)
//            return null;
//        return fileUrl.substring(beginIndex + str.length());
//    }

    /**
     * @param fileUrls 文件url
     * @return List<String>  fileName集合
     * @MethodName: getFileName
     * @Description: 根据url获取fileNames集合
     */
//    private List<String> getFileName(List<String> fileUrls) {
//        List<String> names = new ArrayList<>();
//        for (String url : fileUrls) {
//            names.add(getFileName(url));
//        }
//        return names;
//    }


    /**
     * @param fileType
     * @return String
     * @MethodName: contentType
     * @Description: 获取文件类型
     */
//    private String contentType(String fileType) {
//        fileType = fileType.toLowerCase();
//        String contentType = "";
//        switch (fileType) {
//            case "bmp":
//                contentType = "image/bmp";
//                break;
//            case "gif":
//                contentType = "image/gif";
//                break;
//            case "png":
//            case "jpeg":
//            case "jpg":
//                contentType = "image/jpeg";
//                break;
//            case "html":
//                contentType = "text/html";
//                break;
//            case "txt":
//                contentType = "text/plain";
//                break;
//            case "vsd":
//                contentType = "application/vnd.visio";
//                break;
//            case "ppt":
//            case "pptx":
//                contentType = "application/vnd.ms-powerpoint";
//                break;
//            case "doc":
//            case "docx":
//                contentType = "application/msword";
//                break;
//            case "xml":
//                contentType = "text/xml";
//                break;
//            case "mp4":
//                contentType = "video/mp4";
//                break;
//            default:
//                contentType = "application/octet-stream";
//                break;
//        }
//        return contentType;
//    }

    /**
     * 通过图片完整url路径，获取图片url最后一段信息
     *
     * @param url 图片完整的url信息
     * @return
     */
    public static String getImgNameFromUrl(String url) {
        if (Objects.isNull(url) || "".equals(url.trim())) {
            return null;
        }
        String lastPath = null;
        try {
            URI uri = new URI(url);
            String path = uri.getPath();
            lastPath = path.substring(path.lastIndexOf("/") + 1);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            System.out.println("url解析出错！");
        }
        return lastPath;
    }

    /**
     * 通过图片完整url路径，获取图片url最后一段信息
     *
     * @param url 图片完整的url信息
     * @return
     */
    public static String getImgUrlPath(String url) {
        if (Objects.isNull(url) || "".equals(url.trim())) {
            return null;
        }
        String shortUrl = null;
        try {
            URI uri = new URI(url);
            shortUrl = uri.getPath() + "?" + uri.getQuery();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            System.out.println("url解析出错！");
        }
        return shortUrl;
    }
}
