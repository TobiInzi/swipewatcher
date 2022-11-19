package com.hackatum.swipewatcher.ui.main.Backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MovieObject implements Comparable<MovieObject> {
    private String title;
    private String director;
    private List<String> actorsList;
    private double priority;
    private String genre;

    public MovieObject(String[] movie) {
        this.title = movie[5];
        actorsList = new ArrayList<String>();
        actorsList.add(movie[1]);
        actorsList.add(movie[2]);
        actorsList.add(movie[3]);
        genre = movie[4];
        director = movie[0];
    }

    public ArrayList<String> getActors() {
        return (ArrayList<String>) actorsList;
    }

    public void lowerPrio() {
        priority = priority - 50;
    }

    public void higherPrio() {
        priority = priority + 50;
    }

    public double getPriority() {
        return priority;
    }

    public void setPriority(double val) {
        priority = val;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public int compareTo(MovieObject o) {
        if (o.getPriority() > this.getPriority()) {
            return 1;
        } else if (o.getPriority() < this.getPriority()) {
            return -1;
        }
        return 0;
    }
}
