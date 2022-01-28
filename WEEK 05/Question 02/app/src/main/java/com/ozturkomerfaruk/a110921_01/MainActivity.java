package com.ozturkomerfaruk.a110921_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSignIn, btnSignUp;
    EditText editTxtUsername, editTxtPassword;

    SharedPreferences preferences;

    Intent intent;

    void InitilizeApp() {
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignUp = findViewById(R.id.btnSignUp);
        editTxtUsername = findViewById(R.id.editTxtUsername);
        editTxtPassword = findViewById(R.id.editTxtPassword);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitilizeApp();
        preferences = getSharedPreferences("settings", MODE_PRIVATE);
    }

    public void SignUpSaveButton(View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("usernameKey", editTxtUsername.getText().toString());
        editor.putString("passwordKey", editTxtPassword.getText().toString());
        editor.apply();
        Toast.makeText(this, "username: " + editTxtUsername.getText().toString()+ "\n" +
                "password: " + editTxtPassword.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    public void SignInReadButton(View view) {
        String usernameKey = preferences.getString("usernameKey", "");
        String passwordKey = preferences.getString("passwordKey", "");
        if(usernameKey.contains(editTxtUsername.getText().toString())
                && passwordKey.contains(editTxtPassword.getText().toString())) {
            intent = new Intent(MainActivity.this, SecondPage.class);
            startActivity(intent);
        }
    }
}
