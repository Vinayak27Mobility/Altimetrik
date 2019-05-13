package com.altimetrikpg.android.di;


import com.altimetrikpg.android.view.impl.VehicleIdActivity;

import dagger.Component;

@ActivityScope
@Component(
        dependencies = {ApplicationComponent.class},
        modules = VehicleIdModule.class)
public interface VehicleIdComponent {
    void inject(VehicleIdActivity vehicleIdActivity);
}
