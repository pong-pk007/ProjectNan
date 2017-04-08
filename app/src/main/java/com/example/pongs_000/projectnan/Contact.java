package com.example.pongs_000.projectnan;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.tel1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phonnum = "0881240377";
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + phonnum));

                if (ActivityCompat.checkSelfPermission(Contact.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                }
                startActivity(callIntent);
            }
        });

        findViewById(R.id.email1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = "aru.napat20@gmail.com";
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + email));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "");
//emailIntent.putExtra(Intent.EXTRA_HTML_TEXT, body); //If you are using HTML in your body text

                startActivity(Intent.createChooser(emailIntent, "Chooser Title"));
            }
        });

        findViewById(R.id.tel2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phonnum = "0998526351";
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + phonnum));

                if (ActivityCompat.checkSelfPermission(Contact.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                }
                startActivity(callIntent);
            }
        });

        findViewById(R.id.email2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = "aru.napat20@gmail.com";
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + email));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "");
//emailIntent.putExtra(Intent.EXTRA_HTML_TEXT, body); //If you are using HTML in your body text

                startActivity(Intent.createChooser(emailIntent, "Chooser Title"));
            }
        });


        //btn zone

        findViewById(R.id.call1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phonnum = "0881240377";
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + phonnum));

                if (ActivityCompat.checkSelfPermission(Contact.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                }
                startActivity(callIntent);
            }
        });

        findViewById(R.id.mail1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = "jintana.chuelong@gmail.com";
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + email));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "");
//emailIntent.putExtra(Intent.EXTRA_HTML_TEXT, body); //If you are using HTML in your body text

                startActivity(Intent.createChooser(emailIntent, "Chooser Title"));
            }
        });

        findViewById(R.id.call2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phonnum = "0998526351";
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + phonnum));

                if (ActivityCompat.checkSelfPermission(Contact.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                }
                startActivity(callIntent);
            }
        });

        findViewById(R.id.mail2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = "jintana.chuelong@gmail.com";
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + email));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "");
//emailIntent.putExtra(Intent.EXTRA_HTML_TEXT, body); //If you are using HTML in your body text

                startActivity(Intent.createChooser(emailIntent, "Chooser Title"));
            }
        });




    }
}
