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
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.khanh.foody4.CLASS_GET_SET.quanan_getset;
import com.example.khanh.foody4.CustomAdapter_odau;
import com.example.khanh.foody4.MainActivity;
import com.example.khanh.foody4.R;

import java.util.List;
/**
 * Created by Khanh on 4/3/2017.
 */

public class CustomAdapter_odau_nhahang extends BaseAdapter
{

    //khởi tạo các đối tượng
    Context context;
    List<String> tenNH;
    List<String> diachi;
    List<Float> diem;
    List<quanan_getset> anh1;
    int vitri = 0;

    private static LayoutInflater inflater = null;

    //hàm này gọi hàm trộn các đối tượng trong textview(imageView và textView) và đổ vào listview
    public CustomAdapter_odau_nhahang(MainActivity mainActivity, List<String> TenNhaHang, List<String> DiaChi,List<Float> Diem,List<quanan_getset> anh)
    {
        // TODO Auto-generated constructor stub
        tenNH = TenNhaHang;
        diachi = DiaChi;
        diem = Diem;
        anh1=anh;
        context = mainActivity;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    //trả về độ dài  danh sách
    @Override
    public int getCount() {
        return tenNH.size();
    }

    //trả về vị trí click trong textview
    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //chứa 1or nhiều đối tượng trong listview là textview và imageview
    static class Holder
    {
        TextView tv_diem, tv_tennhahang, tv_diachi;
        ImageView img;
    }

    //hàm này  trộn texview với imageview
    //Xử lý khi nhấn vào một dòng trong textview
    //mặc định giá trị ban đầu
    //xét vị trí được chọn như hiện icon,đổi màu chữ....
    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        // TODO Auto-generated method stub
        final Holder holder = new Holder();
        final View rowView;

        rowView = inflater.inflate(R.layout.tab_view_foody, null);

        //đỏi màu icon vị trí được chọn cho nó khác đi
        holder.tv_diem = (TextView) rowView.findViewById(R.id.tv_diem);
        holder.tv_tennhahang = (TextView) rowView.findViewById(R.id.tv_tennhahang);
        holder.tv_diachi = (TextView) rowView.findViewById(R.id.tv_diachi);
        holder.img=(ImageView)rowView.findViewById(R.id.home_imageview_album);
        //Toast.makeText(context, Integer.toString(anh1.size()), Toast.LENGTH_SHORT).show();
        Bitmap bitmap = BitmapFactory.decodeByteArray(anh1.get(position).getAnh(),0,anh1.get(position).getAnh().length);
        holder.img.setImageBitmap(bitmap);
        holder.tv_tennhahang.setText(tenNH.get(position));
        holder.tv_diachi.setText(diachi.get(position));
        holder.tv_diem.setText(diem.get(position).toString());

        return rowView;
    }
}