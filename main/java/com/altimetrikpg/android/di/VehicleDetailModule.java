package com.altimetrikpg.android.di;

import com.altimetrikpg.android.network.ServiceHelper;
import com.altimetrikpg.android.presenter.VehicleDetailPresenter;
import com.altimetrikpg.android.view.VehicleDetailContract;

import dagger.Module;
import dagger.Provides;

@Module
public class VehicleDetailModule {
    private VehicleDetailContract.View view;

    public VehicleDetailModule(VehicleDetailContract.View mainView) {
        this.view = mainView;
    }

    @Provides
    @ActivityScope
    VehicleDetailContract.presenter providePresenter(ServiceHelper serviceHelper) {
        return new VehicleDetailPresenter(view, serviceHelper);
    }
}
