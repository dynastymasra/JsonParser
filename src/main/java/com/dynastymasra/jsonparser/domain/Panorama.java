package com.dynastymasra.jsonparser.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Author   : Dynastymasra
 * Name     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */
public class Panorama {
    @SerializedName("count")
    private Integer count;
    @SerializedName("has_more")
    private Boolean more;
    @SerializedName("map_location")
    private MapLocation mapLocation;
    @SerializedName("photos")
    private List<Photos> photoses;

    public Integer getCount() {
        return count;
    }

    public Boolean getMore() {
        return more;
    }

    public MapLocation getMapLocation() {
        return mapLocation;
    }

    public List<Photos> getPhotoses() {
        return photoses;
    }
}
