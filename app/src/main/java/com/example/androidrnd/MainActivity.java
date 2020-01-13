package com.example.androidrnd;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.button2)
    Button login;

    @BindView(R.id.button)
    Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    /*@Override
    public void onClick(View v) {
        if(v.getId()==R.id.button2){
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
            Toasty.success(getApplicationContext(),"Success", Toast.LENGTH_LONG,true).show();
        }
    }*/

    @OnClick(R.id.button) void Register_page(){
        Intent i = new Intent(MainActivity.this, Registration.class);
        startActivity(i);
        Toasty.success(getApplicationContext(),"Success", Toast.LENGTH_LONG,true).show();
    }

    @OnClick(R.id.button2) void Login_page(){
        Intent intent = new Intent(MainActivity.this, Login.class);
        startActivity(intent);
        Toasty.success(getApplicationContext(),"Success", Toast.LENGTH_LONG,true).show();
    }

}
