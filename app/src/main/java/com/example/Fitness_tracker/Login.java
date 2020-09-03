package com.example.Fitness_tracker;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private Button button;
    private EditText e1,e2;
    DataBaseHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mydb= new DataBaseHelper(this);
        e1= findViewById(R.id.editTextTextEmailAddress);
        e2= findViewById(R.id.editTextTextPassword);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e1.getText().toString();
                String password = e2.getText().toString();
                boolean checkEmailPassword= mydb.emailPassword(email,password);
                if(checkEmailPassword){
                    Toast.makeText(getApplicationContext(),"Login Success!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login.this,SelectionActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Wrong email or password!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}