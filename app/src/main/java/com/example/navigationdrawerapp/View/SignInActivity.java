package com.example.navigationdrawerapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navigationdrawerapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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

    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @BindView(R.id.signIn_forget_password)
    TextView signInForgetPassword;

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

                if (!emailID.isEmpty() && !passwordID.isEmpty()) {
                    login(emailID, passwordID);
                } else {
                    Toast.makeText(this, "Field cannot be empty...", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.signIn_sign_up:
                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
                break;
        }
    }

    @OnClick(R.id.signIn_forget_password)
    public void onViewClicked() {
        startActivity(new Intent(SignInActivity.this, ForgetPasswordActivity.class));
    }

    private void login(String mail, String password) {
        mAuth.signInWithEmailAndPassword(mail, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    startActivity(new Intent(SignInActivity.this, MainActivity.class));
                } else {
                    Toast.makeText(SignInActivity.this, "We encountered an error...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
