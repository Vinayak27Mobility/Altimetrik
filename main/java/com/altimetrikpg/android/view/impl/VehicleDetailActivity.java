package com.altimetrikpg.android.view.impl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.altimetrikpg.android.APGApplication;
import com.altimetrikpg.android.R;
import com.altimetrikpg.android.di.DaggerVehicleDetailComponent;
import com.altimetrikpg.android.di.VehicleDetailComponent;
import com.altimetrikpg.android.di.VehicleDetailModule;
import com.altimetrikpg.android.model.VehicleImageData;
import com.altimetrikpg.android.view.VehicleDetailContract;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class VehicleDetailActivity extends AppCompatActivity implements VehicleDetailContract.View {


    private VehicleDetailComponent daggerComponent;

    @Inject
    VehicleDetailContract.presenter presenter;

    @BindView(R.id.vehicle_image_ext_iv)
    ImageView vehicleExtImage;

    @BindView(R.id.vehicle_image_int_iv)
    ImageView vehicleIntImage;

    @BindView(R.id.progress_loader)
    ProgressBar progressBar;

    @BindView(R.id.error_text)
    TextView errorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_detail);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();

        setTitle(R.string.vehicle_detail_title);
        setUpDagger();
        if(bundle != null) {
            String retrievedVedId = bundle.getString(getString(R.string.preference_file_veh_id));
            if (retrievedVedId != null) {
                Timber.d("Vehicle id retrieved for detail screen %s ", retrievedVedId);
                presenter.getVehicleImage(retrievedVedId);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onVehicleImageSuccess(VehicleImageData vehicleImageData) {
        Timber.d("vehicle image data " , vehicleImageData);
        Picasso.get()
                .load(vehicleImageData.getVehicle().getEXT020().getUrl())
                .into(vehicleExtImage);

        Picasso.get()
                .load(vehicleImageData.getVehicle().getINT1().getUrl())
                .into(vehicleIntImage);
        errorMessage.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onVehicleImageFail() {
        errorMessage.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onDestroy() {
        daggerComponent = null;
        super.onDestroy();
    }

    private void setUpDagger() {
        daggerComponent = DaggerVehicleDetailComponent.builder()
                .vehicleDetailModule(new VehicleDetailModule(this))
                .applicationComponent(APGApplication.getApplicationComponent())
                .build();

        daggerComponent.inject(this);
    }


}
