package com.example.inventory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Esta clase da soporte de código a la activity del login
 * @author Carlos Cruz Domínguez
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnSignIn) {
            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
            startActivity(intent);
        }
    }
}
