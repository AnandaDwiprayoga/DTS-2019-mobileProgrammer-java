package com.dts.aplikasikalkulatorbmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.dts.aplikasikalkulatorbmi.adapter.RecyclerViewAdapters;
import com.dts.aplikasikalkulatorbmi.models.Info;
import com.dts.aplikasikalkulatorbmi.models.ItemResult;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    TextView gender, bmi,kategori,umur;
    RecyclerView recyclerView;

    List<ItemResult> listItemResult = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.rvHasil);

        Info info = getIntent().getParcelableExtra(MainActivity.key_MainActivity);

        listItemResult.add(new ItemResult("Jenis Kelamin",info.getjKelamin()));
        listItemResult.add(new ItemResult("Hasil BMI", info.getHasilBmi()));
        listItemResult.add(new ItemResult("Kategori", info.getKategori()));
        listItemResult.add(new ItemResult("Umur",info.getUmur()));

        RecyclerViewAdapters recyclerViewAdapters = new RecyclerViewAdapters(listItemResult);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapters);

    }
}
