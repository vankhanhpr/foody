


package com.example.khanh.foody4.CUSTOMADAPTER;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.khanh.foody4.MainActivity;
import com.example.khanh.foody4.R;
import com.example.khanh.foody4.SELECT_CITY_DISTRICT.Select_province;
import com.example.khanh.foody4.odau;

import java.util.List;

/**
 * Created by Khanh on 4/3/2017.*/



public class Customadapter_odau_thanhpho extends BaseAdapter
{

    List<String> result;
    Context context;
    int vitri=0;

    private static LayoutInflater inflater=null;
    Customadapter_odau_thanhpho.IOnSetDefaultCity onSetDefaultCity;

    public Customadapter_odau_thanhpho(Select_province mainActivity, List<String> prgmNameList,IOnSetDefaultCity onSetDefaultCity)
    {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context = mainActivity;
        //mn=mainActivity;
        this.onSetDefaultCity=onSetDefaultCity;
        inflater =(LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return result.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    static class Holder
    {
        TextView tv_lv_select_city,tv_lv_select_macdinh;
        ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent)
    {
        // TODO Auto-generated method stub
        final Customadapter_odau_thanhpho.Holder holder = new Customadapter_odau_thanhpho.Holder();
        final View rowView;

        rowView = inflater.inflate(R.layout.layout_header_item, null);
        holder.tv_lv_select_city = (TextView) rowView.findViewById(R.id.tv_lv_select_city);
        holder.img=(ImageView)rowView.findViewById(R.id.imv_lv_select_city) ;
        holder.tv_lv_select_macdinh=(TextView)rowView.findViewById(R.id.tv_lv_select_macdinh);
        holder.tv_lv_select_city.setText(result.get(position));


        if (position == vitri)
        {
            holder.img.setVisibility(View.VISIBLE);
            holder.tv_lv_select_macdinh.setText("Mặc định");
            holder.tv_lv_select_macdinh.setTextColor(context.getResources().getColor(R.color.black_text_list1));
            holder.tv_lv_select_macdinh.setBackgroundResource(R.drawable.duongvien_goctron_listview1);
        }
        rowView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                TextView tv_lv_select_macdinh1;
                ImageView imv_check3;
                for (int i = 1;i<parent.getChildCount();i++)
                {
                    imv_check3 = (ImageView)parent.getChildAt(i).findViewById(R.id.imv_lv_select_city);
                    tv_lv_select_macdinh1=(TextView)parent.getChildAt(i).findViewById(R.id.tv_lv_select_macdinh);
                    tv_lv_select_macdinh1.setVisibility(View.GONE);
                    imv_check3.setVisibility(View.GONE);
                    tv_lv_select_macdinh1.setText("");
                   /* tv_lv_select_macdinh1.setBackgroundResource(R.color.listgray);*/
                }

                vitri=position;
                getdata.setS(vitri+1);
                tv_lv_select_macdinh1 = (TextView) v.findViewById(R.id.tv_lv_select_macdinh);
                imv_check3 = (ImageView)v.findViewById(R.id.imv_lv_select_city);
                tv_lv_select_macdinh1.setVisibility(View.VISIBLE);
                tv_lv_select_macdinh1.setText("Mặc định");
                tv_lv_select_macdinh1.setTextColor(context.getResources().getColor(R.color.black_text_list1));
                tv_lv_select_macdinh1.setBackgroundResource(R.drawable.duongvien_goctron_listview1);
                imv_check3.setVisibility(View.VISIBLE);
                //Toast.makeText(context, holder.tv_lv_select_city.getText(), Toast.LENGTH_SHORT).show();
                getdata.setTen_tp(holder.tv_lv_select_city.getText().toString());

                tv_lv_select_macdinh1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        onSetDefaultCity.onSetDefaultCity();
                    }
                });

            }
        });
        return rowView;
    }

    public interface IOnSetDefaultCity
    {
        void onSetDefaultCity();
    }
}
