package com.example.khanh.foody4.CLASS_GET_SET;

import java.util.List;

/**
 * Created by Khanh on 3/31/2017.
 */

public class tinh_geetset
{

    Integer matinh;
    String tentinh;
    List<quan_huyen_getset> districtList;


    public tinh_geetset(Integer matinh1, String tentinh1, List<quan_huyen_getset> districtList)
    {
        this.matinh = matinh1;
        this.tentinh = tentinh1;
        this.districtList = districtList;
    }

    public Integer getMaTinh()
    {
        return matinh;
    }


    public String getTenTinh() {
        return tentinh;
    }

    public List<quan_huyen_getset> getDistrictList() {
        return districtList;
    }

}
