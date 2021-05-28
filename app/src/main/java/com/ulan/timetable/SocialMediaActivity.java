package com.ulan.timetable;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SocialMediaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.social_media);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void Facebook(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/RMITuniversity/"));
        startActivity(browserIntent);
    }

    public void Google(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=RMIT+University"));
        startActivity(browserIntent);
    }

    public void Twitter(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/RMIT"));
        startActivity(browserIntent);
    }

    public void LinkedIn(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://au.linkedin.com/school/rmit-university/"));
        startActivity(browserIntent);
    }
}