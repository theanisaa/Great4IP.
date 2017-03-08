package com.example.a6sigma.great4ip;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText mEmail;
    private EditText mPassword;
    private Button mLogin;

    private Button mSignUp;

    private ProgressDialog mProgressDialog;
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = (EditText) findViewById(R.id.editTextEmailLogin);
        mPassword = (EditText) findViewById(R.id.editTextPasswordLogin);
        mLogin = (Button) findViewById(R.id.buttonLogin);
        mSignUp = (Button) findViewById(R.id.Sign_Up);

        mProgressDialog = new ProgressDialog(this);
        mFirebaseAuth = FirebaseAuth.getInstance();

        mLogin.setOnClickListener(this);
        mSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();

        LoginModel loginModel = new LoginModel(email, password);
        if (v == mSignUp){
            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);
        } else if (v == mLogin){
            if(validateUser(loginModel)){
                userLogin(loginModel);
            } else {
                mPassword.setText("");
                return;
            }
        }
    }

    private boolean validateUser(LoginModel loginModel){
        boolean validate = false;

        if(TextUtils.isEmpty(loginModel.getEmail()) && TextUtils.isEmpty(loginModel.getPassword())){
            Toast.makeText(this, "Please input your email and password", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(loginModel.getEmail())){
            Toast.makeText(this, "Please input your email", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(loginModel.getPassword())){
            Toast.makeText(this, "Please input your password", Toast.LENGTH_SHORT).show();
        } else {
            validate = true;
        }
        return validate;
    }

    private void userLogin(LoginModel loginModel){
        mProgressDialog.setMessage("Signing in...");
        mProgressDialog.show();

        mFirebaseAuth.signInWithEmailAndPassword(loginModel.getEmail(), loginModel.getPassword())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        mProgressDialog.dismiss();
                        if(task.isSuccessful()){
                            finish();
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, "Please Try Again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
