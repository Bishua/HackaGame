package com.example.bishua.hackagame;

import android.app.Application;
import android.content.Context;

/**
 * Created by Illia on 14.09.2014.
 */
public class MyApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        MyApplication.context = getApplicationContext();
    }

    public static Context getAppContext(){
        return MyApplication.context;
    }


}
