package com.mriksani.yourtags.Menu;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.mriksani.yourtags.R;

public class Menu10Activity extends AppCompatActivity {
    private TextView copy1, copy2, copy3, copy4, copy5, copy6, copy7, copy8, copy9;
    private Button btnCopy1, btnCopy2, btnCopy3, btnCopy4, btnCopy5, btnCopy6, btnCopy7, btnCopy8, btnCopy9;
    private ImageButton btnImg;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu10);

        //Ads Intertitial
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1828706743315425/7729310815");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });

        copy1 = (TextView) findViewById(R.id.copy1);
        btnCopy1 = (Button) findViewById(R.id.btnCopy1);
        btnCopy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", copy1.getText().toString());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(Menu10Activity.this, "Copied", Toast.LENGTH_SHORT).show();
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        copy2 = (TextView) findViewById(R.id.copy2);
        btnCopy2 = (Button) findViewById(R.id.btnCopy2);
        btnCopy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", copy2.getText().toString());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(Menu10Activity.this, "Copied", Toast.LENGTH_SHORT).show();
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        copy3 = (TextView) findViewById(R.id.copy3);
        btnCopy3 = (Button) findViewById(R.id.btnCopy3);
        btnCopy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", copy3.getText().toString());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(Menu10Activity.this, "Copied", Toast.LENGTH_SHORT).show();
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        copy4 = (TextView) findViewById(R.id.copy4);
        btnCopy4 = (Button) findViewById(R.id.btnCopy4);
        btnCopy4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", copy4.getText().toString());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(Menu10Activity.this, "Copied", Toast.LENGTH_SHORT).show();
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        copy5 = (TextView) findViewById(R.id.copy5);
        btnCopy5 = (Button) findViewById(R.id.btnCopy5);
        btnCopy5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", copy5.getText().toString());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(Menu10Activity.this, "Copied", Toast.LENGTH_SHORT).show();
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        copy6 = (TextView) findViewById(R.id.copy6);
        btnCopy6 = (Button) findViewById(R.id.btnCopy6);
        btnCopy6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", copy6.getText().toString());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(Menu10Activity.this, "Copied", Toast.LENGTH_SHORT).show();
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        copy7 = (TextView) findViewById(R.id.copy7);
        btnCopy7 = (Button) findViewById(R.id.btnCopy7);
        btnCopy7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", copy7.getText().toString());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(Menu10Activity.this, "Copied", Toast.LENGTH_SHORT).show();
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        copy8 = (TextView) findViewById(R.id.copy8);
        btnCopy8 = (Button) findViewById(R.id.btnCopy8);
        btnCopy8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", copy8.getText().toString());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(Menu10Activity.this, "Copied", Toast.LENGTH_SHORT).show();
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        copy9 = (TextView) findViewById(R.id.copy9);
        btnCopy9 = (Button) findViewById(R.id.btnCopy9);
        btnCopy9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", copy9.getText().toString());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(Menu10Activity.this, "Copied", Toast.LENGTH_SHORT).show();
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });
        btnImg = (ImageButton) findViewById(R.id.imageButton);
        btnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
