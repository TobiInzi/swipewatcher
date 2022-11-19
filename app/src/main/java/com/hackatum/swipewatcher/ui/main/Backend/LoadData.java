package com.hackatum.swipewatcher.ui.main.Backend;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class MovieObject implements Comparable<MovieObject> {
    private  String otitle;
    private String title;
    private String actors;
    private List<String> actorsList;
    private int priority;
    private String id;
    private int serie;

    public MovieObject () {
        this.actorsList = Arrays.stream(actors.split(",")).collect(Collectors.toList());
    }

    public ArrayList<String> getActors() {
        return (ArrayList<String>) actorsList;
    }

    public int getFSK() {
        return 0;
    }

    public void lowerPrio() {
        priority--;
    }

    public void higherPrio() {
        priority++;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int val) {
        priority = val;
    }


    public String getId() {
        return id;
    }

    public String getTitle() {
        return Objects.equals(otitle, "") ? title : otitle;
    }

    public boolean isSeries() {
        return serie == 1;
    }

    @Override
    public int compareTo(MovieObject o) {
        return o.getPriority() - priority;
    }
}

public class LoadData {
    public static List<MovieObject> loadDataFromJson(String file) {

        //String file = "src/main/streampicker/ap.json";

        String json = null;
        try {
            json = new String(Files.readAllBytes(Paths.get(file)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Gson gson = new Gson();
        MovieObject[] watchables0 = gson.fromJson(json, MovieObject[].class);

        List<MovieObject> watchables = new ArrayList<>(Arrays.asList(watchables0));

        watchables=watchables.stream().filter(distinctBy(MovieObject::getTitle)).collect(Collectors.toList());

        return watchables;
    }


    private static <T> Predicate<T> distinctBy(Function<? super T, ?> f) {
        Set<Object> objects = new HashSet<>();
        return t -> objects.add(f.apply(t));
    }


}