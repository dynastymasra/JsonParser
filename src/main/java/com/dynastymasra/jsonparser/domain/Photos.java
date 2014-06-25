package com.dynastymasra.jsonparser.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Author   : Dynastymasra
 * Name     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */
public class Photos {
    @SerializedName("height")
    private Integer height;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("longitude")
    private String longtitude;
    @SerializedName("owner_id")
    private Integer id;
    @SerializedName("owner_name")
    private String name;
    @SerializedName("owner_url")
    private String url;
    @SerializedName("photo_file_url")
    private String photoFileUrl;
    @SerializedName("photo_id")
    private Integer photoId;
    @SerializedName("photo_title")
    private String title;
    @SerializedName("photo_url")
    private String photoUrl;
    @SerializedName("upload_date")
    private String date;
    @SerializedName("width")
    private Integer width;

    public Integer getHeight() {
        return height;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getPhotoFileUrl() {
        return photoFileUrl;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public String getTitle() {
        return title;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getDate() {
        return date;
    }

    public Integer getWidth() {
        return width;
    }
}
