package com.example.khanh.foody4.CUSTOMADAPTER;

/**
 * Created by Khanh on 4/2/2017.
 */

public class getdata
{
    static  Integer S=0;
    static Integer vitri;
    static  String ten_tp="TP.HCM";
    static  Integer danhmuc=1;
    static  Integer danhmuc_huyen=1;
    static  Integer danhmuc_tinh=1;


    static  Integer angi_danhmuc=-1;
    static  Integer angi_huyen=0;
    static  Integer angi_tinh=1;

    public static void setDanhmuc(Integer danhmuc) {
        getdata.danhmuc = danhmuc;
    }

    public static Integer getAngi_danhmuc() {
        return angi_danhmuc;
    }

    public static void setAngi_danhmuc(Integer angi_danhmuc) {
        getdata.angi_danhmuc = angi_danhmuc;
    }

    public static Integer getAngi_huyen() {
        return angi_huyen;
    }

    public static void setAngi_huyen(Integer angi_huyen) {
        getdata.angi_huyen = angi_huyen;
    }

    public static Integer getAngi_tinh() {
        return angi_tinh;
    }

    public static void setAngi_tinh(Integer angi_tinh) {
        getdata.angi_tinh = angi_tinh;
    }

    public static Integer getVitri() {
        return vitri;
    }

    public static void setVitri(Integer vitri) {
        getdata.vitri = vitri;
    }

    public static Integer getDanhmuc_tinh()
    {
        return danhmuc_tinh;
    }

    public static void setDanhmuc_tinh(Integer danhmuc_tinh) {
        getdata.danhmuc_tinh = danhmuc_tinh;
    }

    public static Integer getDanhmuc_huyen() {
        return danhmuc_huyen;
    }

    public static void setDanhmuc_huyen(Integer danhmuc_huyen)
    {
        getdata.danhmuc_huyen = danhmuc_huyen;
    }



    public static Integer getS()
    {
        return S;
    }

    public static void setS(Integer s)
    {
        S = s;
    }

    public static String getTen_tp()
    {
        return ten_tp;
    }

    public static void setTen_tp(String ten_tp)
    {
        getdata.ten_tp = ten_tp;
    }
    public static  int angi_thanhpho;

    public static int getAngi_thanhpho()
    {
        return angi_thanhpho;
    }
    public static void setAngi_thanhpho(int angi_thanhpho)
    {
        getdata.angi_thanhpho = angi_thanhpho;
    }
    public static int getDanhmuc()
    {
        return danhmuc;
    }
    public static void setDanhmuc(int danhmuc) {
        getdata.danhmuc = danhmuc;
    }

}
