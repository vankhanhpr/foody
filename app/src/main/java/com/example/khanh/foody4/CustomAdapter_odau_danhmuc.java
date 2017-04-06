package com.example.khanh.foody4;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.khanh.foody4.BAO.TestAdapter_restaurant;
import com.example.khanh.foody4.CLASS_GET_SET.quanan_getset;
import com.example.khanh.foody4.CUSTOMADAPTER.CustomAdapter_odau_nhahang;
import com.example.khanh.foody4.CUSTOMADAPTER.getdata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Khanh on 4/3/2017.
 */

public class CustomAdapter_odau_danhmuc extends BaseAdapter
{

    List<String>arr_tennhahang;
    List<String>arr_diachi;
    List<Float>arr_diem;

    List<String> result;
    List<Integer> imageId;

    private  ArrayList<quanan_getset> listTenNhaHang;

    private static LayoutInflater inflater=null;
    Activity mn;
    int vitri=0;
    private  ArrayList<quanan_getset> listTenNhaHang2;
    TestAdapter_restaurant ta_nhahang1;
    public MainActivity mainActivity;

    Context context;
    public CustomAdapter_odau_danhmuc (MainActivity mainActivity,List<String> prgmNameList, List<Integer> prgmImages)
    {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=mainActivity;
        this.mn=mainActivity;
        imageId=prgmImages;
        this.context = mainActivity.getApplicationContext();
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mainActivity = mainActivity;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img,imv_check_a;

    }
    @Override
    public View getView(final int position, View convertView, final ViewGroup parent)
    {
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.layout_listview, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView10);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView10);
        holder.tv.setText(result.get(position));
        holder.imv_check_a=(ImageView)rowView.findViewById(R.id.imv_check);
        holder.img.setImageResource(imageId.get(position));

        if(position==vitri)
        {
            //holder.img.setColorFilter(context.getResources().getColor(R.color.blu_icon));
            holder.tv.setTextColor(context.getResources().getColor(R.color.red1));
            holder.imv_check_a.setImageResource(R.drawable.icon_check);
            holder.imv_check_a.setColorFilter(context.getResources().getColor(R.color.red1));
            holder.img.setVisibility(View.GONE);
        }

        rowView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TextView tv1;
                ImageView imv_check1;
                LinearLayout tab_liner;
                LinearLayout tab_chinh_odau;
                /*// TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked "+result.get(position), Toast.LENGTH_LONG).show();
                holderimv_check=(ImageView)v.findViewById(R.id.imv_check);.
*/
                for(int i=0;i<parent.getChildCount();i++)
                {
                    tv1=(TextView)parent.getChildAt(i).findViewById(R.id.textView10);
                    //img1=(ImageView)parent.getChildAt(i).findViewById(R.id.imageView10);
                    imv_check1=(ImageView)parent.getChildAt(i).findViewById(R.id.imv_check);

                    tv1.setTextColor(context.getResources().getColor(R.color.black_icon));
                    //img1.setColorFilter(null);
                    imv_check1.setImageResource(0);
                }
                if(position==0)
                {
                    odau.tv_odau_danhmuc.setTextColor(context.getResources().getColor(R.color.colortab));
                }
                else
                {
                    odau.tv_odau_danhmuc.setTextColor(context.getResources().getColor(R.color.red1));
                }
                vitri=position;
                getdata.setDanhmuc(position);
                tv1=(TextView)v.findViewById(R.id.textView10);
                //img1=(ImageView)v.findViewById(R.id.imageView10);
                imv_check1=(ImageView)v.findViewById(R.id.imv_check);
                tv1.setTextColor(context.getResources().getColor(R.color.red1));
                //img1.setColorFilter(context.getResources().getColor(R.color.blu_icon));
                imv_check1.setImageResource(R.drawable.icon_check);
                imv_check1.setColorFilter(context.getResources().getColor(R.color.red1));

                TextView tv_odau_danhmuc;
                tv_odau_danhmuc=(TextView)mn.findViewById(R.id.tv_odau_danhmuc);
                tv_odau_danhmuc.setText(tv1.getText());

                tab_liner=(LinearLayout)mn.findViewById(R.id.tab_listview_odau_danhmuc);
                tab_chinh_odau=(LinearLayout) mn.findViewById(R.id.tab_chinh_odau);
                tab_liner.setVisibility(v.GONE);
                tab_chinh_odau.setVisibility(v.VISIBLE);
                mainActivity.tab_button_nagi.setVisibility(v.VISIBLE);
                odau.button_huy.setVisibility(v.GONE);


                odau.flag_danhmuc=true;
                //odau.lv_nhahang_odau.setAdapter(odau.cs);
                odau.tab_danhmuc.setBackgroundResource(R.color.colorWhite);
                getListTenNhaHang();
                setItem_nhahang();
            }

            public   void getListTenNhaHang()
            {
                ta_nhahang1=new TestAdapter_restaurant(context);
                listTenNhaHang2 = new ArrayList<>();
                listTenNhaHang2 = ta_nhahang1.getListNhaHang(getdata.getDanhmuc());
            }
            public void setItem_nhahang()
            {
                arr_diem= new ArrayList<>();
                arr_diachi=new ArrayList<>();
                arr_tennhahang=new ArrayList<>();
                for(int i=0;i<listTenNhaHang2.size();i++)
                {
                    arr_tennhahang.add(listTenNhaHang2.get(i).getTenNhaHang());
                    arr_diachi.add(listTenNhaHang2.get(i).getDiaChi());
                    arr_diem.add(listTenNhaHang2.get(i).getDiem());
                    //arr_picture.add(listTenNhaHang.get(i).getAnh());
                }
                odau.lv_nhahang_odau.setAdapter(new CustomAdapter_odau_nhahang(mainActivity,arr_tennhahang,arr_diachi,arr_diem,listTenNhaHang2));
            }
        });
        return rowView;
    }

}
