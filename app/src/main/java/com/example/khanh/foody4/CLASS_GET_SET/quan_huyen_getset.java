package com.example.khanh.foody4.CLASS_GET_SET;

import java.util.List;

/**
 * Created by Khanh on 3/31/2017.
 */

public class quan_huyen_getset
{

    String idDistrict;
    String titleDistrict;
    int numofStreet;
    List<duong_getset> streetList;

    public quan_huyen_getset(String idDistrict, String tittleDistrict, List<duong_getset> streetList)
    {
        this.idDistrict = idDistrict;
        this.titleDistrict = tittleDistrict;
        this.streetList = streetList;
    }

    public String getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(String idDistrict) {
        this.idDistrict = idDistrict;
    }

    public String getTittleDistrict() {
        return titleDistrict;
    }

    public void setTittleDistrict(String tittleDistrict) {
        this.titleDistrict = tittleDistrict;
    }

    public List<duong_getset> getStreetList() {
        return streetList;
    }

    public void setStreetList(List<duong_getset> streetList) {
        this.streetList = streetList;
    }

    public int getNumofStreet() {
        return numofStreet;
    }

    public void setNumofStreet(int numofStreet) {
        this.numofStreet = numofStreet;
    }
}
