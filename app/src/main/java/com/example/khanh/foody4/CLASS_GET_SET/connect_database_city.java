package com.example.khanh.foody4.CLASS_GET_SET;

/**
 * Created by Khanh on 3/30/2017.
 */

public class connect_database_city
{
    private int MaTinh;
    private String TenTinh;

    public connect_database_city() {

    }
    public connect_database_city(int mathanhpho,String tenthanhpho)
    {
        this.MaTinh=mathanhpho;
        this.TenTinh=tenthanhpho;
    }
    public int getMathanhpho()
    {
        return MaTinh;
    }
    public void setMathanhpho()
    {
        this.MaTinh=MaTinh;
    }
    public  String getTenthanhpho()
    {
        return  TenTinh;
    }
    public void setTenthanhpho()
    {
        this.TenTinh=TenTinh;
    }


}
