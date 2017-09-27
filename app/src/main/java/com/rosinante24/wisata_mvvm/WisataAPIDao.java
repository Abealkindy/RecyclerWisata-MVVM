package com.rosinante24.wisata_mvvm;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rosinante24 on 9/26/17.
 */

public class WisataAPIDao {

    @SerializedName("id_data")
    private Integer id_data;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String desc;
    @SerializedName("url_image")
    private String url_image;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("rate")
    private Float rate;

    public Integer getId_data() {
        return id_data;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getUrl_image() {
        return url_image;
    }

    public String getCreated_at() {
        return created_at;
    }

    public Float getRate() {
        return rate;
    }
}
