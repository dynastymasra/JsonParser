package com.dynastymasra.jsonparser;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.dynastymasra.jsonparser.domain.Panorama;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        new RequestUrl().execute();
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

    private class RequestUrl extends AsyncTask<Void, Void, Panorama> {
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);

        @Override
        protected Panorama doInBackground(Void... voids) {
            try {
                final String url = "http://www.panoramio.com/map/get_panoramas.php?set=public&from=0&to=20&minx=-180&miny=-90&maxx=180&maxy=90&size=medium&mapfilter=true";
                RestTemplate restTemplate = new RestTemplate();
                GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
                restTemplate.getMessageConverters().add(gsonHttpMessageConverter);

                return restTemplate.getForObject(url, Panorama.class);
            } catch (Exception ex) {
                Log.e("MainActivity", ex.getMessage());
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Panorama panorama) {
            super.onPostExecute(panorama);
            TextView textView = (TextView) findViewById(R.id.test);
            TextView more = (TextView) findViewById(R.id.more);
            TextView lat = (TextView) findViewById(R.id.lat);
            TextView longt = (TextView) findViewById(R.id.longt);
            TextView zoom = (TextView) findViewById(R.id.zoom);

            textView.setText("Count \t\t\t: " + panorama.getCount());
            more.setText("More \t\t\t\t:" + panorama.getMore());
            lat.setText("Latitude \t\t\t:" + panorama.getMapLocation().getLat());
            longt.setText("Longtitude \t\t:" + panorama.getMapLocation().getLon());
            zoom.setText("Zoom \t\t\t\t:" +panorama.getMapLocation().getZoom());
            progressDialog.dismiss();
        }
    }
}
