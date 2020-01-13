package com.example.androidrnd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Index extends AppCompatActivity {

    FirebaseAuth mFirebaseAuth;

    @BindView(R.id.index_textview)
    TextView index_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        ButterKnife.bind(this);

        index_textview.setText(String.valueOf(mFirebaseAuth.getCurrentUser()));

        Log.d("Current User", String.valueOf(mFirebaseAuth.getCurrentUser()));


    }

    @OnClick(R.id.logout) void logout(){
        mFirebaseAuth.signOut();
    }

}
