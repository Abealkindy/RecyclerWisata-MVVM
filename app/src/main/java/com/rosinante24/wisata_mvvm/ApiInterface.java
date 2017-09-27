package com.rosinante24.wisata_mvvm;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Rosinante24 on 9/27/17.
 */

public interface ApiInterface {
    @GET("index.php/api/get/filter/dataalam")
    Observable<WisataListDao> getWisata(

            @Query("kategori") int kategori


    );
}
