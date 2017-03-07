package com.example.a6sigma.great4ip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mSignUp;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mSignUp = (Button) findViewById(R.id.Sign_Up);

        mSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mSignUp){
            mIntent = new Intent(LoginActivity.this, SignUpActivity.class);
        }
        startActivity(mIntent);
    }
}
