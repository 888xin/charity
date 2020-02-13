package com.lhx.charity.utils;

/**
 * 使用的一些常量
 */
public class Constants {


    public static final int BAD = 1001;
    public static final int INIT = 0;
    public static final String IS_PAY = "已支付";
    //无权限
    public static final int NO_AUTHORITY = 1002;
    public static final int NO_LOGIN_CODE = 1003;
    public static final int OK = 1000;
    public static final int OVER = 1;
    public static final int PAGE_NUM = 1000;
    //发送频率十分钟限制
    public static final int RATE_LENGTH = 10;

    public static final String SUFFIX = ".eml";

    public static final String MAIL_FORWARD = "邮件转发";

    public static final String REDIS_MAIL_ADDRESS = "mail:address";
    public static final String REDIS_MAIL_TYPE = "mail:type";
    public static final String REDIS_MAIL_MONTH = "mail:month";
    //已经外发过的人
    public static final String REDIS_MAIL_SEND_PERSON = "mail:person";
    //已经外发过的单位
    public static final String REDIS_MAIL_SEND_UNIT = "mail:unit";
    //已经外发过的邮箱地址
    public static final String REDIS_MAIL_SEND_ADDRESS = "mail:sendAddr";
    //统计回函收到的数量，倒计
    public static final String REDIS_MAIL_RECEIVE_NUM = "mail:receiveNum";
    //接收邮件数据备份
    public static final String REDIS_MAIL_SAVE = "mail:save";
    public static final String REDIS_MAIL_NET_SAVE = "mail:net:save";
    public static final String REDIS_BIDDING_PERSON= "招投标潜在用户群";
    public static final String REDIS_MAIL_AUTHORITY= "mail:authority";
    public static final String REDIS_MAIL_PERSON_LEVEL= "mail:level";
    //发送失败的部门邮箱
    public static final String REDIS_MAIL_FAILDEPT= "mail:failDept";
    //发送频率限制
    public static final String REDIS_MAIL_RATE= "mail:rate";

    //public static final String MAIL = "[a-zA-Z0-9_-]+@\\w+\\.[a-z]+(\\.[a-z]+)?";
//    public static final String MAIL = "[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+";
    public static final String MAIL = "[A-Za-z0-9][\\w\\-\\.]{1,12}@([\\w\\-]+\\.)+[\\w]{2,3}";


    public static final String SPLIT = "%#####_#####%";
    public static final String SPLIT2 = "+++++";
    public static final String SPLIT22 = "\\+\\+\\+\\+\\+";
    //外发邮件供应部加上唯一编码的分隔符
    public static final String SPLIT3 = "#";


    public static final String REDIS_MAIL_DEDUCT= "mail:deduct";
    public static final String REDIS_MAIL_DISTRIBUTE= "mail:distribute";
    //邮件存档扣款提示
    public static final String MSG_PROPECTIVE_LDEDUCT_TYPE = "mailPropectiveDeduct";
    //邮件存档扣款提示
    public static final String MSG_DEDUCT_TYPE = "mailDeduct";
    //邮件派发提示信息
    public static final String MSG_DISTRIBUTE_TYPE = "mailDistribute";
    //邮件处理任务提示信息
    public static final String MSG_HANDLE_TYPE = "mailHandle";



    //超级管理员ID
    public static final String SUPER_ADMIN_ID = "2";

    //经理级number
    public static final int MANAGE_NUMBER = 12;
    //总经理级number
    public static final int MAIN_MANAGE_NUMBER = 6;
    //经理级以下超期扣款
    public static final int BELOW_DEDUCT_MONEY = 10;
    public static final int BELOW_EVERY_DAY_DEDUCT_MONEY = 10;
    //经理级以上超期扣款
    public static final int HIGH_DEDUCT_MONEY = 20;
    public static final int HIGH_EVERY_DAY_DEDUCT_MONEY = 10;


    public static final int HIGH_ASSIGN_DEDUCT_MONEY = 10;
    public static final int HIGH_EVERY_DAY_ASSIGN_DEDUCT_MONEY = 10;

    public static final int HIGH_HANDLE_DEDUCT_MONEY = 10;
    public static final int HIGH_EVERY_DAY_HANDLE_DEDUCT_MONEY = 10;

    public static final int ASSIGN_DAYS = 3;

    //个人和部门id的分界点
    public static final int PERSON0DEPT = 110000000;
    //不用分派和分派部门id的分界点
    public static final int PERSON0DEPT2 = 150000000;




    public enum AddressType {

        UNIT("单位"),
        PERSON("收件人"),
        ADDRESS("邮箱地址");

        private final String name;

        AddressType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    //0初始 1提交Oa 2通过 3未通过 4已发送 5退回初始节点
    public enum SendStatus {

        INIT("初始"),
        SUBMIT("提交"),
        PASS("通过"),
        NOPASS("未通过"),
        SENDED("已发送"),
        BACK_INIT("退回初始节点"),
        DONGING("审批中");

        private final String name;

        SendStatus(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    //0初始 1待处理 2通过 3未通过 4已发送 5退回初始节点
    public enum AssignStatus {

        INIT("待分派"),
        PENDING("待处理"),
        REPLY("已回复"),
        OVER("已办结"),
        PROCESSED("已处理");


        private final String name;

        AssignStatus(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    //0普通 1供应部
    public enum SendType {

        NORMAL("普通"),
        SUPPLY("供应部");

        private final String name;

        SendType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }


    //0邮件标题编号 1收件人称谓 2无限制
    public enum RuleType {

        TITLE("邮件标题编号"),
        NAME("收件人称谓"),
        ANY("无限制");

        private final String name;

        RuleType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    public enum LetterType {

        ASK("询价函"),
        INVITE("邀标函"),
        CONFIRM("价格确认函"),
        ORDER("订货协议"),
        OTHER("其他函");

        private final String name;

        LetterType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    public enum DeductType {

        SAVE("存档"),
        ASSIGN("派发"),
        HANDLE("处理");

        private final String name;

        DeductType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    //0 不可以看 1可以看本部门的，但是不可以看内容 3可以看内容
    public enum QueryType {

        NO("不可以看"),
        MYDEPT("看本部门，但是不可以看内容"),
        LOOK("可以看内容");

        private final String name;

        QueryType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }


    public static final String CSS_CONTENT= "<style>\n" +
            "\n" +
            "    .ql-container {\n" +
            "        box-sizing: border-box;\n" +
            "        font-family: Helvetica, Arial, sans-serif;\n" +
            "        font-size: 13px;\n" +
            "        height: 100%;\n" +
            "        margin: 0px;\n" +
            "        position: relative;\n" +
            "    }\n" +
            "    .ql-container.ql-disabled .ql-tooltip {\n" +
            "        visibility: hidden;\n" +
            "    }\n" +
            "    .ql-container.ql-disabled ul[data-checked] > li::before {\n" +
            "        pointer-events: none;\n" +
            "    }\n" +
            "    .ql-clipboard {\n" +
            "        left: -100000px;\n" +
            "        height: 1px;\n" +
            "        overflow-y: hidden;\n" +
            "        position: absolute;\n" +
            "        top: 50%;\n" +
            "    }\n" +
            "    .ql-clipboard p {\n" +
            "        margin: 0;\n" +
            "        padding: 0;\n" +
            "    }\n" +
            "    {\n" +
            "        box-sizing: border-box;\n" +
            "        line-height: 1.42;\n" +
            "        height: 100%;\n" +
            "        outline: none;\n" +
            "        overflow-y: auto;\n" +
            "        padding: 12px 15px;\n" +
            "        tab-size: 4;\n" +
            "        -moz-tab-size: 4;\n" +
            "        text-align: left;\n" +
            "        white-space: pre-wrap;\n" +
            "        word-wrap: break-word;\n" +
            "    }\n" +
            "    > * {\n" +
            "        cursor: text;\n" +
            "    }\n" +
            "    p,\n" +
            "    ol,\n" +
            "    ul,\n" +
            "    pre,\n" +
            "    blockquote,\n" +
            "    h1,\n" +
            "    h2,\n" +
            "    h3,\n" +
            "    h4,\n" +
            "    h5,\n" +
            "    h6 {\n" +
            "        margin: 0;\n" +
            "        padding: 0;\n" +
            "        counter-reset: list-1 list-2 list-3 list-4 list-5 list-6 list-7 list-8 list-9;\n" +
            "    }\n" +
            "    ol,\n" +
            "    ul {\n" +
            "        padding-left: 1.5em;\n" +
            "    }\n" +
            "    ol > li,\n" +
            "    ul > li {\n" +
            "        list-style-type: none;\n" +
            "    }\n" +
            "    ul > li::before {\n" +
            "        content: '\\2022';\n" +
            "    }\n" +
            "    ul[data-checked=true],\n" +
            "    ul[data-checked=false] {\n" +
            "        pointer-events: none;\n" +
            "    }\n" +
            "    ul[data-checked=true] > li *,\n" +
            "    ul[data-checked=false] > li * {\n" +
            "        pointer-events: all;\n" +
            "    }\n" +
            "    ul[data-checked=true] > li::before,\n" +
            "    ul[data-checked=false] > li::before {\n" +
            "        color: #777;\n" +
            "        cursor: pointer;\n" +
            "        pointer-events: all;\n" +
            "    }\n" +
            "    ul[data-checked=true] > li::before {\n" +
            "        content: '\\2611';\n" +
            "    }\n" +
            "    ul[data-checked=false] > li::before {\n" +
            "        content: '\\2610';\n" +
            "    }\n" +
            "    li::before {\n" +
            "        display: inline-block;\n" +
            "        white-space: nowrap;\n" +
            "        width: 1.2em;\n" +
            "    }\n" +
            "    li:not(.ql-direction-rtl)::before {\n" +
            "        margin-left: -1.5em;\n" +
            "        margin-right: 0.3em;\n" +
            "        text-align: right;\n" +
            "    }\n" +
            "    li.ql-direction-rtl::before {\n" +
            "        margin-left: 0.3em;\n" +
            "        margin-right: -1.5em;\n" +
            "    }\n" +
            "    ol li:not(.ql-direction-rtl),\n" +
            "    ul li:not(.ql-direction-rtl) {\n" +
            "        padding-left: 1.5em;\n" +
            "    }\n" +
            "    ol li.ql-direction-rtl,\n" +
            "    ul li.ql-direction-rtl {\n" +
            "        padding-right: 1.5em;\n" +
            "    }\n" +
            "    ol li {\n" +
            "        counter-reset: list-1 list-2 list-3 list-4 list-5 list-6 list-7 list-8 list-9;\n" +
            "        counter-increment: list-0;\n" +
            "    }\n" +
            "    ol li:before {\n" +
            "        content: counter(list-0, decimal) '. ';\n" +
            "    }\n" +
            "    ol li.ql-indent-1 {\n" +
            "        counter-increment: list-1;\n" +
            "    }\n" +
            "    ol li.ql-indent-1:before {\n" +
            "        content: counter(list-1, lower-alpha) '. ';\n" +
            "    }\n" +
            "    ol li.ql-indent-1 {\n" +
            "        counter-reset: list-2 list-3 list-4 list-5 list-6 list-7 list-8 list-9;\n" +
            "    }\n" +
            "    ol li.ql-indent-2 {\n" +
            "        counter-increment: list-2;\n" +
            "    }\n" +
            "    ol li.ql-indent-2:before {\n" +
            "        content: counter(list-2, lower-roman) '. ';\n" +
            "    }\n" +
            "    ol li.ql-indent-2 {\n" +
            "        counter-reset: list-3 list-4 list-5 list-6 list-7 list-8 list-9;\n" +
            "    }\n" +
            "    ol li.ql-indent-3 {\n" +
            "        counter-increment: list-3;\n" +
            "    }\n" +
            "    ol li.ql-indent-3:before {\n" +
            "        content: counter(list-3, decimal) '. ';\n" +
            "    }\n" +
            "    ol li.ql-indent-3 {\n" +
            "        counter-reset: list-4 list-5 list-6 list-7 list-8 list-9;\n" +
            "    }\n" +
            "    ol li.ql-indent-4 {\n" +
            "        counter-increment: list-4;\n" +
            "    }\n" +
            "    ol li.ql-indent-4:before {\n" +
            "        content: counter(list-4, lower-alpha) '. ';\n" +
            "    }\n" +
            "    ol li.ql-indent-4 {\n" +
            "        counter-reset: list-5 list-6 list-7 list-8 list-9;\n" +
            "    }\n" +
            "    ol li.ql-indent-5 {\n" +
            "        counter-increment: list-5;\n" +
            "    }\n" +
            "    ol li.ql-indent-5:before {\n" +
            "        content: counter(list-5, lower-roman) '. ';\n" +
            "    }\n" +
            "    ol li.ql-indent-5 {\n" +
            "        counter-reset: list-6 list-7 list-8 list-9;\n" +
            "    }\n" +
            "    ol li.ql-indent-6 {\n" +
            "        counter-increment: list-6;\n" +
            "    }\n" +
            "    ol li.ql-indent-6:before {\n" +
            "        content: counter(list-6, decimal) '. ';\n" +
            "    }\n" +
            "    ol li.ql-indent-6 {\n" +
            "        counter-reset: list-7 list-8 list-9;\n" +
            "    }\n" +
            "    ol li.ql-indent-7 {\n" +
            "        counter-increment: list-7;\n" +
            "    }\n" +
            "    ol li.ql-indent-7:before {\n" +
            "        content: counter(list-7, lower-alpha) '. ';\n" +
            "    }\n" +
            "    ol li.ql-indent-7 {\n" +
            "        counter-reset: list-8 list-9;\n" +
            "    }\n" +
            "    ol li.ql-indent-8 {\n" +
            "        counter-increment: list-8;\n" +
            "    }\n" +
            "    ol li.ql-indent-8:before {\n" +
            "        content: counter(list-8, lower-roman) '. ';\n" +
            "    }\n" +
            "    ol li.ql-indent-8 {\n" +
            "        counter-reset: list-9;\n" +
            "    }\n" +
            "    ol li.ql-indent-9 {\n" +
            "        counter-increment: list-9;\n" +
            "    }\n" +
            "    ol li.ql-indent-9:before {\n" +
            "        content: counter(list-9, decimal) '. ';\n" +
            "    }\n" +
            "    .ql-indent-1:not(.ql-direction-rtl) {\n" +
            "        padding-left: 3em;\n" +
            "    }\n" +
            "    li.ql-indent-1:not(.ql-direction-rtl) {\n" +
            "        padding-left: 4.5em;\n" +
            "    }\n" +
            "    .ql-indent-1.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 3em;\n" +
            "    }\n" +
            "    li.ql-indent-1.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 4.5em;\n" +
            "    }\n" +
            "    .ql-indent-2:not(.ql-direction-rtl) {\n" +
            "        padding-left: 6em;\n" +
            "    }\n" +
            "    li.ql-indent-2:not(.ql-direction-rtl) {\n" +
            "        padding-left: 7.5em;\n" +
            "    }\n" +
            "    .ql-indent-2.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 6em;\n" +
            "    }\n" +
            "    li.ql-indent-2.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 7.5em;\n" +
            "    }\n" +
            "    .ql-indent-3:not(.ql-direction-rtl) {\n" +
            "        padding-left: 9em;\n" +
            "    }\n" +
            "    li.ql-indent-3:not(.ql-direction-rtl) {\n" +
            "        padding-left: 10.5em;\n" +
            "    }\n" +
            "    .ql-indent-3.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 9em;\n" +
            "    }\n" +
            "    li.ql-indent-3.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 10.5em;\n" +
            "    }\n" +
            "    .ql-indent-4:not(.ql-direction-rtl) {\n" +
            "        padding-left: 12em;\n" +
            "    }\n" +
            "    li.ql-indent-4:not(.ql-direction-rtl) {\n" +
            "        padding-left: 13.5em;\n" +
            "    }\n" +
            "    .ql-indent-4.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 12em;\n" +
            "    }\n" +
            "    li.ql-indent-4.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 13.5em;\n" +
            "    }\n" +
            "    .ql-indent-5:not(.ql-direction-rtl) {\n" +
            "        padding-left: 15em;\n" +
            "    }\n" +
            "    li.ql-indent-5:not(.ql-direction-rtl) {\n" +
            "        padding-left: 16.5em;\n" +
            "    }\n" +
            "    .ql-indent-5.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 15em;\n" +
            "    }\n" +
            "    li.ql-indent-5.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 16.5em;\n" +
            "    }\n" +
            "    .ql-indent-6:not(.ql-direction-rtl) {\n" +
            "        padding-left: 18em;\n" +
            "    }\n" +
            "    li.ql-indent-6:not(.ql-direction-rtl) {\n" +
            "        padding-left: 19.5em;\n" +
            "    }\n" +
            "    .ql-indent-6.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 18em;\n" +
            "    }\n" +
            "    li.ql-indent-6.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 19.5em;\n" +
            "    }\n" +
            "    .ql-indent-7:not(.ql-direction-rtl) {\n" +
            "        padding-left: 21em;\n" +
            "    }\n" +
            "    li.ql-indent-7:not(.ql-direction-rtl) {\n" +
            "        padding-left: 22.5em;\n" +
            "    }\n" +
            "    .ql-indent-7.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 21em;\n" +
            "    }\n" +
            "    li.ql-indent-7.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 22.5em;\n" +
            "    }\n" +
            "    .ql-indent-8:not(.ql-direction-rtl) {\n" +
            "        padding-left: 24em;\n" +
            "    }\n" +
            "    li.ql-indent-8:not(.ql-direction-rtl) {\n" +
            "        padding-left: 25.5em;\n" +
            "    }\n" +
            "    .ql-indent-8.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 24em;\n" +
            "    }\n" +
            "    li.ql-indent-8.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 25.5em;\n" +
            "    }\n" +
            "    .ql-indent-9:not(.ql-direction-rtl) {\n" +
            "        padding-left: 27em;\n" +
            "    }\n" +
            "    li.ql-indent-9:not(.ql-direction-rtl) {\n" +
            "        padding-left: 28.5em;\n" +
            "    }\n" +
            "    .ql-indent-9.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 27em;\n" +
            "    }\n" +
            "    li.ql-indent-9.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 28.5em;\n" +
            "    }\n" +
            "    .ql-video {\n" +
            "        display: block;\n" +
            "        max-width: 100%;\n" +
            "    }\n" +
            "    .ql-video.ql-align-center {\n" +
            "        margin: 0 auto;\n" +
            "    }\n" +
            "    .ql-video.ql-align-right {\n" +
            "        margin: 0 0 0 auto;\n" +
            "    }\n" +
            "    .ql-bg-black {\n" +
            "        background-color: #000;\n" +
            "    }\n" +
            "    .ql-bg-red {\n" +
            "        background-color: #e60000;\n" +
            "    }\n" +
            "    .ql-bg-orange {\n" +
            "        background-color: #f90;\n" +
            "    }\n" +
            "    .ql-bg-yellow {\n" +
            "        background-color: #ff0;\n" +
            "    }\n" +
            "    .ql-bg-green {\n" +
            "        background-color: #008a00;\n" +
            "    }\n" +
            "    .ql-bg-blue {\n" +
            "        background-color: #06c;\n" +
            "    }\n" +
            "    .ql-bg-purple {\n" +
            "        background-color: #93f;\n" +
            "    }\n" +
            "    .ql-color-white {\n" +
            "        color: #fff;\n" +
            "    }\n" +
            "    .ql-color-red {\n" +
            "        color: #e60000;\n" +
            "    }\n" +
            "    .ql-color-orange {\n" +
            "        color: #f90;\n" +
            "    }\n" +
            "    .ql-color-yellow {\n" +
            "        color: #ff0;\n" +
            "    }\n" +
            "    .ql-color-green {\n" +
            "        color: #008a00;\n" +
            "    }\n" +
            "    .ql-color-blue {\n" +
            "        color: #06c;\n" +
            "    }\n" +
            "    .ql-color-purple {\n" +
            "        color: #93f;\n" +
            "    }\n" +
            "    .ql-font-serif {\n" +
            "        font-family: Georgia, Times New Roman, serif;\n" +
            "    }\n" +
            "    .ql-font-monospace {\n" +
            "        font-family: Monaco, Courier New, monospace;\n" +
            "    }\n" +
            "    .ql-size-small {\n" +
            "        font-size: 0.75em;\n" +
            "    }\n" +
            "    .ql-size-large {\n" +
            "        font-size: 1.5em;\n" +
            "    }\n" +
            "    .ql-size-huge {\n" +
            "        font-size: 2.5em;\n" +
            "    }\n" +
            "    .ql-direction-rtl {\n" +
            "        direction: rtl;\n" +
            "        text-align: inherit;\n" +
            "    }\n" +
            "    .ql-align-center {\n" +
            "        text-align: center;\n" +
            "    }\n" +
            "    .ql-align-justify {\n" +
            "        text-align: justify;\n" +
            "    }\n" +
            "    .ql-align-right {\n" +
            "        text-align: right;\n" +
            "    }\n" +
            "    .ql-editor.ql-blank::before {\n" +
            "        color: rgba(0,0,0,0.6);\n" +
            "        content: attr(data-placeholder);\n" +
            "        font-style: italic;\n" +
            "        left: 15px;\n" +
            "        pointer-events: none;\n" +
            "        position: absolute;\n" +
            "        right: 15px;\n" +
            "    }\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "    /*!\n" +
            " * Quill Editor v1.3.6\n" +
            " * https://quilljs.com/\n" +
            " * Copyright (c) 2014, Jason Chen\n" +
            " * Copyright (c) 2013, salesforce.com\n" +
            " */\n" +
            "    .ql-container {\n" +
            "        box-sizing: border-box;\n" +
            "        font-family: Helvetica, Arial, sans-serif;\n" +
            "        font-size: 13px;\n" +
            "        height: 100%;\n" +
            "        margin: 0px;\n" +
            "        position: relative;\n" +
            "    }\n" +
            "    .ql-container.ql-disabled .ql-tooltip {\n" +
            "        visibility: hidden;\n" +
            "    }\n" +
            "    .ql-container.ql-disabled ul[data-checked] > li::before {\n" +
            "        pointer-events: none;\n" +
            "    }\n" +
            "    .ql-clipboard {\n" +
            "        left: -100000px;\n" +
            "        height: 1px;\n" +
            "        overflow-y: hidden;\n" +
            "        position: absolute;\n" +
            "        top: 50%;\n" +
            "    }\n" +
            "    .ql-clipboard p {\n" +
            "        margin: 0;\n" +
            "        padding: 0;\n" +
            "    }\n" +
            "    {\n" +
            "        box-sizing: border-box;\n" +
            "        line-height: 1.42;\n" +
            "        height: 100%;\n" +
            "        outline: none;\n" +
            "        overflow-y: auto;\n" +
            "        padding: 12px 15px;\n" +
            "        tab-size: 4;\n" +
            "        -moz-tab-size: 4;\n" +
            "        text-align: left;\n" +
            "        white-space: pre-wrap;\n" +
            "        word-wrap: break-word;\n" +
            "    }\n" +
            "    > * {\n" +
            "        cursor: text;\n" +
            "    }\n" +
            "    p,\n" +
            "    ol,\n" +
            "    ul,\n" +
            "    pre,\n" +
            "    blockquote,\n" +
            "    h1,\n" +
            "    h2,\n" +
            "    h3,\n" +
            "    h4,\n" +
            "    h5,\n" +
            "    h6 {\n" +
            "        margin: 0;\n" +
            "        padding: 0;\n" +
            "        counter-reset: list-1 list-2 list-3 list-4 list-5 list-6 list-7 list-8 list-9;\n" +
            "    }\n" +
            "    ol,\n" +
            "    ul {\n" +
            "        padding-left: 1.5em;\n" +
            "    }\n" +
            "    ol > li,\n" +
            "    ul > li {\n" +
            "        list-style-type: none;\n" +
            "    }\n" +
            "    ul > li::before {\n" +
            "        content: '\\2022';\n" +
            "    }\n" +
            "    ul[data-checked=true],\n" +
            "    ul[data-checked=false] {\n" +
            "        pointer-events: none;\n" +
            "    }\n" +
            "    ul[data-checked=true] > li *,\n" +
            "    ul[data-checked=false] > li * {\n" +
            "        pointer-events: all;\n" +
            "    }\n" +
            "    ul[data-checked=true] > li::before,\n" +
            "    ul[data-checked=false] > li::before {\n" +
            "        color: #777;\n" +
            "        cursor: pointer;\n" +
            "        pointer-events: all;\n" +
            "    }\n" +
            "    ul[data-checked=true] > li::before {\n" +
            "        content: '\\2611';\n" +
            "    }\n" +
            "    ul[data-checked=false] > li::before {\n" +
            "        content: '\\2610';\n" +
            "    }\n" +
            "    li::before {\n" +
            "        display: inline-block;\n" +
            "        white-space: nowrap;\n" +
            "        width: 1.2em;\n" +
            "    }\n" +
            "    li:not(.ql-direction-rtl)::before {\n" +
            "        margin-left: -1.5em;\n" +
            "        margin-right: 0.3em;\n" +
            "        text-align: right;\n" +
            "    }\n" +
            "    li.ql-direction-rtl::before {\n" +
            "        margin-left: 0.3em;\n" +
            "        margin-right: -1.5em;\n" +
            "    }\n" +
            "    ol li:not(.ql-direction-rtl),\n" +
            "    ul li:not(.ql-direction-rtl) {\n" +
            "        padding-left: 1.5em;\n" +
            "    }\n" +
            "    ol li.ql-direction-rtl,\n" +
            "    ul li.ql-direction-rtl {\n" +
            "        padding-right: 1.5em;\n" +
            "    }\n" +
            "    ol li {\n" +
            "        counter-reset: list-1 list-2 list-3 list-4 list-5 list-6 list-7 list-8 list-9;\n" +
            "        counter-increment: list-0;\n" +
            "    }\n" +
            "    ol li:before {\n" +
            "        content: counter(list-0, decimal) '. ';\n" +
            "    }\n" +
            "    ol li.ql-indent-1 {\n" +
            "        counter-increment: list-1;\n" +
            "    }\n" +
            "    ol li.ql-indent-1:before {\n" +
            "        content: counter(list-1, lower-alpha) '. ';\n" +
            "    }\n" +
            "    ol li.ql-indent-1 {\n" +
            "        counter-reset: list-2 list-3 list-4 list-5 list-6 list-7 list-8 list-9;\n" +
            "    }\n" +
            "    ol li.ql-indent-2 {\n" +
            "        counter-increment: list-2;\n" +
            "    }\n" +
            "    ol li.ql-indent-2:before {\n" +
            "        content: counter(list-2, lower-roman) '. ';\n" +
            "    }\n" +
            "    ol li.ql-indent-2 {\n" +
            "        counter-reset: list-3 list-4 list-5 list-6 list-7 list-8 list-9;\n" +
            "    }\n" +
            "    ol li.ql-indent-3 {\n" +
            "        counter-increment: list-3;\n" +
            "    }\n" +
            "    ol li.ql-indent-3:before {\n" +
            "        content: counter(list-3, decimal) '. ';\n" +
            "    }\n" +
            "    ol li.ql-indent-3 {\n" +
            "        counter-reset: list-4 list-5 list-6 list-7 list-8 list-9;\n" +
            "    }\n" +
            "    ol li.ql-indent-4 {\n" +
            "        counter-increment: list-4;\n" +
            "    }\n" +
            "    ol li.ql-indent-4:before {\n" +
            "        content: counter(list-4, lower-alpha) '. ';\n" +
            "    }\n" +
            "    ol li.ql-indent-4 {\n" +
            "        counter-reset: list-5 list-6 list-7 list-8 list-9;\n" +
            "    }\n" +
            "    ol li.ql-indent-5 {\n" +
            "        counter-increment: list-5;\n" +
            "    }\n" +
            "    ol li.ql-indent-5:before {\n" +
            "        content: counter(list-5, lower-roman) '. ';\n" +
            "    }\n" +
            "    ol li.ql-indent-5 {\n" +
            "        counter-reset: list-6 list-7 list-8 list-9;\n" +
            "    }\n" +
            "    ol li.ql-indent-6 {\n" +
            "        counter-increment: list-6;\n" +
            "    }\n" +
            "    ol li.ql-indent-6:before {\n" +
            "        content: counter(list-6, decimal) '. ';\n" +
            "    }\n" +
            "    ol li.ql-indent-6 {\n" +
            "        counter-reset: list-7 list-8 list-9;\n" +
            "    }\n" +
            "    ol li.ql-indent-7 {\n" +
            "        counter-increment: list-7;\n" +
            "    }\n" +
            "    ol li.ql-indent-7:before {\n" +
            "        content: counter(list-7, lower-alpha) '. ';\n" +
            "    }\n" +
            "    ol li.ql-indent-7 {\n" +
            "        counter-reset: list-8 list-9;\n" +
            "    }\n" +
            "    ol li.ql-indent-8 {\n" +
            "        counter-increment: list-8;\n" +
            "    }\n" +
            "    ol li.ql-indent-8:before {\n" +
            "        content: counter(list-8, lower-roman) '. ';\n" +
            "    }\n" +
            "    ol li.ql-indent-8 {\n" +
            "        counter-reset: list-9;\n" +
            "    }\n" +
            "    ol li.ql-indent-9 {\n" +
            "        counter-increment: list-9;\n" +
            "    }\n" +
            "    ol li.ql-indent-9:before {\n" +
            "        content: counter(list-9, decimal) '. ';\n" +
            "    }\n" +
            "    .ql-indent-1:not(.ql-direction-rtl) {\n" +
            "        padding-left: 3em;\n" +
            "    }\n" +
            "    li.ql-indent-1:not(.ql-direction-rtl) {\n" +
            "        padding-left: 4.5em;\n" +
            "    }\n" +
            "    .ql-indent-1.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 3em;\n" +
            "    }\n" +
            "    li.ql-indent-1.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 4.5em;\n" +
            "    }\n" +
            "    .ql-indent-2:not(.ql-direction-rtl) {\n" +
            "        padding-left: 6em;\n" +
            "    }\n" +
            "    li.ql-indent-2:not(.ql-direction-rtl) {\n" +
            "        padding-left: 7.5em;\n" +
            "    }\n" +
            "    .ql-indent-2.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 6em;\n" +
            "    }\n" +
            "    li.ql-indent-2.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 7.5em;\n" +
            "    }\n" +
            "    .ql-indent-3:not(.ql-direction-rtl) {\n" +
            "        padding-left: 9em;\n" +
            "    }\n" +
            "    li.ql-indent-3:not(.ql-direction-rtl) {\n" +
            "        padding-left: 10.5em;\n" +
            "    }\n" +
            "    .ql-indent-3.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 9em;\n" +
            "    }\n" +
            "    li.ql-indent-3.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 10.5em;\n" +
            "    }\n" +
            "    .ql-indent-4:not(.ql-direction-rtl) {\n" +
            "        padding-left: 12em;\n" +
            "    }\n" +
            "    li.ql-indent-4:not(.ql-direction-rtl) {\n" +
            "        padding-left: 13.5em;\n" +
            "    }\n" +
            "    .ql-indent-4.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 12em;\n" +
            "    }\n" +
            "    li.ql-indent-4.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 13.5em;\n" +
            "    }\n" +
            "    .ql-indent-5:not(.ql-direction-rtl) {\n" +
            "        padding-left: 15em;\n" +
            "    }\n" +
            "    li.ql-indent-5:not(.ql-direction-rtl) {\n" +
            "        padding-left: 16.5em;\n" +
            "    }\n" +
            "    .ql-indent-5.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 15em;\n" +
            "    }\n" +
            "    li.ql-indent-5.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 16.5em;\n" +
            "    }\n" +
            "    .ql-indent-6:not(.ql-direction-rtl) {\n" +
            "        padding-left: 18em;\n" +
            "    }\n" +
            "    li.ql-indent-6:not(.ql-direction-rtl) {\n" +
            "        padding-left: 19.5em;\n" +
            "    }\n" +
            "    .ql-indent-6.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 18em;\n" +
            "    }\n" +
            "    li.ql-indent-6.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 19.5em;\n" +
            "    }\n" +
            "    .ql-indent-7:not(.ql-direction-rtl) {\n" +
            "        padding-left: 21em;\n" +
            "    }\n" +
            "    li.ql-indent-7:not(.ql-direction-rtl) {\n" +
            "        padding-left: 22.5em;\n" +
            "    }\n" +
            "    .ql-indent-7.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 21em;\n" +
            "    }\n" +
            "    li.ql-indent-7.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 22.5em;\n" +
            "    }\n" +
            "    .ql-indent-8:not(.ql-direction-rtl) {\n" +
            "        padding-left: 24em;\n" +
            "    }\n" +
            "    li.ql-indent-8:not(.ql-direction-rtl) {\n" +
            "        padding-left: 25.5em;\n" +
            "    }\n" +
            "    .ql-indent-8.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 24em;\n" +
            "    }\n" +
            "    li.ql-indent-8.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 25.5em;\n" +
            "    }\n" +
            "    .ql-indent-9:not(.ql-direction-rtl) {\n" +
            "        padding-left: 27em;\n" +
            "    }\n" +
            "    li.ql-indent-9:not(.ql-direction-rtl) {\n" +
            "        padding-left: 28.5em;\n" +
            "    }\n" +
            "    .ql-indent-9.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 27em;\n" +
            "    }\n" +
            "    li.ql-indent-9.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 28.5em;\n" +
            "    }\n" +
            "    .ql-video {\n" +
            "        display: block;\n" +
            "        max-width: 100%;\n" +
            "    }\n" +
            "    .ql-video.ql-align-center {\n" +
            "        margin: 0 auto;\n" +
            "    }\n" +
            "    .ql-video.ql-align-right {\n" +
            "        margin: 0 0 0 auto;\n" +
            "    }\n" +
            "    .ql-bg-black {\n" +
            "        background-color: #000;\n" +
            "    }\n" +
            "    .ql-bg-red {\n" +
            "        background-color: #e60000;\n" +
            "    }\n" +
            "    .ql-bg-orange {\n" +
            "        background-color: #f90;\n" +
            "    }\n" +
            "    .ql-bg-yellow {\n" +
            "        background-color: #ff0;\n" +
            "    }\n" +
            "    .ql-bg-green {\n" +
            "        background-color: #008a00;\n" +
            "    }\n" +
            "    .ql-bg-blue {\n" +
            "        background-color: #06c;\n" +
            "    }\n" +
            "    .ql-bg-purple {\n" +
            "        background-color: #93f;\n" +
            "    }\n" +
            "    .ql-color-white {\n" +
            "        color: #fff;\n" +
            "    }\n" +
            "    .ql-color-red {\n" +
            "        color: #e60000;\n" +
            "    }\n" +
            "    .ql-color-orange {\n" +
            "        color: #f90;\n" +
            "    }\n" +
            "    .ql-color-yellow {\n" +
            "        color: #ff0;\n" +
            "    }\n" +
            "    .ql-color-green {\n" +
            "        color: #008a00;\n" +
            "    }\n" +
            "    .ql-color-blue {\n" +
            "        color: #06c;\n" +
            "    }\n" +
            "    .ql-color-purple {\n" +
            "        color: #93f;\n" +
            "    }\n" +
            "    .ql-font-serif {\n" +
            "        font-family: Georgia, Times New Roman, serif;\n" +
            "    }\n" +
            "    .ql-font-monospace {\n" +
            "        font-family: Monaco, Courier New, monospace;\n" +
            "    }\n" +
            "    .ql-size-small {\n" +
            "        font-size: 0.75em;\n" +
            "    }\n" +
            "    .ql-size-large {\n" +
            "        font-size: 1.5em;\n" +
            "    }\n" +
            "    .ql-size-huge {\n" +
            "        font-size: 2.5em;\n" +
            "    }\n" +
            "    .ql-direction-rtl {\n" +
            "        direction: rtl;\n" +
            "        text-align: inherit;\n" +
            "    }\n" +
            "    .ql-align-center {\n" +
            "        text-align: center;\n" +
            "    }\n" +
            "    .ql-align-justify {\n" +
            "        text-align: justify;\n" +
            "    }\n" +
            "    .ql-align-right {\n" +
            "        text-align: right;\n" +
            "    }\n" +
            "    .ql-editor.ql-blank::before {\n" +
            "        color: rgba(0,0,0,0.6);\n" +
            "        content: attr(data-placeholder);\n" +
            "        font-style: italic;\n" +
            "        left: 15px;\n" +
            "        pointer-events: none;\n" +
            "        position: absolute;\n" +
            "        right: 15px;\n" +
            "    }\n" +
            "    .ql-snow.ql-toolbar:after,\n" +
            "    .ql-snow .ql-toolbar:after {\n" +
            "        clear: both;\n" +
            "        content: '';\n" +
            "        display: table;\n" +
            "    }\n" +
            "    .ql-snow.ql-toolbar button,\n" +
            "    .ql-snow .ql-toolbar button {\n" +
            "        background: none;\n" +
            "        border: none;\n" +
            "        cursor: pointer;\n" +
            "        display: inline-block;\n" +
            "        float: left;\n" +
            "        height: 24px;\n" +
            "        padding: 3px 5px;\n" +
            "        width: 28px;\n" +
            "    }\n" +
            "    .ql-snow.ql-toolbar button svg,\n" +
            "    .ql-snow .ql-toolbar button svg {\n" +
            "        float: left;\n" +
            "        height: 100%;\n" +
            "    }\n" +
            "    .ql-snow.ql-toolbar button:active:hover,\n" +
            "    .ql-snow .ql-toolbar button:active:hover {\n" +
            "        outline: none;\n" +
            "    }\n" +
            "    .ql-snow.ql-toolbar input.ql-image[type=file],\n" +
            "    .ql-snow .ql-toolbar input.ql-image[type=file] {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .ql-snow.ql-toolbar button:hover,\n" +
            "    .ql-snow .ql-toolbar button:hover,\n" +
            "    .ql-snow.ql-toolbar button:focus,\n" +
            "    .ql-snow .ql-toolbar button:focus,\n" +
            "    .ql-snow.ql-toolbar button.ql-active,\n" +
            "    .ql-snow .ql-toolbar button.ql-active,\n" +
            "    .ql-snow.ql-toolbar .ql-picker-label:hover,\n" +
            "    .ql-snow .ql-toolbar .ql-picker-label:hover,\n" +
            "    .ql-snow.ql-toolbar .ql-picker-label.ql-active,\n" +
            "    .ql-snow .ql-toolbar .ql-picker-label.ql-active,\n" +
            "    .ql-snow.ql-toolbar .ql-picker-item:hover,\n" +
            "    .ql-snow .ql-toolbar .ql-picker-item:hover,\n" +
            "    .ql-snow.ql-toolbar .ql-picker-item.ql-selected,\n" +
            "    .ql-snow .ql-toolbar .ql-picker-item.ql-selected {\n" +
            "        color: #06c;\n" +
            "    }\n" +
            "    .ql-snow.ql-toolbar button:hover .ql-fill,\n" +
            "    .ql-snow .ql-toolbar button:hover .ql-fill,\n" +
            "    .ql-snow.ql-toolbar button:focus .ql-fill,\n" +
            "    .ql-snow .ql-toolbar button:focus .ql-fill,\n" +
            "    .ql-snow.ql-toolbar button.ql-active .ql-fill,\n" +
            "    .ql-snow .ql-toolbar button.ql-active .ql-fill,\n" +
            "    .ql-snow.ql-toolbar .ql-picker-label:hover .ql-fill,\n" +
            "    .ql-snow .ql-toolbar .ql-picker-label:hover .ql-fill,\n" +
            "    .ql-snow.ql-toolbar .ql-picker-label.ql-active .ql-fill,\n" +
            "    .ql-snow .ql-toolbar .ql-picker-label.ql-active .ql-fill,\n" +
            "    .ql-snow.ql-toolbar .ql-picker-item:hover .ql-fill,\n" +
            "    .ql-snow .ql-toolbar .ql-picker-item:hover .ql-fill,\n" +
            "    .ql-snow.ql-toolbar .ql-picker-item.ql-selected .ql-fill,\n" +
            "    .ql-snow .ql-toolbar .ql-picker-item.ql-selected .ql-fill,\n" +
            "    .ql-snow.ql-toolbar button:hover .ql-stroke.ql-fill,\n" +
            "    .ql-snow .ql-toolbar button:hover .ql-stroke.ql-fill,\n" +
            "    .ql-snow.ql-toolbar button:focus .ql-stroke.ql-fill,\n" +
            "    .ql-snow .ql-toolbar button:focus .ql-stroke.ql-fill,\n" +
            "    .ql-snow.ql-toolbar button.ql-active .ql-stroke.ql-fill,\n" +
            "    .ql-snow .ql-toolbar button.ql-active .ql-stroke.ql-fill,\n" +
            "    .ql-snow.ql-toolbar .ql-picker-label:hover .ql-stroke.ql-fill,\n" +
            "    .ql-snow .ql-toolbar .ql-picker-label:hover .ql-stroke.ql-fill,\n" +
            "    .ql-snow.ql-toolbar .ql-picker-label.ql-active .ql-stroke.ql-fill,\n" +
            "    .ql-snow .ql-toolbar .ql-picker-label.ql-active .ql-stroke.ql-fill,\n" +
            "    .ql-snow.ql-toolbar .ql-picker-item:hover .ql-stroke.ql-fill,\n" +
            "    .ql-snow .ql-toolbar .ql-picker-item:hover .ql-stroke.ql-fill,\n" +
            "    .ql-snow.ql-toolbar .ql-picker-item.ql-selected .ql-stroke.ql-fill,\n" +
            "    .ql-snow .ql-toolbar .ql-picker-item.ql-selected .ql-stroke.ql-fill {\n" +
            "        fill: #06c;\n" +
            "    }\n" +
            "    .ql-snow.ql-toolbar button:hover .ql-stroke,\n" +
            "    .ql-snow .ql-toolbar button:hover .ql-stroke,\n" +
            "    .ql-snow.ql-toolbar button:focus .ql-stroke,\n" +
            "    .ql-snow .ql-toolbar button:focus .ql-stroke,\n" +
            "    .ql-snow.ql-toolbar button.ql-active .ql-stroke,\n" +
            "    .ql-snow .ql-toolbar button.ql-active .ql-stroke,\n" +
            "    .ql-snow.ql-toolbar .ql-picker-label:hover .ql-stroke,\n" +
            "    .ql-snow .ql-toolbar .ql-picker-label:hover .ql-stroke,\n" +
            "    .ql-snow.ql-toolbar .ql-picker-label.ql-active .ql-stroke,\n" +
            "    .ql-snow .ql-toolbar .ql-picker-label.ql-active .ql-stroke,\n" +
            "    .ql-snow.ql-toolbar .ql-picker-item:hover .ql-stroke,\n" +
            "    .ql-snow .ql-toolbar .ql-picker-item:hover .ql-stroke,\n" +
            "    .ql-snow.ql-toolbar .ql-picker-item.ql-selected .ql-stroke,\n" +
            "    .ql-snow .ql-toolbar .ql-picker-item.ql-selected .ql-stroke,\n" +
            "    .ql-snow.ql-toolbar button:hover .ql-stroke-miter,\n" +
            "    .ql-snow .ql-toolbar button:hover .ql-stroke-miter,\n" +
            "    .ql-snow.ql-toolbar button:focus .ql-stroke-miter,\n" +
            "    .ql-snow .ql-toolbar button:focus .ql-stroke-miter,\n" +
            "    .ql-snow.ql-toolbar button.ql-active .ql-stroke-miter,\n" +
            "    .ql-snow .ql-toolbar button.ql-active .ql-stroke-miter,\n" +
            "    .ql-snow.ql-toolbar .ql-picker-label:hover .ql-stroke-miter,\n" +
            "    .ql-snow .ql-toolbar .ql-picker-label:hover .ql-stroke-miter,\n" +
            "    .ql-snow.ql-toolbar .ql-picker-label.ql-active .ql-stroke-miter,\n" +
            "    .ql-snow .ql-toolbar .ql-picker-label.ql-active .ql-stroke-miter,\n" +
            "    .ql-snow.ql-toolbar .ql-picker-item:hover .ql-stroke-miter,\n" +
            "    .ql-snow .ql-toolbar .ql-picker-item:hover .ql-stroke-miter,\n" +
            "    .ql-snow.ql-toolbar .ql-picker-item.ql-selected .ql-stroke-miter,\n" +
            "    .ql-snow .ql-toolbar .ql-picker-item.ql-selected .ql-stroke-miter {\n" +
            "        stroke: #06c;\n" +
            "    }\n" +
            "    @media (pointer: coarse) {\n" +
            "        .ql-snow.ql-toolbar button:hover:not(.ql-active),\n" +
            "        .ql-snow .ql-toolbar button:hover:not(.ql-active) {\n" +
            "            color: #444;\n" +
            "        }\n" +
            "        .ql-snow.ql-toolbar button:hover:not(.ql-active) .ql-fill,\n" +
            "        .ql-snow .ql-toolbar button:hover:not(.ql-active) .ql-fill,\n" +
            "        .ql-snow.ql-toolbar button:hover:not(.ql-active) .ql-stroke.ql-fill,\n" +
            "        .ql-snow .ql-toolbar button:hover:not(.ql-active) .ql-stroke.ql-fill {\n" +
            "            fill: #444;\n" +
            "        }\n" +
            "        .ql-snow.ql-toolbar button:hover:not(.ql-active) .ql-stroke,\n" +
            "        .ql-snow .ql-toolbar button:hover:not(.ql-active) .ql-stroke,\n" +
            "        .ql-snow.ql-toolbar button:hover:not(.ql-active) .ql-stroke-miter,\n" +
            "        .ql-snow .ql-toolbar button:hover:not(.ql-active) .ql-stroke-miter {\n" +
            "            stroke: #444;\n" +
            "        }\n" +
            "    }\n" +
            "    .ql-snow {\n" +
            "        box-sizing: border-box;\n" +
            "    }\n" +
            "    .ql-snow * {\n" +
            "        box-sizing: border-box;\n" +
            "    }\n" +
            "    .ql-snow .ql-hidden {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .ql-snow .ql-out-bottom,\n" +
            "    .ql-snow .ql-out-top {\n" +
            "        visibility: hidden;\n" +
            "    }\n" +
            "    .ql-snow .ql-tooltip {\n" +
            "        position: absolute;\n" +
            "        transform: translateY(10px);\n" +
            "    }\n" +
            "    .ql-snow .ql-tooltip a {\n" +
            "        cursor: pointer;\n" +
            "        text-decoration: none;\n" +
            "    }\n" +
            "    .ql-snow .ql-tooltip.ql-flip {\n" +
            "        transform: translateY(-10px);\n" +
            "    }\n" +
            "    .ql-snow .ql-formats {\n" +
            "        display: inline-block;\n" +
            "        vertical-align: middle;\n" +
            "    }\n" +
            "    .ql-snow .ql-formats:after {\n" +
            "        clear: both;\n" +
            "        content: '';\n" +
            "        display: table;\n" +
            "    }\n" +
            "    .ql-snow .ql-stroke {\n" +
            "        fill: none;\n" +
            "        stroke: #444;\n" +
            "        stroke-linecap: round;\n" +
            "        stroke-linejoin: round;\n" +
            "        stroke-width: 2;\n" +
            "    }\n" +
            "    .ql-snow .ql-stroke-miter {\n" +
            "        fill: none;\n" +
            "        stroke: #444;\n" +
            "        stroke-miterlimit: 10;\n" +
            "        stroke-width: 2;\n" +
            "    }\n" +
            "    .ql-snow .ql-fill,\n" +
            "    .ql-snow .ql-stroke.ql-fill {\n" +
            "        fill: #444;\n" +
            "    }\n" +
            "    .ql-snow .ql-empty {\n" +
            "        fill: none;\n" +
            "    }\n" +
            "    .ql-snow .ql-even {\n" +
            "        fill-rule: evenodd;\n" +
            "    }\n" +
            "    .ql-snow .ql-thin,\n" +
            "    .ql-snow .ql-stroke.ql-thin {\n" +
            "        stroke-width: 1;\n" +
            "    }\n" +
            "    .ql-snow .ql-transparent {\n" +
            "        opacity: 0.4;\n" +
            "    }\n" +
            "    .ql-snow .ql-direction svg:last-child {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .ql-snow .ql-direction.ql-active svg:last-child {\n" +
            "        display: inline;\n" +
            "    }\n" +
            "    .ql-snow .ql-direction.ql-active svg:first-child {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .ql-snow h1 {\n" +
            "        font-size: 2em;\n" +
            "    }\n" +
            "    .ql-snow h2 {\n" +
            "        font-size: 1.5em;\n" +
            "    }\n" +
            "    .ql-snow h3 {\n" +
            "        font-size: 1.17em;\n" +
            "    }\n" +
            "    .ql-snow h4 {\n" +
            "        font-size: 1em;\n" +
            "    }\n" +
            "    .ql-snow h5 {\n" +
            "        font-size: 0.83em;\n" +
            "    }\n" +
            "    .ql-snow h6 {\n" +
            "        font-size: 0.67em;\n" +
            "    }\n" +
            "    .ql-snow a {\n" +
            "        text-decoration: underline;\n" +
            "    }\n" +
            "    .ql-snow blockquote {\n" +
            "        border-left: 4px solid #ccc;\n" +
            "        margin-bottom: 5px;\n" +
            "        margin-top: 5px;\n" +
            "        padding-left: 16px;\n" +
            "    }\n" +
            "    .ql-snow code,\n" +
            "    .ql-snow pre {\n" +
            "        background-color: #f0f0f0;\n" +
            "        border-radius: 3px;\n" +
            "    }\n" +
            "    .ql-snow pre {\n" +
            "        white-space: pre-wrap;\n" +
            "        margin-bottom: 5px;\n" +
            "        margin-top: 5px;\n" +
            "        padding: 5px 10px;\n" +
            "    }\n" +
            "    .ql-snow code {\n" +
            "        font-size: 85%;\n" +
            "        padding: 2px 4px;\n" +
            "    }\n" +
            "    .ql-snow pre.ql-syntax {\n" +
            "        background-color: #23241f;\n" +
            "        color: #f8f8f2;\n" +
            "        overflow: visible;\n" +
            "    }\n" +
            "    .ql-snow img {\n" +
            "        max-width: 100%;\n" +
            "    }\n" +
            "    .ql-snow .ql-picker {\n" +
            "        color: #444;\n" +
            "        display: inline-block;\n" +
            "        float: left;\n" +
            "        font-size: 14px;\n" +
            "        font-weight: 500;\n" +
            "        height: 24px;\n" +
            "        position: relative;\n" +
            "        vertical-align: middle;\n" +
            "    }\n" +
            "    .ql-snow .ql-picker-label {\n" +
            "        cursor: pointer;\n" +
            "        display: inline-block;\n" +
            "        height: 100%;\n" +
            "        padding-left: 8px;\n" +
            "        padding-right: 2px;\n" +
            "        position: relative;\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .ql-snow .ql-picker-label::before {\n" +
            "        display: inline-block;\n" +
            "        line-height: 22px;\n" +
            "    }\n" +
            "    .ql-snow .ql-picker-options {\n" +
            "        background-color: #fff;\n" +
            "        display: none;\n" +
            "        min-width: 100%;\n" +
            "        padding: 4px 8px;\n" +
            "        position: absolute;\n" +
            "        white-space: nowrap;\n" +
            "    }\n" +
            "    .ql-snow .ql-picker-options .ql-picker-item {\n" +
            "        cursor: pointer;\n" +
            "        display: block;\n" +
            "        padding-bottom: 5px;\n" +
            "        padding-top: 5px;\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-expanded .ql-picker-label {\n" +
            "        color: #ccc;\n" +
            "        z-index: 2;\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-expanded .ql-picker-label .ql-fill {\n" +
            "        fill: #ccc;\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-expanded .ql-picker-label .ql-stroke {\n" +
            "        stroke: #ccc;\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-expanded .ql-picker-options {\n" +
            "        display: block;\n" +
            "        margin-top: -1px;\n" +
            "        top: 100%;\n" +
            "        z-index: 1;\n" +
            "    }\n" +
            "    .ql-snow .ql-color-picker,\n" +
            "    .ql-snow .ql-icon-picker {\n" +
            "        width: 28px;\n" +
            "    }\n" +
            "    .ql-snow .ql-color-picker .ql-picker-label,\n" +
            "    .ql-snow .ql-icon-picker .ql-picker-label {\n" +
            "        padding: 2px 4px;\n" +
            "    }\n" +
            "    .ql-snow .ql-color-picker .ql-picker-label svg,\n" +
            "    .ql-snow .ql-icon-picker .ql-picker-label svg {\n" +
            "        right: 4px;\n" +
            "    }\n" +
            "    .ql-snow .ql-icon-picker .ql-picker-options {\n" +
            "        padding: 4px 0px;\n" +
            "    }\n" +
            "    .ql-snow .ql-icon-picker .ql-picker-item {\n" +
            "        height: 24px;\n" +
            "        width: 24px;\n" +
            "        padding: 2px 4px;\n" +
            "    }\n" +
            "    .ql-snow .ql-color-picker .ql-picker-options {\n" +
            "        padding: 3px 5px;\n" +
            "        width: 152px;\n" +
            "    }\n" +
            "    .ql-snow .ql-color-picker .ql-picker-item {\n" +
            "        border: 1px solid transparent;\n" +
            "        float: left;\n" +
            "        height: 16px;\n" +
            "        margin: 2px;\n" +
            "        padding: 0px;\n" +
            "        width: 16px;\n" +
            "    }\n" +
            "    .ql-snow .ql-picker:not(.ql-color-picker):not(.ql-icon-picker) svg {\n" +
            "        position: absolute;\n" +
            "        margin-top: -9px;\n" +
            "        right: 0;\n" +
            "        top: 50%;\n" +
            "        width: 18px;\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-header .ql-picker-label[data-label]:not([data-label=''])::before,\n" +
            "    .ql-snow .ql-picker.ql-font .ql-picker-label[data-label]:not([data-label=''])::before,\n" +
            "    .ql-snow .ql-picker.ql-size .ql-picker-label[data-label]:not([data-label=''])::before,\n" +
            "    .ql-snow .ql-picker.ql-header .ql-picker-item[data-label]:not([data-label=''])::before,\n" +
            "    .ql-snow .ql-picker.ql-font .ql-picker-item[data-label]:not([data-label=''])::before,\n" +
            "    .ql-snow .ql-picker.ql-size .ql-picker-item[data-label]:not([data-label=''])::before {\n" +
            "        content: attr(data-label);\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-header {\n" +
            "        width: 98px;\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-header .ql-picker-label::before,\n" +
            "    .ql-snow .ql-picker.ql-header .ql-picker-item::before {\n" +
            "        content: 'Normal';\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-header .ql-picker-label[data-value=\"1\"]::before,\n" +
            "    .ql-snow .ql-picker.ql-header .ql-picker-item[data-value=\"1\"]::before {\n" +
            "        content: 'Heading 1';\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-header .ql-picker-label[data-value=\"2\"]::before,\n" +
            "    .ql-snow .ql-picker.ql-header .ql-picker-item[data-value=\"2\"]::before {\n" +
            "        content: 'Heading 2';\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-header .ql-picker-label[data-value=\"3\"]::before,\n" +
            "    .ql-snow .ql-picker.ql-header .ql-picker-item[data-value=\"3\"]::before {\n" +
            "        content: 'Heading 3';\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-header .ql-picker-label[data-value=\"4\"]::before,\n" +
            "    .ql-snow .ql-picker.ql-header .ql-picker-item[data-value=\"4\"]::before {\n" +
            "        content: 'Heading 4';\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-header .ql-picker-label[data-value=\"5\"]::before,\n" +
            "    .ql-snow .ql-picker.ql-header .ql-picker-item[data-value=\"5\"]::before {\n" +
            "        content: 'Heading 5';\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-header .ql-picker-label[data-value=\"6\"]::before,\n" +
            "    .ql-snow .ql-picker.ql-header .ql-picker-item[data-value=\"6\"]::before {\n" +
            "        content: 'Heading 6';\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-header .ql-picker-item[data-value=\"1\"]::before {\n" +
            "        font-size: 2em;\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-header .ql-picker-item[data-value=\"2\"]::before {\n" +
            "        font-size: 1.5em;\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-header .ql-picker-item[data-value=\"3\"]::before {\n" +
            "        font-size: 1.17em;\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-header .ql-picker-item[data-value=\"4\"]::before {\n" +
            "        font-size: 1em;\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-header .ql-picker-item[data-value=\"5\"]::before {\n" +
            "        font-size: 0.83em;\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-header .ql-picker-item[data-value=\"6\"]::before {\n" +
            "        font-size: 0.67em;\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-font {\n" +
            "        width: 108px;\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-font .ql-picker-label::before,\n" +
            "    .ql-snow .ql-picker.ql-font .ql-picker-item::before {\n" +
            "        content: 'Sans Serif';\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-font .ql-picker-label[data-value=serif]::before,\n" +
            "    .ql-snow .ql-picker.ql-font .ql-picker-item[data-value=serif]::before {\n" +
            "        content: 'Serif';\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-font .ql-picker-label[data-value=monospace]::before,\n" +
            "    .ql-snow .ql-picker.ql-font .ql-picker-item[data-value=monospace]::before {\n" +
            "        content: 'Monospace';\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-font .ql-picker-item[data-value=serif]::before {\n" +
            "        font-family: Georgia, Times New Roman, serif;\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-font .ql-picker-item[data-value=monospace]::before {\n" +
            "        font-family: Monaco, Courier New, monospace;\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-size {\n" +
            "        width: 98px;\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-size .ql-picker-label::before,\n" +
            "    .ql-snow .ql-picker.ql-size .ql-picker-item::before {\n" +
            "        content: 'Normal';\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-size .ql-picker-label[data-value=small]::before,\n" +
            "    .ql-snow .ql-picker.ql-size .ql-picker-item[data-value=small]::before {\n" +
            "        content: 'Small';\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-size .ql-picker-label[data-value=large]::before,\n" +
            "    .ql-snow .ql-picker.ql-size .ql-picker-item[data-value=large]::before {\n" +
            "        content: 'Large';\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-size .ql-picker-label[data-value=huge]::before,\n" +
            "    .ql-snow .ql-picker.ql-size .ql-picker-item[data-value=huge]::before {\n" +
            "        content: 'Huge';\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-size .ql-picker-item[data-value=small]::before {\n" +
            "        font-size: 10px;\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-size .ql-picker-item[data-value=large]::before {\n" +
            "        font-size: 18px;\n" +
            "    }\n" +
            "    .ql-snow .ql-picker.ql-size .ql-picker-item[data-value=huge]::before {\n" +
            "        font-size: 32px;\n" +
            "    }\n" +
            "    .ql-snow .ql-color-picker.ql-background .ql-picker-item {\n" +
            "        background-color: #fff;\n" +
            "    }\n" +
            "    .ql-snow .ql-color-picker.ql-color .ql-picker-item {\n" +
            "        background-color: #000;\n" +
            "    }\n" +
            "    .ql-toolbar.ql-snow {\n" +
            "        border: 1px solid #ccc;\n" +
            "        box-sizing: border-box;\n" +
            "        font-family: 'Helvetica Neue', 'Helvetica', 'Arial', sans-serif;\n" +
            "        padding: 8px;\n" +
            "    }\n" +
            "    .ql-toolbar.ql-snow .ql-formats {\n" +
            "        margin-right: 15px;\n" +
            "    }\n" +
            "    .ql-toolbar.ql-snow .ql-picker-label {\n" +
            "        border: 1px solid transparent;\n" +
            "    }\n" +
            "    .ql-toolbar.ql-snow .ql-picker-options {\n" +
            "        border: 1px solid transparent;\n" +
            "        box-shadow: rgba(0,0,0,0.2) 0 2px 8px;\n" +
            "    }\n" +
            "    .ql-toolbar.ql-snow .ql-picker.ql-expanded .ql-picker-label {\n" +
            "        border-color: #ccc;\n" +
            "    }\n" +
            "    .ql-toolbar.ql-snow .ql-picker.ql-expanded .ql-picker-options {\n" +
            "        border-color: #ccc;\n" +
            "    }\n" +
            "    .ql-toolbar.ql-snow .ql-color-picker .ql-picker-item.ql-selected,\n" +
            "    .ql-toolbar.ql-snow .ql-color-picker .ql-picker-item:hover {\n" +
            "        border-color: #000;\n" +
            "    }\n" +
            "    .ql-toolbar.ql-snow + .ql-container.ql-snow {\n" +
            "        border-top: 0px;\n" +
            "    }\n" +
            "    .ql-snow .ql-tooltip {\n" +
            "        background-color: #fff;\n" +
            "        border: 1px solid #ccc;\n" +
            "        box-shadow: 0px 0px 5px #ddd;\n" +
            "        color: #444;\n" +
            "        padding: 5px 12px;\n" +
            "        white-space: nowrap;\n" +
            "    }\n" +
            "    .ql-snow .ql-tooltip::before {\n" +
            "        content: \"Visit URL:\";\n" +
            "        line-height: 26px;\n" +
            "        margin-right: 8px;\n" +
            "    }\n" +
            "    .ql-snow .ql-tooltip input[type=text] {\n" +
            "        display: none;\n" +
            "        border: 1px solid #ccc;\n" +
            "        font-size: 13px;\n" +
            "        height: 26px;\n" +
            "        margin: 0px;\n" +
            "        padding: 3px 5px;\n" +
            "        width: 170px;\n" +
            "    }\n" +
            "    .ql-snow .ql-tooltip a.ql-preview {\n" +
            "        display: inline-block;\n" +
            "        max-width: 200px;\n" +
            "        overflow-x: hidden;\n" +
            "        text-overflow: ellipsis;\n" +
            "        vertical-align: top;\n" +
            "    }\n" +
            "    .ql-snow .ql-tooltip a.ql-action::after {\n" +
            "        border-right: 1px solid #ccc;\n" +
            "        content: 'Edit';\n" +
            "        margin-left: 16px;\n" +
            "        padding-right: 8px;\n" +
            "    }\n" +
            "    .ql-snow .ql-tooltip a.ql-remove::before {\n" +
            "        content: 'Remove';\n" +
            "        margin-left: 8px;\n" +
            "    }\n" +
            "    .ql-snow .ql-tooltip a {\n" +
            "        line-height: 26px;\n" +
            "    }\n" +
            "    .ql-snow .ql-tooltip.ql-editing a.ql-preview,\n" +
            "    .ql-snow .ql-tooltip.ql-editing a.ql-remove {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .ql-snow .ql-tooltip.ql-editing input[type=text] {\n" +
            "        display: inline-block;\n" +
            "    }\n" +
            "    .ql-snow .ql-tooltip.ql-editing a.ql-action::after {\n" +
            "        border-right: 0px;\n" +
            "        content: 'Save';\n" +
            "        padding-right: 0px;\n" +
            "    }\n" +
            "    .ql-snow .ql-tooltip[data-mode=link]::before {\n" +
            "        content: \"Enter link:\";\n" +
            "    }\n" +
            "    .ql-snow .ql-tooltip[data-mode=formula]::before {\n" +
            "        content: \"Enter formula:\";\n" +
            "    }\n" +
            "    .ql-snow .ql-tooltip[data-mode=video]::before {\n" +
            "        content: \"Enter video:\";\n" +
            "    }\n" +
            "    .ql-snow a {\n" +
            "        color: #06c;\n" +
            "    }\n" +
            "    .ql-container.ql-snow {\n" +
            "        border: 1px solid #ccc;\n" +
            "    }\n" +
            "\n" +
            "\n" +
            "\n" +
            "    /*!\n" +
            " * Quill Editor v1.3.6\n" +
            " * https://quilljs.com/\n" +
            " * Copyright (c) 2014, Jason Chen\n" +
            " * Copyright (c) 2013, salesforce.com\n" +
            " */\n" +
            "    .ql-container {\n" +
            "        box-sizing: border-box;\n" +
            "        font-family: Helvetica, Arial, sans-serif;\n" +
            "        font-size: 13px;\n" +
            "        height: 100%;\n" +
            "        margin: 0px;\n" +
            "        position: relative;\n" +
            "    }\n" +
            "    .ql-container.ql-disabled .ql-tooltip {\n" +
            "        visibility: hidden;\n" +
            "    }\n" +
            "    .ql-container.ql-disabled ul[data-checked] > li::before {\n" +
            "        pointer-events: none;\n" +
            "    }\n" +
            "    .ql-clipboard {\n" +
            "        left: -100000px;\n" +
            "        height: 1px;\n" +
            "        overflow-y: hidden;\n" +
            "        position: absolute;\n" +
            "        top: 50%;\n" +
            "    }\n" +
            "    .ql-clipboard p {\n" +
            "        margin: 0;\n" +
            "        padding: 0;\n" +
            "    }\n" +
            "    {\n" +
            "        box-sizing: border-box;\n" +
            "        line-height: 1.42;\n" +
            "        height: 100%;\n" +
            "        outline: none;\n" +
            "        overflow-y: auto;\n" +
            "        padding: 12px 15px;\n" +
            "        tab-size: 4;\n" +
            "        -moz-tab-size: 4;\n" +
            "        text-align: left;\n" +
            "        white-space: pre-wrap;\n" +
            "        word-wrap: break-word;\n" +
            "    }\n" +
            "    > * {\n" +
            "        cursor: text;\n" +
            "    }\n" +
            "    p,\n" +
            "    ol,\n" +
            "    ul,\n" +
            "    pre,\n" +
            "    blockquote,\n" +
            "    h1,\n" +
            "    h2,\n" +
            "    h3,\n" +
            "    h4,\n" +
            "    h5,\n" +
            "    h6 {\n" +
            "        margin: 0;\n" +
            "        padding: 0;\n" +
            "        counter-reset: list-1 list-2 list-3 list-4 list-5 list-6 list-7 list-8 list-9;\n" +
            "    }\n" +
            "    ol,\n" +
            "    ul {\n" +
            "        padding-left: 1.5em;\n" +
            "    }\n" +
            "    ol > li,\n" +
            "    ul > li {\n" +
            "        list-style-type: none;\n" +
            "    }\n" +
            "    ul > li::before {\n" +
            "        content: '\\2022';\n" +
            "    }\n" +
            "    ul[data-checked=true],\n" +
            "    ul[data-checked=false] {\n" +
            "        pointer-events: none;\n" +
            "    }\n" +
            "    ul[data-checked=true] > li *,\n" +
            "    ul[data-checked=false] > li * {\n" +
            "        pointer-events: all;\n" +
            "    }\n" +
            "    ul[data-checked=true] > li::before,\n" +
            "    ul[data-checked=false] > li::before {\n" +
            "        color: #777;\n" +
            "        cursor: pointer;\n" +
            "        pointer-events: all;\n" +
            "    }\n" +
            "    ul[data-checked=true] > li::before {\n" +
            "        content: '\\2611';\n" +
            "    }\n" +
            "    ul[data-checked=false] > li::before {\n" +
            "        content: '\\2610';\n" +
            "    }\n" +
            "    li::before {\n" +
            "        display: inline-block;\n" +
            "        white-space: nowrap;\n" +
            "        width: 1.2em;\n" +
            "    }\n" +
            "    li:not(.ql-direction-rtl)::before {\n" +
            "        margin-left: -1.5em;\n" +
            "        margin-right: 0.3em;\n" +
            "        text-align: right;\n" +
            "    }\n" +
            "    li.ql-direction-rtl::before {\n" +
            "        margin-left: 0.3em;\n" +
            "        margin-right: -1.5em;\n" +
            "    }\n" +
            "    ol li:not(.ql-direction-rtl),\n" +
            "    ul li:not(.ql-direction-rtl) {\n" +
            "        padding-left: 1.5em;\n" +
            "    }\n" +
            "    ol li.ql-direction-rtl,\n" +
            "    ul li.ql-direction-rtl {\n" +
            "        padding-right: 1.5em;\n" +
            "    }\n" +
            "    ol li {\n" +
            "        counter-reset: list-1 list-2 list-3 list-4 list-5 list-6 list-7 list-8 list-9;\n" +
            "        counter-increment: list-0;\n" +
            "    }\n" +
            "    ol li:before {\n" +
            "        content: counter(list-0, decimal) '. ';\n" +
            "    }\n" +
            "    ol li.ql-indent-1 {\n" +
            "        counter-increment: list-1;\n" +
            "    }\n" +
            "    ol li.ql-indent-1:before {\n" +
            "        content: counter(list-1, lower-alpha) '. ';\n" +
            "    }\n" +
            "    ol li.ql-indent-1 {\n" +
            "        counter-reset: list-2 list-3 list-4 list-5 list-6 list-7 list-8 list-9;\n" +
            "    }\n" +
            "    ol li.ql-indent-2 {\n" +
            "        counter-increment: list-2;\n" +
            "    }\n" +
            "    ol li.ql-indent-2:before {\n" +
            "        content: counter(list-2, lower-roman) '. ';\n" +
            "    }\n" +
            "    ol li.ql-indent-2 {\n" +
            "        counter-reset: list-3 list-4 list-5 list-6 list-7 list-8 list-9;\n" +
            "    }\n" +
            "    ol li.ql-indent-3 {\n" +
            "        counter-increment: list-3;\n" +
            "    }\n" +
            "    ol li.ql-indent-3:before {\n" +
            "        content: counter(list-3, decimal) '. ';\n" +
            "    }\n" +
            "    ol li.ql-indent-3 {\n" +
            "        counter-reset: list-4 list-5 list-6 list-7 list-8 list-9;\n" +
            "    }\n" +
            "    ol li.ql-indent-4 {\n" +
            "        counter-increment: list-4;\n" +
            "    }\n" +
            "    ol li.ql-indent-4:before {\n" +
            "        content: counter(list-4, lower-alpha) '. ';\n" +
            "    }\n" +
            "    ol li.ql-indent-4 {\n" +
            "        counter-reset: list-5 list-6 list-7 list-8 list-9;\n" +
            "    }\n" +
            "    ol li.ql-indent-5 {\n" +
            "        counter-increment: list-5;\n" +
            "    }\n" +
            "    ol li.ql-indent-5:before {\n" +
            "        content: counter(list-5, lower-roman) '. ';\n" +
            "    }\n" +
            "    ol li.ql-indent-5 {\n" +
            "        counter-reset: list-6 list-7 list-8 list-9;\n" +
            "    }\n" +
            "    ol li.ql-indent-6 {\n" +
            "        counter-increment: list-6;\n" +
            "    }\n" +
            "    ol li.ql-indent-6:before {\n" +
            "        content: counter(list-6, decimal) '. ';\n" +
            "    }\n" +
            "    ol li.ql-indent-6 {\n" +
            "        counter-reset: list-7 list-8 list-9;\n" +
            "    }\n" +
            "    ol li.ql-indent-7 {\n" +
            "        counter-increment: list-7;\n" +
            "    }\n" +
            "    ol li.ql-indent-7:before {\n" +
            "        content: counter(list-7, lower-alpha) '. ';\n" +
            "    }\n" +
            "    ol li.ql-indent-7 {\n" +
            "        counter-reset: list-8 list-9;\n" +
            "    }\n" +
            "    ol li.ql-indent-8 {\n" +
            "        counter-increment: list-8;\n" +
            "    }\n" +
            "    ol li.ql-indent-8:before {\n" +
            "        content: counter(list-8, lower-roman) '. ';\n" +
            "    }\n" +
            "    ol li.ql-indent-8 {\n" +
            "        counter-reset: list-9;\n" +
            "    }\n" +
            "    ol li.ql-indent-9 {\n" +
            "        counter-increment: list-9;\n" +
            "    }\n" +
            "    ol li.ql-indent-9:before {\n" +
            "        content: counter(list-9, decimal) '. ';\n" +
            "    }\n" +
            "    .ql-indent-1:not(.ql-direction-rtl) {\n" +
            "        padding-left: 3em;\n" +
            "    }\n" +
            "    li.ql-indent-1:not(.ql-direction-rtl) {\n" +
            "        padding-left: 4.5em;\n" +
            "    }\n" +
            "    .ql-indent-1.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 3em;\n" +
            "    }\n" +
            "    li.ql-indent-1.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 4.5em;\n" +
            "    }\n" +
            "    .ql-indent-2:not(.ql-direction-rtl) {\n" +
            "        padding-left: 6em;\n" +
            "    }\n" +
            "    li.ql-indent-2:not(.ql-direction-rtl) {\n" +
            "        padding-left: 7.5em;\n" +
            "    }\n" +
            "    .ql-indent-2.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 6em;\n" +
            "    }\n" +
            "    li.ql-indent-2.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 7.5em;\n" +
            "    }\n" +
            "    .ql-indent-3:not(.ql-direction-rtl) {\n" +
            "        padding-left: 9em;\n" +
            "    }\n" +
            "    li.ql-indent-3:not(.ql-direction-rtl) {\n" +
            "        padding-left: 10.5em;\n" +
            "    }\n" +
            "    .ql-indent-3.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 9em;\n" +
            "    }\n" +
            "    li.ql-indent-3.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 10.5em;\n" +
            "    }\n" +
            "    .ql-indent-4:not(.ql-direction-rtl) {\n" +
            "        padding-left: 12em;\n" +
            "    }\n" +
            "    li.ql-indent-4:not(.ql-direction-rtl) {\n" +
            "        padding-left: 13.5em;\n" +
            "    }\n" +
            "    .ql-indent-4.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 12em;\n" +
            "    }\n" +
            "    li.ql-indent-4.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 13.5em;\n" +
            "    }\n" +
            "    .ql-indent-5:not(.ql-direction-rtl) {\n" +
            "        padding-left: 15em;\n" +
            "    }\n" +
            "    li.ql-indent-5:not(.ql-direction-rtl) {\n" +
            "        padding-left: 16.5em;\n" +
            "    }\n" +
            "    .ql-indent-5.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 15em;\n" +
            "    }\n" +
            "    li.ql-indent-5.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 16.5em;\n" +
            "    }\n" +
            "    .ql-indent-6:not(.ql-direction-rtl) {\n" +
            "        padding-left: 18em;\n" +
            "    }\n" +
            "    li.ql-indent-6:not(.ql-direction-rtl) {\n" +
            "        padding-left: 19.5em;\n" +
            "    }\n" +
            "    .ql-indent-6.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 18em;\n" +
            "    }\n" +
            "    li.ql-indent-6.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 19.5em;\n" +
            "    }\n" +
            "    .ql-indent-7:not(.ql-direction-rtl) {\n" +
            "        padding-left: 21em;\n" +
            "    }\n" +
            "    li.ql-indent-7:not(.ql-direction-rtl) {\n" +
            "        padding-left: 22.5em;\n" +
            "    }\n" +
            "    .ql-indent-7.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 21em;\n" +
            "    }\n" +
            "    li.ql-indent-7.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 22.5em;\n" +
            "    }\n" +
            "    .ql-indent-8:not(.ql-direction-rtl) {\n" +
            "        padding-left: 24em;\n" +
            "    }\n" +
            "    li.ql-indent-8:not(.ql-direction-rtl) {\n" +
            "        padding-left: 25.5em;\n" +
            "    }\n" +
            "    .ql-indent-8.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 24em;\n" +
            "    }\n" +
            "    li.ql-indent-8.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 25.5em;\n" +
            "    }\n" +
            "    .ql-indent-9:not(.ql-direction-rtl) {\n" +
            "        padding-left: 27em;\n" +
            "    }\n" +
            "    li.ql-indent-9:not(.ql-direction-rtl) {\n" +
            "        padding-left: 28.5em;\n" +
            "    }\n" +
            "    .ql-indent-9.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 27em;\n" +
            "    }\n" +
            "    li.ql-indent-9.ql-direction-rtl.ql-align-right {\n" +
            "        padding-right: 28.5em;\n" +
            "    }\n" +
            "    .ql-video {\n" +
            "        display: block;\n" +
            "        max-width: 100%;\n" +
            "    }\n" +
            "    .ql-video.ql-align-center {\n" +
            "        margin: 0 auto;\n" +
            "    }\n" +
            "    .ql-video.ql-align-right {\n" +
            "        margin: 0 0 0 auto;\n" +
            "    }\n" +
            "    .ql-bg-black {\n" +
            "        background-color: #000;\n" +
            "    }\n" +
            "    .ql-bg-red {\n" +
            "        background-color: #e60000;\n" +
            "    }\n" +
            "    .ql-bg-orange {\n" +
            "        background-color: #f90;\n" +
            "    }\n" +
            "    .ql-bg-yellow {\n" +
            "        background-color: #ff0;\n" +
            "    }\n" +
            "    .ql-bg-green {\n" +
            "        background-color: #008a00;\n" +
            "    }\n" +
            "    .ql-bg-blue {\n" +
            "        background-color: #06c;\n" +
            "    }\n" +
            "    .ql-bg-purple {\n" +
            "        background-color: #93f;\n" +
            "    }\n" +
            "    .ql-color-white {\n" +
            "        color: #fff;\n" +
            "    }\n" +
            "    .ql-color-red {\n" +
            "        color: #e60000;\n" +
            "    }\n" +
            "    .ql-color-orange {\n" +
            "        color: #f90;\n" +
            "    }\n" +
            "    .ql-color-yellow {\n" +
            "        color: #ff0;\n" +
            "    }\n" +
            "    .ql-color-green {\n" +
            "        color: #008a00;\n" +
            "    }\n" +
            "    .ql-color-blue {\n" +
            "        color: #06c;\n" +
            "    }\n" +
            "    .ql-color-purple {\n" +
            "        color: #93f;\n" +
            "    }\n" +
            "    .ql-font-serif {\n" +
            "        font-family: Georgia, Times New Roman, serif;\n" +
            "    }\n" +
            "    .ql-font-monospace {\n" +
            "        font-family: Monaco, Courier New, monospace;\n" +
            "    }\n" +
            "    .ql-size-small {\n" +
            "        font-size: 0.75em;\n" +
            "    }\n" +
            "    .ql-size-large {\n" +
            "        font-size: 1.5em;\n" +
            "    }\n" +
            "    .ql-size-huge {\n" +
            "        font-size: 2.5em;\n" +
            "    }\n" +
            "    .ql-direction-rtl {\n" +
            "        direction: rtl;\n" +
            "        text-align: inherit;\n" +
            "    }\n" +
            "    .ql-align-center {\n" +
            "        text-align: center;\n" +
            "    }\n" +
            "    .ql-align-justify {\n" +
            "        text-align: justify;\n" +
            "    }\n" +
            "    .ql-align-right {\n" +
            "        text-align: right;\n" +
            "    }\n" +
            "    .ql-editor.ql-blank::before {\n" +
            "        color: rgba(0,0,0,0.6);\n" +
            "        content: attr(data-placeholder);\n" +
            "        font-style: italic;\n" +
            "        left: 15px;\n" +
            "        pointer-events: none;\n" +
            "        position: absolute;\n" +
            "        right: 15px;\n" +
            "    }\n" +
            "    .ql-bubble.ql-toolbar:after,\n" +
            "    .ql-bubble .ql-toolbar:after {\n" +
            "        clear: both;\n" +
            "        content: '';\n" +
            "        display: table;\n" +
            "    }\n" +
            "    .ql-bubble.ql-toolbar button,\n" +
            "    .ql-bubble .ql-toolbar button {\n" +
            "        background: none;\n" +
            "        border: none;\n" +
            "        cursor: pointer;\n" +
            "        display: inline-block;\n" +
            "        float: left;\n" +
            "        height: 24px;\n" +
            "        padding: 3px 5px;\n" +
            "        width: 28px;\n" +
            "    }\n" +
            "    .ql-bubble.ql-toolbar button svg,\n" +
            "    .ql-bubble .ql-toolbar button svg {\n" +
            "        float: left;\n" +
            "        height: 100%;\n" +
            "    }\n" +
            "    .ql-bubble.ql-toolbar button:active:hover,\n" +
            "    .ql-bubble .ql-toolbar button:active:hover {\n" +
            "        outline: none;\n" +
            "    }\n" +
            "    .ql-bubble.ql-toolbar input.ql-image[type=file],\n" +
            "    .ql-bubble .ql-toolbar input.ql-image[type=file] {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .ql-bubble.ql-toolbar button:hover,\n" +
            "    .ql-bubble .ql-toolbar button:hover,\n" +
            "    .ql-bubble.ql-toolbar button:focus,\n" +
            "    .ql-bubble .ql-toolbar button:focus,\n" +
            "    .ql-bubble.ql-toolbar button.ql-active,\n" +
            "    .ql-bubble .ql-toolbar button.ql-active,\n" +
            "    .ql-bubble.ql-toolbar .ql-picker-label:hover,\n" +
            "    .ql-bubble .ql-toolbar .ql-picker-label:hover,\n" +
            "    .ql-bubble.ql-toolbar .ql-picker-label.ql-active,\n" +
            "    .ql-bubble .ql-toolbar .ql-picker-label.ql-active,\n" +
            "    .ql-bubble.ql-toolbar .ql-picker-item:hover,\n" +
            "    .ql-bubble .ql-toolbar .ql-picker-item:hover,\n" +
            "    .ql-bubble.ql-toolbar .ql-picker-item.ql-selected,\n" +
            "    .ql-bubble .ql-toolbar .ql-picker-item.ql-selected {\n" +
            "        color: #fff;\n" +
            "    }\n" +
            "    .ql-bubble.ql-toolbar button:hover .ql-fill,\n" +
            "    .ql-bubble .ql-toolbar button:hover .ql-fill,\n" +
            "    .ql-bubble.ql-toolbar button:focus .ql-fill,\n" +
            "    .ql-bubble .ql-toolbar button:focus .ql-fill,\n" +
            "    .ql-bubble.ql-toolbar button.ql-active .ql-fill,\n" +
            "    .ql-bubble .ql-toolbar button.ql-active .ql-fill,\n" +
            "    .ql-bubble.ql-toolbar .ql-picker-label:hover .ql-fill,\n" +
            "    .ql-bubble .ql-toolbar .ql-picker-label:hover .ql-fill,\n" +
            "    .ql-bubble.ql-toolbar .ql-picker-label.ql-active .ql-fill,\n" +
            "    .ql-bubble .ql-toolbar .ql-picker-label.ql-active .ql-fill,\n" +
            "    .ql-bubble.ql-toolbar .ql-picker-item:hover .ql-fill,\n" +
            "    .ql-bubble .ql-toolbar .ql-picker-item:hover .ql-fill,\n" +
            "    .ql-bubble.ql-toolbar .ql-picker-item.ql-selected .ql-fill,\n" +
            "    .ql-bubble .ql-toolbar .ql-picker-item.ql-selected .ql-fill,\n" +
            "    .ql-bubble.ql-toolbar button:hover .ql-stroke.ql-fill,\n" +
            "    .ql-bubble .ql-toolbar button:hover .ql-stroke.ql-fill,\n" +
            "    .ql-bubble.ql-toolbar button:focus .ql-stroke.ql-fill,\n" +
            "    .ql-bubble .ql-toolbar button:focus .ql-stroke.ql-fill,\n" +
            "    .ql-bubble.ql-toolbar button.ql-active .ql-stroke.ql-fill,\n" +
            "    .ql-bubble .ql-toolbar button.ql-active .ql-stroke.ql-fill,\n" +
            "    .ql-bubble.ql-toolbar .ql-picker-label:hover .ql-stroke.ql-fill,\n" +
            "    .ql-bubble .ql-toolbar .ql-picker-label:hover .ql-stroke.ql-fill,\n" +
            "    .ql-bubble.ql-toolbar .ql-picker-label.ql-active .ql-stroke.ql-fill,\n" +
            "    .ql-bubble .ql-toolbar .ql-picker-label.ql-active .ql-stroke.ql-fill,\n" +
            "    .ql-bubble.ql-toolbar .ql-picker-item:hover .ql-stroke.ql-fill,\n" +
            "    .ql-bubble .ql-toolbar .ql-picker-item:hover .ql-stroke.ql-fill,\n" +
            "    .ql-bubble.ql-toolbar .ql-picker-item.ql-selected .ql-stroke.ql-fill,\n" +
            "    .ql-bubble .ql-toolbar .ql-picker-item.ql-selected .ql-stroke.ql-fill {\n" +
            "        fill: #fff;\n" +
            "    }\n" +
            "    .ql-bubble.ql-toolbar button:hover .ql-stroke,\n" +
            "    .ql-bubble .ql-toolbar button:hover .ql-stroke,\n" +
            "    .ql-bubble.ql-toolbar button:focus .ql-stroke,\n" +
            "    .ql-bubble .ql-toolbar button:focus .ql-stroke,\n" +
            "    .ql-bubble.ql-toolbar button.ql-active .ql-stroke,\n" +
            "    .ql-bubble .ql-toolbar button.ql-active .ql-stroke,\n" +
            "    .ql-bubble.ql-toolbar .ql-picker-label:hover .ql-stroke,\n" +
            "    .ql-bubble .ql-toolbar .ql-picker-label:hover .ql-stroke,\n" +
            "    .ql-bubble.ql-toolbar .ql-picker-label.ql-active .ql-stroke,\n" +
            "    .ql-bubble .ql-toolbar .ql-picker-label.ql-active .ql-stroke,\n" +
            "    .ql-bubble.ql-toolbar .ql-picker-item:hover .ql-stroke,\n" +
            "    .ql-bubble .ql-toolbar .ql-picker-item:hover .ql-stroke,\n" +
            "    .ql-bubble.ql-toolbar .ql-picker-item.ql-selected .ql-stroke,\n" +
            "    .ql-bubble .ql-toolbar .ql-picker-item.ql-selected .ql-stroke,\n" +
            "    .ql-bubble.ql-toolbar button:hover .ql-stroke-miter,\n" +
            "    .ql-bubble .ql-toolbar button:hover .ql-stroke-miter,\n" +
            "    .ql-bubble.ql-toolbar button:focus .ql-stroke-miter,\n" +
            "    .ql-bubble .ql-toolbar button:focus .ql-stroke-miter,\n" +
            "    .ql-bubble.ql-toolbar button.ql-active .ql-stroke-miter,\n" +
            "    .ql-bubble .ql-toolbar button.ql-active .ql-stroke-miter,\n" +
            "    .ql-bubble.ql-toolbar .ql-picker-label:hover .ql-stroke-miter,\n" +
            "    .ql-bubble .ql-toolbar .ql-picker-label:hover .ql-stroke-miter,\n" +
            "    .ql-bubble.ql-toolbar .ql-picker-label.ql-active .ql-stroke-miter,\n" +
            "    .ql-bubble .ql-toolbar .ql-picker-label.ql-active .ql-stroke-miter,\n" +
            "    .ql-bubble.ql-toolbar .ql-picker-item:hover .ql-stroke-miter,\n" +
            "    .ql-bubble .ql-toolbar .ql-picker-item:hover .ql-stroke-miter,\n" +
            "    .ql-bubble.ql-toolbar .ql-picker-item.ql-selected .ql-stroke-miter,\n" +
            "    .ql-bubble .ql-toolbar .ql-picker-item.ql-selected .ql-stroke-miter {\n" +
            "        stroke: #fff;\n" +
            "    }\n" +
            "    @media (pointer: coarse) {\n" +
            "        .ql-bubble.ql-toolbar button:hover:not(.ql-active),\n" +
            "        .ql-bubble .ql-toolbar button:hover:not(.ql-active) {\n" +
            "            color: #ccc;\n" +
            "        }\n" +
            "        .ql-bubble.ql-toolbar button:hover:not(.ql-active) .ql-fill,\n" +
            "        .ql-bubble .ql-toolbar button:hover:not(.ql-active) .ql-fill,\n" +
            "        .ql-bubble.ql-toolbar button:hover:not(.ql-active) .ql-stroke.ql-fill,\n" +
            "        .ql-bubble .ql-toolbar button:hover:not(.ql-active) .ql-stroke.ql-fill {\n" +
            "            fill: #ccc;\n" +
            "        }\n" +
            "        .ql-bubble.ql-toolbar button:hover:not(.ql-active) .ql-stroke,\n" +
            "        .ql-bubble .ql-toolbar button:hover:not(.ql-active) .ql-stroke,\n" +
            "        .ql-bubble.ql-toolbar button:hover:not(.ql-active) .ql-stroke-miter,\n" +
            "        .ql-bubble .ql-toolbar button:hover:not(.ql-active) .ql-stroke-miter {\n" +
            "            stroke: #ccc;\n" +
            "        }\n" +
            "    }\n" +
            "    .ql-bubble {\n" +
            "        box-sizing: border-box;\n" +
            "    }\n" +
            "    .ql-bubble * {\n" +
            "        box-sizing: border-box;\n" +
            "    }\n" +
            "    .ql-bubble .ql-hidden {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .ql-bubble .ql-out-bottom,\n" +
            "    .ql-bubble .ql-out-top {\n" +
            "        visibility: hidden;\n" +
            "    }\n" +
            "    .ql-bubble .ql-tooltip {\n" +
            "        position: absolute;\n" +
            "        transform: translateY(10px);\n" +
            "    }\n" +
            "    .ql-bubble .ql-tooltip a {\n" +
            "        cursor: pointer;\n" +
            "        text-decoration: none;\n" +
            "    }\n" +
            "    .ql-bubble .ql-tooltip.ql-flip {\n" +
            "        transform: translateY(-10px);\n" +
            "    }\n" +
            "    .ql-bubble .ql-formats {\n" +
            "        display: inline-block;\n" +
            "        vertical-align: middle;\n" +
            "    }\n" +
            "    .ql-bubble .ql-formats:after {\n" +
            "        clear: both;\n" +
            "        content: '';\n" +
            "        display: table;\n" +
            "    }\n" +
            "    .ql-bubble .ql-stroke {\n" +
            "        fill: none;\n" +
            "        stroke: #ccc;\n" +
            "        stroke-linecap: round;\n" +
            "        stroke-linejoin: round;\n" +
            "        stroke-width: 2;\n" +
            "    }\n" +
            "    .ql-bubble .ql-stroke-miter {\n" +
            "        fill: none;\n" +
            "        stroke: #ccc;\n" +
            "        stroke-miterlimit: 10;\n" +
            "        stroke-width: 2;\n" +
            "    }\n" +
            "    .ql-bubble .ql-fill,\n" +
            "    .ql-bubble .ql-stroke.ql-fill {\n" +
            "        fill: #ccc;\n" +
            "    }\n" +
            "    .ql-bubble .ql-empty {\n" +
            "        fill: none;\n" +
            "    }\n" +
            "    .ql-bubble .ql-even {\n" +
            "        fill-rule: evenodd;\n" +
            "    }\n" +
            "    .ql-bubble .ql-thin,\n" +
            "    .ql-bubble .ql-stroke.ql-thin {\n" +
            "        stroke-width: 1;\n" +
            "    }\n" +
            "    .ql-bubble .ql-transparent {\n" +
            "        opacity: 0.4;\n" +
            "    }\n" +
            "    .ql-bubble .ql-direction svg:last-child {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .ql-bubble .ql-direction.ql-active svg:last-child {\n" +
            "        display: inline;\n" +
            "    }\n" +
            "    .ql-bubble .ql-direction.ql-active svg:first-child {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .ql-bubble h1 {\n" +
            "        font-size: 2em;\n" +
            "    }\n" +
            "    .ql-bubble h2 {\n" +
            "        font-size: 1.5em;\n" +
            "    }\n" +
            "    .ql-bubble h3 {\n" +
            "        font-size: 1.17em;\n" +
            "    }\n" +
            "    .ql-bubble h4 {\n" +
            "        font-size: 1em;\n" +
            "    }\n" +
            "    .ql-bubble h5 {\n" +
            "        font-size: 0.83em;\n" +
            "    }\n" +
            "    .ql-bubble h6 {\n" +
            "        font-size: 0.67em;\n" +
            "    }\n" +
            "    .ql-bubble a {\n" +
            "        text-decoration: underline;\n" +
            "    }\n" +
            "    .ql-bubble blockquote {\n" +
            "        border-left: 4px solid #ccc;\n" +
            "        margin-bottom: 5px;\n" +
            "        margin-top: 5px;\n" +
            "        padding-left: 16px;\n" +
            "    }\n" +
            "    .ql-bubble code,\n" +
            "    .ql-bubble pre {\n" +
            "        background-color: #f0f0f0;\n" +
            "        border-radius: 3px;\n" +
            "    }\n" +
            "    .ql-bubble pre {\n" +
            "        white-space: pre-wrap;\n" +
            "        margin-bottom: 5px;\n" +
            "        margin-top: 5px;\n" +
            "        padding: 5px 10px;\n" +
            "    }\n" +
            "    .ql-bubble code {\n" +
            "        font-size: 85%;\n" +
            "        padding: 2px 4px;\n" +
            "    }\n" +
            "    .ql-bubble pre.ql-syntax {\n" +
            "        background-color: #23241f;\n" +
            "        color: #f8f8f2;\n" +
            "        overflow: visible;\n" +
            "    }\n" +
            "    .ql-bubble img {\n" +
            "        max-width: 100%;\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker {\n" +
            "        color: #ccc;\n" +
            "        display: inline-block;\n" +
            "        float: left;\n" +
            "        font-size: 14px;\n" +
            "        font-weight: 500;\n" +
            "        height: 24px;\n" +
            "        position: relative;\n" +
            "        vertical-align: middle;\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker-label {\n" +
            "        cursor: pointer;\n" +
            "        display: inline-block;\n" +
            "        height: 100%;\n" +
            "        padding-left: 8px;\n" +
            "        padding-right: 2px;\n" +
            "        position: relative;\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker-label::before {\n" +
            "        display: inline-block;\n" +
            "        line-height: 22px;\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker-options {\n" +
            "        background-color: #444;\n" +
            "        display: none;\n" +
            "        min-width: 100%;\n" +
            "        padding: 4px 8px;\n" +
            "        position: absolute;\n" +
            "        white-space: nowrap;\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker-options .ql-picker-item {\n" +
            "        cursor: pointer;\n" +
            "        display: block;\n" +
            "        padding-bottom: 5px;\n" +
            "        padding-top: 5px;\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-expanded .ql-picker-label {\n" +
            "        color: #777;\n" +
            "        z-index: 2;\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-expanded .ql-picker-label .ql-fill {\n" +
            "        fill: #777;\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-expanded .ql-picker-label .ql-stroke {\n" +
            "        stroke: #777;\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-expanded .ql-picker-options {\n" +
            "        display: block;\n" +
            "        margin-top: -1px;\n" +
            "        top: 100%;\n" +
            "        z-index: 1;\n" +
            "    }\n" +
            "    .ql-bubble .ql-color-picker,\n" +
            "    .ql-bubble .ql-icon-picker {\n" +
            "        width: 28px;\n" +
            "    }\n" +
            "    .ql-bubble .ql-color-picker .ql-picker-label,\n" +
            "    .ql-bubble .ql-icon-picker .ql-picker-label {\n" +
            "        padding: 2px 4px;\n" +
            "    }\n" +
            "    .ql-bubble .ql-color-picker .ql-picker-label svg,\n" +
            "    .ql-bubble .ql-icon-picker .ql-picker-label svg {\n" +
            "        right: 4px;\n" +
            "    }\n" +
            "    .ql-bubble .ql-icon-picker .ql-picker-options {\n" +
            "        padding: 4px 0px;\n" +
            "    }\n" +
            "    .ql-bubble .ql-icon-picker .ql-picker-item {\n" +
            "        height: 24px;\n" +
            "        width: 24px;\n" +
            "        padding: 2px 4px;\n" +
            "    }\n" +
            "    .ql-bubble .ql-color-picker .ql-picker-options {\n" +
            "        padding: 3px 5px;\n" +
            "        width: 152px;\n" +
            "    }\n" +
            "    .ql-bubble .ql-color-picker .ql-picker-item {\n" +
            "        border: 1px solid transparent;\n" +
            "        float: left;\n" +
            "        height: 16px;\n" +
            "        margin: 2px;\n" +
            "        padding: 0px;\n" +
            "        width: 16px;\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker:not(.ql-color-picker):not(.ql-icon-picker) svg {\n" +
            "        position: absolute;\n" +
            "        margin-top: -9px;\n" +
            "        right: 0;\n" +
            "        top: 50%;\n" +
            "        width: 18px;\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-header .ql-picker-label[data-label]:not([data-label=''])::before,\n" +
            "    .ql-bubble .ql-picker.ql-font .ql-picker-label[data-label]:not([data-label=''])::before,\n" +
            "    .ql-bubble .ql-picker.ql-size .ql-picker-label[data-label]:not([data-label=''])::before,\n" +
            "    .ql-bubble .ql-picker.ql-header .ql-picker-item[data-label]:not([data-label=''])::before,\n" +
            "    .ql-bubble .ql-picker.ql-font .ql-picker-item[data-label]:not([data-label=''])::before,\n" +
            "    .ql-bubble .ql-picker.ql-size .ql-picker-item[data-label]:not([data-label=''])::before {\n" +
            "        content: attr(data-label);\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-header {\n" +
            "        width: 98px;\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-header .ql-picker-label::before,\n" +
            "    .ql-bubble .ql-picker.ql-header .ql-picker-item::before {\n" +
            "        content: 'Normal';\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-header .ql-picker-label[data-value=\"1\"]::before,\n" +
            "    .ql-bubble .ql-picker.ql-header .ql-picker-item[data-value=\"1\"]::before {\n" +
            "        content: 'Heading 1';\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-header .ql-picker-label[data-value=\"2\"]::before,\n" +
            "    .ql-bubble .ql-picker.ql-header .ql-picker-item[data-value=\"2\"]::before {\n" +
            "        content: 'Heading 2';\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-header .ql-picker-label[data-value=\"3\"]::before,\n" +
            "    .ql-bubble .ql-picker.ql-header .ql-picker-item[data-value=\"3\"]::before {\n" +
            "        content: 'Heading 3';\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-header .ql-picker-label[data-value=\"4\"]::before,\n" +
            "    .ql-bubble .ql-picker.ql-header .ql-picker-item[data-value=\"4\"]::before {\n" +
            "        content: 'Heading 4';\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-header .ql-picker-label[data-value=\"5\"]::before,\n" +
            "    .ql-bubble .ql-picker.ql-header .ql-picker-item[data-value=\"5\"]::before {\n" +
            "        content: 'Heading 5';\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-header .ql-picker-label[data-value=\"6\"]::before,\n" +
            "    .ql-bubble .ql-picker.ql-header .ql-picker-item[data-value=\"6\"]::before {\n" +
            "        content: 'Heading 6';\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-header .ql-picker-item[data-value=\"1\"]::before {\n" +
            "        font-size: 2em;\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-header .ql-picker-item[data-value=\"2\"]::before {\n" +
            "        font-size: 1.5em;\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-header .ql-picker-item[data-value=\"3\"]::before {\n" +
            "        font-size: 1.17em;\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-header .ql-picker-item[data-value=\"4\"]::before {\n" +
            "        font-size: 1em;\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-header .ql-picker-item[data-value=\"5\"]::before {\n" +
            "        font-size: 0.83em;\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-header .ql-picker-item[data-value=\"6\"]::before {\n" +
            "        font-size: 0.67em;\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-font {\n" +
            "        width: 108px;\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-font .ql-picker-label::before,\n" +
            "    .ql-bubble .ql-picker.ql-font .ql-picker-item::before {\n" +
            "        content: 'Sans Serif';\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-font .ql-picker-label[data-value=serif]::before,\n" +
            "    .ql-bubble .ql-picker.ql-font .ql-picker-item[data-value=serif]::before {\n" +
            "        content: 'Serif';\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-font .ql-picker-label[data-value=monospace]::before,\n" +
            "    .ql-bubble .ql-picker.ql-font .ql-picker-item[data-value=monospace]::before {\n" +
            "        content: 'Monospace';\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-font .ql-picker-item[data-value=serif]::before {\n" +
            "        font-family: Georgia, Times New Roman, serif;\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-font .ql-picker-item[data-value=monospace]::before {\n" +
            "        font-family: Monaco, Courier New, monospace;\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-size {\n" +
            "        width: 98px;\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-size .ql-picker-label::before,\n" +
            "    .ql-bubble .ql-picker.ql-size .ql-picker-item::before {\n" +
            "        content: 'Normal';\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-size .ql-picker-label[data-value=small]::before,\n" +
            "    .ql-bubble .ql-picker.ql-size .ql-picker-item[data-value=small]::before {\n" +
            "        content: 'Small';\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-size .ql-picker-label[data-value=large]::before,\n" +
            "    .ql-bubble .ql-picker.ql-size .ql-picker-item[data-value=large]::before {\n" +
            "        content: 'Large';\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-size .ql-picker-label[data-value=huge]::before,\n" +
            "    .ql-bubble .ql-picker.ql-size .ql-picker-item[data-value=huge]::before {\n" +
            "        content: 'Huge';\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-size .ql-picker-item[data-value=small]::before {\n" +
            "        font-size: 10px;\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-size .ql-picker-item[data-value=large]::before {\n" +
            "        font-size: 18px;\n" +
            "    }\n" +
            "    .ql-bubble .ql-picker.ql-size .ql-picker-item[data-value=huge]::before {\n" +
            "        font-size: 32px;\n" +
            "    }\n" +
            "    .ql-bubble .ql-color-picker.ql-background .ql-picker-item {\n" +
            "        background-color: #fff;\n" +
            "    }\n" +
            "    .ql-bubble .ql-color-picker.ql-color .ql-picker-item {\n" +
            "        background-color: #000;\n" +
            "    }\n" +
            "    .ql-bubble .ql-toolbar .ql-formats {\n" +
            "        margin: 8px 12px 8px 0px;\n" +
            "    }\n" +
            "    .ql-bubble .ql-toolbar .ql-formats:first-child {\n" +
            "        margin-left: 12px;\n" +
            "    }\n" +
            "    .ql-bubble .ql-color-picker svg {\n" +
            "        margin: 1px;\n" +
            "    }\n" +
            "    .ql-bubble .ql-color-picker .ql-picker-item.ql-selected,\n" +
            "    .ql-bubble .ql-color-picker .ql-picker-item:hover {\n" +
            "        border-color: #fff;\n" +
            "    }\n" +
            "    .ql-bubble .ql-tooltip {\n" +
            "        background-color: #444;\n" +
            "        border-radius: 25px;\n" +
            "        color: #fff;\n" +
            "    }\n" +
            "    .ql-bubble .ql-tooltip-arrow {\n" +
            "        border-left: 6px solid transparent;\n" +
            "        border-right: 6px solid transparent;\n" +
            "        content: \" \";\n" +
            "        display: block;\n" +
            "        left: 50%;\n" +
            "        margin-left: -6px;\n" +
            "        position: absolute;\n" +
            "    }\n" +
            "    .ql-bubble .ql-tooltip:not(.ql-flip) .ql-tooltip-arrow {\n" +
            "        border-bottom: 6px solid #444;\n" +
            "        top: -6px;\n" +
            "    }\n" +
            "    .ql-bubble .ql-tooltip.ql-flip .ql-tooltip-arrow {\n" +
            "        border-top: 6px solid #444;\n" +
            "        bottom: -6px;\n" +
            "    }\n" +
            "    .ql-bubble .ql-tooltip.ql-editing .ql-tooltip-editor {\n" +
            "        display: block;\n" +
            "    }\n" +
            "    .ql-bubble .ql-tooltip.ql-editing .ql-formats {\n" +
            "        visibility: hidden;\n" +
            "    }\n" +
            "    .ql-bubble .ql-tooltip-editor {\n" +
            "        display: none;\n" +
            "    }\n" +
            "    .ql-bubble .ql-tooltip-editor input[type=text] {\n" +
            "        background: transparent;\n" +
            "        border: none;\n" +
            "        color: #fff;\n" +
            "        font-size: 13px;\n" +
            "        height: 100%;\n" +
            "        outline: none;\n" +
            "        padding: 10px 20px;\n" +
            "        position: absolute;\n" +
            "        width: 100%;\n" +
            "    }\n" +
            "    .ql-bubble .ql-tooltip-editor a {\n" +
            "        top: 10px;\n" +
            "        position: absolute;\n" +
            "        right: 20px;\n" +
            "    }\n" +
            "    .ql-bubble .ql-tooltip-editor a:before {\n" +
            "        color: #ccc;\n" +
            "        content: \"\\D7\";\n" +
            "        font-size: 16px;\n" +
            "        font-weight: bold;\n" +
            "    }\n" +
            "    .ql-container.ql-bubble:not(.ql-disabled) a {\n" +
            "        position: relative;\n" +
            "        white-space: nowrap;\n" +
            "    }\n" +
            "    .ql-container.ql-bubble:not(.ql-disabled) a::before {\n" +
            "        background-color: #444;\n" +
            "        border-radius: 15px;\n" +
            "        top: -5px;\n" +
            "        font-size: 12px;\n" +
            "        color: #fff;\n" +
            "        content: attr(href);\n" +
            "        font-weight: normal;\n" +
            "        overflow: hidden;\n" +
            "        padding: 5px 15px;\n" +
            "        text-decoration: none;\n" +
            "        z-index: 1;\n" +
            "    }\n" +
            "    .ql-container.ql-bubble:not(.ql-disabled) a::after {\n" +
            "        border-top: 6px solid #444;\n" +
            "        border-left: 6px solid transparent;\n" +
            "        border-right: 6px solid transparent;\n" +
            "        top: 0;\n" +
            "        content: \" \";\n" +
            "        height: 0;\n" +
            "        width: 0;\n" +
            "    }\n" +
            "    .ql-container.ql-bubble:not(.ql-disabled) a::before,\n" +
            "    .ql-container.ql-bubble:not(.ql-disabled) a::after {\n" +
            "        left: 0;\n" +
            "        margin-left: 50%;\n" +
            "        position: absolute;\n" +
            "        transform: translate(-50%, -100%);\n" +
            "        transition: visibility 0s ease 200ms;\n" +
            "        visibility: hidden;\n" +
            "    }\n" +
            "    .ql-container.ql-bubble:not(.ql-disabled) a:hover::before,\n" +
            "    .ql-container.ql-bubble:not(.ql-disabled) a:hover::after {\n" +
            "        visibility: visible;\n" +
            "    }\n" +
            "</style>";


}
