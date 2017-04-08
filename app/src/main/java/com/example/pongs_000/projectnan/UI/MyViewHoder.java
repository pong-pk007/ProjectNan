package com.example.pongs_000.projectnan.UI;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pongs_000.projectnan.R;


/**
 * Created by pongs_000 on 28/9/2559.
 */

public class MyViewHoder extends RecyclerView.ViewHolder implements  View.OnClickListener {


    TextView tvseriname;
    TextView tvseriprice;
    ImageView img;
    ItemClickListener itemClickListener;




    public MyViewHoder(View itemView) {
        super(itemView);

        tvseriname = (TextView) itemView.findViewById(R.id.tvgraden);
        tvseriprice = (TextView) itemView.findViewById(R.id.tvprice);
        img = (ImageView) itemView.findViewById(R.id.imgseri);

        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        this.itemClickListener.onItemClick();
    }


    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener=itemClickListener;

    }
}
