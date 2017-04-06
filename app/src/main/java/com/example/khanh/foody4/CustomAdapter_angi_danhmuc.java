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
import android.widget.Toast;

import com.example.khanh.foody4.BAO.TestAdapter_angi_monan;
import com.example.khanh.foody4.CLASS_GET_SET.monan_getset;
import com.example.khanh.foody4.CUSTOMADAPTER.CustomAdapter_angi_monan;
import com.example.khanh.foody4.CUSTOMADAPTER.getdata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Khanh on 4/3/2017.
 */

public class CustomAdapter_angi_danhmuc extends BaseAdapter
{
    //khởi tạo các đối tượng
    List<String> result;
    Context context;
    List<Integer> imageId;
    private static LayoutInflater inflater=null;
    MainActivity mn;
    ArrayList<monan_getset> listMonAn;
    TestAdapter_angi_monan ta_monan;

    int vitri =0;

    //hàm này gọi hàm trộn các đối tượng trong textview(imageView và textView) và đổ vào listview
    public CustomAdapter_angi_danhmuc (MainActivity mainActivity,List<String> prgmNameList, List<Integer> prgmImages)
    {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=mainActivity;
        mn=mainActivity;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    //trả về độ dài  danh sách
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.size();
    }

    //trả về vị trí click trong textview
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
    public View getView(final int position, final View convertView, final ViewGroup parent)
    {
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.layout_listview, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView10);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView10);
        holder.imv_check_a=(ImageView)rowView.findViewById(R.id.imv_check);
        holder.tv.setText(result.get(position));
        holder.img.setImageResource(imageId.get(position));

        if(position==vitri)
        {
            //holder.img.setColorFilter(context.getResources().getColor(R.color.blu_icon));
            holder.tv.setTextColor(context.getResources().getColor(R.color.red1));
            holder.imv_check_a.setImageResource(R.drawable.icon_check);
            holder.img.setVisibility(View.GONE);
            holder.imv_check_a.setColorFilter(context.getResources().getColor(R.color.red1));
        }
//Xử lí kích vào một dòng trong list
        rowView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TextView tv1;
                ImageView imv_check1;
                LinearLayout tab_liner;
                LinearLayout tab_chinh_angi;
                // TODO Auto-generated method stub
                /*Toast.makeText(context, "You Clicked "+result.get(position), Toast.LENGTH_LONG).show();*/
                /*holderimv_check=(ImageView)v.findViewById(R.id.imv_check);.*/

                for(int i=0;i<parent.getChildCount();i++)
                {
                    tv1=(TextView)parent.getChildAt(i).findViewById(R.id.textView10);
                    //img1=(ImageView)parent.getChildAt(i).findViewById(R.id.imageView10);
                    imv_check1=(ImageView)parent.getChildAt(i).findViewById(R.id.imv_check);

                    tv1.setTextColor(context.getResources().getColor(R.color.black_icon));
                    //img1.setColorFilter(null);
                    imv_check1.setImageResource(0);
                }
                vitri=position;
                tv1=(TextView)v.findViewById(R.id.textView10);
                //img1=(ImageView)v.findViewById(R.id.imageView10);
                imv_check1=(ImageView)v.findViewById(R.id.imv_check);
                tv1.setTextColor(context.getResources().getColor(R.color.red1));
                //img1.setColorFilter(context.getResources().getColor(R.color.blu_icon));
                imv_check1.setImageResource(R.drawable.icon_check);
                imv_check1.setColorFilter(context.getResources().getColor(R.color.red1));

                //chọn vtri 0 thì có màu nâu vị trí khác thì là màu đỏ
                if(position==0)
                {
                    angi.tv_angi_danhmuc.setTextColor(context.getResources().getColor(R.color.colortab));
                }
                else
                    angi.tv_angi_danhmuc.setTextColor(context.getResources().getColor(R.color.red1));


                //hiện icon text màu text cho giống giao diện
                TextView tv_angi_danhmuc;
                tv_angi_danhmuc=(TextView)mn.findViewById(R.id.tv_angi_danhmuc);
                tv_angi_danhmuc.setText(tv1.getText());
                if(position==0)
                    tv_angi_danhmuc.setTextColor(context.getResources().getColor(R.color.colortab));
                else
                    tv_angi_danhmuc.setTextColor(context.getResources().getColor(R.color.red1));

                tab_liner=(LinearLayout)mn.findViewById(R.id.tab_listview_angi_danhmuc);
                tab_chinh_angi=(LinearLayout) mn.findViewById(R.id.tab_chinh1);
                tab_liner.setVisibility(v.GONE);
                tab_chinh_angi.setVisibility(v.VISIBLE);
                mn.tab_button_nagi.setVisibility(View.VISIBLE);
                angi.button_huy_angi.setVisibility(View.GONE);

                angi.tab_danh_muc_angi.setBackgroundResource(R.color.colorWhite);

                getdata.setAngi_danhmuc(position+1);
                getdata.setAngi_huyen(0);

                angi.flag_danhmuc=true;

                //đỏ lại danh sách nhà hàng theo danh mục
                getMonAn();
                LayMonAn();

            }
            //hàm lấy ds đói tượng món ăn /nhà hàng
            public  void  getMonAn()
            {
                listMonAn=new ArrayList<>();
                ta_monan=new TestAdapter_angi_monan(context);
                listMonAn=ta_monan.getListMonAn(getdata.getAngi_danhmuc(),getdata.getAngi_huyen(),getdata.getAngi_tinh());
            }
            //Bây giờ gọi lớp adapter đổ vào listview
            public void LayMonAn()
            {
                CustomAdapter_angi_monan csmonan1 = new CustomAdapter_angi_monan(angi.inflater,mn,listMonAn);
                angi.lv_angi_nhahang.setAdapter(csmonan1);
            }


        });




        return rowView;
    }
}
