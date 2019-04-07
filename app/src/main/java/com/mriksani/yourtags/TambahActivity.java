package com.mriksani.yourtags;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class TambahActivity extends AppCompatActivity {
    private EditText Enama, Edeskripsi;
    private Button btn;
    private DataHelper db;
    private String Snama, Sdeskripsi;
    private static final String TAG = "TambahActivity";
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        //Ads Intertitial
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1828706743315425/1391133176");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });

        //Data Base
        db = new DataHelper(this);

        Enama = (EditText) findViewById(R.id.namaTags);
        Edeskripsi = (EditText) findViewById(R.id.isiTags);

        Button btnCreate = (Button) findViewById(R.id.btnAdd);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snama = String.valueOf(Enama.getText());
                Sdeskripsi = String.valueOf(Edeskripsi.getText());

                if (Snama.equals("")) {
                    Enama.requestFocus();
                    Toast.makeText(TambahActivity.this, "Silahkan isi nama", Toast.LENGTH_SHORT).show();
                }  else if (Sdeskripsi.equals("")) {
                    Edeskripsi.requestFocus();
                    Toast.makeText(TambahActivity.this, "Silahkan isi deskripsi", Toast.LENGTH_SHORT).show();
                } else {
                    Enama.setText("");
                    Edeskripsi.setText("");
                    Toast.makeText(TambahActivity.this, "Tags telah ditambah", Toast.LENGTH_SHORT).show();
                    db.CreateTugas(new Deklarasi(null, Snama, Sdeskripsi));
                    finish();
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    } else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }
                }
            }
        });

        btn = (Button) findViewById(R.id.btnCancel);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
