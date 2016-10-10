package com.rex.hwong.openeyes;

import android.app.Application;
import android.content.Context;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 16/10/9
 * @time 下午2:04
 */

public class OpenEyesApp extends Application {

    public static OpenEyesApp openEyesApp = null;

    @Override
    public void onCreate() {
        super.onCreate();
        openEyesApp = this;
    }

    public static Context getContext(){
        return openEyesApp;
    }
}
