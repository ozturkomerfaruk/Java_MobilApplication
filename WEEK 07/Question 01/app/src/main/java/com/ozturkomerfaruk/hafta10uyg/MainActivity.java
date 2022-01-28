package com.ozturkomerfaruk.hafta10uyg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editTxtName;
    EditText editTxtSurname;
    EditText editTxtAge;
    EditText editTxtJob;

    Button btnClear;
    Button btnAdd;
    Button btnUpdate;
    Button btnRemove;

    RadioButton rdnBtnWoman;
    RadioButton rdnBtnMan;


    ListView listViewUser;
    List<User> myUsers;

    public Boolean IsWoman = true;

    int clickedItemIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTxtName = findViewById(R.id.editTxtName);
        editTxtSurname = findViewById(R.id.editTxtSurname);
        editTxtAge = findViewById(R.id.editTxtAge);
        editTxtJob = findViewById(R.id.editTxtJob);

        btnClear = findViewById(R.id.btnClear);
        btnAdd = findViewById(R.id.btnAdd);
        btnRemove = findViewById(R.id.btnRemove);
        btnUpdate = findViewById(R.id.btnUpdate);

        rdnBtnWoman = findViewById(R.id.rdnBtnWoman);
        rdnBtnMan = findViewById(R.id.rdnBtnMan);


        myUsers = new ArrayList<User>();
        listViewUser = findViewById(R.id.listViewUser);

        myUsers.add(new User("Omer", "Ozturk", "24", "Ogrenci", false));
        myUsers.add(new User("Oğuzhan", "Çakmak", "16", "Bebe", true));

        CustomAdapter customAdapter = new CustomAdapter(this, myUsers);
        listViewUser.setAdapter(customAdapter);


        listViewUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                editTxtName.setText(myUsers.get(i).get_name());
                //editTxtName.setEnabled(false);
                editTxtSurname.setText(myUsers.get(i).get_surname());
                //editTxtSurname.setEnabled(false);
                editTxtAge.setText(myUsers.get(i).get_age());
                //editTxtAge.setEnabled(false);
                editTxtJob.setText(myUsers.get(i).get_job());
                //editTxtJob.setEnabled(false);
                if (myUsers.get(i).get_isWoman()) {
                    rdnBtnWoman.setChecked(true);
                } else {
                    rdnBtnMan.setChecked(true);
                }
                //rdnBtnWoman.setEnabled(false);
                //rdnBtnMan.setEnabled(false);

                clickedItemIndex = i;
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTxtName.setText("");
                //editTxtName.setEnabled(true);
                editTxtSurname.setText("");
                //editTxtSurname.setEnabled(true);
                editTxtAge.setText("");
                //editTxtAge.setEnabled(true);
                editTxtJob.setText("");
                //editTxtJob.setEnabled(true);
                rdnBtnWoman.setChecked(false);
                //rdnBtnWoman.setEnabled(true);
                rdnBtnMan.setChecked(false);
                //rdnBtnMan.setEnabled(true);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myUsers.add(new User(
                        editTxtName.getText().toString().trim(),
                        editTxtSurname.getText().toString().trim(),
                        editTxtAge.getText().toString().trim(),
                        editTxtJob.getText().toString().trim(),
                        IsWoman
                ));

                CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, myUsers);
                listViewUser.setAdapter(customAdapter);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myUsers.set(clickedItemIndex, new User(
                        editTxtName.getText().toString().trim(),
                        editTxtSurname.getText().toString().trim(),
                        editTxtAge.getText().toString().trim(),
                        editTxtJob.getText().toString().trim(),
                        IsWoman
                ));
                CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, myUsers);
                listViewUser.setAdapter(customAdapter);
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myUsers.remove(clickedItemIndex);
                CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, myUsers);
                listViewUser.setAdapter(customAdapter);
            }
        });
    }

    public void rdnBtnOnClick(View view) {
        IsWoman = rdnBtnWoman.isChecked();
    }
}