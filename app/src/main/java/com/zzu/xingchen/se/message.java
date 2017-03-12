package com.zzu.xingchen.se;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zzu.xingchen.se.entity.MyInformation;
import com.zzu.xingchen.se.util.Statice_url;

public class message extends AppCompatActivity {
TextView typer,time,title,message;
    ImageView imageView;
    TextView setJia;
    Button leavMess;
    Context context;
    Statice_url ul=new Statice_url();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        typer= (TextView) findViewById(R.id.list_item_typer);
        time= (TextView) findViewById(R.id.list_item_time);
        title= (TextView) findViewById(R.id.list_item_title);
        message= (TextView) findViewById(R.id.list_item_message);
        context=this;
        imageView= (ImageView) findViewById(R.id.mess_image);
        setJia= (TextView) findViewById(R.id.zanVELL);
        leavMess= (Button) findViewById(R.id.messButton);
        MyApplacions applacions= (MyApplacions) getApplication();

        MyInformation information=applacions.getInformation();

        typer.setText(ul.getTyper(information.getTyper()));
        time.setText(information.getActiveTime());
        title.setText(information.getTitle());
        message.setText(information.getMyMessage());

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setJia.setText("+1!");
            }
        });

        leavMess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,LeavMessage.class);
                startActivity(intent);
            }
        });
    }
}
