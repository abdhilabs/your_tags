package com.mriksani.yourtags.fragment;


import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.mriksani.yourtags.R;

import static android.content.Context.CLIPBOARD_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class AppsFragment extends Fragment implements View.OnClickListener {
    private RelativeLayout btnIg, btnWa, btnTwitter;
    private Button btnSave, btnCopy, btnClear;
    private EditText Estatus;
    private String st;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
//    private static final String EDIT_STATUS = "edit_status";

    public AppsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_apps, container, false);

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
        mInterstitialAd.setAdUnitId("ca-app-pub-1828706743315425/7948609146");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });

        btnIg = rootView.findViewById(R.id.insta);
        btnIg.setOnClickListener(this);

        btnWa = rootView.findViewById(R.id.wa);
        btnWa.setOnClickListener(this);

        btnTwitter = rootView.findViewById(R.id.twitter);
        btnTwitter.setOnClickListener(this);

        Estatus = (EditText) rootView.findViewById(R.id.Estatus);
        //Save to Preference
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getActivity());
        final String st1 = pref.getString("st", " ");
        Estatus.setText(st1);

        btnSave = (Button) rootView.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                st = Estatus.getText().toString();

                //Save
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("st", st);
                editor.apply();

                Toast.makeText(getActivity(), "Status Di Simpan", Toast.LENGTH_SHORT).show();
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        Estatus = (EditText) rootView.findViewById(R.id.Estatus);
        btnCopy = (Button) rootView.findViewById(R.id.btnCopy);
        btnCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getActivity().getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", Estatus.getText().toString());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(getActivity(), "Copied", Toast.LENGTH_SHORT).show();
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        btnClear = (Button) rootView.findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Estatus.getText().clear();
                //Save
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("st", st);
                editor.apply();
            }
        });
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insta:
                Intent launchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.instagram.android");
                if (launchIntent != null) {
                    try {
                        startActivity(launchIntent);
                    } catch (ActivityNotFoundException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    Toast.makeText(getActivity(), "Aplikasi Instagram belum terpasang", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.wa:
                Intent go = getActivity().getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                if (go != null) {
                    try {
                        startActivity(go);
                    } catch (ActivityNotFoundException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    Toast.makeText(getActivity(), "Aplikasi Whatsapp belum terpasang", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.twitter:
                Intent pindah = getActivity().getPackageManager().getLaunchIntentForPackage("com.twitter.android");
                if (pindah != null) {
                    try {
                        startActivity(pindah);
                    } catch (ActivityNotFoundException ex) // in case Twitter not installed in your device
                    {
                        ex.printStackTrace();
                    }
                } else {
                    Toast.makeText(getActivity(), "Aplikasi Twitter belum terpasang", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
