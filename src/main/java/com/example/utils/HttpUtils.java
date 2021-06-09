package com.example.utils;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultHttpResponseParserFactory;
import org.apache.http.impl.conn.ManagedHttpClientConnectionFactory;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.conn.SystemDefaultDnsResolver;
import org.apache.http.impl.io.DefaultHttpRequestWriterFactory;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.CollectionUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * <hr>
 *
 * @author TheWk
 * @version 1.0.0
 * <pre>
 * =========================== Logs =========================== <br>
 * 1.0.0(2018-09-05 10:18) TheWk 创建 <br>
 * =========================== Logs =========================== <br>
 * </pre>
 */
@Slf4j
public abstract class HttpUtils {
    //    _____   _             __      ___  __
    //   |_   _| | |_      ___  \ \    / / |/ /
    //     | |   | ' \    / -_)  \ \/\/ /| ' <
    //    _|_|_  |_||_|   \___|   \_/\_/ |_|\_\
    //  _|"""""|_|"""""|_|"""""|_|"""""|_|"""""|_
    //  "`-0-0-'"`-0-0-'"`-0-0-'"`-0-0-'"`-0-0-'"


    private static final String CONTENT_TYPE = "Content-Type";

    private static final String HTTP = "http";

    private static final String HTTPS = "https";

    private static final String RSP_BODY = "body";

    private static final String RSP_HEADER = "header";

    private static final ContentType APPLICATION_TEXT_PLAIN = ContentType.create("text/plain", Consts.UTF_8);
    private static final ContentType APPLICATION_FORM_URLENCODED = ContentType.create("application/x-www-form-urlencoded", Consts.UTF_8);
    private static final ContentType APPLICATION_JSON = ContentType.create("application/json", Consts.UTF_8);


    private static final Header DEFAULT_TEXT_PLAIN_HEADER = new BasicHeader(CONTENT_TYPE, APPLICATION_TEXT_PLAIN.toString());

    private static final Header DEFAULT_FORM_URLENCODED_HEADER = new BasicHeader(CONTENT_TYPE, APPLICATION_FORM_URLENCODED.toString());

    private static final Header DEFAULT_JSON_HEADER = new BasicHeader(CONTENT_TYPE, APPLICATION_JSON.toString());
    /**
     * 握手协议（SSL.x和TLS.x）
     */
    private static final String SSL = "TLS";
    /**
     * 连接主机服务超时时间
     */
    private static int CONNECT_TIMEOUT = 35000;
    /**
     * 请求超时时间
     */
    private static int CONNECTION_REQUEST_TIMEOUT = 35000;
    /**
     * 数据读取超时时间
     */
    private static int SOCKET_TIMEOUT = 600000;

    /**
     * 默认的配置信息
     */
    private static final RequestConfig DEFAULT_REQUEST_CONFIG = RequestConfig.custom()
            .setConnectTimeout(CONNECT_TIMEOUT)
            .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT)
            .setSocketTimeout(SOCKET_TIMEOUT)
            .build();


    private HttpUtils() throws IllegalAccessException {
        throw new IllegalAccessException("工具类不能被实例化");
    }

    public static String doPostJson(String url, String json) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setHeader("Accept-Encoding", "");
            httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
            httpPost.setHeader("Accept", "application/json");
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            e.printStackTrace(new PrintStream(baos));
            String exception = baos.toString();
            log.error("请求能力平台失败{}",exception);
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                log.error("关流失败{}",e.getMessage());
            }
        }

        return resultString;
    }




    public static void main(String[] args) throws Exception {

//        final long beginTime = System.currentTimeMillis();
//        final String url = "http://httpbin.org/get";
//
//        Map<String, String> params = new HashMap<>();
//        params.put("key1", "中文1");
//        params.put("key2", "中文2");
//
//        String result = HttpUtil.doGet(url, (status, res) -> {
//            System.out.println(status);
//            System.out.println(res);
//            return res;
//        }, params);
//        final long endTime = System.currentTimeMillis();
//        System.out.println("耗时：" + (endTime - beginTime));
//
//        System.out.println(result);

        final String baidu = "http://api.douban.com/v2/movie/search";
        Map<String, String> body = new HashMap<>();
        body.put("q", "张艺谋");
//        body.put("wd", "jmeter性能测试");
        HttpUtil.doGet(baidu, (status, res) -> {
            System.out.println(status);
            System.out.println(res);
            return res;
        }, body);

    }

}
