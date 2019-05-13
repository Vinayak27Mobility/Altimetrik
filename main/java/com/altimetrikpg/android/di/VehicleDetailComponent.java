package com.altimetrikpg.android.di;


import com.altimetrikpg.android.view.impl.VehicleDetailActivity;

import dagger.Component;

@ActivityScope
@Component(
        dependencies = {ApplicationComponent.class},
        modules = VehicleDetailModule.class)
public interface VehicleDetailComponent {
    void inject(VehicleDetailActivity vehicleDetailActivity);
}
