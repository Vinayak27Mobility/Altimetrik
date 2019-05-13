package com.altimetrikpg.android.di;


import com.altimetrikpg.android.network.ServiceHelper;
import com.altimetrikpg.android.network.VehicleAPI;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.support.AndroidSupportInjectionModule;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = AndroidSupportInjectionModule.class)
public class
NetworkModule {

    @Provides
    @Singleton
    ServiceHelper provideServiceHelper(VehicleAPI vehicleAPI) {
        return new ServiceHelper(vehicleAPI);
    }

    @Provides
    @Singleton
    VehicleAPI provideVehicleApi() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(logging);
        client.connectTimeout(15, TimeUnit.SECONDS);
        client.readTimeout(15, TimeUnit.SECONDS);
        client.writeTimeout(15, TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.mercedes-benz.com/image_tryout/v1/vehicles/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();

        return retrofit.create(VehicleAPI.class);
    }
}
