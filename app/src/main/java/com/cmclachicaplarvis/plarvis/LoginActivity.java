package com.cmclachicaplarvis.plarvis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    private Button btnLinkToRegister;
    private Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLinkToRegister = (Button) findViewById(R.id.btnLinkToRegisterScreen);
        btnlogin = (Button) findViewById(R.id.btnLogin);
        Login();

        // Link to Register Screen
        btnLinkToRegister.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        RegistrationActivity.class);
                startActivity(i);
                finish();
            }
        });


    }

    public void Login() {
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent MainWindow = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(MainWindow);
            }
        });
    }
}