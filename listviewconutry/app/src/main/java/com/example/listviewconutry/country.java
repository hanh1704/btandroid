package com.example.listviewconutry;

import androidx.annotation.NonNull;

public class country {
    private String CountryName;
    //ten file(khong chu duoi)
    private String FlagName;
    private int population;

    public country(String countryName, String flagName, int population) {
        CountryName = countryName;
        FlagName = flagName;
        this.population = population;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public String getFlagName() {
        return FlagName;
    }

    public void setFlagName(String flagName) {
        FlagName = flagName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @NonNull
    @Override
    public String toString() {
        return CountryName+population;
    }
}
