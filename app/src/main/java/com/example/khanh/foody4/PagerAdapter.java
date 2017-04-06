package com.example.khanh.foody4;

import  android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Khanh on 4/1/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter
{
    odau odau;
    angi angi;

    //khởi tạo các giá trị
    public PagerAdapter(FragmentManager gf,MainActivity mainActivity)
    {
        super(gf);
        odau=new odau(mainActivity);
        angi=new angi(mainActivity);
    }

    //Hàm này chọn bên trái là tab ở đâu, bên phải là ăn gì(vuốt)
    @Override
    public android.support.v4.app.Fragment getItem(int position) {

        android.support.v4.app.Fragment frag=null;
        switch (position){
            case 0:
                frag=odau;
                break;
            default:
                frag= angi;
                break;
        }
        return  frag;
    }
    //có 2 tab
    @Override
    public int getCount() {
        return 2;
    }
    @Override
    public CharSequence getPageTitle(int position) {

        return "";
    }
}
