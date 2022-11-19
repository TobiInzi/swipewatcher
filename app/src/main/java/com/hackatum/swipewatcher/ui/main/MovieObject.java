package com.hackatum.swipewatcher.ui.main;

import java.util.PriorityQueue;
import java.util.Random;

public class MovieObject implements Comparable {

    private static PriorityQueue<MovieObject> movies = new PriorityQueue<>();
    private String title;
    private String description;
    private double value;
    private static Random random = new Random();

    public MovieObject(String title, String description, double value) {
        this.title = title;
        this.description = description;
        this.value = value;
    }

    public static MovieObject getNext() {
        return movies.poll();
    }

    public static void createObjects() {
        for (int i = 0; i < 1000; i++) {
            movies.add(new MovieObject(String.valueOf(random.nextInt() % 20), String.valueOf(random.nextInt()), random.nextDouble()));
        }
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getValue() {
        return value;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof MovieObject) {
            return (int) (this.value - ((MovieObject) o).value * 100000);
        }
        return -1;
    }
}
