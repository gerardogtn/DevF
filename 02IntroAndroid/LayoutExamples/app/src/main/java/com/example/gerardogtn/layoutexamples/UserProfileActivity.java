package com.example.gerardogtn.layoutexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by gerardogtn on 6/28/15.
 */
public class UserProfileActivity extends AppCompatActivity {

    public static final String LOG_UPA = "UserProfileActivity: ";

    @InjectView(R.id.etxt_up_first_name)
    public EditText mFirstName;

    @InjectView(R.id.etxt_up_last_name)
    public EditText mLastName;

    @InjectView(R.id.etxt_up_username)
    public EditText mUserName;

    @InjectView(R.id.etxt_up_phone)
    public EditText mPhone;

    @InjectView(R.id.etxt_up_email)
    public EditText mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friska_user_profile);
        ButterKnife.inject(this);
        fillFields();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    // REQUIRES: Intent has all fields.
    // MODIFIES: this.
    // EFFECTS: Fills all the EditText fields with the info passed by the intent.
    @Nullable
    private void fillFields(){
        Intent source = getIntent();
        abstractSetText(mFirstName, source, "first_name");
        abstractSetText(mLastName, source, "last_name");
        abstractSetText(mUserName, source, "username");
        abstractSetText(mPhone, source, "phone");
        abstractSetText(mEmail, source, "email");
    }


    // REQUIRES: None.
    // MODIFIES: this.
    // EFFECTS: If key is valid: Sets the EditText text to the text with key key in source Intent.
    //          If key is invalid: logs an error notifying that the  key was not found.
    private void abstractSetText(EditText dest, Intent source, String key){
        String sourceInfo = source.getStringExtra(key);
        if (sourceInfo != null){
            dest.setText(sourceInfo);
        } else {
            Log.e(LOG_UPA, (key + " not found"));
        }

    }
}
