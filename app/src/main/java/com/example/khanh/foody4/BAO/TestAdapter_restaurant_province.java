package com.example.khanh.foody4.BAO;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.khanh.foody4.CLASS_GET_SET.quanan_getset;
import com.example.khanh.foody4.DAO.DataBaseHelper;

import java.util.ArrayList;

/**
 * Created by Khanh on 4/3/2017.
 */

public class TestAdapter_restaurant_province extends DataBaseHelper
{
    protected static final String TAG = "DataAdapter";

    private final Context mContext;
    private SQLiteDatabase mDb;
    private DataBaseHelper mDbHelper;

    public TestAdapter_restaurant_province(Context context)
    {
        super(context);
        this.mContext = context;
        mDbHelper = new DataBaseHelper(mContext);
    }

    public ArrayList<quanan_getset> getListNhaHang(int matinh)
    {
        ArrayList<quanan_getset> listNhaHang = new ArrayList<>();
        // mo ket noi
        try {
            mDbHelper.openDataBase();
            Cursor cs = mDbHelper.database.rawQuery("select * from QuanAn where MaHuyen='"+matinh+"'",null);
            quanan_getset nhaHang;
            while (cs.moveToNext())
            {
                nhaHang = new quanan_getset(cs.getInt(0),cs.getInt(1),cs.getInt(2), cs.getString(3),cs.getString(4),cs.getFloat(5),cs.getString(6),cs.getBlob(7),cs.getInt(8),cs.getInt(9));
                listNhaHang.add(nhaHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }

        return listNhaHang;
    }
}
