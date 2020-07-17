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
import com.google.android.material.snackbar.Snackbar;

public class RegisterActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    Button mRegisterButton;
    TextView mTextLogin;
    private BloodMatcherOpenHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        mDbHelper = new BloodMatcherOpenHelper(this);
        mTextUsername = (EditText) findViewById(R.id.editText_username);
        mTextPassword = (EditText) findViewById(R.id.editText_password);
        mTextCnfPassword = (EditText) findViewById(R.id.edit_cnf_password);
        mRegisterButton = (Button) findViewById(R.id.register_button);

        mTextLogin = (TextView) findViewById(R.id.register);
        mTextLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registerUser();
            }
        });
    }

    private void registerUser() {
        String user = mTextUsername.getText().toString();
        String pswrd = mTextPassword.getText().toString();
        String cnf_pswrd = mTextCnfPassword.getText().toString();

        if (user != null && pswrd != null && cnf_pswrd != null) {
            if (pswrd.equals(cnf_pswrd)) {

                mDbHelper.addUser(user, pswrd);

                Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            } else {
                Snackbar.make(findViewById(R.id.reg_view), "Password do not match, Check again!!", Snackbar.LENGTH_LONG).show();
            }
        } else {
            Snackbar.make(findViewById(R.id.reg_view), "Fill all empty fields!", Snackbar.LENGTH_LONG).show();
        }
    }
}
