package com.example.pongs_000.projectnan;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pongs_000.projectnan.UI.PicassoClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

public class Detail extends FragmentActivity implements OnMapReadyCallback, GoogleMap.InfoWindowAdapter, GoogleMap.OnInfoWindowClickListener {

    TextView tvgraden,tvtime,tvdes,tvlatlong,tvSRprice,tvphone,tvcategory;
    ImageView ivseri;
//    ImageButton googleBTN;
    private int seri_id;
//    ListView listView;
    ArrayList<HashMap<String, String>> MyArrList;
    ProgressDialog progress;



    private GoogleMap mMap;
    private UiSettings mUiSettings;
    private Marker marker;
    private String graden,time,image,description,latitude,longitude,price,period,telephone,category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(this);



//        listView =  (ListView) findViewById(R.id.nearby);

        final Intent i = this.getIntent();

        seri_id = i.getExtras().getInt("SERI_ID");

        graden = i.getExtras().getString("GRADEN_KEY");
        time = i.getExtras().getString("TIME_KEY");
        image = i.getExtras().getString("IMAGE_KEY");
        description = i.getExtras().getString("DES_KEY");
        latitude = i.getExtras().getString("LATITUDE_KEY");
        longitude = i.getExtras().getString("LONGITUDE_KEY");
        price = i.getExtras().getString("PRICE_KEY");
        period = i.getExtras().getString("PERIOD_KEY");
        telephone = i.getExtras().getString("PHONE_KEY");
        category = i.getExtras().getString("CATEGORY");

        tvgraden = (TextView) findViewById(R.id.tvseriname);
        tvtime = (TextView) findViewById(R.id.tvtime);
        tvdes = (TextView) findViewById(R.id.tvdescrip);
//        tvlatlong = (TextView) findViewById(R.id.tvlatlongt);
        tvSRprice = (TextView) findViewById(R.id.tvprice);
        ivseri = (ImageView) findViewById(R.id.imgseridetail);
//        googleBTN = (ImageButton) findViewById(R.id.googleMap);
        tvphone = (TextView) findViewById(R.id.tvphone);
        tvcategory = (TextView) findViewById(R.id.tvcategory);

//        RequestParams params = new RequestParams();
//        params.put("seri_id",seri_id);
//        AsyncHttpClient client = new AsyncHttpClient();
//        client.post("http://it56.itsisaket.com/Graden/GET_JSON/get_nearby.php" ,params , new AsyncHttpResponseHandler() {
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//                String result = null;
//                try {
//                    MyArrList = new ArrayList<HashMap<String, String>>();
//                    HashMap<String, String> map;
//                    result = new String(responseBody,"UTF-8");
//                    if (result.equals("0")){
//
//                        Log.d("Check", "ไม่มีข้อมูล");
//                        Toast.makeText(Detail.this, "ไม่มีข้อมูล" , Toast.LENGTH_SHORT).show();
//                    }else {
//                        JSONArray readerArray = new JSONArray(result);
//
//                        for (int i = 0; i < readerArray.length();i++){
//                            JSONObject obj = readerArray.getJSONObject(i);
//                            map = new HashMap<String, String>();
//                            map.put("name",obj.getString("name"));
//                            map.put("length", obj.getString("length"));
//                            MyArrList.add(map);
//
//                        }
//                    }
//                    progress.dismiss();
//                    SimpleAdapter adapter;
//                    adapter = new SimpleAdapter(Detail.this, MyArrList, R.layout.itemnearby,
//                            new String[] {"name", "length"}, new int[] {R.id.nearbytv, R.id.nearbyLength});
//                    listView.setAdapter(adapter);
//
//
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onStart() {
//                super.onStart();
//                progress = ProgressDialog.show(Detail.this,"กำลังประมวลผล","รอสักครู่...กำลังโหลดข้อมูล", true);
//            }
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//
//            }
//        });

        tvgraden.setText(graden);
        tvtime.setText(time);
        tvdes.setText(description);
//        tvlatlong.setText("ตำแหน่ง : "+latitude+", "+longitude);
        tvSRprice.setText("ราคาต่อวัน "+ price + period);
        tvphone.setText(telephone);
        tvcategory.setText(category);
        PicassoClient.downloadImage(this,image,ivseri);

//        googleBTN.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String strUri = "http://maps.google.com/maps?q=loc:" + latitude + "," + longitude + " (" + graden + ")";
//                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
//                intent.putExtra("latitude",latitude);
//                intent.putExtra("longitude",longitude);
//                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
//                startActivity(intent);
//            }
//        });

    }


    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }

    @Override
    public void onInfoWindowClick(Marker marker) {

//        Toast.makeText(this,"TestMap", Toast.LENGTH_SHORT).show();

        String strUri = "http://maps.google.com/maps?q=loc:" + latitude + "," + longitude + " (" + graden + ")";
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
        intent.putExtra("latitude",latitude);
        intent.putExtra("longitude",longitude);
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(intent);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        mUiSettings = mMap.getUiSettings();
        LatLng latLng = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));
        marker = mMap.addMarker(new MarkerOptions().position(latLng).title(graden));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
        marker.showInfoWindow();
        mMap.setOnInfoWindowClickListener(this);

    }


//    private class getNearby extends AsyncTask<String, Void, Void>{
//
//
//        private ProgressDialog pd;
//        ArrayList<HashMap<String, String>> myList = new ArrayList<HashMap<String, String>>();
//        boolean con = false;
//
//        @Override
//        protected void onPreExecute() {
//            pd = new ProgressDialog(Detail.this);
//            pd.setTitle("กำลังทำงาน");
//            pd.setMessage("โหลดข้อมูล...");
//            pd.show();
//        }
//
//        @Override
//        protected Void doInBackground(String... params) {
//            String jString;
//            HashMap<String, String> map ;
//            String url = "";
//            try{
//
//                JSONArray data = new JSONArray(getHttpGet(url));
//
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//
//            return null;
//        }
//    }
//
//
//
//    public static String getHttpGet(String url) {
//        StringBuilder str = new StringBuilder();
//        HttpClient client = new DefaultHttpClient();
//        HttpGet httpGet = new HttpGet(url);
//        try {
//            HttpResponse response = client.execute(httpGet);
//            StatusLine statusLine = response.getStatusLine();
//            int statusCode = statusLine.getStatusCode();
//            if (statusCode == 200) { // Download OK
//                HttpEntity entity = response.getEntity();
//                InputStream content = entity.getContent();
//                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    str.append(line);
//                }
//            } else {
//                Log.e("Log", "Failed to download result..");
//            }
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return str.toString();
//    }
//
//
//
//
//    private String getJsonFromUrl(String strUrl) throws IOException {
//
//        URL url = new URL(strUrl);
//        try {
//            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
//            httpCon.setRequestMethod("GET");
//            httpCon.setConnectTimeout(6*1000);
//            httpCon.connect();
//
//            int responseCode = httpCon.getResponseCode();
//            //Log.d(TAG, "The response is: " + responseCode);
//
//            if (responseCode == HttpURLConnection.HTTP_OK){
//                //Log.d(TAG, " size: " + httpCon.getContentLength());
//
//                InputStream ins = httpCon.getInputStream();
//                BufferedReader rd = new BufferedReader(
//                        new InputStreamReader(ins,"UTF-8"));
//                String line;
//                StringBuilder response = new StringBuilder();
//                while ((line = rd.readLine()) != null) {
//                    response.append(line);
//                    response.append("\n");
//                    //Log.d(TAG, line);
//                }
//                rd.close();
//                return response.toString();
//            }
//
//        } catch (Exception ex) {
//            //Log.d(TAG, "Problem reading " +  ex.getLocalizedMessage());
//            //ex.printStackTrace();
//        }
//        return null;
//    }


}
