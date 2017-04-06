package com.example.khanh.foody4.CLASS_GET_SET;

/**
 * Created by Khanh on 4/3/2017.
 */

public class quanan_getset
{
    private int MaNhaHang;
    private int MaTinh;
    int MaHuyen;
    String TenNhaHang;
    String DiaChi;
    float diem;
    String SoDT;
    byte[] Anh;
    int LuotXem;
    int MaDanhMuc;

    public quanan_getset(int maNhaHang, int maTinh, int maHuyen, String tenNhaHang, String diaChi, float diem, String soDT, byte[] anh, int luotXem, int maDanhMuc) {
        this.MaNhaHang = maNhaHang;
        this.MaTinh = maTinh;
        this.MaHuyen = maHuyen;
        this.TenNhaHang = tenNhaHang;
        this.DiaChi = diaChi;
        this.diem = diem;
        this.SoDT = soDT;
        this.Anh = anh;
        this.MaDanhMuc = maDanhMuc;
        this.LuotXem = luotXem;
    }

    public int getMaNhaHang()
    {
        return MaNhaHang;
    }

    public void setMaNhaHang(int maNhaHang)
    {
        MaNhaHang = maNhaHang;
    }

    public int getMaTinh() {
        return MaTinh;
    }

    public void setMaTinh(int maTinh) {
        MaTinh = maTinh;
    }

    public int getMaHuyen() {
        return MaHuyen;
    }

    public void setMaHuyen(int maHuyen) {
        MaHuyen = maHuyen;
    }

    public String getTenNhaHang() {
        return TenNhaHang;
    }

    public void setTenNhaHang(String tenNhaHang) {
        TenNhaHang = tenNhaHang;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String soDT) {
        SoDT = soDT;
    }

    public byte[] getAnh()
    {
        return Anh;
    }

    public void setAnh(byte[] anh) {
        Anh = anh;
    }

    public int getLuotXem() {
        return LuotXem;
    }

    public void setLuotXem(int luotXem) {
        LuotXem = luotXem;
    }

    public int getMaDanhMuc() {
        return MaDanhMuc;
    }

    public void setMaDanhMuc(int maDanhMuc) {
        MaDanhMuc = maDanhMuc;
    }
}
