package com.ozturkomerfaruk.week02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    String yemekMetni = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTxtFirst = findViewById(R.id.editTxtFirst);
        EditText editTxtSecond = findViewById(R.id.editTxtSecond);
        TextView txtCombine = findViewById(R.id.txtCombine);
        Button btnCombine = findViewById(R.id.btnCombine);

        btnCombine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtCombine.setText(editTxtFirst.getText().toString() + " " + editTxtSecond.getText().toString());
            }
        });

        CheckBox cBoxNohut = findViewById(R.id.cBoxNohut);
        CheckBox cBoxBulgur = findViewById(R.id.cBoxBulgur);
        CheckBox cBoxMakarna = findViewById(R.id.cBoxMakarna);
        CheckBox cBoxPilav = findViewById(R.id.cBoxPilav);
        CheckBox cBoxTavuk = findViewById(R.id.cBoxTavuk);
        TextView txtYemekMetni = findViewById(R.id.txtYemekMetni);

        CheckBox.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                String yemekMetni = "";
                if (cBoxNohut.isChecked())
                    yemekMetni += (cBoxNohut.getText().toString() + " ");
                if (cBoxBulgur.isChecked())
                    yemekMetni += (cBoxBulgur.getText().toString() + " ");
                if (cBoxMakarna.isChecked())
                    yemekMetni += (cBoxMakarna.getText().toString() + " ");
                if (cBoxPilav.isChecked())
                    yemekMetni += (cBoxPilav.getText().toString() + " ");
                if (cBoxTavuk.isChecked())
                    yemekMetni += (cBoxTavuk.getText().toString() + " ");

                txtYemekMetni.setText(yemekMetni);

                if (cBoxNohut.isChecked() == false && cBoxBulgur.isChecked() == false &&
                        cBoxMakarna.isChecked() == false && cBoxPilav.isChecked() == false && cBoxTavuk.isChecked() == false)
                    Toast.makeText(getApplicationContext(), "Yemek Seçilmemiştir", Toast.LENGTH_SHORT).show();
            }

        };

        cBoxNohut.setOnCheckedChangeListener(onCheckedChangeListener);
        cBoxBulgur.setOnCheckedChangeListener(onCheckedChangeListener);
        cBoxMakarna.setOnCheckedChangeListener(onCheckedChangeListener);
        cBoxPilav.setOnCheckedChangeListener(onCheckedChangeListener);
        cBoxTavuk.setOnCheckedChangeListener(onCheckedChangeListener);
    }
}
