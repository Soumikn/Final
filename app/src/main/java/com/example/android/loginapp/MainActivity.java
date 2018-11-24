package com.example.android.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText Name, Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;
    private TextView userRegistration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etUserPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);
        userRegistration = (TextView)findViewById(R.id.tvUserSignUp);

        Info.setText("No Of Attempts Remaining : 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());

            }
        });

        userRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
            }
        });

    }
    private void validate(String userName, String userPassword){
        if ((userName.equals("Admin")) && (userPassword.equals("12345"))){
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);

        }else{
            counter--;

            Info.setText("No Of Attempts Remaining :" + String.valueOf(counter));

            if(counter == 0){
                Login.setEnabled(false);
            }


        }


    }
}
