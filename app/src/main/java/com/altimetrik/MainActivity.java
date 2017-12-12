package com.altimetrik;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferenceDemo();
        fileInternalStorage();
    }

    //Using internal storage
    void sharedPreferenceDemo() {
        SharedPreferences myPreference = getSharedPreferences("samplePreference", Context.MODE_PRIVATE);
        //write data to shared preference
        SharedPreferences.Editor editor = myPreference.edit();
        editor.putInt("count", 10);
        editor.commit();

        //read data from shared preference
        int count = myPreference.getInt("count",-1);
        Log.d("sharedPreferenceDemo","count:" + count);
    }

    void fileInternalStorage() {
        String filename = "myfile";
        String string = "Hello world!";
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Using external Storage


}
