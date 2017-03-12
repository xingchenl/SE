package com.zzu.xingchen.se.adapt;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zzu.xingchen.se.R;
import com.zzu.xingchen.se.entity.MyInformation;
import com.zzu.xingchen.se.util.ImagLoadThread;
import com.zzu.xingchen.se.util.Statice_url;

import java.util.List;

/**
 * Created by xingchen on 2016/7/22.
 */
public class List_Adapt extends BaseAdapter {

    List<MyInformation> data;
    Context mycontext;

   public List_Adapt(List<MyInformation> data , Context context){

        this.data=data;
       this.mycontext=context;
    }

    @Override
    public int getCount() {


        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        ViewHolder holder=null;
        if(view==null){
            view= LayoutInflater.from(mycontext).inflate(R.layout.item,null);
            holder=new ViewHolder();
           holder.image=(ImageView) view.findViewById(R.id.list_item_img);
            holder.title=(TextView) view.findViewById(R.id.myTitle);
            holder.time=(TextView) view.findViewById(R.id.date);

            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        ImagLoadThread imagLoadThread=new ImagLoadThread();
        holder.title.setText(data.get(position).getTitle());
        holder.time.setText(data.get(position).getActiveTime());
        Statice_url ul=new Statice_url();
        Log.e("xzdefasfasfsa",data.get(position).getPhoneNumber());
        String url=ul.getService_me_URL()+"imag?url="+data.get(position).getPhoneNumber();
        holder.image.setTag(url);
        imagLoadThread.ShowImageByThread(holder.image,url);

//        view= LayoutInflater.from(mycontext).inflate(R.layout.item,null);
  //      ImageView img= (ImageView) view.findViewById(R.id.list_item_img);
//        TextView mytitle= (TextView) view.findViewById(R.id.myTitle);
//        TextView mydata= (TextView) view.findViewById(R.id.date);
//        mytitle.setText(data.get(position).getTitle());
//        mydata.setText(data.get(position).getTime());

//        RequestQueue mQueue = Volley.newRequestQueue(mycontext);
//
//        ImageLoader imageLoader = new ImageLoader(mQueue,new BitmapCache());
//
//        ImageLoader.ImageListener listener = ImageLoader.getImageListener(img,R.drawable.passport_default_avatar, R.drawable.passport_default_avatar);
//        imageLoader.get("http://115.29.47.36:8080/SE/image?url="+data.get(position).getUrl(), listener);



        return view;
    }

    private static class ViewHolder{
        ImageView image;
        TextView title;
        TextView time;

    }


}
