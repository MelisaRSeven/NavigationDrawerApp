package com.example.navigationdrawerapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navigationdrawerapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignInActivity extends AppCompatActivity {

    @BindView(R.id.signIn_mail)
    EditText signInMail;
    @BindView(R.id.signIn_password)
    EditText signInPassword;
    @BindView(R.id.signIn_button)
    Button signInButton;
    @BindView(R.id.signIn_sign_up)
    TextView signInSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.signIn_button, R.id.signIn_sign_up})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.signIn_button:
                String emailID = signInMail.getText().toString().trim();
                String passwordID = signInPassword.getText().toString().trim();

                if(!emailID.isEmpty() && !passwordID.isEmpty()) {

                }else {
                    Toast.makeText(this, "Field cannot be empty...", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.signIn_sign_up:
                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
                break;
        }
    }
}
