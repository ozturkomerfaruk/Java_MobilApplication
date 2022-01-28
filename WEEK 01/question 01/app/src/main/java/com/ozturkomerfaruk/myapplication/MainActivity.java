package com.ozturkomerfaruk.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tmpLabelName, tmpLabelSurname, tmpLabelHello;
    Button tmpButtonChange;
    EditText tmpEditTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tmpLabelName = findViewById(R.id.txtName);
        tmpLabelSurname = findViewById(R.id.txtSurname);
        tmpButtonChange = findViewById(R.id.btnChange);
        tmpEditTextName = findViewById(R.id.editTextName);
        tmpLabelHello = findViewById(R.id.txtNameHello);

        tmpLabelName.setText("Ömer Faruk");
        tmpLabelSurname.setText("Öztürk");

        tmpEditTextName.setText("");
        tmpLabelHello.setText("");

        tmpButtonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //2
                String name = tmpLabelName.getText().toString();
                String surname = tmpLabelSurname.getText().toString();
                tmpLabelName.setText(surname);
                tmpLabelSurname.setText(name);

                //3
                tmpLabelHello.setText(tmpEditTextName.getText().toString() + " Hello World");

                //4
                Toast.makeText(MainActivity.this, tmpEditTextName.getText().toString() + " Nasılsın", Toast.LENGTH_SHORT).show();
            }
        });



    }
}