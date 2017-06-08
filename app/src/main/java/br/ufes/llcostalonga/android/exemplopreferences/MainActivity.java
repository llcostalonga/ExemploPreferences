package br.ufes.llcostalonga.android.exemplopreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtPref1;// = (TextView) findViewById(R.id.txtPref1);
    TextView txtPref2;// = (TextView) findViewById(R.id.txtPref2);
    TextView txtPref3;// = (TextView) findViewById(R.id.txtPref3);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



         txtPref1 = (TextView) findViewById(R.id.txtPref1);
         txtPref2 = (TextView) findViewById(R.id.txtPref2);
         txtPref3 = (TextView) findViewById(R.id.txtPref3);



    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String strUserName = SP.getString("username", "NA");
        boolean bAppUpdates = SP.getBoolean("applicationUpdates",false);
        String downloadType = SP.getString("downloadType","1");

        txtPref1.setText(strUserName);
        txtPref2.setText(String.valueOf(bAppUpdates));
        txtPref3.setText(downloadType);


    }

    public void buttonClick(View v){
        Intent i = new Intent(this, MyPreferencesActivity.class);
        startActivity(i);
    }
}
