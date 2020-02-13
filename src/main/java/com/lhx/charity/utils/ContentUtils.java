package com.lhx.charity.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.StringUtils;

import java.beans.PropertyDescriptor;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class ContentUtils {

    public static boolean isValidate(Object ... objs){
        for (Object obj : objs) {
            if (obj instanceof String){
                String s = (String) obj;
                if (StringUtils.isEmpty(s)){
                    return true;
                }
            } else {
                if (obj == null){
                    return true;
                }
            }
        }
        return false;
    }


    public static Date dateToDate(String date) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date ld = df.parse(date);
            return ld;
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
            return null ;
        }
    }

    public static Date dateToDate2(String date) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date ld = df.parse(date);
            return ld;
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
            return null ;
        }
    }

    public static String dateToDateStr(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String ld = df.format(date);
        return ld;
    }

    public static String dateToDateStr2(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
        String ld = df.format(date);
        return ld;
    }

    public static String dateToDateStr3(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
        String ld = df.format(date);
        return ld;
    }

    public static LocalDate dateToLocalDate(Date date){
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalDate();
    }

    public static LocalDateTime dateToLocalDateTime(Date date){
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime;
    }


    public static String createTreeAge(Date platDate) {
        LocalDate now = LocalDate.now();
        LocalDate beforeLocalDate = ContentUtils.dateToLocalDate(platDate);
        YearMonth before = YearMonth.of(beforeLocalDate.getYear(),beforeLocalDate.getMonth());
        YearMonth after = YearMonth.of(now.getYear(), 6);
        int month = after.getMonthValue() - before.getMonthValue();
        int year = after.getYear() - before.getYear();
        String treeAge = String.format("%.1f", year+(month/12.0));
        return treeAge;
    }


    public static Date localDateToUdate(LocalDate localDate) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);
        return date;
    }

    public static  String random5(){
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for( int i = 0; i < 6; i ++) {
            int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; // 取得大写还是小写
            stringBuilder.append((char)(choice + random.nextInt(26)));
        }
        return stringBuilder.toString();
    }

    public static String base64Decode(String str){
        final Base64.Decoder decoder = Base64.getDecoder();
        final byte[] textByte = str.getBytes(StandardCharsets.UTF_8);
        //解码
        return new String(decoder.decode(textByte), StandardCharsets.UTF_8);
    }

    public static String base64Encode(String str){
        final Base64.Encoder encoder = Base64.getEncoder();
        final byte[] textByte = str.getBytes(StandardCharsets.UTF_8);
        //编码
        return encoder.encodeToString(textByte);
    }

    public static boolean isBase64(String str) {
        String base64Pattern = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$";
        return Pattern.matches(base64Pattern, str);
    }




    /**
     * 将目标源中不为空的字段过滤，将数据库中查出的数据源复制到提交的目标源中
     *
     * @param source 用id从数据库中查出来的数据源
     * @param target 提交的实体，目标源
     */
    public static void copyNullProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target, getNoNullProperties(target));
    }

    /**
     * @param target 目标源数据
     * @return 将目标源中不为空的字段取出
     */
    private static String[] getNoNullProperties(Object target) {
        BeanWrapper srcBean = new BeanWrapperImpl(target);
        PropertyDescriptor[] pds = srcBean.getPropertyDescriptors();
        Set<String> noEmptyName = new HashSet<>();
        for (PropertyDescriptor p : pds) {
            Object value = srcBean.getPropertyValue(p.getName());
            if (value != null) noEmptyName.add(p.getName());
        }
        String[] result = new String[noEmptyName.size()];
        return noEmptyName.toArray(result);
    }


    public static String deRegularExpression(String content) {

        content = deRegularScript(content); // 过滤script标签

        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
        /* String regEx_inStyle = "style=\"([^\";]+;?)+\""; */
        String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(content);
        content = m_style.replaceAll(""); // 过滤style标签

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(content);
        content = m_html.replaceAll(" "); // 过滤html标签

        // 去除&nbsp;
        Pattern pattern = Pattern.compile("&nbsp;");
        Matcher matcher = pattern.matcher(content);
        content = matcher.replaceAll(" ");

        return content.trim(); // 返回文本字符串
    }


    public static String deRegularScript(String content) {
        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式

        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(content);
        return m_script.replaceAll(""); // 过滤script标签
    }


    public static boolean isValidFileName(String fileName) {
        if (fileName == null || fileName.length() > 255)
            return false;
        else
            return fileName.matches("[^\\s\\\\/:\\*\\?\\\"<>\\|](\\x20|[^\\s\\\\/:\\*\\?\\\"<>\\|])*[^\\s\\\\/:\\*\\?\\\"<>\\|\\.]$");
    }

    public static String returnRightFileName(String fileName) {
        if (fileName == null){
            return null;
        } else if (fileName.length() > 255){
            return fileName.substring(0,254);
        } else {
            if (fileName.matches("[^\\s\\\\/:\\*\\?\\\"<>\\|](\\x20|[^\\s\\\\/:\\*\\?\\\"<>\\|])*[^\\s\\\\/:\\*\\?\\\"<>\\|\\.]$")){

                return fileName;
            } else {
                Pattern pattern = Pattern.compile("[\\s\\\\/:\\*\\?\\\"<>\\|]");
                Matcher matcher = pattern.matcher(fileName);
                fileName= matcher.replaceAll(""); // 将匹配到的非法字符以空替换
                return fileName;
            }
        }
    }




    public static void main(String[] args) {
        //System.out.println(deRegularExpression("<p>sdfsdfsdf</p>"));
//        System.out.println(isValidFileName("TO<金 牌 销 售 训 练>.docx"));
//        System.out.println(isValidFileName("TO金 牌 销 售 训 练.docx"));
//        Pattern pattern = Pattern.compile("[\\s\\\\/:\\*\\?\\\"<>\\|]");
//
//
//        String fileName = "TO金 牌 销 售 训 练.docx";
//      Matcher matcher = pattern.matcher(fileName);
//
//
//      fileName= matcher.replaceAll(""); // 将匹配到的非法字符以空替换
//        System.out.println(fileName);
//        System.out.println(returnRightFileName("<456456htrhr.docx"));
        System.out.println(random5());
    }

}
