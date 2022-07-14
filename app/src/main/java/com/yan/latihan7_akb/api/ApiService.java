package com.yan.latihan7_akb.api;

import com.yan.latihan7_akb.model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
        // Birliano Ekayan Arsyad 10119173 IF-5 14/07/2022
        @GET("od_18171_jumlah_layanan_colocation_berdasarkan_perangkat_daerah?limit=4")
        Call<ResponseModel> getLayanan();
}
