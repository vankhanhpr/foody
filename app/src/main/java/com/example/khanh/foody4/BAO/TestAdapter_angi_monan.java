package com.example.khanh.foody4.BAO;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.BaseAdapter;

import com.example.khanh.foody4.CLASS_GET_SET.connect_database_district;
import com.example.khanh.foody4.CLASS_GET_SET.monan_getset;
import com.example.khanh.foody4.DAO.DataBaseHelper;

import java.util.ArrayList;

/**
 * Created by Khanh on 4/5/2017.
 */

public class TestAdapter_angi_monan  extends DataBaseHelper
{
    protected static final String TAG = "DataAdapter";
    private final Context mContext;
    private SQLiteDatabase mDb;
    private DataBaseHelper mDbHelper;

    public TestAdapter_angi_monan(Context context)
    {
        super(context);
        this.mContext = context;
        mDbHelper = new DataBaseHelper(mContext);
    }

    public ArrayList<monan_getset> getListMonAn(int madanhmuc,int mahuyen,int matinh)
    {
        ArrayList<monan_getset> listMonAn = new ArrayList<>();
        Cursor cs;
        // mo ket noi
        try {
            mDbHelper.openDataBase();
            if(mahuyen==0 && madanhmuc==-1)
            {
                cs = mDbHelper.database.rawQuery("select * from MonAn,QuanAn where MonAn.MaNhaHang = QuanAn.MaNhaHang and MaTinh='"+matinh+"'", null);
            }
            else
            if( madanhmuc==-1)
            {
                cs = mDbHelper.database.rawQuery("select * from MonAn,QuanAn where MonAn.MaNhaHang = QuanAn.MaNhaHang and MaHuyen='"+mahuyen+"'and MaTinh='"+matinh+"'", null);

            }else
            if(mahuyen==0)
            {
                cs = mDbHelper.database.rawQuery("select * from MonAn,QuanAn where MonAn.MaNhaHang = QuanAn.MaNhaHang and MaDanhMuc='"+madanhmuc+"'and MaTinh='"+matinh+"'", null);

            }
            else
                cs = mDbHelper.database.rawQuery("select * from MonAn,QuanAn where MonAn.MaNhaHang = QuanAn.MaNhaHang and MaHuyen='"+mahuyen+"'and MaTinh='"+matinh+"'and MaDanhMuc='"+madanhmuc+"'", null);

            monan_getset monan;/* where MaTinh='"+x+"'*/
            while (cs.moveToNext())
            {
                monan = new monan_getset(cs.getInt(0),cs.getString(1),cs.getBlob(2),cs.getInt(3));
                listMonAn.add(monan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }

        return listMonAn;
    }
    public ArrayList<monan_getset> getAllListMonAn(int matinh,int mahuyen,int madanhmuc)
    {
        ArrayList<monan_getset> listMonAn = new ArrayList<>();
        Cursor cs;
        // mo ket noi
        try {
            mDbHelper.openDataBase();
            cs = mDbHelper.database.rawQuery("select * from MonAn", null);

            monan_getset monan;/* where MaTinh='"+x+"'*/
            while (cs.moveToNext())
            {
                monan = new monan_getset(cs.getInt(0),cs.getString(1),cs.getBlob(2),cs.getInt(3));
                listMonAn.add(monan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }

        return listMonAn;
    }

}
