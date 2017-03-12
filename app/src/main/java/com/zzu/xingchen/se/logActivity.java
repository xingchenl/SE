package com.zzu.xingchen.se;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.zzu.xingchen.se.util.EventMess;
import com.zzu.xingchen.se.util.Statice_url;
import com.zzu.xingchen.se.util.utilVolleyString;

import org.json.JSONException;
import org.json.JSONObject;

import de.greenrobot.event.EventBus;


public class logActivity extends AppCompatActivity {
Button button,button2;
    TextView textView1,textView2;
    MyApplacions applacions;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        context=this;
        //注册EventBus
                EventBus.getDefault().register(context);

        button= (Button) findViewById(R.id.loginBtn);
        button2= (Button) findViewById(R.id.creat_TaxtView);
        textView1= (TextView) findViewById(R.id.log_textview1);
        textView2= (TextView) findViewById(R.id.log_textview2);
         applacions= (MyApplacions) getApplication();



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applacions.setId(textView1.getText().toString());
                Statice_url ul=new Statice_url();

                String url=ul.getService_me_URL()+"login?phone="+textView1.getText()+"&pass="+textView2.getText();

                utilVolleyString us=new utilVolleyString(url,context);
                us.getString();

            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(logActivity.this,registActivity.class);
                startActivity(intent);
            }
        });

    }

    public void onEventMainThread(EventMess event) {
        String msg = "登陆：" + event.getMessage();
        Toast.makeText(logActivity.this, msg, Toast.LENGTH_LONG).show();

        if(event.getMessage().equals("true")){
            Intent intent=new Intent(logActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }

        Log.d("harvic", msg);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
