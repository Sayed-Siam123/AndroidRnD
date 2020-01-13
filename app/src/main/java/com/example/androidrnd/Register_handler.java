package com.example.androidrnd;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import java.util.concurrent.Executor;

import es.dmoral.toasty.Toasty;

public class Register_handler extends User {



    Register_handler(String email, String pass) {
        super(email, pass);
    }

    @Override
    public void login() {

    }

    @Override
    public void register() {

        String Email=User.getEmail();
        String Pass=User.getPass();

        User.setEmail(Email);
        User.setPass(Pass);

        Log.d("Confirmation","Register Begin!!!! huhuhuhahaha email: "+Email);

    }


}
