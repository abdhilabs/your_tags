package com.mriksani.yourtags.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.mriksani.yourtags.R;
import com.mriksani.yourtags.menu.Menu10Activity;
import com.mriksani.yourtags.menu.Menu11Activity;
import com.mriksani.yourtags.menu.Menu12Activity;
import com.mriksani.yourtags.menu.Menu13Activity;
import com.mriksani.yourtags.menu.Menu14Activity;
import com.mriksani.yourtags.menu.Menu15Activity;
import com.mriksani.yourtags.menu.Menu16Activity;
import com.mriksani.yourtags.menu.Menu17Activity;
import com.mriksani.yourtags.menu.Menu18Activity;
import com.mriksani.yourtags.menu.Menu19Activity;
import com.mriksani.yourtags.menu.Menu1Activity;
import com.mriksani.yourtags.menu.Menu20Activity;
import com.mriksani.yourtags.menu.Menu21Activity;
import com.mriksani.yourtags.menu.Menu22Activity;
import com.mriksani.yourtags.menu.Menu23Activity;
import com.mriksani.yourtags.menu.Menu24Activity;
import com.mriksani.yourtags.menu.Menu2Activity;
import com.mriksani.yourtags.menu.Menu3Activity;
import com.mriksani.yourtags.menu.Menu4Activity;
import com.mriksani.yourtags.menu.Menu5Activity;
import com.mriksani.yourtags.menu.Menu6Activity;
import com.mriksani.yourtags.menu.Menu7Activity;
import com.mriksani.yourtags.menu.Menu8Activity;
import com.mriksani.yourtags.menu.Menu9Activity;


/**
 * A simple {@link Fragment} subclass.
 */
public class TagsFragment extends Fragment {
    private RelativeLayout menu1, menu2, menu3, menu4, menu5, menu6, menu7, menu8, menu9, menu10,
            menu11, menu12, menu13, menu14, menu15, menu16, menu17, menu18, menu19, menu20, menu21, menu22, menu23, menu24;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    public TagsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tags, container, false);

        //Ads Banner
        MobileAds.initialize(getActivity(), "ca-app-pub-1828706743315425~7621306082");
        mAdView = (AdView) rootView.findViewById(R.id.adView);
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
        //Ads Intertitial
        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId("ca-app-pub-1828706743315425/1682707406");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });
        menu1 = (RelativeLayout) rootView.findViewById(R.id.menu1);
        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getActivity(), Menu1Activity.class);
                startActivity(pindah);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        menu2 = (RelativeLayout) rootView.findViewById(R.id.menu2);
        menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getActivity(), Menu2Activity.class);
                startActivity(pindah);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        menu3 = (RelativeLayout) rootView.findViewById(R.id.menu3);
        menu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getActivity(), Menu3Activity.class);
                startActivity(pindah);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        menu4 = (RelativeLayout) rootView.findViewById(R.id.menu4);
        menu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getActivity(), Menu4Activity.class);
                startActivity(pindah);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        menu5 = (RelativeLayout) rootView.findViewById(R.id.menu5);
        menu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getActivity(), Menu5Activity.class);
                startActivity(pindah);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        menu6 = (RelativeLayout) rootView.findViewById(R.id.menu6);
        menu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getActivity(), Menu6Activity.class);
                startActivity(pindah);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        menu7 = (RelativeLayout) rootView.findViewById(R.id.menu7);
        menu7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getActivity(), Menu7Activity.class);
                startActivity(pindah);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        menu8 = (RelativeLayout) rootView.findViewById(R.id.menu8);
        menu8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getActivity(), Menu8Activity.class);
                startActivity(pindah);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        menu9 = (RelativeLayout) rootView.findViewById(R.id.menu9);
        menu9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getActivity(), Menu9Activity.class);
                startActivity(pindah);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        menu10 = (RelativeLayout) rootView.findViewById(R.id.menu10);
        menu10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getActivity(), Menu10Activity.class);
                startActivity(pindah);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        menu11 = (RelativeLayout) rootView.findViewById(R.id.menu11);
        menu11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getActivity(), Menu11Activity.class);
                startActivity(pindah);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        menu12 = (RelativeLayout) rootView.findViewById(R.id.menu12);
        menu12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getActivity(), Menu12Activity.class);
                startActivity(pindah);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        menu13 = (RelativeLayout) rootView.findViewById(R.id.menu13);
        menu13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getActivity(), Menu13Activity.class);
                startActivity(pindah);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        menu14 = (RelativeLayout) rootView.findViewById(R.id.menu14);
        menu14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getActivity(), Menu14Activity.class);
                startActivity(pindah);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        menu15 = (RelativeLayout) rootView.findViewById(R.id.menu15);
        menu15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getActivity(), Menu15Activity.class);
                startActivity(pindah);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        menu16 = (RelativeLayout) rootView.findViewById(R.id.menu16);
        menu16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getActivity(), Menu16Activity.class);
                startActivity(pindah);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        menu17 = (RelativeLayout) rootView.findViewById(R.id.menu17);
        menu17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getActivity(), Menu17Activity.class);
                startActivity(pindah);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        menu18 = (RelativeLayout) rootView.findViewById(R.id.menu18);
        menu18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getActivity(), Menu18Activity.class);
                startActivity(pindah);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        menu19 = (RelativeLayout) rootView.findViewById(R.id.menu19);
        menu19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getActivity(), Menu19Activity.class);
                startActivity(pindah);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        menu20 = (RelativeLayout) rootView.findViewById(R.id.menu20);
        menu20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getActivity(), Menu20Activity.class);
                startActivity(pindah);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        menu21 = (RelativeLayout) rootView.findViewById(R.id.menu21);
        menu21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getActivity(), Menu21Activity.class);
                startActivity(pindah);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        menu22 = (RelativeLayout) rootView.findViewById(R.id.menu22);
        menu22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getActivity(), Menu22Activity.class);
                startActivity(pindah);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        menu23 = (RelativeLayout) rootView.findViewById(R.id.menu23);
        menu23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getActivity(), Menu23Activity.class);
                startActivity(pindah);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        menu24 = (RelativeLayout) rootView.findViewById(R.id.menu24);
        menu24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getActivity(), Menu24Activity.class);
                startActivity(pindah);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        return rootView;
    }

}
