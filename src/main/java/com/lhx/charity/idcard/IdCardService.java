package com.lhx.charity.idcard;


import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service("idCardService")
public class IdCardService {

    @Value("${baidu.appId:15362202}")
    private String appId;

    @Value("${baidu.apiKey:j2xe6r0N9pWa3ua60xXVwLwc}")
    private String apiKey;

    @Value("${baidu.secretKey:YDRCM86oilMrRgOZzmK4hxp176DnLb2e}")
    private String secretKey;

    private static AipOcr client;

    public AipOcr getClient(){
        if (client == null){
            client = new AipOcr(appId, apiKey, secretKey);
            // 可选：设置网络连接参数
            client.setConnectionTimeoutInMillis(2000);
            client.setSocketTimeoutInMillis(60000);
        }
        return client;
    }




    /**
     * 识别获取身份证正面相关信息
     *
     * @param front
     * @return
     */
    public Map<String, Object> identification(String front) {// 执行认证查询
        Map<String, Object> map = new HashMap<>();
        try {
            // 识别身份证正面id_card_side=front;识别身份证背面id_card_side=back;
            // 正面
            // 传入可选参数调用接口
            HashMap<String, String> options = new HashMap<>();
            options.put("detect_direction", "true");
            options.put("detect_risk", "false");

            String idCardSide = "front";
            Path path = Paths.get(front);
            byte[] imgData = Files.readAllBytes(path);
            //JSONObject res = client.idcard(front, idCardSide, options);
            JSONObject jsonObject = getClient().idcard(imgData, idCardSide, options);
            map.put("result", jsonObject);// 身份证所有信息
            map.put("address", jsonObject.getJSONObject("words_result").get("住址"));// 地址
            map.put("birth", jsonObject.getJSONObject("words_result").get("出生"));// 出生
            map.put("name", jsonObject.getJSONObject("words_result").get("姓名"));// 姓名
            map.put("IDCard", jsonObject.getJSONObject("words_result").get("公民身份号码"));// 身份证ID
            map.put("sex", jsonObject.getJSONObject("words_result").get("性别"));// 性别
            map.put("nation", jsonObject.getJSONObject("words_result").get("民族"));// 民族
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    /**
     * 获取身份证背面相关信息
     *
     * @param back
     * @return
     */
    public Map<String, Object> idCardVerify(String back) {
        Map<String, Object> map = new HashMap<>();
        try {
            // 识别身份证正面id_card_side=front;识别身份证背面id_card_side=back;
            HashMap<String, String> options = new HashMap<>();
            options.put("detect_direction", "true");
            options.put("detect_risk", "false");

            String idCardSide = "back";
            Path path = Paths.get(back);
            byte[] imgData = Files.readAllBytes(path);
            //JSONObject res = client.idcard(front, idCardSide, options);
            JSONObject jsonObject = getClient().idcard(imgData, idCardSide, options);
            map.put("result", jsonObject);// 所有信息
            map.put("issueDate", jsonObject.getJSONObject("words_result").get("签发日期"));// 签发日期
            map.put("expiryDate",jsonObject.getJSONObject("words_result").get("失效日期")); // 失效日期
            map.put("issueyAuthority", jsonObject.getJSONObject("words_result").get("签发机关"));// 签发机关
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    /** * 身份认证 */
    public boolean identification(String name, String front, String back) {
        try {
//          CommonsMultipartFile[] file = new CommonsMultipartFile[] { front, back };// 上传到本地
//          List<String> uploadFile = UploadFile(file, request);// 返回图片URL
            // 验证身份证有效期 反面
            Map<String, Object> idCardVerifyBack = idCardVerify(back);
            // 获得身份证失效日期
            String expiryDate = ((JSONObject) idCardVerifyBack.get("expiryDate")).get("words").toString();
            StringBuffer str = new StringBuffer(expiryDate);// 处理日期格式 20180424-->2018-04-24
            str.insert(4, "-");
            str.insert(7, "-");
            String currentTime = LocalDate.now().toString();// 获得当前日期 进行比对
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");// 格式化
            Date cu = dateFormat.parse(currentTime);// 转换成毫秒数 进行比对
            Date ex = dateFormat.parse(str.toString());
            if (ex.before(cu)) { // 当前时间小于当前时间

                //return MsgUtil.result(false, "身份证已过期");
                return false;
            }
            // 执行认证
            Map<String, Object> idCardVerifyFront = identification(front);
            // 验证姓名是否跟身份证姓名是否匹对
            String names = ((JSONObject) idCardVerifyFront.get("name")).get("words").toString();
            if (!names.equals(name)) {
                //return MsgUtil.result(false, "输入姓名与身份证姓名不匹配");
                return false;
            }
            // IDCard身份证号码
            String IDCard = ((JSONObject) idCardVerifyFront.get("IDCard")).get("words").toString();
            // 修改数据库字段填入身份证号码 认证成功
//          Vip_info vip = (Vip_info) request.getSession().getAttribute("user");// 获取当前登录用户
            //Map<String, Object> map = new HashMap<String, Object>();
            //map.put("uid", pd.getString("uid"));//用户编号
            //map.put("id_card", IDCard);
//          //mapper.updateIDCardById(map);// 执行修改
            //dao.update("BtcAppImMapper.updateIDCardById", map);//执行修改
//          // 删除上传图片
//          for (String path : uploadFile) {
//              File f = new File(path);
//              f.delete(); // 执行删除
//          }
            // 认证成功
            //return MsgUtil.result(true, "认证成功");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            //return MsgUtil.result(false, "认证失败,请稍后再试");
            return false;
        }
    }



}
