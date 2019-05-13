package com.altimetrikpg.android.di;


import com.altimetrikpg.android.APGApplication;
import com.altimetrikpg.android.network.ServiceHelper;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(APGApplication gpApplication);

    ServiceHelper getServiceHelper();
}
