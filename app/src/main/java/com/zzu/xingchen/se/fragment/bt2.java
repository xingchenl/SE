package com.zzu.xingchen.se.fragment;

import android.app.Application;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zzu.xingchen.se.MyApplacions;
import com.zzu.xingchen.se.R;
import com.zzu.xingchen.se.util.Statice_url;

/**
 * Created by xingchen on 2016/8/20.
 */
public class bt2 extends Fragment {
    WebView webView;
    Statice_url ul=new Statice_url();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment2,container,false);
            webView= (WebView) root.findViewById(R.id.fragment2_webView);
        MyApplacions applacions= (MyApplacions) getActivity().getApplication();
        WebSettings webSettings = webView.getSettings();
        //设置WebView属性，能够执行Javascript脚本
        webSettings.setJavaScriptEnabled(true);
        //设置可以访问文件
        webSettings.setAllowFileAccess(true);
        //设置支持缩放
       // webSettings.setBuiltInZoomControls(true);
        //加载需要显示的网页
        webView.loadUrl(ul.getService_me_URL()+"leavingMess?phone="+applacions.getId());
        //设置Web视图
        webView.setWebViewClient(new webViewClient ());

        return root;
    }


    //设置回退
    //覆盖Activity类的onKeyDown(int keyCoder,KeyEvent event)方法
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack(); //goBack()表示返回WebView的上一页面
            return true;
        }
        getActivity().finish();//结束退出程序
        return false;
    }



    //Web视图
    private class webViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}
