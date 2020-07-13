package com.ahmedabiodun.bloodmatcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ahmedabiodun.bloodmatcher.R;

public class LoginActivity extends AppCompatActivity {

    private EditText mTextUsername;
    private EditText mTextPassword;
    private Button mLoginButton;
    private TextView mTextRegister;
    private BloodMatcherOpenHelper mDbHelper = new BloodMatcherOpenHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextUsername = (EditText) findViewById(R.id.editText_username);
        mTextPassword = (EditText) findViewById(R.id.editText_password);
        mLoginButton = (Button) findViewById(R.id.login_button);
        mTextRegister = (TextView) findViewById(R.id.register);
        mTextRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                checkUser();
                Toast.makeText(LoginActivity.this, "Teting testing!!!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void checkUser() {
        String user = mTextUsername.getText().toString().trim();
        String pswrd = mTextPassword.getText().toString().trim();
        Boolean isUserExist = mDbHelper.checkUser(user, pswrd);

        if (isUserExist) {
            Toast.makeText(LoginActivity.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
            Intent homeIntent = new Intent(LoginActivity.this, HomeScreenActivity.class);
            startActivity(homeIntent);
        } else {
            Toast.makeText(LoginActivity.this, "Login Error, check details again!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        mDbHelper.close();
        super.onDestroy();
    }
}
