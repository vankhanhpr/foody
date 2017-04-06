package com.example.khanh.foody4.BAO;

import java.io.IOException;
import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.khanh.foody4.CLASS_GET_SET.connect_database_city;
import com.example.khanh.foody4.DAO.DataBaseHelper;

/**
 * Created by Khanh on 3/31/2017.
 */

public class TestAdapter extends  DataBaseHelper
{
    protected static final String TAG = "DataAdapter";

    private final Context mContext;
    private SQLiteDatabase mDb;
    private DataBaseHelper mDbHelper;

    public TestAdapter(Context context)
    {
        super(context);
        this.mContext = context;
        mDbHelper = new DataBaseHelper(mContext);
    }

    public ArrayList<connect_database_city> getListLopHoc() {
        ArrayList<connect_database_city> listLopHoc = new ArrayList<>();
        // mo ket noi
        try {
            mDbHelper.openDataBase();
            Cursor cs = mDbHelper.database.rawQuery("select * from Tinh", null);
            connect_database_city lopHoc;
            while (cs.moveToNext()) {
                lopHoc = new connect_database_city(cs.getInt(0), cs.getString(1));
                listLopHoc.add(lopHoc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }

        return listLopHoc;
    }

    /*public TestAdapter open() throws SQLException
    {
        try
        {
            mDbHelper.openDataBase();
            mDbHelper.close();
            mDb = mDbHelper.getReadableDatabase();
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "open >>"+ mSQLException.toString());
            throw mSQLException;
        }
        return this;
    }
    public void close()
    {
        mDbHelper.close();
    }*/

    public Cursor getTestData()
    {
        try
        {
            String sql ="SELECT * FROM tinh";

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
