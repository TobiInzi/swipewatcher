package com.hackatum.swipewatcher.ui.main.Backend;



import android.content.res.AssetManager;

import com.hackatum.swipewatcher.MainActivity;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
public class LoadData
{
    public static ArrayList<MovieObject> getData(MainActivity mainActivity) {
        ArrayList<MovieObject> movies = new ArrayList<>();
        String line = "";
        String splitBy = ",";
        try {
//parsing a CSV file into BufferedReader class constructor
            AssetManager a = mainActivity.getAssets();
            BufferedReader br = new BufferedReader(new InputStreamReader((a.open("final_data.csv"))));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] movie = line.split(splitBy);    // use comma as separator
                movies.add(new MovieObject(movie));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }
    public static ArrayList<MovieObject> getCoupleData(MainActivity mainActivity) {
        ArrayList<MovieObject> movies = new ArrayList<>();
        String line = "";
        String splitBy = ",";
        try {
//parsing a CSV file into BufferedReader class constructor
            AssetManager a = mainActivity.getAssets();
            BufferedReader br = new BufferedReader(new InputStreamReader((a.open("couple_data.csv"))));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] movie = line.split(splitBy);    // use comma as separator
                movies.add(new MovieObject(movie));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;


    }
}