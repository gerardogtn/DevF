package com.example.gerardogtn.layoutexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by gerardogtn on 6/24/15.
 */
public class FormActivity extends AppCompatActivity {

    @InjectView(R.id.btn_create_sign_in)
    public Button mCreateSignIn;

    @InjectView(R.id.etxt_first_name)
    public EditText mFirstName;

    @InjectView(R.id.etxt_last_name)
    public EditText mLastName;

    @InjectView(R.id.etxt_username)
    public EditText mUserName;

    @InjectView(R.id.etxt_password1)
    public EditText mPassword1;

    @InjectView(R.id.etxt_password2)
    public EditText mPassword2;

    @InjectView(R.id.etxt_phone_number)
    public EditText mPhoneNumber;

    @InjectView(R.id.etxt_email)
    public EditText mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friska_form);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.btn_create_sign_in)
    public void signIn(){
        if (isFieldEmpty()){
            Toast.makeText(this, "Some fields are empty.", Toast.LENGTH_SHORT).show();
        } else if (!doPasswordsMatch()){
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
        } else{
            goToUserProfile();
        }

    }

    // REQUIRES: None.
    // MODIFIES: None.
    // EFFECTS: Goes to UserProfileActivity, passing all data in edit texts.
    private void goToUserProfile(){
        Intent userProfileActivity = new Intent(FormActivity.this, UserProfileActivity.class);
        userProfileActivity.putExtra("first_name", mFirstName.getText().toString());
        userProfileActivity.putExtra("last_name", mLastName.getText().toString());
        userProfileActivity.putExtra("username", mUserName.getText().toString());
        userProfileActivity.putExtra("phone", mPhoneNumber.getText().toString());
        userProfileActivity.putExtra("email", mEmail.getText().toString());
        startActivity(userProfileActivity);
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

        return output;
    }

    // REQUIRES: None.
    // MODIFIES: None.
    // EFFECTS: Returns true if any of the fields is empty. False otherwise.
    private boolean isFieldEmpty(){
        boolean output;
        output = mFirstName.getText().toString().isEmpty();
        output = output || mLastName.getText().toString().isEmpty();
        output = output || mPassword1.getText().toString().isEmpty();
        output = output || mPassword2.getText().toString().isEmpty();
        output = output || mPhoneNumber.getText().toString().isEmpty();
        output = output || mEmail.getText().toString().isEmpty();
        return output;
    }

    // REQUIRES: None.
    // MODIFIES: None.
    // EFFECTS:  Returns true if both passwords have the same text. False otherwise.
    private boolean doPasswordsMatch(){
        return mPassword1.getText().toString().equals(mPassword2.getText().toString());
    }
}
