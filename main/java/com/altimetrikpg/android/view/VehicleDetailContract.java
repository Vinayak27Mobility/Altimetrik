package com.altimetrikpg.android.view;


import com.altimetrikpg.android.model.VehicleImageData;

public interface VehicleDetailContract {
    interface View {
        void onVehicleImageSuccess(VehicleImageData vehicleImageData);
        void onVehicleImageFail();
    }

    interface presenter {
        void getVehicleImage(String vehId);
    }
}
