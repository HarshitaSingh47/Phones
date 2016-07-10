package com.example.mahe.phones;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomAdapter extends ArrayAdapter<String> {

    CustomAdapter(Context context, String[] foods) {
        super(context, R.layout.custom_row ,foods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater buckysInflater = LayoutInflater.from(getContext());
        View customView = buckysInflater.inflate(R.layout.custom_row, parent, false);

        String singleFoodItem = getItem(position);
        TextView buckysText = (TextView) customView.findViewById(R.id.tv5);
        ImageView i1 = (ImageView) customView.findViewById(R.id.img);

        buckysText.setText(singleFoodItem);
       i1.setImageResource(R.drawable.i1);
        return customView;
    }
}
