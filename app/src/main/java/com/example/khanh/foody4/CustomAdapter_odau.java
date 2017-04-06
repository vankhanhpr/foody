package com.example.khanh.foody4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Khanh on 4/3/2017.
 */

public class CustomAdapter_odau extends BaseAdapter
{

    List<String> result;
    Context context;
    List<Integer> imageId;
    private static LayoutInflater inflater=null;
    MainActivity mn;
    public CustomAdapter_odau(MainActivity mainActivity,List<String> prgmNameList, List<Integer> prgmImages)
    {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=mainActivity;
        mn=mainActivity;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount()
    {
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
        ImageView img,imv_check_a,imv_new;

    }
    @Override
    public View getView(final int position, View convertView, final ViewGroup parent)
    {
        // TODO Auto-generated method stub
       Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.layout_listview, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView10);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView10);
        holder.tv.setText(result.get(position));
        holder.img.setImageResource(imageId.get(position));
        holder.imv_check_a=(ImageView)rowView.findViewById(R.id.imv_check);
        holder.imv_check_a=(ImageView)rowView.findViewById(R.id.imv_check);
        holder.imv_new=(ImageView)rowView.findViewById(R.id.imv_new);
        if(position==0)
        {
            holder.img.setColorFilter(context.getResources().getColor(R.color.blu_icon));
            holder.tv.setTextColor(context.getResources().getColor(R.color.red1));
            holder.imv_check_a.setImageResource(R.drawable.icon_check);
        holder.imv_check_a.setColorFilter(context.getResources().getColor(R.color.red1));
        }
        if(position==7)
        {
            holder.imv_new.setImageResource(R.drawable.icon_list_new);
        }

        rowView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TextView tv1;
                ImageView img1,imv_check1;
                LinearLayout tab_liner;
                LinearLayout tab_chinh_odau;
                // TODO Auto-generated method stub
                /*Toast.makeText(context, "You Clicked "+result.get(position), Toast.LENGTH_LONG).show();*/
                /*holderimv_check=(ImageView)v.findViewById(R.id.imv_check);.*/

                for(int i=0;i<parent.getChildCount();i++)
                {
                    tv1=(TextView)parent.getChildAt(i).findViewById(R.id.textView10);
                    img1=(ImageView)parent.getChildAt(i).findViewById(R.id.imageView10);
                    imv_check1=(ImageView)parent.getChildAt(i).findViewById(R.id.imv_check);

                    tv1.setTextColor(context.getResources().getColor(R.color.black_icon));
                    img1.setColorFilter(null);
                    imv_check1.setImageResource(0);
                }

                tv1=(TextView)v.findViewById(R.id.textView10);
                img1=(ImageView)v.findViewById(R.id.imageView10);
                imv_check1=(ImageView)v.findViewById(R.id.imv_check);
                tv1.setTextColor(context.getResources().getColor(R.color.red1));
                img1.setColorFilter(context.getResources().getColor(R.color.blu_icon));
                imv_check1.setImageResource(R.drawable.icon_check);
                imv_check1.setColorFilter(context.getResources().getColor(R.color.red1));


                TextView tv_moinhat_odau;
                tv_moinhat_odau=(TextView)mn.findViewById(R.id.tv_moinhat_odau);
                tv_moinhat_odau.setText(tv1.getText());

                tab_liner=(LinearLayout)mn.findViewById(R.id.tab_listview_odau);
                tab_chinh_odau=(LinearLayout) mn.findViewById(R.id.tab_chinh_odau);
                tab_liner.setVisibility(v.GONE);
                tab_chinh_odau.setVisibility(v.VISIBLE);
                mn.tab_button_nagi.setVisibility(v.VISIBLE);
                odau.button_huy.setVisibility(v.GONE);

                odau.flag_odau=true;
                odau.tab_moinhat.setBackgroundResource(R.color.colorWhite);
            }
        });
        return rowView;
    }
}
