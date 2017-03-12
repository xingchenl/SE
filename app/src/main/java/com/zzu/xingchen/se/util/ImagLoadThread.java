package com.zzu.xingchen.se.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by xingchen on 2016/8/24.
 */
public class ImagLoadThread {
    String mUrl=null;
    private ImageView myimageView;
    Handler myhandle=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);


            if(myimageView.getTag().equals(mUrl)) {
                myimageView.setImageBitmap((Bitmap) msg.obj);

            }
        }
    };

  public void  ShowImageByThread(ImageView imageView, final String url){
            mUrl=url;
            myimageView=imageView;
      new Thread(){
          @Override
          public void run() {
              super.run();
              Bitmap bitmap=getBitmapForUrl(url);
              Message message=Message.obtain();
              message.obj=bitmap;
              myhandle.sendMessage(message);
          }
      }.start();

  }

    public Bitmap getBitmapForUrl(String urlSting){
        Bitmap bitmap=null;
        InputStream is=null;
        try {
            URL url=new URL(urlSting);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            is=new BufferedInputStream(connection.getInputStream());
            bitmap= BitmapFactory.decodeStream(is);
            connection.disconnect();
            return bitmap;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bitmap;
    }

}
