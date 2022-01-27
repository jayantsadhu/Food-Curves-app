package com.example.foodcurves.loginactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.foodcurves.MainActivity;
import com.example.foodcurves.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class LoginActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    FloatingActionButton fb, google, twitter;
    final int NUM_TABS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        viewPager = findViewById(R.id.login_pager);
        tabLayout = findViewById(R.id.tab_layout);
        fb = findViewById(R.id.fb_button);
        google = findViewById(R.id.google_button);
        twitter = findViewById(R.id.twitter_button);

        tabLayout.addTab(tabLayout.newTab().setText("Login"));
        tabLayout.addTab(tabLayout.newTab().setText("Signup"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        LoginSignupTabAdapter tabAdapter = new LoginSignupTabAdapter(getSupportFragmentManager(), getApplicationContext(), NUM_TABS);

        viewPager.setAdapter(tabAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        fb.setTranslationY(300);
        google.setTranslationY(300);
        twitter.setTranslationY(300);
        tabLayout.setTranslationX(500);

        fb.setAlpha(0.0f);
        google.setAlpha(0.0f);
        twitter.setAlpha(0.0f);
        tabLayout.setAlpha(0.0f);

        fb.animate().translationY(0).alpha(1).setStartDelay(800).setDuration(1000).start();
        google.animate().translationY(0).alpha(1).setStartDelay(600).setDuration(1000).start();
        twitter.animate().translationY(0).alpha(1).setStartDelay(400).setDuration(1000).start();
        tabLayout.animate().translationX(0).alpha(1).setStartDelay(400).setDuration(1000).start();

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

    }


    public void floatingButtonClick(View view){
        int tag = Integer.parseInt(view.getTag().toString());
        String url = "";
        switch (tag){
            case 0:
                url = "https://www.facebook.com";
                break;
            case 1:
                url = "https://www.google.com";
                break;
            case 2:
                url = "https://www.twitter.com";
                break;
            default:
                break;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        if(intent.resolveActivity(getPackageManager())!=null)
            startActivity(intent);
        else
            Toast.makeText(getApplicationContext(), "No suitable application found to handle this request",
                    Toast.LENGTH_SHORT).show();
    }
}