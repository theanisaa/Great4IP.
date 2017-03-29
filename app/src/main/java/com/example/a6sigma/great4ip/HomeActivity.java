package com.example.a6sigma.great4ip;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by lenovo on 08/03/2017.
 */

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mSignOut;
    private Intent mIntent;

    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mSignOut = (Button) findViewById(R.id.buttonSignOutHome);

        mSignOut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mSignOut){
            finish();
            mFirebaseAuth.signOut();
            mIntent = new Intent(this, LoginActivity.class);
            startActivity(mIntent);
        }
    }
}
