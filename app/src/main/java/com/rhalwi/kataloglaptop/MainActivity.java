package com.rhalwi.kataloglaptop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton btnAcer, btnAsus;
    public static final String JENIS_GALERY_KEY = "JENIS GALERY" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();
    }

    private void inisialisasiView() {
        btnAcer = findViewById(R.id.btn_buka_acer);
        btnAsus = findViewById(R.id.btn_buka_asus);
        btnAcer.setOnClickListener(view -> bukaGalery("Acer") );
        btnAsus.setOnClickListener(view -> bukaGalery("Asus"));
    }

    private void bukaGalery(String jenisLaptop) {
        Log.d("MAIN", "Buka activity Laptop");
        Intent intent = new Intent(this, GaleryActivity.class);
        intent.putExtra(JENIS_GALERY_KEY, jenisLaptop);
        startActivity(intent);
    }
}