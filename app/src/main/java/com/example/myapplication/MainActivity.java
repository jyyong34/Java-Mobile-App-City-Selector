package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button button;
    ArrayList<String> selectedCities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        listView = findViewById(R.id.listView1);
        button = findViewById(R.id.button1);

        ArrayList<City> cities = City.getInitialCities(); // Replace this with your city list

        Listadapter adapter = new Listadapter(this, cities);
        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSelectedCities();
            }
        });
    }

    private void showSelectedCities() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selected Cities");

        String[] selectedArray = new String[selectedCities.size()];
        selectedArray = selectedCities.toArray(selectedArray);

        builder.setItems(selectedArray, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void addCity(String city) {
        selectedCities.add(city);
    }

    public void removeCity(String city) {
        selectedCities.remove(city);
    }
}

