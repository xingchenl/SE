package com.zzu.xingchen.se.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.zzu.xingchen.se.R;
import com.zzu.xingchen.se.logActivity;

/**
 * Created by xingchen on 2016/8/20.
 */
public class bt4 extends Fragment{
    RelativeLayout remove,updown,help,update,about;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment4,container,false);
        remove= (RelativeLayout) root.findViewById(R.id.relative_1);
        updown= (RelativeLayout) root.findViewById(R.id.relative_2);
        help= (RelativeLayout) root.findViewById(R.id.relative_3);
        update= (RelativeLayout) root.findViewById(R.id.relative_4);
        about= (RelativeLayout) root.findViewById(R.id.relative_5);

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "清除缓存", Toast.LENGTH_LONG).show();
            }
        });

        updown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(getActivity(),logActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });


        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "帮助正在开发。。", Toast.LENGTH_LONG).show();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "当前为最新版本！", Toast.LENGTH_LONG).show();
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                new AlertDialog.Builder(getActivity()).setTitle("关于我们！")//设置对话框标题

                        .setMessage("这是我们团队上线的测试APP！")//设置显示的内容

                        .setPositiveButton("确定",new DialogInterface.OnClickListener() {//添加确定按钮



                            @Override

                            public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件

                                // TODO Auto-generated method stub



                            }

                        }).setNegativeButton("返回",new DialogInterface.OnClickListener() {//添加返回按钮



                    @Override

                    public void onClick(DialogInterface dialog, int which) {//响应事件

                        // TODO Auto-generated method stub

                        Log.i("alertdialog"," 请保存数据！");

                    }

                }).show();//在按键响应事件中显示此对话框

            }
        });
        return root;
    }







}
