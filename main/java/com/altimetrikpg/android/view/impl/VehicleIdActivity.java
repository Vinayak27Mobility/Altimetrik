package com.altimetrikpg.android.view.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.altimetrikpg.android.APGApplication;
import com.altimetrikpg.android.R;
import com.altimetrikpg.android.di.DaggerVehicleIdComponent;
import com.altimetrikpg.android.di.VehicleIdComponent;
import com.altimetrikpg.android.di.VehicleIdModule;
import com.altimetrikpg.android.view.VehicleIdContract;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class VehicleIdActivity extends AppCompatActivity implements VehicleIdContract.View {


    private VehicleIdComponent daggerComponent;

    @Inject
    VehicleIdContract.presenter presenter;

    @BindView(R.id.vehicle_id_et)
    EditText vehicleIdET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_id);
        ButterKnife.bind(this);
        vehicleIdET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    String vegId = vehicleIdET.getText().toString().trim();
                    if (TextUtils.isEmpty(vegId)) {
                        presenter.showBlankError();
                    } else {
                        presenter.saveVehicleID(vegId, VehicleIdActivity.this);
                        navigateToVehicleDetail(vegId);
                    }
                    return true;
                }
                return false;
            }
        });
        setTitle(R.string.vehicle_title);
        setUpDagger();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        daggerComponent = null;
        super.onDestroy();
    }

    @Override
    public void navigateToVehicleDetail(String vehicleId) {
        Timber.d("Selected Vehicle : " + vehicleId);
        Intent intent = new Intent(VehicleIdActivity.this, VehicleDetailActivity.class);
        intent.putExtra(getString(R.string.preference_file_veh_id), vehicleId);
        VehicleIdActivity.this.startActivity(intent);
    }

    @Override
    public void setErrorEmpty() {
        vehicleIdET.setError(getString(R.string.data_empty_error));
    }

    @Override
    public void removeError() {
        vehicleIdET.setError(null);
    }

    private void setUpDagger() {
        daggerComponent = DaggerVehicleIdComponent.builder()
                .vehicleIdModule(new VehicleIdModule(this))
                .applicationComponent(APGApplication.getApplicationComponent())
                .build();

        daggerComponent.inject(this);
    }
}
