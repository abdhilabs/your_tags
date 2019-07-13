package com.mriksani.yourtags.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mriksani.yourtags.model.Deklarasi;
import com.mriksani.yourtags.R;

import java.util.List;

public class CostumListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Deklarasi> movieItems;

    public CostumListAdapter(Activity activity, List<Deklarasi> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }

    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.costum_list, null);

        TextView nama = (TextView) convertView.findViewById(R.id.txt_nama);
        TextView namadeskripsi = (TextView) convertView.findViewById(R.id.txt_deskripsi);

        Deklarasi m = movieItems.get(position);

        nama.setText(m.get_nama());
        namadeskripsi.setText(m.get_deskripsi());

        return convertView;
    }
}
