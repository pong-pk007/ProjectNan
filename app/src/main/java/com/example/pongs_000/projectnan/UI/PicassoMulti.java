package com.example.pongs_000.projectnan.UI;

import android.content.Context;
import android.widget.ImageView;

import com.example.pongs_000.projectnan.R;
import com.example.pongs_000.projectnan.urlWebServer;
import com.squareup.picasso.Picasso;

/**
 * Created by pongs_000 on 15/4/2560.
 */

public class PicassoMulti {
    private static String Server = new urlWebServer().name();

    public static void downloadImage(Context c, String imageUrl, ImageView imgres){
        if (imageUrl != null && imageUrl.length() > 0){

            Picasso.with(c).load(Server+"Graden/photos/"+imageUrl).placeholder(R.drawable.placeholder_200x200).resize(700, 700).centerCrop().into(imgres);

        }else {
            Picasso.with(c).load(R.drawable.placeholder_200x200).into(imgres);
        }

    }
}
