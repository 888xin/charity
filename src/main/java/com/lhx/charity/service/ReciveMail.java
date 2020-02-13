//package com.hwagain.mail.service;
//
//import com.sun.org.apache.xml.internal.security.utils.Base64;
//
//import java.io.BufferedInputStream;
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.InputStream;
//import java.security.Security;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Properties;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import javax.mail.BodyPart;
//import javax.mail.Flags;
//import javax.mail.Folder;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Multipart;
//import javax.mail.Part;
//import javax.mail.Session;
//import javax.mail.Store;
//import javax.mail.URLName;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeUtility;
//
//
//
//public class ReciveMail {
//    private static Pattern encodeStringPattern = Pattern.compile(
//            "=\\?(.+)\\?(B|Q)\\?(.+)\\?=", 34);
//    private static Pattern subjectStringPattern = Pattern.compile(
//            "(?:.*?)(=\\?(?:.*?)\\?(?:B|Q)\\?(?:.*?)\\?=)(?:.*?)", 34);
//    private static Pattern subjectRepeatedStringPattern = Pattern
//            .compile(
//                    "(?:.*?)(?:(=\\?(?:.*?)\\?(?:B|Q))\\?(?:.*?)(\\?=(?:.*?)(=\\?(?:.*?)\\?(?:B|Q))\\?)(?:.*?)\\?=)(?:.*?)",
//                    34);
//    private MimeMessage mimeMessage = null;
//    private String saveAttachPath = ""; // 附件下载后的存放目录
//    private StringBuffer bodytext = new StringBuffer();// 存放邮件内容
//    private String dateformat = "yy-MM-dd HH:mm"; // 默认的日前显示格式
//
//    public ReciveMail(MimeMessage mimeMessage) {
//        this.mimeMessage = mimeMessage;
//    }
//
//    public void setMimeMessage(MimeMessage mimeMessage) {
//        this.mimeMessage = mimeMessage;
//    }
//
//    /**
//     * 获得发件人的地址和姓名
//     */
//    public String getFrom() throws Exception {
//        InternetAddress address[] = (InternetAddress[]) mimeMessage.getFrom();
//        String from = address[0].getAddress();
//        if (from == null)
//            from = "";
//        String personal = address[0].getPersonal();
//        if (personal == null)
//            personal = "";
//        String fromaddr = personal + "<" + from + ">";
//        return fromaddr;
//    }
//
//    /**
//     * 获得邮件的收件人，抄送，和密送的地址和姓名，根据所传递的参数的不同 "to"----收件人 "cc"---抄送人地址 "bcc"---密送人地址
//     */
//    public String getMailAddress(String type) throws Exception {
//        String mailaddr = "";
//        String addtype = type.toUpperCase();
//        InternetAddress[] address = null;
//        if (addtype.equals("TO") || addtype.equals("CC")
//                || addtype.equals("BCC")) {
//            if (addtype.equals("TO")) {
//                address = (InternetAddress[]) mimeMessage
//                        .getRecipients(Message.RecipientType.TO);
//            } else if (addtype.equals("CC")) {
//                address = (InternetAddress[]) mimeMessage
//                        .getRecipients(Message.RecipientType.CC);
//            } else {
//                address = (InternetAddress[]) mimeMessage
//                        .getRecipients(Message.RecipientType.BCC);
//            }
//            if (address != null) {
//                for (int i = 0; i < address.length; i++) {
//                    String email = address[i].getAddress();
//                    if (email == null)
//                        email = "";
//                    else {
//                        email = MimeUtility.decodeText(email);
//                    }
//                    String personal = address[i].getPersonal();
//                    if (personal == null)
//                        personal = "";
//                    else {
//                        personal = MimeUtility.decodeText(personal);
//                    }
//                    String compositeto = personal + "<" + email + ">";
//                    mailaddr += "," + compositeto;
//                }
//                mailaddr = mailaddr.substring(1);
//            }
//        } else {
//            throw new Exception("Error emailaddr type!");
//        }
//        return mailaddr;
//    }
//
//    /**
//     * 获得邮件主题
//     */
//    public String getSubject() throws MessagingException {
//        String subject = "";
//        try {
//            subject = MimeUtility.decodeText(mimeMessage.getSubject());
//            if (subject == null)
//                subject = "";
//        } catch (Exception exce) {
//        }
//        return subject;
//    }
//
//    /**
//     * 获得邮件发送日期
//     */
//    public String getSentDate() throws Exception {
//        Date sentdate = mimeMessage.getSentDate();
//        SimpleDateFormat format = new SimpleDateFormat(dateformat);
//        return format.format(sentdate);
//    }
//
//    /**
//     * 获得邮件正文内容
//     */
//    public String getBodyText() {
//        return bodytext.toString();
//    }
//
//    /**
//     * 解析邮件，把得到的邮件内容保存到一个StringBuffer对象中，解析邮件 主要是根据MimeType类型的不同执行不同的操作，一步一步的解析
//     */
//    public void getMailContent(Part part) throws Exception {
//        String contenttype = part.getContentType();
//        int nameindex = contenttype.indexOf("name");
//        boolean conname = false;
//        if (nameindex != -1)
//            conname = true;
//        System.out.println("CONTENTTYPE: " + contenttype);
//        if (part.isMimeType("text/plain") && !conname) {
//            bodytext.append((String) part.getContent());
//        } else if (part.isMimeType("text/html") && !conname) {
//            bodytext.append((String) part.getContent());
//        } else if (part.isMimeType("multipart/*")) {
//            Multipart multipart = (Multipart) part.getContent();
//            int counts = multipart.getCount();
//            for (int i = 0; i < counts; i++) {
//                getMailContent(multipart.getBodyPart(i));
//            }
//        } else if (part.isMimeType("message/rfc822")) {
//            getMailContent((Part) part.getContent());
//        } else {
//        }
//    }
//
//    /**
//     * 判断此邮件是否需要回执，如果需要回执返回"true",否则返回"false"
//     */
//    public boolean getReplySign() throws MessagingException {
//        boolean replysign = false;
//        String needreply[] = mimeMessage
//                .getHeader("Disposition-Notification-To");
//        if (needreply != null) {
//            replysign = true;
//        }
//        return replysign;
//    }
//
//    /**
//     * 获得此邮件的Message-ID
//     */
//    public String getMessageId() throws MessagingException {
//        return mimeMessage.getMessageID();
//    }
//
//    /**
//     * 【判断此邮件是否已读，如果未读返回返回false,反之返回true】
//     */
//    public boolean isNew() throws MessagingException {
//        boolean isnew = false;
//        Flags flags = ((Message) mimeMessage).getFlags();
//        Flags.Flag[] flag = flags.getSystemFlags();
//        System.out.println("flags's length: " + flag.length);
//        for (int i = 0; i < flag.length; i++) {
//            if (flag[i] == Flags.Flag.SEEN) {
//                isnew = true;
//                System.out.println("seen Message.......");
//                break;
//            }
//        }
//        return isnew;
//    }
//
//    /**
//     * 判断此邮件是否包含附件
//     */
//    public boolean isContainAttach(Part part) throws Exception {
//        boolean attachflag = false;
//        if (part.isMimeType("multipart/*")) {
//            Multipart mp = (Multipart) part.getContent();
//            for (int i = 0; i < mp.getCount(); i++) {
//                BodyPart mpart = mp.getBodyPart(i);
//                String disposition = mpart.getDisposition();
//                if ((disposition != null)
//                        && ((disposition.equals(Part.ATTACHMENT)) || (disposition
//                        .equals(Part.INLINE))))
//                    attachflag = true;
//                else if (mpart.isMimeType("multipart/*")) {
//                    attachflag = isContainAttach((Part) mpart);
//                } else {
//                    String contype = mpart.getContentType();
//                    if (contype.toLowerCase().indexOf("application") != -1)
//                        attachflag = true;
//                    if (contype.toLowerCase().indexOf("name") != -1)
//                        attachflag = true;
//                }
//            }
//        } else if (part.isMimeType("message/rfc822")) {
//            attachflag = isContainAttach((Part) part.getContent());
//        }
//        return attachflag;
//    }
//
//    /**
//     * 【保存附件】
//     */
//    public String[] saveAttachMent(Part part) throws Exception {
//        String fileNames[] = null;
//        if (part.isMimeType("multipart/*")) {
//            Multipart mp = (Multipart) part.getContent();
//            fileNames=new String[mp.getCount()];
//            for (int i = 0; i < mp.getCount(); i++) {
//                BodyPart mpart = mp.getBodyPart(i);
//                String disposition = mpart.getDisposition();
//                if ((disposition != null)
//                        && ((disposition.equals(Part.ATTACHMENT)) || (disposition
//                        .equals(Part.INLINE)))) {
//                    fileNames[i] = mpart.getFileName();
//                    if(fileNames[i]!=null ){
//                        if ((fileNames[i].toLowerCase().indexOf("gb") != -1)|| (fileNames[i].toLowerCase().indexOf("utf") != -1)){
//                            fileNames[i] = getDecodeText(fileNames[i]);
//                        }else{
//                            fileNames[i] = new String(fileNames[i].getBytes("iso-8859-1"),"GBK");
//                        }
//                        fileNames[i]=saveFile(fileNames[i], mpart.getInputStream());
//                    }
//                } else if (mpart.isMimeType("multipart/*")) {
//                    saveAttachMent(mpart);
//                } else {
//                    fileNames[i] = mpart.getFileName();
//                    if ((fileNames[i] != null)
//                            && (fileNames[i].toLowerCase().indexOf("GBK") != -1)) {
//                        fileNames[i] = MimeUtility.decodeText(fileNames[i]);
//                        fileNames[i]=saveFile(fileNames[i], mpart.getInputStream());
//                    }
//                }
//            }
//        } else if (part.isMimeType("message/rfc822")) {
//            saveAttachMent((Part) part.getContent());
//        }
//        return fileNames;
//    }
//
//    /**
//     * 【设置附件存放路径】
//     */
//
//    public void setAttachPath(String attachpath) {
//        this.saveAttachPath = attachpath;
//    }
//
//    /**
//     * 【设置日期显示格式】
//     */
//    public void setDateFormat(String format) throws Exception {
//        this.dateformat = format;
//    }
//
//    /**
//     * 【获得附件存放路径】
//     */
//    public String getAttachPath() {
//        return saveAttachPath;
//    }
//
//    /**
//     * 【真正的保存附件到指定目录里】
//     */
//    private String saveFile(String fileName, InputStream in) throws Exception {
//        String osName = System.getProperty("os.name");
//        String storedir = getAttachPath();
//        String separator = "";
//        if (osName == null)
//            osName = "";
//        if (osName.toLowerCase().indexOf("win") != -1) {
//            separator = "\\";
//            if (storedir == null || storedir.equals(""))
//                storedir = "c:\\tmp";
//        } else {
//            separator = "/";
//            storedir = "/tmp";
//        }
//        File storefile = new File(storedir + separator + fileName);
//        System.out.println("storefile's path: " + storefile.toString());
//        // for(int i=0;storefile.exists();i++){
//        // storefile = new File(storedir+separator+fileName+i);
//        // }
//        BufferedOutputStream bos = null;
//        BufferedInputStream bis = null;
//        try {
//            bos = new BufferedOutputStream(new FileOutputStream(storefile));
//            bis = new BufferedInputStream(in);
//            int c;
//            while ((c = bis.read()) != -1) {
//                bos.write(c);
//                bos.flush();
//            }
//        } catch (Exception exception) {
//            exception.printStackTrace();
//            throw new Exception("文件保存失败!");
//        } finally {
//            bos.close();
//            bis.close();
//        }
//        return fileName;
//    }
//
////    public static List<MailContent> reviceMail(Mail mail,String attachmentBasePath,String relativePath) throws Exception {
////        List<MailContent> mailContentList=null;
////        Store store=null;
////        if(mail.getMailAddr().endsWith("qq.com")){
////            store=getQQSSLStore(mail);
////        }
////        else{
////            store=getStore(mail);
////        }
////        if(store==null){
////            return null;
////        }
////        try{
////            store.connect();
////        }catch(MessagingException e){
////            System.out.println("pop3连接失败");
////            return null;
////        }
////        Folder folder = store.getFolder("INBOX");
////        folder.open(Folder.READ_ONLY);
////        Message message[] = folder.getMessages();
////        ReciveMail pmm = null;
////        if(message!=null&&message.length>0){
////            mailContentList=new ArrayList<MailContent>();
////            MailContent content=null;
////            for (int i = 0; i < message.length; i++) {
////                content=new MailContent();
////                pmm = new ReciveMail((MimeMessage) message[i]);
////                content.setSubject(pmm.getSubject().replaceAll("<", "[").replaceAll(">", "]"));
////                content.setSendDate(pmm.getSentDate());
////                content.setReplySign(pmm.getReplySign()?"1":"0");
////                content.setIsNew(pmm.isNew()?"1":"0");
////                content.setIsContainAttach(pmm.isContainAttach((Part) message[i])?"1":"0");
////                content.setSenderInfo(pmm.getFrom().replaceAll("<", "[").replaceAll(">", "]"));
////                content.setReciveInfo(pmm.getMailAddress("to").replaceAll("<", "[").replaceAll(">", "]"));
////                content.setCopyInfo(pmm.getMailAddress("cc").replaceAll("<", "[").replaceAll(">", "]"));
////                content.setSecretInfo(pmm.getMailAddress("bcc").replaceAll("<", "[").replaceAll(">", "]"));
////                pmm.setDateFormat("yyyy-MM-dd HH:mm");
////                content.setSendDate(pmm.getSentDate());
////                content.setMessageID(pmm.getMessageId());
////                content.setIsInner("0");
////                // 获得邮件内容===============
////                pmm.getMailContent((Part) message[i]);
////                content.setContent(pmm.getBodyText());
////                content.setType("收件");
////                if("1".equals(content.getIsContainAttach())){
////                    pmm.setAttachPath(attachmentBasePath);
////                    String attachmentPaths[]=pmm.saveAttachMent((Part) message[i]);
////                    if(attachmentPaths!=null&&attachmentPaths.length>0){
////                        StringBuilder sb=new StringBuilder();
////                        for(String s:attachmentPaths){
////                            if(s!=null)
////                                sb.append(relativePath+s+",");
////                        }
////                        content.setAttachPath(sb.toString());
////                    }
////                }
////                content.setMail(mail);
////                mailContentList.add(content);
////            }
////        }
////        return mailContentList;
////    }
////
////
////
////    public static List<ExternalReceiveMailContent> reciveMailByexternal(Mail mail,String attachmentBasePath,String relativePath) throws Exception {
////        List<ExternalReceiveMailContent> mailContentList=null;
////        Store store=null;
////        if(mail.getMailAddr().endsWith("qq.com")){
////            store=getQQSSLStoreIMap(mail);
////        }else{
////            store=getIMapStore(mail);
////        }
////        if(store==null){
////            return null;
////        }
////        try{
////            store.connect();
////        }catch(MessagingException e){
////            System.out.println("连接失败");
////            return null;
////        }
////        IMAPFolder folder = (IMAPFolder) store.getFolder("INBOX");
////        folder.open(Folder.READ_ONLY);
////        //Message message[] = folder.getMessages();
////        //获取未读邮件
////        Message[] message = folder.getMessages(folder.getMessageCount()-folder.getUnreadMessageCount()+1,folder.getMessageCount());
////        ReciveMail pmm = null;
////        if(message!=null&&message.length>0){
////            mailContentList=new ArrayList<ExternalReceiveMailContent>();
////            ExternalReceiveMailContent content=null;
////            for (int i = 0; i <1; i++) {
////                content=new ExternalReceiveMailContent();
////                //pmm = new ReciveMail((MimeMessage) message[i]);
////                Message msg = folder.getMessageByUID(folder.getUID( message[i]));
////                content.setMailId(mail.getId());
////                pmm = new ReciveMail((MimeMessage)msg);
////                content.setSubject(pmm.getSubject().replaceAll("<", "[").replaceAll(">", "]"));
////                content.setSendDate(pmm.getSentDate());
////                content.setReplySign(pmm.getReplySign()?"1":"0");
////                content.setIsNew(pmm.isNew()?"1":"0");
////                content.setIsContainAttach(pmm.isContainAttach((Part) message[i])?"1":"0");
////                if(pmm.getFrom().indexOf("<")>-1){
////                    content.setSenderInfo(pmm.getFrom().split("<")[0]);
////                    content.setSecretAddr(pmm.getFrom().split("<")[1].replace(">", "").trim());
////                }else{
////                    content.setSenderInfo(pmm.getFrom().replaceAll("<", "").replaceAll(">", ""));
////                }
////                if(pmm.getMailAddress("to").indexOf("<")>-1){
////                    content.setReciveInfo(pmm.getMailAddress("to").split("<")[0]);
////                    content.setReciveAddr(pmm.getMailAddress("to").split("<")[1].replace(">", "").trim());
////                }else{
////                    content.setReciveInfo(pmm.getMailAddress("to").replaceAll("<", "").replaceAll(">", ""));
////                }
////                if(pmm.getMailAddress("cc").indexOf("<")>-1){
////                    content.setCopyInfo(pmm.getMailAddress("cc").split("<")[0]);
////                    content.setCopyAddr(pmm.getMailAddress("cc").split("<")[1].replace(">", "").trim());
////                }else{
////                    content.setCopyInfo(pmm.getMailAddress("cc").replaceAll("<", "").replaceAll(">", ""));
////                }
////                if(pmm.getMailAddress("cc").indexOf("<")>-1){
////                    content.setSecretInfo(pmm.getMailAddress("bcc").split("<")[0]);
////                    content.setSecretAddr(pmm.getMailAddress("bcc").split("<")[1].replace(">", "").trim());
////                }else{
////                    content.setSecretInfo(pmm.getMailAddress("bcc").replaceAll("<", "").replaceAll(">", ""));
////                }
////                pmm.setDateFormat("yyyy-MM-dd HH:mm");
////                content.setSendDate(pmm.getSentDate());
////                content.setMessageID(pmm.getMessageId());
////                // 获得邮件内容===============
////                pmm.getMailContent((Part) message[i]);
////                content.setContent(pmm.getBodyText());
////                //content.setMail(mail);
////                //message[i].setFlag(Flags.Flag.SEEN, true);
////
////                if("1".equals(content.getIsContainAttach())){
////                    pmm.setAttachPath(attachmentBasePath);
////                    String attachmentPaths[]=pmm.saveAttachMent((Part) message[i]);
////                    if(attachmentPaths!=null&&attachmentPaths.length>0){
////                        StringBuilder sb=new StringBuilder();
////                        for(String s:attachmentPaths){
////                            if(s!=null)
////                                sb.append(relativePath+s+",");
////                        }
////                        content.setAttachPath(sb.toString());
////                    }
////                }
////                mailContentList.add(content);
////            }
////        }
////        return mailContentList;
////    }
//    /**
//     * qq邮箱需要建立ssl连接才能接收邮件 pop3方式
//     * */
////    public static Store getQQSSLStoreIMap(Mail mail) throws Exception {
////        // 创建一个有具体连接信息的Properties对象
////        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
////        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
////        Properties props = System.getProperties();
////        props.setProperty("mail.imap.socketFactory.class", SSL_FACTORY);
////        props.setProperty("mail.imap.socketFactory.fallback", "false");
////        props.setProperty("mail.imap.port", "143");
////        props.setProperty("mail.imap.socketFactory.port", "993");
////        Session session = Session.getInstance(props);
////        URLName urln = new URLName("imap", mail.getPop3Server(), mail.getPop3Port(), null,mail.getMailAddr(),mail.getMailPassWord());
////        Store store = session.getStore(urln);
////        return store;
////    }
//
//
//    /**
//     * 返回非ssl连接 IMap4
//     * @param mail
//     * @return
//     * @throws Exception
//     */
////    public static Store getIMapStore(Mail mail)throws Exception {
////        Properties props = new Properties();
////        props.setProperty("mail.store.protocol", "imap");
////        props.setProperty("mail.imap.host", mail.getPop3Server());
////        props.setProperty("mail.imap.port", GlobalFunc.toString(mail.getPop3Port()));
////        Session session = Session.getInstance(props);
////        URLName urln = new URLName("imap", mail.getPop3Server(), mail.getPop3Port(), null,mail.getMailAddr(),mail.getMailPassWord());
////        Store store = session.getStore(urln);
////        return store;
////    }
////
////
////
////    /**
////     * qq邮箱需要建立ssl连接才能接收邮件 pop3方式
////     * */
////    public static Store getQQSSLStore(Mail mail) throws Exception {
////        // 创建一个有具体连接信息的Properties对象
////        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
////        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
////        Properties props = System.getProperties();
////        props.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY);
////        props.setProperty("mail.pop3.socketFactory.fallback", "false");
////        props.setProperty("mail.pop3.port", "465");
////        props.setProperty("mail.pop3.socketFactory.port", "995");
////        Session session = Session.getInstance(props);
////        URLName urln = new URLName("pop3", mail.getPop3Server(), mail.getPop3Port(), null,mail.getMailAddr(),mail.getMailPassWord());
////        Store store = session.getStore(urln);
////        return store;
////    }
//
//
//    /**
//     * 返回非ssl连接
//     * */
////    public static Store getStore(Mail mail) throws Exception {
////        Properties props = System.getProperties();
////        props.put("mail.smtp.host", mail.getSmtpServer());
////        props.put("mail.smtp.auth", "true");
////        Session session = Session.getInstance(props, null);
////        URLName urln = new URLName("pop3", mail.getPop3Server(), 110, null,
////                mail.getMailAddr(), mail.getMailPassWord());
////        Store store = session.getStore(urln);
////        return store;
////    }
//    /**
//     * PraseMimeMessage类测试
//     */
//    public static void main(String args[]) throws Exception {
//        Properties props = System.getProperties();
//        props.put("mail.smtp.host", "smtp.163.com");
//        props.put("mail.smtp.auth", "true");
//        Session session = Session.getDefaultInstance(props, null);
//        URLName urln = new URLName("pop3", "pop3.163.com", 110, null,
//                "sherlock_001@163.com", "moshu521");
//        Store store = session.getStore(urln);
//        store.connect();
//        Folder folder = store.getFolder("INBOX");
//        folder.open(Folder.READ_ONLY);
//        Message message[] = folder.getMessages();
//        System.out.println("Messages's length: " + message.length);
//        ReciveMail pmm = null;
//        for (int i = 0; i < message.length; i++) {
//            System.out.println("======================");
//            pmm = new ReciveMail((MimeMessage) message[i]);
//            System.out
//                    .println("Message " + i + " subject: " + pmm.getSubject());
//            System.out.println("Message " + i + " sentdate: "
//                    + pmm.getSentDate());
//            System.out.println("Message " + i + " replysign: "
//                    + pmm.getReplySign());
//            System.out.println("Message " + i + " hasRead: " + pmm.isNew());
//            System.out.println("Message " + i + "  containAttachment: "
//                    + pmm.isContainAttach((Part) message[i]));
//            System.out.println("Message " + i + " form: " + pmm.getFrom());
//            System.out.println("Message " + i + " to: "
//                    + pmm.getMailAddress("to"));
//            System.out.println("Message " + i + " cc: "
//                    + pmm.getMailAddress("cc"));
//            System.out.println("Message " + i + " bcc: "
//                    + pmm.getMailAddress("bcc"));
//            pmm.setDateFormat("yy年MM月dd日 HH:mm");
//            System.out.println("Message " + i + " sentdate: "
//                    + pmm.getSentDate());
//            System.out.println("Message " + i + " Message-ID: "
//                    + pmm.getMessageId());
//            // 获得邮件内容===============
//            pmm.getMailContent((Part) message[i]);
//            System.out.println("Message " + i + " bodycontent: \r\n"
//                    + pmm.getBodyText());
//            pmm.setAttachPath("c:\\");
//            pmm.saveAttachMent((Part) message[i]);
//        }
//    }
//
//    public String getDecodeText(String temp) {
//        try {
//            StringBuffer subject = new StringBuffer();
//            subject.append(temp);
//            Matcher m = subjectRepeatedStringPattern.matcher(subject);
//            while (m.find()) {
//                if (m.group(1).equals(m.group(3)))
//                    subject.replace(m.start(2), m.end(2), "");
//
//                m.reset();
//            }
//            m = subjectStringPattern.matcher(subject);
//            int end = 0;
//            int end2 = 0;
//            if (m.matches()) {
//                while (m.find(end)) {
//                    Matcher m2 = encodeStringPattern.matcher(m.group(1)
//                            .replaceAll("\\s", ""));
//                    while (m2.find())
//                        if (m2.group(1).toLowerCase().indexOf("gb") > -1) {
//                            if (m2.group(2).toLowerCase().equals("b"))
//                                temp = new String(Base64
//                                        .decode(m2.group(3)), "GBK");
//                            else
//                                temp = MimeUtility.decodeText(m.group(1)
//                                        .replaceAll("\\s", ""));
//                        } else if (m2.group(1).toLowerCase().indexOf("utf") > -1) {
//                            temp = MimeUtility.decodeText(m.group(1)
//                                    .replaceAll("\\s", ""));
//                        } else {
//                            if (m2.group(1).toLowerCase().indexOf("x-unknown") > -1)
//                                return getDecodeText(temp.replace("x-unknown",
//                                        "gbk"));
//
//                            temp = MimeUtility.decodeText(m.group(1)
//                                    .replaceAll("\\s", ""));
//                        }
//
//                    subject.replace(m.start(1), m.end(1), temp);
//                    if (m.start(1) > end) {
//                        end2 = temp.length();
//                        temp = new String(subject.substring(end, m.start(1))
//                                .getBytes("iso-8859-1"), "GBK");
//                        subject.replace(end, m.start(1), temp);
//                        end += temp.length() + end2;
//                    } else {
//                        end += temp.length();
//                    }
//                }
//                if (subject.length() > end)
//                    subject.replace(end, subject.length(), new String(subject
//                            .substring(end, subject.length()).getBytes(
//                                    "iso-8859-1"), "GBK"));
//
//                return subject.toString().replaceAll("\\t|\\n|\\x0B|\\f|\\r",
//                        "");
//            }
//            return new String(temp.getBytes("iso-8859-1"), "GBK");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "";
//    }
//}
