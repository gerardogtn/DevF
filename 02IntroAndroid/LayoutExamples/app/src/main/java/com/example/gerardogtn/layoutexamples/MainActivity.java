package com.example.gerardogtn.layoutexamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected EditText mUserName;
    protected EditText mPassword;
    protected TextView mForgotPassword;
    protected Button mCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friska_layout_bis);

        mUserName = (EditText) findViewById(R.id.etxt_username);
        mPassword = (EditText) findViewById(R.id.etxt_password);
        mForgotPassword = (TextView) findViewById(R.id.txt_forgot_password);
        mCreateAccount = (Button) findViewById(R.id.btn_create_account);

        mCreateAccount.setOnClickListener(this);
    }

    public void onButtonClick(View view){
        Toast.makeText(this, "Escribiendo algo.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_create_account){
            Toast.makeText(this, "Taylor Swift.", Toast.LENGTH_SHORT).show();
        }
    }
}
