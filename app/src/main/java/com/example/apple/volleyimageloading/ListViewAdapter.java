package com.example.apple.volleyimageloading;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Hero> {
    private List<Hero> heroList;
    private Context mCtx;

    public ListViewAdapter(List<Hero> heroList, Context mCtx) {
        super(mCtx, R.layout.list_items, heroList);
        this.heroList = heroList;
        this.mCtx = mCtx;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        @SuppressLint("ViewHolder")
        View listViewItem = LayoutInflater.from(mCtx).inflate(R.layout.list_items, null, true);
        TextView textViewName = listViewItem.findViewById(R.id.textViewName);
        TextView textViewUrl = listViewItem.findViewById(R.id.textViewUrl);
        NetworkImageView textViewImageUrl = listViewItem.findViewById(R.id.textViewImageUrl);
        Hero hero = heroList.get(position);
        textViewName.setText(hero.getName());
        textViewUrl.setText(hero.getImageUrl());
        textViewImageUrl.setImageUrl(hero.getImageUrl(), CustomVolleyRequest.getInstance(mCtx).getImageLoader());
        return listViewItem;
    }
}
