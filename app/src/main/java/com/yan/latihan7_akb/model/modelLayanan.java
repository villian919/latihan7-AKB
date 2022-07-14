package com.yan.latihan7_akb.model;

import com.google.gson.annotations.SerializedName;

public class modelLayanan {
    // Birliano Ekayan Arsyad 10119173 IF-5 14/07/2022
    @SerializedName("jumlah_colocation")
    public Integer jumlah_colocation;
    @SerializedName("kode_provinsi")
    public Integer kode_provinsi;
    @SerializedName("nama_perangkat_daerah")
    public String nama_perangkat_daerah;
    @SerializedName("nama_provinsi")
    public String nama_provinsi;
    @SerializedName("satuan")
    public String satuan;
    @SerializedName("tahun")
    public Integer tahun;


    public Integer getJumlah_colocation(){
        return jumlah_colocation;
    }

    public Integer getKode_provinsi(){
        return kode_provinsi;
    }

    public String getNama_perangkat_daerah(){
        return nama_perangkat_daerah;
    }

    public String getNama_provinsi(){
        return nama_provinsi;
    }

    public String getSatuan(){
        return satuan;
    }

    public Integer getTahun(){
        return tahun;
    }
}
