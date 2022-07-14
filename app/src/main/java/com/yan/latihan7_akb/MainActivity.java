package com.yan.latihan7_akb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.widget.Toast;


import com.yan.latihan7_akb.Adapter.LayananAdapter;
import com.yan.latihan7_akb.api.ApiEndPoint;
import com.yan.latihan7_akb.api.ApiService;
import com.yan.latihan7_akb.model.ResponseModel;
import com.yan.latihan7_akb.model.modelLayanan;

import java.util.ArrayList;
import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    // Birliano Ekayan Arsyad 10119173 IF-5 14/07/2022
    private LayananAdapter balitaStantingAdapter;
    private List<modelLayanan> dbItems = new ArrayList<>();

    @BindView(R.id.recyclerViewMovie)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        balitaStantingAdapter = new LayananAdapter(this, dbItems);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(balitaStantingAdapter);

        loadDataBalita();
    }

    private void loadDataBalita() {

        //Declare Retrofit
        ApiService api = ApiEndPoint.getClient().create(ApiService.class);

        Call<ResponseModel> call = api.getLayanan();
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int message = response.body().getStatus();
                System.out.println("Message : "+message);
                dbItems = response.body().data;
                System.out.println("STATUS data "+dbItems);
                balitaStantingAdapter = new LayananAdapter(MainActivity.this, dbItems);
                recyclerView.setAdapter(balitaStantingAdapter);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Oops, your connection is WONGKY! ", Toast.LENGTH_SHORT).show();
            }
        });

    }
}