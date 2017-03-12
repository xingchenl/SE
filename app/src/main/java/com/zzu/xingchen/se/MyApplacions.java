package com.zzu.xingchen.se;

import android.app.Application;

import com.zzu.xingchen.se.entity.MyInformation;

import java.util.List;

/**
 * Created by xingchen on 2016/8/31.
 */
public class MyApplacions extends Application {
    String id="18039225721";

    List<MyInformation> data1,data2,data3,data4,data5;
    MyInformation information=null;

    public MyInformation getInformation() {
        return information;
    }

    public void setInformation(MyInformation information) {
        this.information = information;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<MyInformation> getData1() {
        return data1;
    }

    public List<MyInformation> getData2() {
        return data2;
    }

    public List<MyInformation> getData3() {
        return data3;
    }

    public List<MyInformation> getData4() {
        return data4;
    }

    public List<MyInformation> getData5() {
        return data5;
    }

    public void setData1(List<MyInformation> data1) {
        this.data1 = data1;
    }

    public void setData2(List<MyInformation> data2) {
        this.data2 = data2;
    }

    public void setData3(List<MyInformation> data3) {
        this.data3 = data3;
    }

    public void setData4(List<MyInformation> data4) {
        this.data4 = data4;
    }

    public void setData5(List<MyInformation> data5) {
        this.data5 = data5;
    }
}
