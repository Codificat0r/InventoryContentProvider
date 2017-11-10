package com.example.inventorymaterial.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.inventorymaterial.DashboardActivity;
import com.example.inventorymaterial.R;

/**
 * Esta clase da soporte de código a la activity del login
 * @author Carlos Cruz Domínguez
 */
public class LoginViewImpl extends AppCompatActivity implements View.OnClickListener{

    LoginPresenter loginPresenter;
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
            loginPresenter.validateCredentials("paco", "123456");
            /*Intent intent = new Intent(LoginViewImpl.this, DashboardActivity.class);
            strtActivity(intent);*/
        }
    }
}
