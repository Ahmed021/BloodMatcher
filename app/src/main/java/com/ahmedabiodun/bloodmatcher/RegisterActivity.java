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
                String user = mTextUsername.getText().toString().trim();
                String pswrd = mTextPassword.getText().toString().trim();
                String cnf_pswrd = mTextCnfPassword.getText().toString().trim();

//                if (pswrd.equals(cnf_pswrd)) {
//                    long val = mDbHelper.addUser(user, pswrd);
//                    if (val > 0) {
//                        Toast.makeText(RegisterActivity.this, "Registration Successful!", Toast.LENGTH_LONG).show();
//                    } else {
//                        Toast.makeText(RegisterActivity.this, "Registration Error!!", Toast.LENGTH_LONG).show();
//                    }
//                } else {
//                    Toast.makeText(RegisterActivity.this, "Password do not match, check again!", Toast.LENGTH_SHORT).show();
//                }

                Toast.makeText(RegisterActivity.this, "Successfully registered", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
