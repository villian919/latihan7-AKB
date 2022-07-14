package com.yan.latihan7_akb.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResponseModel {
    // Birliano Ekayan Arsyad 10119173 IF-5 14/07/2022
    @SerializedName("status")
    public int status;
    @SerializedName("message")
    public String message;
    @SerializedName("data")
    public List<modelLayanan> data = new ArrayList<>();

    public int getStatus() {
        return status;
    }

    public List<modelLayanan> getData() {
        return data;
    }

    public void setData(List<modelLayanan> data) {
        this.data = data;
    }
}
