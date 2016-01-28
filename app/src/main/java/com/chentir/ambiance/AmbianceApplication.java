package com.chentir.ambiance;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by achentir on 1/26/16.
 */
public class AmbianceApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
        Stetho.initializeWithDefaults(this);
    }
}
