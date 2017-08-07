package com.example.zulkuf.firstrunapp;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences preferences;
    final String firstRunString = "IamFirstRunning";

    //Called activity when first running app
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        //second argument is the default to use if the preference can't be found

        Boolean isFirstRun = preferences.getBoolean(firstRunString,false);

        if (!isFirstRun){

            //here you can do when app first show
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(firstRunString,true);
            editor.commit(); // You have to commit preference.
            Toast.makeText(this,"This is first run ",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"This app runned before",Toast.LENGTH_SHORT).show();
        }
    }
}
