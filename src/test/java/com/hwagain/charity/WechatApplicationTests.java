package com.hwagain.charity;

import com.baidu.aip.ocr.AipOcr;
import com.lhx.charity.idcard.IdCardService;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@CrossOrigin
public class WechatApplicationTests {

    @Resource
    private IdCardService idCardService;

    @Test
    public void testIDCard() throws JSONException {
        AipOcr client = idCardService.getClient();
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<>();
        options.put("detect_direction", "true");
        options.put("detect_risk", "false");

        String idCardSide = "back";

        // 参数为本地路径
        String image = "G:\\lhx\\wechat\\images\\aa.jpg";
        JSONObject res = client.idcard(image, idCardSide, options);
        System.out.println(res.toString(2));

        Map<String, Object> map = idCardService.idCardVerify(image);
        for (String s : map.keySet()) {
            System.out.println(s);
            System.out.println("===============");
            System.out.println(map.get(s));
        }

    }




}

