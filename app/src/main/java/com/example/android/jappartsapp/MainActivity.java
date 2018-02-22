package com.example.android.jappartsapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    String number = "+48 58 302 38 12";
    String url = "http://www.japparts.pl/";
    String email = "hurtownia@japparts.pl";
    String facebook = "https://www.facebook.com/Japparts/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToMap(View View) {
        Uri googleMap = Uri.parse("geo:54.3414023, 18.5515824");
        Intent intent = new Intent(Intent.ACTION_VIEW, googleMap);
        intent.setPackage("com.google.android.apps.maps");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void goToWebsite(View View) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    public void callUs(View view) {

        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", number, null));
        startActivity(intent);
    }

    public void emailUs(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"hurtownia@japparts.pl"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Question");
        intent.putExtra(Intent.EXTRA_TEXT, "Hi, I would like you to ask about");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
