package com.example.gerardogtn.layoutexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by gerardogtn on 6/24/15.
 */
public class FormActivity extends AppCompatActivity {

    @InjectView(R.id.btn_create_sign_in) public Button mCreateSignIn;
    @InjectView(R.id.etxt_first_name) public EditText mFirstName;
    @InjectView(R.id.etxt_last_name) public EditText mLastName;
    @InjectView(R.id.etxt_password1) public EditText mPassword1;
    @InjectView(R.id.etxt_password2) public EditText mPassword2;
    @InjectView(R.id.etxt_phone_number) public EditText mPhoneNumber;
    @InjectView(R.id.etxt_email) public EditText mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friska_registration);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.btn_create_sign_in)
    public void signIn(){
        if (isInputValid()) {
            Intent homeActivity = new Intent(this, HomeActivity.class);
            startActivity(homeActivity);
        } else {
            Toast.makeText(this, "Some fields are empty or there is a password mismatch", Toast.LENGTH_SHORT).show();
        }
    }

    // REQUIRES: None.
    // MODIFIES: None.
    // EFFECTS: Returns true if no EditText is empty and both passwords are equal.
    private boolean isInputValid() {
        boolean output;
        output = !mFirstName.getText().toString().isEmpty();
        output = output && !mLastName.getText().toString().isEmpty();
        output = output && !mPassword1.getText().toString().isEmpty();
        output = output && !mPassword2.getText().toString().isEmpty();
        output = output && (mPassword1.getText().toString().equals(mPassword2.getText().toString()));
        output = output && !mPhoneNumber.getText().toString().isEmpty();
        output = output && !mEmail.getText().toString().isEmpty();

        return output; // STUB
    }
}
