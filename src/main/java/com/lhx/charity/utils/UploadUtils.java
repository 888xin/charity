package com.lhx.charity.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

@Slf4j
public class UploadUtils {

    //private final static String UPLOAD_URL = "http://10.0.216.200:8090/DecryptFileToPhone.aspx?ProductName=ProductPackaging&FileUrl=http://hwtest3.hwagain.com:8087/hwagain-mail/Penguins.jpg";
    //http://10.0.216.200:8090/DecryptFileToPhone.aspx?ProductName=ProductPackaging&FileUrl=http://192.168.65.123:8087/2af061e7-adae-43b4-a407-daccc5214e79+++++Lighthouse.jpg


    public static int doPost(String url, MultiValueMap<String, String> map) {
        RestTemplate restTemplate = new RestTemplate();

        //创建请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);


        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request ,String.class);

        return response.getStatusCode().value();
    }


    public static boolean downloadLittleFileToPath(String url, String targetDir) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<byte[]> rsp = null;
        try {
            rsp = restTemplate.getForEntity(url, byte[].class);
        } catch (RestClientException e) {
            log.error(e.getMessage(), e);
            return false;
        }
        if (rsp.getStatusCode().value() == 200){
            try {
                Files.write(Paths.get(targetDir), Objects.requireNonNull(rsp.getBody(), "未获取到下载文件"));
                return true;
            } catch (IOException e) {
                log.error("[下载文件] 写入失败:", e);
                return false;
            }
        } else {
            return false;
        }

    }


    public static void main(String[] args) {
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("ProductName", "ProductPackaging");
        //map.add("FileUrl", "http://10.0.82.75:8087/hwagain-mail/bb.xls");
        //map.add("FileUrl", "http://10.0.82.75:8087/hwagain-mail/abc.dwg");
        map.add("FileUrl", "http://10.0.82.75:8087/hwagain-mail/abc.doc");

        //System.out.println(doPost("http://10.0.216.200:8090/DecryptFileToPhone.aspx?ProductName=ProductPackaging&FileUrl=http://10.0.82.75:8087/hwagain-mail/1e60370d-4b97-43ba-8a36-9e5b9b3eb96b+++++出差林场补助5月.xlsx", map));
//        System.out.println(doPost("http://10.0.216.200:8090/DecryptFileToPhone.aspx?ProductName=ProductPackaging&FileUrl=http://10.0.82.75:8087/hwagain-mail/出差林场补助5月.xlsx", map));
        System.out.println(doPost("http://10.0.216.200:8090/DecryptFileToPhone.aspx", map));

        //downloadLittleFileToPath("http://10.0.216.200:8090/OaFiles/0123456789.dwg","G:/0123456789.dwg");
    }


    public void test() throws IOException, InterruptedException {
        //文件名
        String attachment = "00你还9.jpg";
        String attachmentPath = "D://aa";
        //直接访问的网址
        String sendAttachmentPath = "http://oa.....";
        //解密服务器的接口网址
        String uploadPre = "http://10.0.216.200:8090/DecryptFileToPhone.aspx";
        String downloadPre = "http://10.0.216.200:8090/OaFiles/";
        String aName = attachment.toLowerCase();
        //if (aName.endsWith(".pdf") || aName.endsWith(".doc") || aName.endsWith(".docx") || aName.endsWith(".xlsx") || aName.endsWith(".xls")){
        if (!aName.endsWith(".txt")){

            //复制文档，解密服务器不支持中文名
            String houzhui = attachment.substring(attachment.lastIndexOf("."));
            String newName = ContentUtils.random5()+houzhui;
            Files.copy(Paths.get(attachmentPath + attachment), Paths.get(attachmentPath+ newName));

            MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
            map.add("ProductName", "ProductPackaging");
            map.add("FileUrl", sendAttachmentPath + newName);
            int statusCode = UploadUtils.doPost(uploadPre, map);
            boolean isUpload = false;
            if (statusCode == 200){
                Files.deleteIfExists(Paths.get(attachmentPath+ newName));
                isUpload = true;
            }

            if (isUpload){
                //外发邮件需要给时间附件解密
                Thread.sleep(5000);
                UploadUtils.downloadLittleFileToPath(downloadPre + newName,"");
            }
        }
    }


}
