package com.rosinante24.wisata_mvvm;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rosinante24 on 9/27/17.
 */

public class BaseAPIDao {
    @SerializedName("data")
    private List<WisataAPIDao> datawisata;

    public List<WisataAPIDao> getDatawisata() {
        return datawisata;
    }
}
