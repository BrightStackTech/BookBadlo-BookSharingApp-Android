package com.example.bookbadloo;

import android.media.Image;

import java.io.Serializable;

public class HospitalsModel implements Serializable {
    String hlocation, haddress, hstate, hnum, horgan;
    int hname;

    public HospitalsModel(int hname, String hlocation, String haddress, String hstate, String hnum, String horgan){
        this.hname = hname;
        this.hlocation = hlocation;
        this.haddress = haddress;
        this.hstate = hstate;
        this.hnum = hnum;
        this.horgan = horgan;
    }

    public String getHorgan(){
        return horgan;
    }

    public int getHname(){
        return hname;
    }

    public String getHaddress(){
        return haddress;
    }

    public String getHstate(){
        return hstate;
    }

    public String getHnum(){
        return hnum;
    }

    public String getHlocation(){
        return hlocation;
    }

}

