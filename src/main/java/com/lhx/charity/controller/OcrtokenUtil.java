package com.lhx.charity.controller;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class OcrtokenUtil {
    //官网获取 App ID
    public static final String APP_ID = "17018550";
    //官网获取的 API Key
    public static final String clientId="AKPlSO3sfH1x4jv98wxBPBLN";
    //官网获取的 Secret Key
    public static final String clientSecret="wxZ7UwybCHOejnEm3meu1xazi0bTnOua";
    //API url
    public static final String authHost="https://aip.baidubce.com/oauth/2.0/token";
    //grant_type为固定参数
    public static final String grantType="client_credentials";

    private static final Logger logger = LoggerFactory.getLogger(OcrtokenUtil.class);


    /**
     * @Title: OcrGetApi
     * @Description: 获取access_token get请求
     * @return JSONObject 返回类型
     * @author wl
     * @date 2018年4月17日 上午11:49:09
     */
    public static String OcrGetApi()throws Exception {
        String access_token =null;
        String getAccessTokenUrl = authHost
                + "?grant_type=client_credentials"
                + "&client_id=" + clientId
                + "&client_secret=" + clientSecret;
        JSONObject jsonobj=HttpClientUtil.httpGetAndReturn(getAccessTokenUrl);
        if (jsonobj == null || jsonobj.isNullObject()){
            logger.error("token获取异常");
        }else{
            access_token = jsonobj.getString("access_token");
            logger.info("此次token信息是："+access_token);
        }
        return access_token;
    }

    /**
     * @Title: OcrPostApi
     * @Description: 获取access_token post请求
     * @return JSONObject 返回类型
     * @author wl
     * @date 2018年4月17日 上午11:49:09
     */
    public static String OcrPostApi()throws Exception {
        String access_token =null;
        Map<String, Object> map=new HashMap<>();
        map.put("client_id", clientId);
        map.put("client_secret", clientSecret);
        map.put("grant_type", grantType);
        JSONObject jsonobj=HttpClientUtil.httpPostMap(authHost, map);
        if (jsonobj == null || jsonobj.isNullObject()){
            logger.error("token获取异常");
        }else{
            access_token = jsonobj.getString("access_token");
            logger.info("此次token信息是："+access_token);
        }

        return access_token;
    }


    /**
     * @Title: Ocrinit
     * @Description: 文字识别java客户端
     * @param @return
     * @param @throws Exception  参数说明
     * @return AipOcr 返回类型
     * @author wl
     * @date 2018年4月27日 下午12:09:15
     */
    public static AipOcr Ocrinit()throws Exception {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, clientId, clientSecret);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
		/*client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理
		 */
        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "log4j.properties");

        return client;
    }

}

