package com.mriksani.yourtags;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.mriksani.yourtags.fragment.AppsFragment;
import com.mriksani.yourtags.fragment.CustomFragment;
import com.mriksani.yourtags.fragment.TagsFragment;

import hotchemi.android.rate.AppRate;

public class MainActivity extends AppCompatActivity {
    private long backPressCount;
    private AdView mAdView;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_tags:
                    TagsFragment tagsFragment = new TagsFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.content, tagsFragment);
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_custom:
                    CustomFragment customFragment = new CustomFragment();
                    FragmentTransaction fragmentCustTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentCustTransaction.replace(R.id.content, customFragment);
                    fragmentCustTransaction.commit();
                    return true;
                case R.id.navigation_apps:
                    AppsFragment appsFragment = new AppsFragment();
                    FragmentTransaction fragmentApTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentApTransaction.replace(R.id.content, appsFragment);
                    fragmentApTransaction.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppRate.with(this)
                .setInstallDays(1)
                .setLaunchTimes(3)
                .setRemindInterval(2)
                .monitor();

        AppRate.showRateDialogIfMeetsConditions(this);
        AppRate.with(this).clearAgreeShowDialog();

        MobileAds.initialize(this, "ca-app-pub-1828706743315425~7621306082");
        mAdView = (AdView) findViewById(R.id.adView);
        mAdView.loadAd(new AdRequest.Builder().build());
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                mAdView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAdFailedToLoad(int error) {
                mAdView.setVisibility(View.GONE);
            }
        });

        TagsFragment tagsFragment = new TagsFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, tagsFragment);
        fragmentTransaction.commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onBackPressed(){
        if (backPressCount+2000 > System.currentTimeMillis()){
            super.onBackPressed();
            return;
        }
        else {
            Toast.makeText(getBaseContext(),"Press Back Again...",Toast.LENGTH_SHORT).show();
        }
        backPressCount = System.currentTimeMillis();
    }
}
