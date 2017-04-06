package com.example.khanh.foody4.BAO;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.khanh.foody4.CLASS_GET_SET.connect_database_city;
import com.example.khanh.foody4.CLASS_GET_SET.connect_database_district;
import com.example.khanh.foody4.CUSTOMADAPTER.getdata;
import com.example.khanh.foody4.DAO.DataBaseHelper;

import java.util.ArrayList;

/**
 * Created by Khanh on 4/2/2017.
 */

public class TestAdapter_district extends DataBaseHelper
{
    protected static final String TAG = "DataAdapter";
    private final Context mContext;
    private SQLiteDatabase mDb;
    private DataBaseHelper mDbHelper;

    public TestAdapter_district(Context context)
    {
        super(context);
        this.mContext = context;
        mDbHelper = new DataBaseHelper(mContext);
    }

    public ArrayList<connect_database_district> getListHuyen(int matinh)
    {
        ArrayList<connect_database_district> listHuyen = new ArrayList<>();
        // mo ket noi
        try {
            mDbHelper.openDataBase();
            Cursor cs = mDbHelper.database.rawQuery("select MaHuyen,TenHuyen,MaTinh from Huyen where MaTinh='"+matinh+"'", null);
            connect_database_district huyen;/* where MaTinh='"+x+"'*/
            while (cs.moveToNext())
            {
                huyen = new connect_database_district(cs.getInt(0),cs.getString(1),cs.getInt(2));
                listHuyen.add(huyen);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }

        return listHuyen;
    }

    public Cursor getTestData()
    {
        try
        {
            String sql ="SELECT * FROM District";

            Cursor mCur = mDb.rawQuery(sql, null);
            if (mCur!=null)
            {
                mCur.moveToNext();
            }
            return mCur;
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "getTestData >>"+ mSQLException.toString());
            throw mSQLException;
        }
    }
}
