package com.example.utils;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
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
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.CollectionUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
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
public abstract class HttpUtil {
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


    private HttpUtil() throws IllegalAccessException {
        throw new IllegalAccessException("工具类不能被实例化");
    }

    /**
     * 创建既支持http又支持https的HttpClient
     */
    public static CloseableHttpClient createHttpClient() throws KeyManagementException, NoSuchAlgorithmException {
        //采用绕过验证的方式处理https请求
        SSLContext sslcontext = createIgnoreVerifySSL();

        //设置协议http和https对应的处理socket链接工厂的对象
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register(HTTP, PlainConnectionSocketFactory.INSTANCE)
                .register(HTTPS, new SSLConnectionSocketFactory(sslcontext, NoopHostnameVerifier.INSTANCE))
                .build();
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        HttpClients.custom().setConnectionManager(connManager);

        //创建自定义的httpclient对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connManager).build();
        return httpClient;
    }

    /**
     * 以get方式请求
     *
     * @param url              请求地址
     * @param httpResponseFunc 响应回调函数
     */
    public static <R> R doGet(final String url,
                              final BiFunction<Integer, String, R> httpResponseFunc)
            throws Exception {
        return doGet(url, httpResponseFunc, null, null, DEFAULT_REQUEST_CONFIG);
    }

    /**
     * 以get方式请求
     *
     * @param url              请求地址
     * @param httpResponseFunc 响应回调函数
     * @param paramsMap        请求参数
     */
    public static <R> R doGet(final String url,
                              final BiFunction<Integer, String, R> httpResponseFunc,
                              final Map<String, String> paramsMap)
            throws Exception {
        return doGet(url, httpResponseFunc, paramsMap, null, DEFAULT_REQUEST_CONFIG);
    }

    /**
     * 以get方式请求
     *
     * @param url              请求地址
     * @param httpResponseFunc 响应回调函数
     * @param paramsMap        请求参数
     * @param requestConfig    请求配置信息
     */
    public static <R> R doGet(final String url,
                              final BiFunction<Integer, String, R> httpResponseFunc,
                              final Map<String, String> paramsMap,
                              final RequestConfig requestConfig)
            throws Exception {
        return doGet(url, httpResponseFunc, paramsMap, null, requestConfig);
    }

    /**
     * 以get方式请求
     *
     * @param url              请求地址
     * @param httpResponseFunc 响应回调函数
     * @param paramsMap        请求参数
     * @param headerMap        请求头
     */
    public static <R> R doGet(final String url,
                              final BiFunction<Integer, String, R> httpResponseFunc,
                              final Map<String, String> paramsMap,
                              final Map<String, String> headerMap)
            throws Exception {
        return doGet(url, httpResponseFunc, paramsMap, headerMap, DEFAULT_REQUEST_CONFIG);
    }


    /**
     * 以get方式请求
     *
     * @param url              请求地址
     * @param httpResponseFunc 响应回调函数
     * @param paramsMap        请求参数
     * @param headerMap        请求头
     * @param requestConfig    请求配置信息
     */
    public static <R> R doGet(final String url,
                              final BiFunction<Integer, String, R> httpResponseFunc,
                              final Map<String, String> paramsMap,
                              final Map<String, String> headerMap,
                              final RequestConfig requestConfig)
            throws Exception {
        Preconditions.checkArgument(StringUtils.isNotBlank(url));
        try (final CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // 配置参数
            final List<NameValuePair> nameValuePairList = convertMapToBasicNameValuePairs(paramsMap);
            final String appendParamUrl = new URIBuilder(url.trim()).setParameters(nameValuePairList).toString();
            final HttpGet httpReq = new HttpGet(appendParamUrl);
            httpReq.addHeader(DEFAULT_TEXT_PLAIN_HEADER);

            // 配置请求头
            if (!CollectionUtils.isEmpty(headerMap)) {
                headerMap.entrySet().stream().map(HttpUtil::convertEntryToBasicHeader).forEach(httpReq::setHeader);
            }

            // 配置参数
            httpReq.setConfig(requestConfig);

            // 处理响应信息
            try (final CloseableHttpResponse httpResponse = httpClient.execute(httpReq)) {
                final int resStatusCode = httpResponse.getStatusLine().getStatusCode();
                final String resString = EntityUtils.toString(httpResponse.getEntity(), Consts.UTF_8);
                return httpResponseFunc.apply(resStatusCode, resString);
            }
        }
    }


    /**
     * 以post方式提交表单信息
     *
     * @param url              请求地址
     * @param httpResponseFunc 响应回调函数
     */
    public static <R> R doPost(final String url,
                               final BiFunction<Integer, String, R> httpResponseFunc)
            throws Exception {
        return doPost(url, httpResponseFunc, null, null, DEFAULT_REQUEST_CONFIG);
    }

    /**
     * 以post方式提交表单信息
     *
     * @param url              请求地址
     * @param httpResponseFunc 响应回调函数
     * @param paramsMap        请求参数
     */
    public static <R> R doPost(final String url,
                               final BiFunction<Integer, String, R> httpResponseFunc,
                               final Map<String, String> paramsMap) throws Exception {
        return doPost(url, httpResponseFunc, paramsMap, null, DEFAULT_REQUEST_CONFIG);
    }

    /**
     * 以post方式提交表单信息
     *
     * @param url              请求地址
     * @param httpResponseFunc 响应回调函数
     * @param paramsMap        请求参数
     * @param headerMap        请求头
     */
    public static <R> R doPost(final String url,
                               final BiFunction<Integer, String, R> httpResponseFunc,
                               final Map<String, String> paramsMap,
                               final Map<String, String> headerMap)
            throws Exception {
        return doPost(url, httpResponseFunc, paramsMap, headerMap, DEFAULT_REQUEST_CONFIG);
    }

    /**
     * 以post方式提交表单信息
     *
     * @param url              请求地址
     * @param httpResponseFunc 响应回调函数
     * @param paramsMap        请求参数
     * @param requestConfig    请求配置信息
     */
    public static <R> R doPost(final String url,
                               final BiFunction<Integer, String, R> httpResponseFunc,
                               final Map<String, String> paramsMap,
                               final RequestConfig requestConfig)
            throws Exception {
        return doPost(url, httpResponseFunc, paramsMap, null, requestConfig);
    }


    /**
     * 以post方式提交表单信息
     *
     * @param url              请求地址
     * @param httpResponseFunc 响应回调函数
     * @param paramsMap        请求参数
     * @param headerMap        请求头
     * @param requestConfig    请求配置信息
     */
    public static <R> R doPost(final String url,
                               final BiFunction<Integer, String, R> httpResponseFunc,
                               final Map<String, String> paramsMap,
                               final Map<String, String> headerMap,
                               final RequestConfig requestConfig)
            throws Exception {
        Preconditions.checkArgument(StringUtils.isNotBlank(url));
        try (final CloseableHttpClient httpClient = createHttpClient()) {
            final List<NameValuePair> nameValuePairList = convertMapToBasicNameValuePairs(paramsMap); // 配置参数
            final HttpPost httpReq = new HttpPost(url.trim());
            httpReq.setEntity(new UrlEncodedFormEntity(nameValuePairList, Consts.UTF_8));

            // 配置请求头
            httpReq.addHeader(DEFAULT_FORM_URLENCODED_HEADER);
            if (!CollectionUtils.isEmpty(headerMap)) { // 配置请求头
                headerMap.entrySet().stream().map(HttpUtil::convertEntryToBasicHeader).forEach(httpReq::setHeader);
            }

            // 配置参数
            httpReq.setConfig(requestConfig);
            // 处理响应信息
            try (final CloseableHttpResponse httpResponse = httpClient.execute(httpReq)) {
                final int resStatusCode = httpResponse.getStatusLine().getStatusCode();
                final String resString = EntityUtils.toString(httpResponse.getEntity(), Consts.UTF_8);
                return httpResponseFunc.apply(resStatusCode, resString);
            }
        }
    }

    /**
     * 使用post方式提交json数据
     *
     * @param url              请求地址
     * @param jsonStr          请求json数据
     * @param httpResponseFunc 响应信息回调函数
     */
    public static <R> R doPostJson(final String url,
                                   final String jsonStr,
                                   final BiFunction<Integer, String, R> httpResponseFunc)
            throws Exception {
        return doPostJson(url, jsonStr, httpResponseFunc, null, DEFAULT_REQUEST_CONFIG);
    }

    /**
     * 使用post方式提交json数据
     *
     * @param url              请求地址
     * @param jsonStr          j请求json数据
     * @param httpResponseFunc 响应信息回调函数
     * @param headerMap        请求头
     */
    public static <R> R doPostJson(final String url,
                                   final String jsonStr,
                                   final BiFunction<Integer, String, R> httpResponseFunc,
                                   final Map<String, String> headerMap)
            throws Exception {
        return doPostJson(url, jsonStr, httpResponseFunc, headerMap, DEFAULT_REQUEST_CONFIG);
    }

    /**
     * 使用post方式提交json数据
     *
     * @param url              请求地址
     * @param jsonStr          j请求json数据
     * @param httpResponseFunc 响应信息回调函数（包含响应头信息）
     * @param headerMap        请求头
     */
    public static <R> R doPostJsonResHeaders(final String url,
                                             final String jsonStr,
                                             final BiFunction<Integer, Map, R> httpResponseFunc,
                                             final Map<String, String> headerMap)
            throws Exception {
        return doPostJsonResHeaders(url, jsonStr, httpResponseFunc, headerMap, DEFAULT_REQUEST_CONFIG);
    }

    /**
     * 使用post方式提交json数据
     *
     * @param url              请求地址
     * @param jsonStr          json数据
     * @param httpResponseFunc 响应信息回调函数
     * @param requestConfig    请求配置信息
     */
    public static <R> R doPostJson(final String url,
                                   final String jsonStr,
                                   final BiFunction<Integer, String, R> httpResponseFunc,
                                   final RequestConfig requestConfig)
            throws Exception {
        return doPostJson(url, jsonStr, httpResponseFunc, null, requestConfig);
    }


    /**
     * 使用post方式提交json数据
     *
     * @param url              请求地址
     * @param jsonStr          json数据
     * @param httpResponseFunc 响应信息回调函数
     * @param headerMap        请求头
     * @param requestConfig    请求配置信息
     */
    public static <R> R doPostJson(final String url,
                                   final String jsonStr,
                                   final BiFunction<Integer, String, R> httpResponseFunc,
                                   final Map<String, String> headerMap,
                                   final RequestConfig requestConfig)
            throws Exception {
        Preconditions.checkArgument(StringUtils.isNotBlank(url));
        try (final CloseableHttpClient httpClient = createHttpClient()) {
            final HttpPost httpReq = new HttpPost(url.trim());
            httpReq.setEntity(new StringEntity(jsonStr, Consts.UTF_8));

            // 配置请求头
            httpReq.addHeader(DEFAULT_JSON_HEADER);
            if (!CollectionUtils.isEmpty(headerMap)) { // 配置请求头
                headerMap.entrySet().stream().map(HttpUtil::convertEntryToBasicHeader).forEach(httpReq::setHeader);
            }

            httpReq.setConfig(requestConfig);

            // 处理响应信息
            try (final CloseableHttpResponse httpResponse = httpClient.execute(httpReq)) {
                final int resStatusCode = httpResponse.getStatusLine().getStatusCode();
                final String resString = EntityUtils.toString(httpResponse.getEntity(), Consts.UTF_8);
                return httpResponseFunc.apply(resStatusCode, resString);
            }
        }
    }

    /**
     * 使用post方式提交json数据
     *
     * @param url              请求地址
     * @param jsonStr          json数据
     * @param httpResponseFunc 响应信息回调函数
     * @param headerMap        请求头
     * @param requestConfig    请求配置信息
     */
    public static <R> R doPostJsonResHeaders(final String url,
                                             final String jsonStr,
                                             final BiFunction<Integer, Map, R> httpResponseFunc,
                                             final Map<String, String> headerMap,
                                             final RequestConfig requestConfig)
            throws Exception {
        Preconditions.checkArgument(StringUtils.isNotBlank(url));
        try (final CloseableHttpClient httpClient = createHttpClient()) {
            final HttpPost httpReq = new HttpPost(url.trim());
            httpReq.setEntity(new StringEntity(jsonStr, Consts.UTF_8));

            // 配置请求头
            httpReq.addHeader(DEFAULT_JSON_HEADER);
            if (!CollectionUtils.isEmpty(headerMap)) { // 配置请求头
                headerMap.entrySet().stream().map(HttpUtil::convertEntryToBasicHeader).forEach(httpReq::setHeader);
            }

            httpReq.setConfig(requestConfig);

            // 处理响应信息
            try (final CloseableHttpResponse httpResponse = httpClient.execute(httpReq)) {
                final int resStatusCode = httpResponse.getStatusLine().getStatusCode();
                final Header[] allHeaders = httpResponse.getAllHeaders();
                Map headersMap = new ConcurrentHashMap<>();
                for (Header header : allHeaders) {
                    headersMap.put(header.getName(), header.getValue());
                }
                final String resString = EntityUtils.toString(httpResponse.getEntity(), Consts.UTF_8);
                Map<String, Object> map = Maps.newConcurrentMap();
                map.put(RSP_HEADER, headersMap);
                map.put(RSP_BODY, resString);
                return httpResponseFunc.apply(resStatusCode, map);
            }
        }
    }

    /**
     * 绕过验证
     */
    private static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sc = SSLContext.getInstance(SSL);

        // 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
        X509TrustManager trustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) {
            }

            @Override
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
//        sc.init(null, new TrustManager[]{trustManager}, new java.security.SecureRandom());
        sc.init(null, new TrustManager[]{trustManager}, null);
        return sc;
    }

    /**
     * 转换map中的项为BasicHeader
     */
    private static BasicHeader convertEntryToBasicHeader(final Entry<String, String> entry) {
        return new BasicHeader(entry.getKey(), entry.getValue());
    }


    /**
     * 转换Map为NameValuePair集合
     */
    private static List<NameValuePair> convertMapToBasicNameValuePairs(final Map<String, String> paramsMap) {
        if (CollectionUtils.isEmpty(paramsMap)) {
            return Lists.newArrayList();
        }
        return paramsMap.entrySet().stream()
                .map(HttpUtil::convertEntryToBasicNameValuePair)
                .collect(Collectors.toList());
    }

    /**
     * 转换map中的项为BasicNameValuePair
     */
    private static BasicNameValuePair convertEntryToBasicNameValuePair(final Entry<String, String> entry) {
        return new BasicNameValuePair(entry.getKey(), entry.getValue());
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
