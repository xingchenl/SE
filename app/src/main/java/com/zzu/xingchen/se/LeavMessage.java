package com.zzu.xingchen.se;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zzu.xingchen.se.util.Statice_url;
import com.zzu.xingchen.se.util.utilVolleyString;

public class LeavMessage extends AppCompatActivity {
   Statice_url ul=new Statice_url();
    TextView title_T,message_T;
    Button button;
    MyApplacions applacions;
    String title,message,phone,url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leav_message);
        title_T= (TextView) findViewById(R.id.leav_title_l);
        message_T= (TextView) findViewById(R.id.leav_mess_l);
        button= (Button) findViewById(R.id.leav_subit_l);
        final Context context=this;

        applacions= (MyApplacions) getApplication();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title=title_T.getText().toString();
                message=message_T.getText().toString();
                url=applacions.getId();
                phone=applacions.getInformation().getPhoneNumber();
                String urls=ul.getService_me_URL()+"insertLeaving?phone="+phone+"&title="+title+"&url="+url+"&message="+message;
                 utilVolleyString ut= new utilVolleyString(urls,context);
                ut.getString();

                finish();
            }
        });



    }
}
