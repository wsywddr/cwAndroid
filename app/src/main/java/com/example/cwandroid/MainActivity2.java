package com.example.cwandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.cwandroid.base.BaseActivityWithToolBar;
import com.example.cwandroid.bean.FirstEvent;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.greenrobot.eventbus.EventBus;


@EActivity(R.layout.activity_main)
public class MainActivity2 extends BaseActivityWithToolBar {
    private ImageLoader mImageloader;
    private DisplayImageOptions options;

    @AfterViews
    void afterViews() {
        setTitle("mytitle222222");
        setBtnLeft1Enable(true);



        EventBus.getDefault().post(new FirstEvent("FirstEvent btn clicked","100"));
    }
}
