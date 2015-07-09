package com.example.gerardogtn.introlists;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @Bind(R.id.list_view)
    public ListView listView;

    @Bind(R.id.main_activity)
    public View layout;

    public static final String[] names = {"Chava", "Salvador", "Fer", "Angel", "Emilio", "Sebas"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        SampleAdapter adapter = new SampleAdapter(this, 0, names);
        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(layout, names[position], Snackbar.LENGTH_SHORT).show();
                //Toast.makeText(MainActivity.this, names[position], Toast.LENGTH_SHORT).show();
                return;
            }
        });
    }


}
