package com.zzu.xingchen.se.persion;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.zzu.xingchen.se.MainActivity;
import com.zzu.xingchen.se.MyApplacions;
import com.zzu.xingchen.se.R;
import com.zzu.xingchen.se.logActivity;
import com.zzu.xingchen.se.util.EventMess;
import com.zzu.xingchen.se.util.Statice_url;
import com.zzu.xingchen.se.util.utilVolleyString;

import org.json.JSONException;
import org.json.JSONObject;

import de.greenrobot.event.EventBus;


//个人信息

public class Myinformation extends AppCompatActivity {
Statice_url ul=new Statice_url();
    Context context;
    TextView id,typer,username,time,phone,address,describe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinformation);
        context=this;
        id= (TextView) findViewById(R.id.my_id);
        typer= (TextView) findViewById(R.id.my_typer);
        username= (TextView) findViewById(R.id.my_name);
        time= (TextView) findViewById(R.id.my_time);
        phone= (TextView) findViewById(R.id.my_phone);
        address= (TextView) findViewById(R.id.my_address);
        describe= (TextView) findViewById(R.id.my_describe);
        EventBus.getDefault().register(context);
        MyApplacions application= (MyApplacions) getApplication();

        String url=ul.getService_me_URL()+"queryUser?phone="+application.getId();
        utilVolleyString uvs=new utilVolleyString(url,context);

     uvs.getString();




    }



    public void onEventMainThread(EventMess event) {
        String msg =event.getMessage();


        try {
            JSONObject ob=new JSONObject(msg);

            id.setText(ob.get("id").toString());
            typer.setText(ob.get("type").toString());
            username.setText(ob.get("username").toString());
            time.setText(ob.get("time").toString());
            phone.setText(ob.get("phoneNumber").toString());
            address.setText(ob.get("address").toString());
            describe.setText(ob.get("describe").toString());


        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("harvic", msg);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
