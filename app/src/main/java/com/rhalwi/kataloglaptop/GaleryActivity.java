package com.rhalwi.kataloglaptop;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rhalwi.kataloglaptop.tipe.laptop;

import java.util.List;

public class GaleryActivity extends AppCompatActivity {

    List<laptop> laptops;
    int indeksLaptop = 0;
    String jenisLaptop;
    Button btnPertama,btnTerakhir,btnSebelumnya,btnBerikutnya;
    TextView txJenis,txTipe,txHarga,txDeskripsi;
    ImageView ivFotoLaptop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galery);
        Intent intent = getIntent();
        jenisLaptop= intent.getStringExtra(MainActivity.JENIS_GALERY_KEY);
        laptops = DataProvider.getLaptopsByTipe(this,jenisLaptop);
        inisialisasiView();
        tampilkanProfil();
    }

    private void inisialisasiView() {
        btnPertama = findViewById(R.id.btnPertama);
        btnSebelumnya = findViewById(R.id.btnSebelumnya);
        btnBerikutnya = findViewById(R.id.btnBerikutnya);
        btnTerakhir = findViewById(R.id.btnTerakhir);

        btnPertama.setOnClickListener(view -> laptopPertama());
        btnTerakhir.setOnClickListener(view -> laptopTerakhir());
        btnSebelumnya.setOnClickListener(view -> laptopSebelumnya());
        btnBerikutnya.setOnClickListener(view -> laptopBerikutnya());

        txTipe =findViewById(R.id.txTipe);
        txHarga = findViewById(R.id.txHarga);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivFotoLaptop = findViewById(R.id.gambarLaptop);

        txJenis = findViewById(R.id.txJenis);
        txJenis.setText("Laptop "+jenisLaptop);
    }
    private void tampilkanProfil(){
        laptop g = laptops.get(indeksLaptop);
        Log.d("laptop","Menampilkan Laptop"+g.getTipe());
        txTipe.setText(g.getTipe());
        txHarga.setText(g.getHarga());
        txDeskripsi.setText(g.getDeskripsi());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ivFotoLaptop.setImageDrawable(this.getDrawable(g.getDrawableRes()));
        }
    }
    private void laptopPertama(){
        int posAwal = 0;
        if(indeksLaptop== posAwal){
            Toast.makeText(this,"sudah di posisi pertama",Toast.LENGTH_SHORT).show();
            return;
        }else{
            indeksLaptop = posAwal;
            tampilkanProfil();
        }
    }
    private void laptopTerakhir(){
        int posAkhir = laptops.size() - 1;
        if(indeksLaptop == posAkhir){
            Toast.makeText(this,"sudah di posisi akhir",Toast.LENGTH_SHORT).show();
        return;
        }else{
            indeksLaptop = posAkhir;
            tampilkanProfil();
        }
    }
    private void laptopBerikutnya(){
        if(indeksLaptop == laptops.size() -1 ){
            Toast.makeText(this,"sudah di posisi akhir", Toast.LENGTH_SHORT).show();
            return;
        }else{
            indeksLaptop++;
            tampilkanProfil();
        }
    }
    private void laptopSebelumnya(){
        if(indeksLaptop==0){
            Toast.makeText(this,"sudah di posisi pertama",Toast.LENGTH_SHORT).show();
            return;
        }else {
            indeksLaptop--;
            tampilkanProfil();
        }
    }

}
