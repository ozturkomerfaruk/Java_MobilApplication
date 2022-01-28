package com.ozturkomerfaruk.sqlitedenemesildahasonra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            database = this.openOrCreateDatabase("Okul", MODE_PRIVATE, null);
            database.execSQL("CREATE TABLE IF NOT EXISTS Ogrenciler(ad VARCHAR, soyad VARCHAR, ogrenci_no INT)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sqliteBtnClick(View v) {
        switch (v.getId()) {
            case R.id.btnEkle:
                database.execSQL("INSERT INTO Ogrenciler(ad, soyad, ogrenci_no) VALUES('Fırat', 'Deniz', 814)");

                getData();
                Toast.makeText(getApplicationContext(), "Kayıt Başarıyla Eklendi", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnGuncelle:
                database.execSQL("UPDATE Ogrenciler SET ogrenci_no = 717 WHERE ad = 'İmdat' AND soyad = 'Koçak'");
                getData();
                Toast.makeText(getApplicationContext(), "Kayıt Başarıyla Güncellendi", Toast.LENGTH_SHORT).show();

                break;

            case R.id.btnSil:
                database.execSQL("DELETE FROM Ogrenciler WHERE soyad = 'Koçak'");
                getData();
                Toast.makeText(getApplicationContext(), "Kayıt Başarıyla Silindi", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnTabloyuSil:
                break;

            case R.id.btnGetData:
                    startActivity(new Intent(MainActivity.this, Pop.class));
                break;
        }
    }

    private void getData() {
        Cursor cursor = database.rawQuery("SELECT * FROM Ogrenciler", null);

        int adIndex = cursor.getColumnIndex("ad");
        int soyadIndex = cursor.getColumnIndex("soyad");
        int ogrenciNoIndex = cursor.getColumnIndex("ogrenci_no");

        while (cursor.moveToNext()) {
            System.out.println("\nad: " + cursor.getString(adIndex)
                    + " soyad: " + cursor.getString(soyadIndex)
                    + " ogrenci no: " + cursor.getInt(ogrenciNoIndex) + "\n");
        }

        cursor.close();
    }
}
