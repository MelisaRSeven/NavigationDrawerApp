package com.example.navigationdrawerapp.Controller;

import android.content.Context;
import android.util.Patterns;
import android.widget.Toast;

public class Validator {
    public Validator() {
    }

    public int isEmailValid(String mailID, Context context) {
        int result;

        if(mailID.isEmpty()) {
            Toast toast = Toast.makeText(context, "Field can not be empty(E-Mail)", Toast.LENGTH_SHORT);
            toast.show();
            result = 0;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(mailID).matches()) {
            Toast toast = Toast.makeText(context, "Invalid E-Mail or Password", Toast.LENGTH_SHORT);
            toast.show();
            result = 2;
        }else {
            result = 1;
        }
        return result;
    }

    public int isPasswordValid(String passwordID, Context context) {
        int result;

        if(passwordID.isEmpty()) {
            Toast toast = Toast.makeText(context, "Field can not be empty(Password)", Toast.LENGTH_SHORT);
            toast.show();
            result = 0;
        }else if(passwordID.length() < 6 || passwordID.length() > 20) {
            Toast toast = Toast.makeText(context, "Password must be more than 6 and less than 20 characters", Toast.LENGTH_SHORT);
            toast.show();
            result = 2;
        }else {
            result = 1;
        }
        return result;
    }

    public int isNameValid(String nameID, Context context) {
        int result;

        if(nameID.isEmpty()) {
            Toast toast = Toast.makeText(context, "Field can not be empty(Name or Surname)", Toast.LENGTH_SHORT);
            toast.show();
            result = 0;
        }else if(nameID.length() > 20) {
            Toast toast = Toast.makeText(context, "Name must be less than 20 characters", Toast.LENGTH_SHORT);
            toast.show();
            result = 2;
        }else {
            result= 1;
        }
        return result;
    }
}
