package com.altimetrikpg.android.view;


import android.content.Context;

import java.util.List;

public interface VehicleIdContract {
    interface View {
        void navigateToVehicleDetail(String vehicleId);
        void setErrorEmpty();
        void removeError();
    }

    interface presenter {

        String getVehicleId(Context context);

        void saveVehicleID(String vehicleId, Context context);

        void showBlankError();

        void removeError();
    }
}
