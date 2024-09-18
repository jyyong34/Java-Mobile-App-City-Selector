package com.example.myapplication;

import java.util.ArrayList;

public class City {
    private String name;
    private boolean selected;
    private int imageResource;
    private String additionalText;

    public City(String name, int imageResource, String additionalText) {
        this.name = name;
        this.imageResource = imageResource;
        this.additionalText = additionalText;
        selected = false;
    }

    public String getName() {
        return name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getAdditionalText() {
        return additionalText;
    }

    public static ArrayList<City> getInitialCities() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(new City("Athens", R.drawable.acropolis_image, "Greece"));
        cities.add(new City("Dubai", R.drawable.dubai_image, "Emirate of Dubai"));
        cities.add(new City("Amsterdam", R.drawable.armsterdan_image, "Netherlands"));
        cities.add(new City("London", R.drawable.london_image, "England"));
        cities.add(new City("Tokyo", R.drawable.tokyo_image, "Japan"));
        cities.add(new City("Giza", R.drawable.giza_image, "Egypt"));
        cities.add(new City("Paris", R.drawable.paris_image, "France"));

        return cities;
    }
}
