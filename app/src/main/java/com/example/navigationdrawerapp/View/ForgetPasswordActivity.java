package com.example.navigationdrawerapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.navigationdrawerapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgetPasswordActivity extends AppCompatActivity {
    FirebaseAuth forgetPass = FirebaseAuth.getInstance();

    @BindView(R.id.forgetScreen_email)
    EditText forgetScreenEmail;
    @BindView(R.id.forgetScreen_button)
    Button forgetScreenButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.forgetScreen_button)
    public void onViewClicked() {
        String emailID = forgetScreenEmail.getText().toString().trim();

        forgetPass.sendPasswordResetEmail(emailID).addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(ForgetPasswordActivity.this, "E-Mail Sent", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ForgetPasswordActivity.this, "Failed to send reset e-mail!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        startActivity(new Intent(ForgetPasswordActivity.this, SignInActivity.class));
    }
}
