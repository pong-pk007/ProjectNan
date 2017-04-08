package com.example.pongs_000.projectnan.UI;

import android.content.Context;
import android.widget.ImageView;

import com.example.pongs_000.projectnan.R;
import com.example.pongs_000.projectnan.urlWebServer;
import com.squareup.picasso.Picasso;


/**
 * Created by pongs_000 on 28/9/2559.
 */

public class PicassoClient {
    private static String Server = new urlWebServer().name();

    public static void downloadImage(Context c, String imageUrl, ImageView imgres){
        if (imageUrl != null && imageUrl.length() > 0){

        Picasso.with(c).load(Server+"Graden/photos/"+imageUrl).placeholder(R.drawable.placeholder_200x200).resize(400, 180).centerCrop().into(imgres);

        }else {
        Picasso.with(c).load(R.drawable.placeholder_200x200).into(imgres);
        }

    }
}

