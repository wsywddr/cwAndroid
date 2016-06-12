package com.example.cwandroid.util;

import android.content.SharedPreferences;

import com.example.cwandroid.base.BaseActivity;
import com.example.cwandroid.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class AppManager {

    public static List<BaseActivity> activities = new ArrayList<BaseActivity>();
    public static List<BaseFragment> fragments = new ArrayList<BaseFragment>();
    //选择分类activity
    public static List<BaseActivity> classActivities = new ArrayList<BaseActivity>();

    private static SharedPreferences preferences;

    public static SharedPreferences getPreferences() {
        return preferences;
    }

    public static void setPreferences(SharedPreferences preferences) {
        AppManager.preferences = preferences;
    }
}
