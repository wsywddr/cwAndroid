package com.example.cwandroid;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.cwandroid.base.BaseActivityWithToolBar;
import com.example.cwandroid.bean.FirstEvent;
import com.example.cwandroid.util.ToastUtil;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@EActivity(R.layout.activity_main)
public class MainActivity  extends BaseActivityWithToolBar {
    private ImageLoader mImageloader;
    private DisplayImageOptions options;

    @AfterViews
    void afterViews() {
        setTitle("mytitle");
        setBtnLeft1Enable(true);
        EventBus.getDefault().register(this);

        //AppConfig.getPreferenceBy(preference,"ifSetTitle")
        //AppConfig.setPreferenceBy(preference,"ifSetTitle")

        //IML使用
        ImageView img01=(ImageView)findViewById(R.id.img01);
        mImageloader = ImageLoader.getInstance();

        options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();
        mImageloader.displayImage("http://s.cimg.163.com/catchpic/1/19/198237CEE39C807BEAEADB1E6D33AAF6.jpg.670x270.jpg", img01, options);
        mImageloader.displayImage("http://s.cimg.163.com/catchpic/1/19/198237CEE39C807BEAEADB1E6D33AAF6.jpg.670x270.jpg", img01);

//        PreUtils.putStringToDefault(mActivity, "read", readSequence);

        img01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.show(getApplicationContext(),"123");
                Intent intent = new Intent(MainActivity.this, MainActivity2_.class);
                startActivity(intent);


            }
        });
    }

    @Subscribe
    public void onEvent(FirstEvent event) {
        /* Do something */
        String msg = "onEventMainThread" + event.getMsg();
        Log.d("harvic", msg);
    };


    @Override
    protected void onDestroy(){
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onBackPressed() {
        finish();

        //动画 左到右
        overridePendingTransition(0, R.anim.slide_out_to_left);
    }
}
