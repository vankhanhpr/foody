package com.example.khanh.foody4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

import com.example.khanh.foody4.CUSTOMADAPTER.getdata;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
{

    //Khai báo các ImageView của các button phía dưới giao diện
    ImageButton imv_home,imv_luutru,imv_timkiem,imv_thongbao,imv_dangnhap;
    ImageView imv_f,imv_mainplus;
    ViewPager paper,viewPager;//Khai báo một viewPage
    public  static LinearLayout tab_button_nagi;
    TabLayout tabLayout;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //link các imageview  giữa phần giao diện và phần xử lí
        imv_home=(ImageButton)findViewById(R.id.imv_home);
        imv_luutru=(ImageButton)findViewById(R.id.imv_luutru);
        imv_thongbao=(ImageButton)findViewById(R.id.imv_thongbao);
        imv_timkiem=(ImageButton)findViewById(R.id.imv_timkiem);
        imv_dangnhap=(ImageButton)findViewById(R.id.imv_dangnhap);
        imv_f=(ImageView)findViewById(R.id.imv_f);

        imv_mainplus=(ImageView)findViewById(R.id.imv_mainplus);
        tab_button_nagi=(LinearLayout)findViewById(R.id.tab_button_nagi);
        FragmentManager frament= getSupportFragmentManager();
        //Khởi tạo các ViewPager
        viewPager =(ViewPager)findViewById(R.id.viewPager_main);
        PagerAdapter adapter2 =new PagerAdapter(frament, this);//KHởi tạo một pager
        viewPager.setAdapter(adapter2);
        tabLayout=(TabLayout)findViewById(R.id.tablayout) ;
        getdata.setS(1);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {

            }



            /*Xử lí phần vuốt của tab layout bên trái là tab ở đâu, bên phải là ăn gì
            *    Hai Class tương ứng là ăn gì và ở đâu  Class angi,odau*/
            @Override
            public void onPageSelected(int position)
            {
                if(position==0)
                {
                    tabLayout.getTabAt(0).select();
                }
                else
                    tabLayout.getTabAt(1).select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                int temp=tabLayout.getSelectedTabPosition();
                viewPager.setCurrentItem(temp);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });





        //Bắt sự kiện khi nhấn vào chữ f trên giao diện mở activity mới
            imv_f.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), mainf.class);
                    // gọi activity.
                    startActivity(intent);
                }
            });
         /*Xứ lí phần nhấn vào dấu cộng trên giao diện*/
        imv_mainplus.setOnClickListener(new View.OnClickListener()
        {
            public  void onClick(View v)
            {
                Create_plus create_plus = new Create_plus();
                create_plus.show(getSupportFragmentManager(), create_plus.getTag());
            }
        });


        //Sự kiện khi nhấn vào image home trên tool đổi màu tương ứng
        imv_home.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                imv_home.setBackgroundResource(R.drawable.iconhome1);
                imv_luutru.setBackgroundResource(R.drawable.icon1);
                imv_timkiem.setBackgroundResource(R.drawable.icon4);
                imv_thongbao.setBackgroundResource(R.drawable.icon3);
                imv_dangnhap.setBackgroundResource(R.drawable.icon5);
            }
        });
        imv_luutru.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                imv_luutru.setBackgroundResource(R.drawable.iconluutru1);
                imv_home.setBackgroundResource(R.drawable.icon2);
                imv_timkiem.setBackgroundResource(R.drawable.icon4);
                imv_thongbao.setBackgroundResource(R.drawable.icon3);
                imv_dangnhap.setBackgroundResource(R.drawable.icon5);
            }
        });
        imv_timkiem.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                imv_timkiem.setBackgroundResource(R.drawable.icontimkiem1);
                imv_home.setBackgroundResource(R.drawable.icon2);
                imv_luutru.setBackgroundResource(R.drawable.icon1);
                imv_thongbao.setBackgroundResource(R.drawable.icon3);
                imv_dangnhap.setBackgroundResource(R.drawable.icon5);
            }
        });
        imv_thongbao.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                imv_thongbao.setBackgroundResource(R.drawable.iconthongbao1);
                imv_home.setBackgroundResource(R.drawable.icon2);
                imv_luutru.setBackgroundResource(R.drawable.icon1);
                imv_timkiem.setBackgroundResource(R.drawable.icon4);
                imv_dangnhap.setBackgroundResource(R.drawable.icon5);
            }
        });
        imv_dangnhap.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                imv_dangnhap.setBackgroundResource(R.drawable.icondangnhap1);
                imv_home.setBackgroundResource(R.drawable.icon2);
                imv_luutru.setBackgroundResource(R.drawable.icon1);
                imv_timkiem.setBackgroundResource(R.drawable.icon4);
                imv_thongbao.setBackgroundResource(R.drawable.icon3);
            }
        });
    }

//-------------------------------------------------------------------------------------

}
