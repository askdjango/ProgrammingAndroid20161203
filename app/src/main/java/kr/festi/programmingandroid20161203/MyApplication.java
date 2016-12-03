package kr.festi.programmingandroid20161203;

import android.app.Application;

import com.facebook.FacebookSdk;


public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
    }
}

