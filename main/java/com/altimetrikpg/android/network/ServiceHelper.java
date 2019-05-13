package com.altimetrikpg.android.network;


import com.altimetrikpg.android.model.VehicleImageData;


import retrofit2.Call;

public class ServiceHelper {

    private VehicleAPI vehicleAPI;

    public ServiceHelper(VehicleAPI vehicleAPI) {
        this.vehicleAPI = vehicleAPI;
    }

    public Call<VehicleImageData> getVehicleImage(String vehId) {
        return vehicleAPI.getVehicleImage(vehId, "Bearer a1b2c3d4-a1b2-a1b2-a1b2-a1b2c3d4e5f6");
    }
}
