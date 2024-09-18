
package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Listadapter extends BaseAdapter {

    private ArrayList<City> cities;
    private LayoutInflater inflater;
    private MainActivity activity;

    public Listadapter(MainActivity activity, ArrayList<City> cities) {
        this.activity = activity;
        this.cities = cities;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return cities.size();
    }

    @Override
    public Object getItem(int position) {
        return cities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        ImageView cityImage = convertView.findViewById(R.id.imageView);
        TextView cityName = convertView.findViewById(R.id.textView1);
        TextView additionalText = convertView.findViewById(R.id.textView2);
        CheckBox checkBox = convertView.findViewById(R.id.checkBox1);

        cityImage.setImageResource(cities.get(position).getImageResource());
        cityName.setText(cities.get(position).getName());
        additionalText.setText(cities.get(position).getAdditionalText()); // Replace with the actual additional text
        checkBox.setTag(position);
        checkBox.setChecked(cities.get(position).isSelected());

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                int taggedPosition = (Integer) cb.getTag();
                City city = cities.get(taggedPosition);
                city.setSelected(cb.isChecked());

                if (cb.isChecked()) {
                    activity.addCity(city.getName());
                } else {
                    activity.removeCity(city.getName());
                }
            }
        });

        return convertView;
    }
}
