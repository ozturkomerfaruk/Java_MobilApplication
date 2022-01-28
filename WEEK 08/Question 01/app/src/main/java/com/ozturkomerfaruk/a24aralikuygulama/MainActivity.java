package com.ozturkomerfaruk.a24aralikuygulama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listViewUser;

    Button btnCreate;
    Button btnUpdate;
    Button btnDelete;
    Button btnSelect;

    EditText editTextName;
    EditText editTextSurname;
    EditText editTextPassword;
    EditText editTextAge;

    RadioButton rdnBtnWoman;
    RadioButton rdnBtnMan;

    DBAdapter dbAdapter;

    public Boolean IsWoman = true;

    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewUser = findViewById(R.id.listViewUser);

        btnCreate = findViewById(R.id.btnCreate);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnSelect = findViewById(R.id.btnSelect);

        editTextName = findViewById(R.id.editTextName);
        editTextSurname = findViewById(R.id.editTextSurname);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextAge = findViewById(R.id.editTextAge);

        rdnBtnWoman = findViewById(R.id.rdnBtnWoman);
        rdnBtnMan = findViewById(R.id.rdnBtnMan);

        dbAdapter = new DBAdapter(this);

        List<String> myUsers;

        myUsers = new ArrayList<>();
        listViewUser.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, myUsers));

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbAdapter.insertDataString(
                        editTextName.getText().toString(),
                        editTextSurname.getText().toString(),
                        editTextPassword.getText().toString(),
                        IsWoman ? "Man" : "Woman",
                        editTextAge.getText().toString()
                );
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbAdapter.update(index,
                        editTextName.getText().toString(),
                        editTextSurname.getText().toString(),
                        editTextPassword.getText().toString(),
                        IsWoman ? "Man" : "Woman",
                        editTextAge.getText().toString()
                        );
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cnt = dbAdapter.delete(index);
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> Data = dbAdapter.getData();
                myUsers.clear();
                for(String str : Data) {
                    myUsers.add(str);
                }
                listViewUser.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_list_item_1, myUsers));
            }
        });

        listViewUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String[] database = myUsers.get(i).split(",");
                index = Integer.parseInt(database[0]);
                editTextName.setText(database[1]);
                editTextSurname.setText(database[2]);
                editTextPassword.setText(database[3]);
                rdnBtnWoman.setChecked(database[4].equals("Woman"));
                rdnBtnMan.setChecked(database[4].equals("Man"));
                editTextAge.setText(database[5]);
            }
        });

    }

    public void rdnBtnOnClick(View view) {
        IsWoman = rdnBtnWoman.isChecked();
    }
}