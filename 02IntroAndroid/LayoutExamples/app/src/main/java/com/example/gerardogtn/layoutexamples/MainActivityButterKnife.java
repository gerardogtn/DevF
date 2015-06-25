package com.example.gerardogtn.layoutexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by gerardogtn on 6/24/15.
 */
public class MainActivityButterKnife extends AppCompatActivity{

    @InjectView(R.id.etxt_username) protected EditText mUserName;
    @InjectView(R.id.etxt_password) protected EditText mPassword;
    @InjectView(R.id.txt_forgot_password) protected TextView mForgotPassword;
    @InjectView(R.id.btn_create_account) protected Button mCreateAccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friska_layout_bis);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.txt_forgot_password)
    public void forgotPassword(){
        Toast.makeText(this, "Imprimiendo con ButterKnife.", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_create_account)
    public void createAccount(){
        Intent intent = new Intent(this, FormActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
