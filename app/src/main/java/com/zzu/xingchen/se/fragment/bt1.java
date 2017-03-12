package com.zzu.xingchen.se.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zzu.xingchen.se.ImageViewActivity.img1;
import com.zzu.xingchen.se.ImageViewActivity.img2;
import com.zzu.xingchen.se.ImageViewActivity.img3;
import com.zzu.xingchen.se.ImageViewActivity.img4;
import com.zzu.xingchen.se.ImageViewActivity.img5;
import com.zzu.xingchen.se.ImageViewActivity.img6;
import com.zzu.xingchen.se.R;

/**
 * Created by xingchen on 2016/8/20.
 */
public class bt1 extends Fragment {
private ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment1,container,false);
        imageView1= (ImageView) root.findViewById(R.id.imageView_1);
        imageView2= (ImageView) root.findViewById(R.id.imageView_2);
        imageView3= (ImageView) root.findViewById(R.id.imageView_3);
        imageView4= (ImageView) root.findViewById(R.id.imageView_4);
        imageView5= (ImageView) root.findViewById(R.id.imageView_5);
        imageView6= (ImageView) root.findViewById(R.id.imageView_6);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),img1.class);
                startActivity(intent);

            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),img2.class);
                startActivity(intent);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),img3.class);
                startActivity(intent);
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),img4.class);
                startActivity(intent);
            }
        });

        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),img5.class);
                startActivity(intent);
            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),img6.class);
                startActivity(intent);
            }
        });
        return root;
    }
}
