package com.lhx.charity.controller;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@SuppressWarnings("all")
public class OcrController{


    private static final Logger logger = LoggerFactory.getLogger(OcrController.class);


    /**
     * @Title: ocrtaken
     * @Description: 文字识别taken
     * @param @throws Exception  参数说明
     * @return void 返回类型
     * @author wl
     * @date 2018年4月27日 下午1:14:59
     */
    @RequestMapping("/public/ocrtaken")
    public void ocrtaken(HttpServletRequest request, HttpServletResponse response, Model m)throws Exception {
        FinalResult result = new FinalResult();
        HttpSession session = request.getSession();
        String cookname="accessToken";
        try {
            String accessToken=(String) session.getAttribute(cookname);
            Cookie cookie=CookieUtil.getCookie(request, cookname);
            if(cookie==null || StringUtils.isEmpty(accessToken)){
                int maxValue=60*60*24*30;
                accessToken=OcrtokenUtil.OcrPostApi();
                session.setAttribute(cookname, accessToken);
                CookieUtil.setCookie(response, cookname, accessToken, maxValue);
            }
            result.setRetResult(accessToken);
            result.setState("SUCCESS");
            result.webSuccess();
        } catch (Exception e) {
            logger.equals(e.getMessage());
            e.printStackTrace();
            result.setState("ERROR");
            result.webFaild();
        }

        writeJson(response, result);
    }


    /**
     * @Title: OcrCheck
     * @Description: 文字识别
     * @param @param data
     * @param @throws Exception  参数说明
     * @return void 返回类型
     * @author wl
     * @date 2018年4月27日 上午11:59:48
     */
    @RequestMapping("/public/OcrCheck")
    public void OcrCheck(HttpServletRequest request, HttpServletResponse response,Model m,FormData data)throws Exception {
        FinalResult result = new FinalResult();
        HashMap<String, String> options = new HashMap<String, String>();
        Map<String, Object> resultMap=new HashMap<>();
        Map map=HttpClientUtil.getParameterMap(request);
        try {
            //初始化客户端
            AipOcr client=OcrtokenUtil.Ocrinit();

            //参数为图片外链
            String image ="C:/Users/admin/Desktop/1.jpg";
            //String image =imageUtil.GetImageTolocal((String) map.get("imageUrl"));


            ////------------进行文字识别 -------------////
            options.put("language_type", "CHN_ENG");
            //高清识别
            JSONObject res = client.basicAccurateGeneral(image, options);
            //通用识别
            //JSONObject res = client.basicGeneral(image, options);
            logger.info("文字识别完成");
            JSONArray jsonArray=res.getJSONArray("words_result");
            System.out.println(jsonArray);
            result.setRetResult(jsonArray);
            result.setState("SUCCESS");
            result.webSuccess();

        } catch (Exception e) {
            logger.equals(e.getMessage());
            e.printStackTrace();
            result.setState("ERROR");
            result.webFaild();
        }
        writeJson(response, result);
    }
}

