package com.mriksani.yourtags.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.mriksani.yourtags.database.DataHelper;
import com.mriksani.yourtags.model.Deklarasi;
import com.mriksani.yourtags.ui.EditActivity;
import com.mriksani.yourtags.R;
import com.mriksani.yourtags.ui.TambahActivity;
import com.mriksani.yourtags.adapter.CostumListAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CustomFragment extends Fragment implements AdapterView.OnItemClickListener {
    private Button btn;
    private static final String TAG = "CustomFragment";
    private ListView mListView;
    private DataHelper db;
    private CostumListAdapter adapter_off;
    private List<Deklarasi> ListTags = new ArrayList<Deklarasi>();
    private AdView mAdView;

    public CustomFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_custom, container, false);
        MobileAds.initialize(getActivity(), "ca-app-pub-1828706743315425~7621306082");
        mAdView =(AdView) rootView.findViewById(R.id.adView);
        mAdView.loadAd(new AdRequest.Builder().build());
        mAdView.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() { mAdView.setVisibility(View.VISIBLE);}

            @Override
            public void onAdFailedToLoad(int error) { mAdView.setVisibility(View.GONE);}
        });

        btn = (Button) rootView.findViewById(R.id.btn_add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getActivity(), TambahActivity.class);
                startActivity(pindah);
            }
        });


        db = new DataHelper(getActivity());

        adapter_off = new CostumListAdapter(getActivity(), ListTags);
        mListView = (ListView) rootView.findViewById(R.id.list_tagsCustom);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListTags.clear();

        List<Deklarasi> contacts = db.ReadTugas();
        for (Deklarasi cn : contacts) {
            Deklarasi judulModel = new Deklarasi();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_deskripsi(cn.get_deskripsi());
            ListTags.add(judulModel);

            if ((ListTags.isEmpty()))
                Toast.makeText(getActivity(), "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Deklarasi obj_itemDetails = (Deklarasi) o;

        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_nama();
        String Sdeskripsi = obj_itemDetails.get_deskripsi();

        Intent goUpdel = new Intent(getActivity(), EditActivity.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Ideskripsi", Sdeskripsi);
        startActivity(goUpdel);
    }

    @Override
    public void onResume() {
        super.onResume();
        ListTags.clear();
        mListView.setAdapter(adapter_off);

        List<Deklarasi> contacts = db.ReadTugas();
        for (Deklarasi cn : contacts) {
            Deklarasi judulModel = new Deklarasi();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_deskripsi(cn.get_deskripsi());
            ListTags.add(judulModel);

            if ((ListTags.isEmpty()))
                Toast.makeText(getActivity(), "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}