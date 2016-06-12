package com.example.cwandroid.base;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.cwandroid.util.AppManager;
import com.example.cwandroid.util.Constant;


public class BaseActivity extends AppCompatActivity {

    protected SharedPreferences preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppManager.activities.add(this);
        super.onCreate(savedInstanceState);
        preference = getSharedPreferences(Constant.PERFENAME, Context.MODE_PRIVATE);
        AppManager.setPreferences(preference);
    }

}
