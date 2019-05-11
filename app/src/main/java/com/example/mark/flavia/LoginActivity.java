package com.example.mark.flavia;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);

        mPasswordView = (EditText) findViewById(R.id.password);

        Button register_btn = (Button) findViewById(R.id.btn_regiter1);


        register_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,Register.class);
                startActivity(intent);
            }
        });



        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);

        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //attemptLogin();

                final SharedPreferences sharedPreferences=getSharedPreferences("USER_CREDENTIALS",MODE_PRIVATE);
                final String sh_email=sharedPreferences.getString("Email","DEFAULT_NAME");
                final String sh_pass=sharedPreferences.getString("Password","DEFAULT_PASSWORD");


                String EMAIL = mEmailView.getText().toString();
                String PASS = mPasswordView.getText().toString();


                if(TextUtils.equals(sh_email, EMAIL)){

                    return;
                }
                if(TextUtils.equals(sh_pass, PASS)){
                    return;
                }

                Intent intent = new Intent(LoginActivity.this, Add_Book.class);
                startActivity(intent);



            }
        });

    }


}

