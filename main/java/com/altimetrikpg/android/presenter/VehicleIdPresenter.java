package com.altimetrikpg.android.presenter;


import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.altimetrikpg.android.R;
import com.altimetrikpg.android.network.ServiceHelper;
import com.altimetrikpg.android.view.VehicleIdContract;

public class VehicleIdPresenter implements VehicleIdContract.presenter {

    private VehicleIdContract.View view;
    private ServiceHelper serviceHelper;

    public VehicleIdPresenter(VehicleIdContract.View view, ServiceHelper serviceHelper) {
        this.view = view;
        this.serviceHelper = serviceHelper;
    }


    @Override
    public String getVehicleId(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        return sharedPref.getString(context.getString(R.string.preference_file_veh_id), null);
    }

    @Override
    public void saveVehicleID(String vehicleId, Context context) {
        if(TextUtils.isEmpty(vehicleId)) {
            view.setErrorEmpty();
        } else {
            view.removeError();
            SharedPreferences sharedPref = context.getSharedPreferences(
                    context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString(context.getString(R.string.preference_file_veh_id), vehicleId);
            //async call
            editor.apply();
        }
    }

    @Override
    public void showBlankError() {
        view.setErrorEmpty();
    }

    @Override
    public void removeError() {
        view.removeError();
    }
}
