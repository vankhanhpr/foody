package com.example.khanh.foody4.CLASS_GET_SET;

/**
 * Created by Khanh on 4/5/2017.
 */

public class monan_getset
{
    int mamonan;
    String tenmonan;
    byte[] anh;
    int manhahang;

    public monan_getset(int mamonan, String tenmonan, byte[] anh, int manhahang) {
        this.mamonan = mamonan;
        this.tenmonan = tenmonan;
        this.anh = anh;
        this.manhahang = manhahang;
    }

    public int getMamonan() {
        return mamonan;
    }

    public void setMamonan(int mamonan) {
        this.mamonan = mamonan;
    }

    public String getTenmonan() {
        return tenmonan;
    }

    public void setTenmonan(String tenmonan) {
        this.tenmonan = tenmonan;
    }

    public byte[] getAnh() {
        return anh;
    }

    public void setAnh(byte[] anh) {
        this.anh = anh;
    }

    public int getManhahang() {
        return manhahang;
    }

    public void setManhahang(int manhahang) {
        this.manhahang = manhahang;
    }
}
