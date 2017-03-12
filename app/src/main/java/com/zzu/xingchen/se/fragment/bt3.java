package com.zzu.xingchen.se.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.zzu.xingchen.se.MyApplacions;
import com.zzu.xingchen.se.R;

import com.zzu.xingchen.se.persion.MyDrafts;
import com.zzu.xingchen.se.persion.MyRelease;
import com.zzu.xingchen.se.persion.Myinformation;
import com.zzu.xingchen.se.persion.Mypraise;
import com.zzu.xingchen.se.persion.UseStatistics;
import com.zzu.xingchen.se.util.BitmapCache;
import com.zzu.xingchen.se.util.Statice_url;
import com.zzu.xingchen.se.view.CircleImg;

/**
 * Created by xingchen on 2016/8/20.
 */
public class bt3 extends Fragment {
    CircleImg img;
    LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4,linearLayout5;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment3,container,false);
        img= (CircleImg) root.findViewById(R.id.logo);
        linearLayout1= (LinearLayout) root.findViewById(R.id.listview_f3_1);
        linearLayout2= (LinearLayout) root.findViewById(R.id.listview_f3_2);
        linearLayout3= (LinearLayout) root.findViewById(R.id.listview_f3_3);
        linearLayout4= (LinearLayout) root.findViewById(R.id.listview_f3_4);
        linearLayout5= (LinearLayout) root.findViewById(R.id.listview_f3_5);
        MyApplacions applacions= (MyApplacions) getActivity().getApplication();
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), Myinformation.class);
                startActivity(intent);
            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), MyRelease.class);
                startActivity(intent);

            }
        });

        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), MyDrafts.class);
                startActivity(intent);
            }
        });

        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), Mypraise.class);
                startActivity(intent);
            }
        });
        linearLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), UseStatistics.class);
                startActivity(intent);


            }
        });

        RequestQueue mQueue = Volley.newRequestQueue(getActivity().getApplicationContext());

        ImageLoader imageLoader = new ImageLoader(mQueue,new BitmapCache());
        Statice_url ul=new Statice_url();
        ImageLoader.ImageListener listener = ImageLoader.getImageListener(img,R.drawable.passport_default_avatar, R.drawable.passport_default_avatar);
        imageLoader.get(ul.getService_me_URL()+"imag?url="+applacions.getId(), listener);

        return root;
    }
}
