package com.zzu.xingchen.se.util;

/**
 * Created by xingchen on 2016/8/31.
 */
public class Statice_url {
    String Service_me_URL = "http://115.29.47.36:8080/union/";


    // String Service_me_URL="http://192.168.1.103:8088/union/";
    // String Service_me_URL="http://192.168.253.124:8088/union/";

    String typer[] = {"空类型", "学校", "企业", "校园招聘", "事业单位", "兼职信息"};

    public String getTyper(int i) {
        return typer[i];
    }

    public String getService_me_URL() {
        return Service_me_URL;
    }


}
