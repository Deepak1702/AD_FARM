package com.example.deepak.ad_farm;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Register extends AppCompatActivity  implements OTP_Fragment.OnFragmentInteractionListener,Password_Fragment.OnFragmentInteractionListener{
Button btndone,btnlogin;
    boolean status = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btndone=(Button) findViewById(R.id.btnDone);
        btnlogin=(Button) findViewById(R.id.btnLogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, LogIn_Activity.class);
                startActivity(intent);
            }
        });
        btndone.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                    if (status == false) {
                        OTP_Fragment f1 = new OTP_Fragment();
                        getSupportFragmentManager().beginTransaction().add(R.id.btnDone, f1).commit();
                        status = true;
                    } else {
                        Password_Fragment f2 = new Password_Fragment();
                        getSupportFragmentManager().beginTransaction().add(R.id.btnRegister, f2).commit();
                        status = false;
                    }
                }
            });

        }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
