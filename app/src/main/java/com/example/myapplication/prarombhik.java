package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class prarombhik extends AppCompatActivity {

    private static final String TAG = "GalleryActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prarombhik);
        Log.d(TAG, "onCreate: started.");
    }
}
