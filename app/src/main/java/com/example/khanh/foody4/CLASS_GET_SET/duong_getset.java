package com.example.khanh.foody4.CLASS_GET_SET;

/**
 * Created by Khanh on 3/31/2017.
 */

public class duong_getset
{

    String idStreet;
    String titleStreet;

    public duong_getset(String idStreet, String tittleStreet)
    {
        this.idStreet = idStreet;
        this.titleStreet = tittleStreet;
    }

    public String getIdStreet() {
        return idStreet;
    }

    public void setIdStreet(String idStreet) {
        this.idStreet = idStreet;
    }

    public String getTittleStreet() {
        return titleStreet;
    }

    public void setTittleStreet(String tittleStreet) {
        this.titleStreet = tittleStreet;
    }

}
