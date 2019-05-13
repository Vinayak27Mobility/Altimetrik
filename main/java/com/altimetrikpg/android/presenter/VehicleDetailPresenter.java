package com.altimetrikpg.android.presenter;


import com.altimetrikpg.android.model.VehicleImageData;
import com.altimetrikpg.android.network.ServiceHelper;
import com.altimetrikpg.android.view.VehicleDetailContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class VehicleDetailPresenter implements VehicleDetailContract.presenter {

    private VehicleDetailContract.View view;
    private ServiceHelper serviceHelper;

    public VehicleDetailPresenter(VehicleDetailContract.View view, ServiceHelper serviceHelper) {
        this.view = view;
        this.serviceHelper = serviceHelper;
    }


    @Override
    public void getVehicleImage(String vehId) {

        Call<VehicleImageData> vehicleImageDataCall = serviceHelper.getVehicleImage(vehId);

        vehicleImageDataCall.enqueue(new Callback<VehicleImageData>() {
            @Override
            public void onResponse(Call<VehicleImageData> call, Response<VehicleImageData> response) {
                Timber.d("response for school list is ", response.body());
                if(response.code() == 200) {
                    view.onVehicleImageSuccess(response.body());
                } else {
                    view.onVehicleImageFail();
                }
            }

            @Override
            public void onFailure(Call<VehicleImageData> call, Throwable t) {
                Timber.e("doInBackground: Something went wrong fetching data", t.getMessage());
                view.onVehicleImageFail();
            }
        });
    }
}
