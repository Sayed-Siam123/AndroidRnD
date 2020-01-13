package com.example.androidrnd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.logging.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;

public class Registration extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth mFirebaseAuth;
    Register_handler rh;

   @BindView(R.id.email_registration)
    TextView email_registration;

   @BindView(R.id.pass_registration)
    TextView pass_registration;

   @BindView(R.id.cpass_registration)
    TextView cpass_registration;
    Button get_register,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);
        mFirebaseAuth= FirebaseAuth.getInstance();

        get_register = findViewById(R.id.get_register);
        back= findViewById(R.id.back);

        get_register.setOnClickListener(this);
        back.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.get_register){
            String email = email_registration.getText().toString();
            String pass = pass_registration.getText().toString();

            if(email.isEmpty()){
                email_registration.setError("Enter email please");
                email_registration.requestFocus();
                rh = new Register_handler(email,pass);
            }

            else if(pass.isEmpty()){
                pass_registration.setError("Enter password please");
                pass_registration.requestFocus();
            }

            else if(email.isEmpty() && pass.isEmpty()){
                email_registration.setError("Enter email please");
                email_registration.requestFocus();
                pass_registration.setError("Enter password please");
                pass_registration.requestFocus();
            }

            else if(!pass.equals(cpass_registration.getText().toString())){
                Toasty.error(getApplicationContext(),"Password doesn't match",Toasty.LENGTH_SHORT).show();
            }

            else{

                mFirebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(Registration.this, task -> {
                    if(!task.isSuccessful()){

                        Log.d("Error","Kaj hoy nai bro registration!!!");
                    }
                    else {
                        Intent i = new Intent(Registration.this,Index.class);
                        startActivity(i);
                        Toasty.success(getApplicationContext(),"Registration Done",Toasty.LENGTH_SHORT).show();

                    }
                });
            }
        }

        else if(v.getId()==R.id.back){

        }
    }
}
