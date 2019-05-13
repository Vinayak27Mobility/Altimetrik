package com.altimetrikpg.android.network;



import com.altimetrikpg.android.model.VehicleImageData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface VehicleAPI {

    @GET("{vehicleID}/vehicle?perspectives=EXT020%2CINT1&roofOpen=false&night=false&apikey=Tyt82ndiKG0AdH8TCqe001ROh7RsGOKB")
    Call<VehicleImageData> getVehicleImage(@Path("vehicleID") String vehId, @Header("Authorization") String Auth);

}
