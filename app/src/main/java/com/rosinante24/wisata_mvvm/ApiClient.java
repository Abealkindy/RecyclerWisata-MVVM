package com.rosinante24.wisata_mvvm;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rosinante24 on 9/26/17.
 */

public class ApiClient {
    public static final String BASE_URL = "http://entry.sandbox.gits.id/api/alamku/";
    private ApiInterface apiInterface;
    private static ApiClient apiClient;

    public ApiClient(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
    }
    public static ApiClient getInstance() {
        if (apiClient == null) {
            apiClient = new ApiClient();
        }

        return apiClient;
    }

    public ApiInterface getEndpoint() {
        return apiInterface;
    }

}
