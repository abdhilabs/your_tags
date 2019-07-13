package com.mriksani.yourtags.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.mriksani.yourtags.R;
import com.mriksani.yourtags.database.DataHelper;
import com.mriksani.yourtags.model.Deklarasi;

public class EditActivity extends AppCompatActivity {
    private DataHelper db;
    private String Sid, Snama, Sdeskripsi;
    private EditText Enama, Edeskripsi, cpy;
    private Button btnDel, btnCpy, btnCncl;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

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

        //Database
        db = new DataHelper(this);

        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Sdeskripsi = i.getStringExtra("Ideskripsi");

        Enama = (EditText) findViewById(R.id.namaTags);
        Edeskripsi = (EditText) findViewById(R.id.isiTags);


        Enama.setText(Snama);
        Edeskripsi.setText(Sdeskripsi);

        Button btnUpdate = (Button) findViewById(R.id.btnSimpan);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sdeskripsi = String.valueOf(Edeskripsi.getText());
                if (Snama.equals("")) {
                    Enama.requestFocus();
                    Toast.makeText(EditActivity.this, "Silahkan isi nama", Toast.LENGTH_SHORT).show();
                } else if (Sdeskripsi.equals("")) {
                    Edeskripsi.requestFocus();
                    Toast.makeText(EditActivity.this, "Silahkan isi deskripsi", Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateTugas(new Deklarasi(Sid, Snama, Sdeskripsi));
                    Toast.makeText(EditActivity.this, "Data telah di edit", Toast.LENGTH_SHORT).show();
                    finish();
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    } else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }
                }
            }
        });

        cpy = (EditText) findViewById(R.id.isiTags);
        btnCpy = (Button) findViewById(R.id.btnCopy);
        btnCpy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Edit Text", cpy.getText().toString());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(EditActivity.this, "Copied", Toast.LENGTH_SHORT).show();
                finish();
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });


        btnDel = (Button) findViewById(R.id.btnHapus);
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(EditActivity.this);
                builder.setMessage("Yakin ingin menghapusnya?");
                builder.setCancelable(true);
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        db.DeleteTugas(new Deklarasi(Sid, Snama, Sdeskripsi));
                        Toast.makeText(EditActivity.this, "Data telah di hapus", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        btnCncl = (Button) findViewById(R.id.btnBatal);
        btnCncl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

