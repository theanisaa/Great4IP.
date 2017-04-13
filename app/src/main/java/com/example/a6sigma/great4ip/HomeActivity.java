package com.example.a6sigma.great4ip;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by lenovo on 08/03/2017.
 */

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mSignOut;
    private Intent mIntent;

    private FirebaseAuth mFirebaseAuth;

    private Boolean exit = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mFirebaseAuth = FirebaseAuth.getInstance();
//        mSignOut = (Button) findViewById(R.id.buttonSignOutHome);
//
//        mSignOut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        if(v == mSignOut){
//            finish();
//            mFirebaseAuth.signOut();
//            mIntent = new Intent(this, LoginActivity.class);
//            startActivity(mIntent);
//        }
    }

    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }
    }
}
