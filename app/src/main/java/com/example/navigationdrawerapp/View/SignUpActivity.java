package com.example.navigationdrawerapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.navigationdrawerapp.Controller.Validator;
import com.example.navigationdrawerapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity {

    @BindView(R.id.signUp_mail)
    EditText signUpMail;
    @BindView(R.id.signUp_password)
    EditText signUpPassword;
    @BindView(R.id.signUp_password_repeat)
    EditText signUpPasswordRepeat;
    @BindView(R.id.signUp_button)
    Button signUpButton;

    Validator signUpValidator = new Validator();

    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    String emailID, passwordID, passwordRepeatID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailID = signUpMail.getText().toString().trim();
                passwordID = signUpPassword.getText().toString().trim();
                passwordRepeatID = signUpPasswordRepeat.getText().toString().trim();

                if(signUpValidator.isEmailValid(emailID,SignUpActivity.this) ==1 && signUpValidator.isPasswordValid(passwordID, SignUpActivity.this) ==1) {
                    if(passwordID.equals(passwordRepeatID)) {
                        Register(emailID, passwordID);
                    }else {
                        Toast.makeText(SignUpActivity.this, "Passwords must match!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void Register(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                Toast.makeText(SignUpActivity.this, "Signed up successfully! ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
