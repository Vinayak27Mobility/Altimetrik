package com.altimetrikpg.android;

import android.app.Application;


import com.altimetrikpg.android.di.ApplicationComponent;
import com.altimetrikpg.android.di.ApplicationModule;
import com.altimetrikpg.android.di.DaggerApplicationComponent;
import com.altimetrikpg.android.di.NetworkModule;

import timber.log.Timber;

public class APGApplication extends Application {

    private static APGApplication APGApplication;
    private static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        //Dagger
        setUpDagger();

        //Timber
        if(BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    private static ApplicationComponent getDaggerComponent() {
        return applicationComponent;
    }


    public static ApplicationComponent getApplicationComponent() {
        return APGApplication.getDaggerComponent();
    }

    private void setUpDagger() {
        APGApplication = this;
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule())
                .networkModule(new NetworkModule())
                .build();
        applicationComponent.inject(this);
    }
}
