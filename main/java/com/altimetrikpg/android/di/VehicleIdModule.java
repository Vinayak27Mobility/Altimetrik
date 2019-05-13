package com.altimetrikpg.android.di;

import com.altimetrikpg.android.network.ServiceHelper;
import com.altimetrikpg.android.presenter.VehicleIdPresenter;
import com.altimetrikpg.android.view.VehicleIdContract;

import dagger.Module;
import dagger.Provides;

@Module
public class VehicleIdModule {
    private VehicleIdContract.View view;

    public VehicleIdModule(VehicleIdContract.View mainView) {
        this.view = mainView;
    }

    @Provides
    @ActivityScope
    VehicleIdContract.presenter providePresenter(ServiceHelper serviceHelper) {
        return new VehicleIdPresenter(view, serviceHelper);
    }
}
