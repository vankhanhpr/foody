package com.example.khanh.foody4;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

class CustomAdapter  extends BaseAdapter
{
    //khởi tạo các đối tượng
    List<String> result;
    Context context;
    List<Integer> imageId;
    private static LayoutInflater inflater=null;
    MainActivity mn;//khởi tạo mainactivvity

    //hàm này gọi hàm trộn các đối tượng trong textview(imageView và textView) và đổ vào listview
    public CustomAdapter(MainActivity mainActivity,List<String> prgmNameList, List<Integer> prgmImages)
    {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=mainActivity;
        mn=mainActivity;
        imageId=prgmImages;
        //trộn image và text
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    //trả về độ dài  danh sách
    @Override
    public int getCount()
    {
        // TODO Auto-generated method stub
        return result.size();
    }

    //trả về vị trí click trong textview
    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    //trả về vị trí click item trong textview
    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    //chứa 1or nhiều đối tượng trong listview là textview và imageview
    public class Holder
    {
        TextView tv;
        ImageView img,imv_check_a;

    }
    //hàm này  trộn texview với imageview
    //Xử lý khi nhấn vào một dòng trong textview
    //mặc định giá trị ban đầu
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

        if(position==0)//xét vị trí số 0 luôn được chọn
        {
            holder.img.setColorFilter(context.getResources().getColor(R.color.blu_icon));
            holder.tv.setTextColor(context.getResources().getColor(R.color.red1));
            holder.imv_check_a.setImageResource(R.drawable.icon_check);
            holder.imv_check_a.setColorFilter(context.getResources().getColor(R.color.red1));
            holder.img.getLayoutParams().width=0;
        }

        //Xử lí kích vào một dòng trong list
        rowView.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TextView tv1;
                ImageView img1,imv_check1;
                LinearLayout tab_liner;
                LinearLayout tab_chinh_angi;
                // TODO Auto-generated method stub

                //Cho tất cả các vị trí về mặc định
                for(int i=0;i<parent.getChildCount();i++)
                {
                    tv1=(TextView)parent.getChildAt(i).findViewById(R.id.textView10);
                    img1=(ImageView)parent.getChildAt(i).findViewById(R.id.imageView10);
                    imv_check1=(ImageView)parent.getChildAt(i).findViewById(R.id.imv_check);

                    tv1.setTextColor(context.getResources().getColor(R.color.black_icon));
                    img1.setColorFilter(null);
                    imv_check1.setImageResource(0);
                }
                //đỏi màu icon vị trí được chọn cho nó khác đi

                tv1=(TextView)v.findViewById(R.id.textView10);
                img1=(ImageView)v.findViewById(R.id.imageView10);
                imv_check1=(ImageView)v.findViewById(R.id.imv_check);
                tv1.setTextColor(context.getResources().getColor(R.color.red1));
                img1.setColorFilter(context.getResources().getColor(R.color.blu_icon));
                imv_check1.setImageResource(R.drawable.icon_check);
                imv_check1.setColorFilter(context.getResources().getColor(R.color.red1));

                TextView tv_angi;
                tv_angi=(TextView)mn.findViewById(R.id.textView_moinhat);
                tv_angi.setText(tv1.getText());

                tab_liner=(LinearLayout)mn.findViewById(R.id.tab_listview1);
                tab_chinh_angi=(LinearLayout) mn.findViewById(R.id.tab_chinh1);

                //Xử lý giao diện khi chọn xong
                tab_liner.setVisibility(View.GONE);
                tab_chinh_angi.setVisibility(View.VISIBLE);
                angi.button_huy_angi.setVisibility(View.GONE);
                mn.tab_button_nagi.setVisibility(View.VISIBLE);
                angi.tab_new.setBackgroundResource(R.color.while1);
                angi.flag_moinhat=true;
            }
        });
        return rowView;
    }
}