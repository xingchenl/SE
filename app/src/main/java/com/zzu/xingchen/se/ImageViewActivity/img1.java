package com.zzu.xingchen.se.ImageViewActivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.zzu.xingchen.se.MyApplacions;
import com.zzu.xingchen.se.R;
import com.zzu.xingchen.se.adapt.List_Adapt;
import com.zzu.xingchen.se.entity.MyInformation;
import com.zzu.xingchen.se.message;
import com.zzu.xingchen.se.util.EventMess;
import com.zzu.xingchen.se.util.Statice_url;
import com.zzu.xingchen.se.util.utilVolleyString;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

import de.greenrobot.event.EventBus;

public class img1 extends AppCompatActivity {
    List<MyInformation> myData;
    List_Adapt myAdapt;
    ListView listView;
    Context context;
    int length=0;
    String jsonarrList;
    Statice_url ul=new Statice_url();
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img1);
        EventBus.getDefault().register(this);

        context=this;
        listView=(ListView)findViewById(R.id.listview_my_s);
        searchView= (SearchView) findViewById(R.id.searchView1);
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        String url=ul.getService_me_URL()+"list?number=1";
        utilVolleyString ut= new utilVolleyString(url,context);
        ut.getString();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText( context,"你点击了第" + i + "项", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context,message.class);

                MyInformation information=myData.get(i);
                MyApplacions applacions= (MyApplacions) getApplication();
                applacions.setInformation(information);
                startActivity(intent);
            }
        });

    }

    public void onEventMainThread(EventMess event) {
        String s=event.getMessage();
      //  String msg = "学生z列表：" + s;
       // Toast.makeText(img1.this, s, Toast.LENGTH_LONG).show();

        try {
   ;

            jsonarrList=event.getMessage();
            JSONArray jsonArray=new JSONArray(s);
            length=jsonArray.length();
            myData=new LinkedList<MyInformation>();
            Log.e("数组长度：", String.valueOf(length));
            for(int i=0;i<length-1;i++){
                    JSONObject obj= (JSONObject) jsonArray.get(i);


                MyInformation se=new MyInformation(Integer.parseInt( obj.get("id").toString()),Integer.parseInt(obj.get("typer").toString()),obj.get("title").toString(),obj.get("phoneNumber").toString(),obj.get("activeTime").toString(),obj.get("myMessage").toString());


                Log.e("对象数组",se.toString());
                    myData.add(se);
                myAdapt=new List_Adapt(myData,context);

                listView.setAdapter(myAdapt);



            }




        } catch (JSONException e) {
            e.printStackTrace();
        }



     //   Log.d("harvic", msg);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
