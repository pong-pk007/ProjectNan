package com.example.pongs_000.projectnan.MySQL;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.example.pongs_000.projectnan.DataObject.SeriOBJ;
import com.example.pongs_000.projectnan.UI.CustomAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by pongs_000 on 28/9/2559.
 */

public class DataParser extends AsyncTask<Void,Void,Boolean> {
        Context c;
    String jsonData;
    RecyclerView rv;
    SwipeRefreshLayout swipeRefreshLayout;

    ArrayList<SeriOBJ> seriOBJs=new ArrayList<>();

    public DataParser(Context c, String jsonData, RecyclerView rv, SwipeRefreshLayout swipeRefreshLayout) {
        this.c = c;
        this.jsonData = jsonData;
        this.rv = rv;
        this.swipeRefreshLayout = swipeRefreshLayout;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        return this.parseData();
    }

    @Override
    protected void onPostExecute(Boolean isParsed) {
        super.onPostExecute(isParsed);

        swipeRefreshLayout.setRefreshing(false);

        if (isParsed){
            //bind
            rv.setAdapter(new CustomAdapter(c,seriOBJs));

        }else {

            Toast.makeText(c,"Unable To Parse", Toast.LENGTH_SHORT).show();
        }
    }

    private Boolean parseData(){

        try{
            JSONArray ja = new JSONArray(jsonData);
            JSONObject jo;

            seriOBJs.clear();
            SeriOBJ SeriOBJs;

            for (int i=0; i<ja.length(); i++){

                jo=ja.getJSONObject(i);

                int seri_id = jo.getInt("seri_id");
                String graden = jo.getString("graden");
                String time = jo.getString("time");
                String image = jo.getString("image1");
                String image1 = jo.getString("image2");
                String image2 = jo.getString("image3");
                String image3 = jo.getString("image4");
                String image4 = jo.getString("image5");
                String description = jo.getString("description");
                String price = jo.getString("price");
                String latitude = jo.getString("latitude");
                String longitude = jo.getString("longitude");
                String period = jo.getString("period");
                String telephone = jo.getString("Telephone");
                String category = jo.getString("category");

                SeriOBJs = new SeriOBJ();

                SeriOBJs.setSeri_id(seri_id);
                SeriOBJs.setGraden(graden);
                SeriOBJs.setTime(time);
                SeriOBJs.setImage(image);
                SeriOBJs.setImage2(image1);
                SeriOBJs.setImage3(image2);
                SeriOBJs.setImage4(image3);
                SeriOBJs.setImage5(image4);
                SeriOBJs.setDescription(description);
                SeriOBJs.setPrice(price);
                SeriOBJs.setLatitude(latitude);
                SeriOBJs.setLongitude(longitude);
                SeriOBJs.setPeriod(period);
                SeriOBJs.setTelephone(telephone);
                SeriOBJs.setCategory(category);

                seriOBJs.add(SeriOBJs);

            }
            return true;

        }catch (JSONException e){
        e.printStackTrace();

        }
        return false;
    }
}
