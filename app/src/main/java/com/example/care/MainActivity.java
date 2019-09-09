package com.example.care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.care.home.Home;

public class MainActivity extends AppCompatActivity {

    private EditText eMail,passWord;
    private Button login,register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eMail = findViewById(R.id.email);
        passWord = findViewById(R.id.password);

        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eMail.equals("")||passWord.equals(""))
                {
                    Toast.makeText(MainActivity.this,"Please Fill the details",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    startActivity(new Intent(MainActivity.this, Home.class));
                    finish();
                }
            }
        });
    }
}
