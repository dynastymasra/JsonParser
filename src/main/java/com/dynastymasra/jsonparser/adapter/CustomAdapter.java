package com.dynastymasra.jsonparser.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.dynastymasra.jsonparser.R;
import com.dynastymasra.jsonparser.domain.Panorama;

/**
 * Author   : Dynastymasra
 * Name     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */
public class CustomAdapter extends BaseAdapter {
    private Context context;
    private Panorama panorama;

    public CustomAdapter(Context context, Panorama panorama) {
        this.context = context;
        this.panorama = panorama;
    }

    @Override
    public int getCount() {
        return panorama.getPhotoses().size();
    }

    @Override
    public Object getItem(int i) {
        return panorama.getPhotoses().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.custom_list, viewGroup, false);
        }

        TextView photoId = (TextView) view.findViewById(R.id.photo_id);
        TextView ownerName = (TextView) view.findViewById(R.id.owner_name);
        TextView height = (TextView) view.findViewById(R.id.height);
        TextView width = (TextView) view.findViewById(R.id.width);
        TextView latitude = (TextView) view.findViewById(R.id.latitude);
        TextView longtitude = (TextView) view.findViewById(R.id.longtitude);

        photoId.setText("" + panorama.getPhotoses().get(i).getTitle());
        ownerName.setText("" + panorama.getPhotoses().get(i).getName());
        height.setText("" + panorama.getPhotoses().get(i).getHeight());
        width.setText("" + panorama.getPhotoses().get(i).getWidth());
        latitude.setText("" + panorama.getPhotoses().get(i).getLatitude());
        longtitude.setText("" + panorama.getPhotoses().get(i).getLongtitude());

        return view;
    }
}
