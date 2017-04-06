package com.example.khanh.foody4.SELECT_CITY_DISTRICT;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.khanh.foody4.BAO.TestAdapter;
import com.example.khanh.foody4.CLASS_GET_SET.connect_database_city;
import com.example.khanh.foody4.CUSTOMADAPTER.Customadapter_odau_thanhpho;
import com.example.khanh.foody4.CUSTOMADAPTER.getdata;
import com.example.khanh.foody4.DAO.DataBaseHelper;
import com.example.khanh.foody4.MainActivity;
import com.example.khanh.foody4.R;
import com.example.khanh.foody4.odau;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Khanh on 3/31/2017.
 */

//class giúp đổi tỉnh thành khác lấy mã tỉnh để gửi về 2 class ăn gì và ở đâu
public class Select_province extends AppCompatActivity implements AdapterView.OnItemClickListener,Customadapter_odau_thanhpho.IOnSetDefaultCity
{
    //Khai báo các đối tượng
    ImageView imv_lv_back,imv_lv_search_top;
    TextView tv_lv_xong;
    List<String> arr_thanhpho;
    List<Integer> image_danhmuc;
    Context context;
    //MainActivity mainActivity;
    ListView listview_province;
    TestAdapter ta;
    connect_database_city Tinh;
    Select_header_provice Customadapter;
    EditText edittext_lv;
    LinearLayout tab_lv_xacdinhvitri,tab_lv_xacdinhquocgia;
    Customadapter_odau_thanhpho customadapter_odau_thanhpho;
    private ArrayList<connect_database_city>listThanhPho;
    int k=0;

    /*gọi hàm khởi tạo lấy danh sách tỉnh thành từ csdl và load danh sách lên*/
    protected void onCreate(Bundle savedInstanceState)
    {


        setContentView(R.layout.activity_select_city);//link qua giao diện
        context = getApplicationContext();//khởi tạo context
        unit();//hàm khởi tạo
        super.onCreate(savedInstanceState);//kế thừa
        ta=new TestAdapter(getApplicationContext());//hàm lấy dữ liệu
        getListTP();//lấy danh sách đối tượng thành phố
        setItem_thanhpho();//đổ dánh sách đối tượng thành phố vào list
        //nhấn vào nút back không chọn nữa thì đóng activity
        imv_lv_back.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                finish();
            }
        });
        //khi chọn xong thì gọi hàm gửi mã tỉnh thành về 2 class ăn gì ở đâu
        tv_lv_xong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                int x=listThanhPho.get(getdata.getS()).getMathanhpho();
                sendToMain(x,123);//về ở đâu
                sendToMain(x,456);//về ăn gì
            }
        });
    }

    //hàm khởi tạo các đối tượng
    public void unit()
    {




        imv_lv_back=(ImageView)findViewById(R.id.imv_lv_back);
        tv_lv_xong=(TextView)findViewById(R.id.tv_lv_xong);
        arr_thanhpho=new ArrayList<>();
        image_danhmuc=new ArrayList<>();
        listview_province=(ListView)findViewById(R.id.listview_province);



        View headerListView = LayoutInflater.from(this).inflate(R.layout.layout_header_listview, null);
        listview_province.addHeaderView(headerListView);




        imv_lv_search_top=(ImageView)headerListView.findViewById(R.id.imv_lv_search_top);
        edittext_lv=(EditText)headerListView.findViewById(R.id.edittext_lv);
        tab_lv_xacdinhvitri=(LinearLayout)headerListView.findViewById(R.id.tab_lv_xacdinhvitri);
        tab_lv_xacdinhquocgia=(LinearLayout)headerListView.findViewById(R.id.tab_lv_xacdinhquocgia);

        listview_province.setOnItemClickListener(this);

    }
    //hàm đóng gói giá trị vào bubdle và gửi giá trị đi qua intent
    public  void sendToMain(int temp,int position )
    {
        Intent intent = getIntent();
        Bundle bundle = new Bundle();
        bundle.putInt("KetQua",temp);
        intent.putExtra("TapTin", bundle);
        setResult(position,intent);
        finish(); // Đóng Activity hiện tại
    }


    //lấy danh sách đối tượng tỉnh thành
    private List<connect_database_city> getListTP()
    {
        listThanhPho = new ArrayList<>();
        listThanhPho = ta.getListLopHoc();
        return  listThanhPho;
    }

    //đổ tỉnh thành vào listview tỉnh thành
    public void setItem_thanhpho()
    {
        for(int i=0;i<listThanhPho.size();i++)
        {
            arr_thanhpho.add(listThanhPho.get(i).getTenthanhpho());
        }
        customadapter_odau_thanhpho = new Customadapter_odau_thanhpho(this,arr_thanhpho,this);
        listview_province.setAdapter(customadapter_odau_thanhpho);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {

    }

    //hàm này giúp hàm khác gọi được hàm gửi tin về qua interface cụ thể là hàm customadapter
    @Override
    public void onSetDefaultCity()
    {
        sendToMain(getdata.getS(),123);
    }
}
