package com.yan.latihan7_akb.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yan.latihan7_akb.R;
import com.yan.latihan7_akb.model.modelLayanan;

import java.util.List;

public class LayananAdapter extends RecyclerView.Adapter {
// Birliano Ekayan Arsyad 10119173 IF-5 14/07/2022
    private List dbList;
    Context context;

    public LayananAdapter(Context context, List dbList){
        this.context = context;
        this.dbList = dbList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_list_item,parent,false);
        return new RowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RowViewHolder rowViewHolder = (RowViewHolder) holder;

        int rowPos = rowViewHolder.getAdapterPosition();

        if (rowPos == 0) {

            rowViewHolder.jumlah_colocation.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.kode_provinsi.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.nama_perangkat_daerah.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.nama_provinsi.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.satuan.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.tahun.setBackgroundResource(R.drawable.table_header_cell_bg);

            rowViewHolder.jumlah_colocation.setText("jumlah_colocation");
            rowViewHolder.kode_provinsi.setText("Kode kode_provinsi");
            rowViewHolder.nama_perangkat_daerah.setText("Nama nama_perangkat_daerah");
            rowViewHolder.nama_provinsi.setText("nama_provinsi");
            rowViewHolder.satuan.setText("satuan");
            rowViewHolder.tahun.setText("tahun");
        }else {
            modelLayanan modal = (modelLayanan) dbList.get(rowPos - 1);

            rowViewHolder.jumlah_colocation.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.kode_provinsi.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.nama_perangkat_daerah.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.nama_provinsi.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.satuan.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.tahun.setBackgroundResource(R.drawable.table_content_cell_bg);

            rowViewHolder.jumlah_colocation.setText(modal.getJumlah_colocation().toString());
            rowViewHolder.kode_provinsi.setText(modal.getKode_provinsi().toString());
            rowViewHolder.nama_provinsi.setText(modal.getNama_provinsi());
            rowViewHolder.nama_perangkat_daerah.setText(modal.getNama_perangkat_daerah());
            rowViewHolder.satuan.setText(modal.getSatuan());
            rowViewHolder.tahun.setText(modal.getTahun().toString());
        }
    }

    @Override
    public int getItemCount() {
        return dbList.size() +1;
    }

    public class RowViewHolder extends RecyclerView.ViewHolder {
        TextView jumlah_colocation, kode_provinsi, nama_perangkat_daerah, nama_provinsi, satuan, tahun;
        public RowViewHolder(@NonNull View view) {
            super(view);
            jumlah_colocation =(TextView)view.findViewById(R.id.txtjumlah_colocation);
            kode_provinsi =(TextView)view.findViewById(R.id.txtkode_provinsi);
            nama_perangkat_daerah =(TextView)view.findViewById(R.id.txtnama_perangkat_daerah);
            nama_provinsi =(TextView)view.findViewById(R.id.txtnama_provinsi);
            satuan =(TextView)view.findViewById(R.id.txtsatuan);
            tahun =(TextView)view.findViewById(R.id.txttahun);
        }
    }
}