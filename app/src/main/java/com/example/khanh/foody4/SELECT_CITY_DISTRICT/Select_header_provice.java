package com.example.khanh.foody4.SELECT_CITY_DISTRICT;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.khanh.foody4.CLASS_GET_SET.connect_database_city;
import com.example.khanh.foody4.R;


import java.util.List;

/**
 * Created by FDSA on 4/3/2017.
 */

public class Select_header_provice extends BaseAdapter
{

    //khai báo các đối tượng
    static Context context;
    List<connect_database_city> provinceList;
    connect_database_city currentProvince;
    //khởi tạo đối tượng tương ứng
    public Select_header_provice(Context context,List<connect_database_city> provinceList,connect_database_city currentProvince)
    {
        this.context=context;
        this.provinceList=provinceList;
        this.currentProvince=currentProvince;

    }
    @Override
    public int getCount() {
        return provinceList.size();
    }

    @Override
    public connect_database_city getItem(int position) {
        return provinceList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    ImageView image_view_check_status;
    TextView text_view_province_name;
    TextView text_view_set_default;

    //đổi dux liệu vào từng text và đổ từng text vào trong list
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ChooseProvinceViewHolder holder;
        connect_database_city item = this.provinceList.get(position);
        if (convertView == null)
        {
            convertView = LayoutInflater.from(this.context).inflate(R.layout.layout_header_item, parent, false);
            holder = new ChooseProvinceViewHolder(convertView);
            convertView.setTag(holder);
        } else
        {
            holder = (ChooseProvinceViewHolder) convertView.getTag();
        }
        holder = (ChooseProvinceViewHolder) convertView.getTag();
        //holder.renderData(item);
        return convertView;
    }

    @Override
    public int getViewTypeCount() {

        return getCount();
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }

    static class ChooseProvinceViewHolder
    {
        View item;
        ImageView image_view_check_status;
        TextView text_view_province_name;
        TextView text_view_set_default;

        public ChooseProvinceViewHolder(View view)
        {
//            item = view;
//            this.image_view_check_status = (ImageView) view.findViewById(R.id.image_view_check_status);
//            this.text_view_province_name = (TextView) view.findViewById(R.id.text_view_province_name);
//            this.text_view_set_default=(TextView) view.findViewById(R.id.text_view_set_default);
        }
        /*public void renderData(connect_database_city province)
        {
            if(province.getMathanhpho()== 0)
            {
                this.image_view_check_status.setVisibility(View.VISIBLE);
                this.text_view_province_name.setTextColor(ContextCompat.getColor(context,R.color.bg_screen1));
            }
            this.text_view_province_name.setText(province.getMathanhpho());
        }*/
    }
}
