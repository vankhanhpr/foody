package com.example.khanh.foody4.CUSTOMADAPTER;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.khanh.foody4.BAO.TestAdapter_angi_monan;
import com.example.khanh.foody4.BAO.TestAdapter_restaurant;
import com.example.khanh.foody4.CLASS_GET_SET.monan_getset;
import com.example.khanh.foody4.CLASS_GET_SET.quanan_getset;
import com.example.khanh.foody4.R;

import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * Created by Khanh on 4/5/2017.
 */

public class CustomAdapter_angi_monan extends BaseAdapter
{
    //khởi tạo các đối tượng
    private static Context context;
    private final LayoutInflater inflater;
    static Activity activity;
    static TestAdapter_restaurant restaurant_controller;
    static TestAdapter_angi_monan food_controller;
    List<monan_getset> listfood;
    //hàm này gọi hàm trộn các đối tượng trong textview(imageView và textView) và đổ vào listview
    public CustomAdapter_angi_monan(LayoutInflater inflater, Context aContext , List<monan_getset> listfood) {

        this.context = aContext;
        this.inflater=inflater;
        activity = ((Activity) context);

        food_controller = new TestAdapter_angi_monan(context);
        restaurant_controller = new TestAdapter_restaurant(context);
        this.listfood=listfood;
    }

    //trả về độ dài  danh sách
    @Override
    public int getCount() {
        if(listfood.size()%2==0)
            return listfood.size()/2;
        else
            return listfood.size()/2+1;
    }
    //trả về vị trí click trong textview

    @Override
    public Object getItem(int position) {
        return listfood.get(position);
    }

    //trả về vị trí
    @Override
    public long getItemId(int position) {
        return position;
    }


    //trả về vị trí
    @Override
    public int getItemViewType(int position) {

        return position;
    }

    //trả về view chứa danh sách  các đối tượng để trộn
    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {

        ViewHolder holder;
        int x = position*2;
        final monan_getset food1 = this.listfood.get(x);
        if (convertView == null) {
            convertView = LayoutInflater.from(this.context).inflate(R.layout.layout_view_angi_nhahang, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.renderData1(food1,convertView);
        if(listfood.size()>x+1) {
            final monan_getset food2 = this.listfood.get(x+1);
            holder.renderData2(food2,convertView);
        }
        return convertView;
    }
    //khai báo các đối tượng

    static class ViewHolder {


        //food 1
        LinearLayout ln_food1,ln_info1;
        ImageView imv_info_1,imv_user1;
        TextView food_name1,rest_name1,tv_address1,tv_username1,tv_des1;
        //food 2
        LinearLayout ln_food2,ln_info2;
        ImageView imv_info_2,imv_user2;
        TextView food_name2,rest_name2,tv_address2,tv_username2,tv_des2;

        //RoundedImageView x;


        //link các đối tượng với giao diện
        public ViewHolder(View view) {
            //food1
            ln_food1 = (LinearLayout)view.findViewById(R.id.food_ln_food1);
            ln_info1 = (LinearLayout)view.findViewById(R.id.food_ln_info1);
            imv_info_1 = (ImageView)view.findViewById(R.id.food_imv_info1);
            imv_user1 = (ImageView)view.findViewById(R.id.food_imv_user1);
            food_name1 = (TextView)view.findViewById(R.id.food_tv_foodname1);
            rest_name1 = (TextView)view.findViewById(R.id.food_tv_restname1);
            tv_address1 = (TextView)view.findViewById(R.id.food_tv_address1);
            tv_username1 = (TextView)view.findViewById(R.id.food_tv_username1);
            tv_des1 = (TextView)view.findViewById(R.id.food_tv_des1);
            //x = (RoundedImageView)view.findViewById(R.id.food_imv_info1);
            //food2
            ln_food2 = (LinearLayout)view.findViewById(R.id.food_ln_food2);
            ln_info2 = (LinearLayout)view.findViewById(R.id.food_ln_info2);
            imv_info_2 = (ImageView)view.findViewById(R.id.food_imv_info2);
            imv_user2 = (ImageView)view.findViewById(R.id.food_imv_user2);
            food_name2 = (TextView)view.findViewById(R.id.food_tv_foodname2);
            rest_name2 = (TextView)view.findViewById(R.id.food_tv_restname2);
            tv_address2 = (TextView)view.findViewById(R.id.food_tv_address2);
            tv_username2 = (TextView)view.findViewById(R.id.food_tv_username2);
            tv_des2 = (TextView)view.findViewById(R.id.food_tv_des2);
        }



        //

        public void renderData1(final monan_getset f,  View view) {
            ln_food1.setVisibility(View.VISIBLE);
            food_name1.setText(f.getTenmonan());
            quanan_getset r = restaurant_controller.getNhaHang(f.getManhahang());
            rest_name1.setText(r.getTenNhaHang());
            tv_address1.setText(r.getDiaChi());

/*            Bitmap bm, circularBitmap;
            bm = BitmapFactory.decodeByteArray(f.getAnh(), 0, f.getAnh().length);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.PNG, 5, stream);
            byte[] byteArray = stream.toByteArray();*/
            Glide
                    .with(context)
                    .load(f.getAnh())
                    .crossFade()
                    .into(imv_info_1);
            ln_info1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickFoodInfo(f.getMamonan());
                }
            });
        }
        public void renderData2(final monan_getset f,  View view) {
            ln_food2.setVisibility(View.VISIBLE);
            food_name2.setText(f.getTenmonan());
            quanan_getset r = restaurant_controller.getNhaHang(f.getManhahang());
            rest_name2.setText(r.getTenNhaHang());
            tv_address2.setText(r.getDiaChi());

            Bitmap bm, circularBitmap;
            bm = BitmapFactory.decodeByteArray(f.getAnh(), 0, f.getAnh().length);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            byte[] byteArray = stream.toByteArray();
            Glide.with(context).load(f.getAnh()).crossFade().into(imv_info_2);
            /*Bitmap bm = BitmapFactory.decodeByteArray(f.getAnh(), 0, f.getAnh().length);
            imv_info_1.setImageBitmap(bm);*/
            ln_info2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    clickFoodInfo(f.getMamonan());
                }
            });
        }

    }

    public static void clickFoodInfo(int food_id){
        Toast.makeText(context,"you licked food: "+ Integer.toString(food_id), Toast.LENGTH_SHORT).show();
    }
}
