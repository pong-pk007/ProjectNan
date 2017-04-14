package com.example.pongs_000.projectnan.UI;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pongs_000.projectnan.AnimationUtil;
import com.example.pongs_000.projectnan.DataObject.SeriOBJ;
import com.example.pongs_000.projectnan.Detail;
import com.example.pongs_000.projectnan.R;

import java.util.ArrayList;

/**
 * Created by pongs_000 on 28/9/2559.
 */

public class CustomAdapter extends RecyclerView.Adapter<MyViewHoder> {

    Context c;
    ArrayList<SeriOBJ> seriOBJs;
    private int previousPosition = 0;

    public CustomAdapter(Context c, ArrayList<SeriOBJ> seriOBJs){
        this.c = c;
        this.seriOBJs = seriOBJs;
    }

    @Override
    public MyViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.itemseri,parent,false);
        return new MyViewHoder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHoder holder, int position) {

        if(position > previousPosition){ // We are scrolling DOWN

            AnimationUtil.animate(holder, true);

        }else{ // We are scrolling UP

            AnimationUtil.animate(holder, false);

        }
        previousPosition = position;



        final SeriOBJ SR = seriOBJs.get(position);


        holder.tvseriname.setText(SR.getGraden());
        holder.tvseriprice.setText(SR.getPrice()+" "+SR.getPeriod());

        PicassoClient.downloadImage(c,SR.getImage(),holder.img);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick() {
                OpenDetailRestaurantActivity(SR.getSeri_id(),SR.getGraden(),SR.getTime(),SR.getImage(), SR.getImage2(),SR.getImage3(), SR.getImage4(),SR.getImage5(),SR.getDescription(),SR.getLatitude(),SR.getLongitude(),SR.getPrice(),SR.getPeriod(),SR.getTelephone(),SR.getCategory());
            }
        });
    }


    @Override
    public int getItemCount() {
        return seriOBJs.size();
    }


    private void OpenDetailRestaurantActivity(int seri_id, String graden,String time,String image, String image2, String image3, String image4, String image5 ,String description,String latitude,String longitude,String price,String period,String telephone,String category){

        Intent i = new Intent(c, Detail.class);

        i.putExtra("SERI_ID",seri_id);
        i.putExtra("GRADEN_KEY",graden);
        i.putExtra("TIME_KEY",time);
        i.putExtra("DES_KEY",description);
        i.putExtra("LATITUDE_KEY",latitude);
        i.putExtra("LONGITUDE_KEY",longitude);
        i.putExtra("IMAGE_KEY",image);
        i.putExtra("IMAGE1_KEY",image2);
        i.putExtra("IMAGE2_KEY",image3);
        i.putExtra("IMAGE3_KEY",image4);
        i.putExtra("IMAGE4_KEY",image5);
        i.putExtra("PRICE_KEY" ,price);
        i.putExtra("PERIOD_KEY", period);
        i.putExtra("PHONE_KEY",telephone);
        i.putExtra("CATEGORY",category);
        c.startActivity(i);
    }

}
