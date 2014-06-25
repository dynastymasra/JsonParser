package com.dynastymasra.jsonparser.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Author   : Dynastymasra
 * Name     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */
public class MapLocation {
    @SerializedName("lat")
    private String lat;
    @SerializedName("lon")
    private String lon;
    @SerializedName("panoramio_zoom")
    private Integer zoom;

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public Integer getZoom() {
        return zoom;
    }
}
