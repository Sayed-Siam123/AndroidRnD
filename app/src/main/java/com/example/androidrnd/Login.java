package com.example.androidrnd;

import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;

public class Login extends AppCompatActivity {

    @BindView(R.id.email_field)
    EditText email_field;

    @BindView(R.id.password_field)
    EditText password_field;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login) void get_login(){
        Toasty.success(this,"Button click Paisi"+" "+this.email_field.getText().toString(),Toasty.LENGTH_SHORT).show();
    }

}
