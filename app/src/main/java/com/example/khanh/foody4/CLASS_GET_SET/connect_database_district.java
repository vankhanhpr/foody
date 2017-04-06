package com.example.khanh.foody4.CLASS_GET_SET;

/**
 * Created by Khanh on 4/2/2017.
 */

public class connect_database_district
{
    private int MaHuyen;
    private String TenHuyen;
    private int MaTinh;

    public connect_database_district(int mahuyen,String tenhuyen,int matinh)
    {
        this.MaHuyen=mahuyen;
        this.TenHuyen=tenhuyen;
        this.MaTinh=matinh;
    }
    public int getMatHuyen()
    {
        return MaHuyen;
    }
    public void setMaHuyen()
    {
        this.MaHuyen=MaHuyen;
    }
    public  String getTenHuyen()
    {
        return  TenHuyen;
    }
    public void setTenHuyen()
    {
        this.TenHuyen=TenHuyen;
    }
    public int getMatTinh()
    {
        return MaTinh;
    }
    public void setMaTinh()
    {
     this.MaTinh=MaTinh;
    }

}
