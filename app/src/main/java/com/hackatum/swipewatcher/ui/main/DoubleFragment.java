package com.hackatum.swipewatcher.ui.main;

import android.content.ClipData;
import android.graphics.Movie;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.hackatum.swipewatcher.MainActivity;
import com.hackatum.swipewatcher.R;
import com.hackatum.swipewatcher.ui.main.Backend.MovieObject;
import com.hackatum.swipewatcher.ui.main.Backend.PrioQueue;

import java.util.List;
import java.util.Locale;

public class DoubleFragment extends Fragment {

    private MainActivity mainActivity;

    public DoubleFragment(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }
    private ConstraintLayout f1;
    private ConstraintLayout f2;
    private ConstraintLayout f3;
    private ConstraintLayout f4;
    private ConstraintLayout f5;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_double, container, false);
        f1 = view.findViewById(R.id.first_movie);
        f2 = view.findViewById(R.id.second_movie);
        f3 = view.findViewById(R.id.third_movie);
        f4 = view.findViewById(R.id.fourth_movie);
        f5 = view.findViewById(R.id.fifth_movie);
        List<MovieObject> list = PrioQueue.matchedList;
        f1.setVisibility(View.INVISIBLE);
        f2.setVisibility(View.INVISIBLE);
        f3.setVisibility(View.INVISIBLE);
        f4.setVisibility(View.INVISIBLE);
        f5.setVisibility(View.INVISIBLE);
        if (list.size() > 0) {
            ImageButton f11 = f1.findViewById(R.id.outside_button);
            TextView f111 = f1.findViewById(R.id.movie_name);
            f1.setVisibility(View.VISIBLE);
            MovieObject o = list.get(0);
            f111.setText(o.getTitle().toUpperCase(Locale.ROOT));
        }
        if (list.size() > 1) {
            Log.e("teset", "tsjfs3");
            ImageButton f22 = f2.findViewById(R.id.outside_button);
            TextView f222 = f2.findViewById(R.id.movie_name);
            f2.setVisibility(View.VISIBLE);
            MovieObject o = list.get(1);
            f222.setText(o.getTitle().toUpperCase(Locale.ROOT));
        }
        if (list.size() > 2) {
            Log.e("teset", "tsjfs3");
            ImageButton f33 = f3.findViewById(R.id.outside_button);
            TextView f333 = f3.findViewById(R.id.movie_name);
            f3.setVisibility(View.VISIBLE);
            MovieObject o = list.get(2);
            f333.setText(o.getTitle().toUpperCase(Locale.ROOT));
        }
        if (list.size() > 3) {
            Log.e("teset", "tsjfs4");
            ImageButton f44 = f4.findViewById(R.id.outside_button);
            TextView f444 = f4.findViewById(R.id.movie_name);
            f4.setVisibility(View.VISIBLE);
            MovieObject o = list.get(3);
            f444.setText(o.getTitle().toUpperCase(Locale.ROOT));
        }
        if (list.size() > 4) {
            Log.e("teset", "tsjfs5");
            ImageButton f55 = f5.findViewById(R.id.outside_button);
            TextView f555 = f5.findViewById(R.id.movie_name);
            f5.setVisibility(View.VISIBLE);
            MovieObject o = list.get(4);
            f555.setText(o.getTitle().toUpperCase(Locale.ROOT));
        }

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        List<MovieObject> list = PrioQueue.matchedList;
        f1.setVisibility(View.INVISIBLE);
        f2.setVisibility(View.INVISIBLE);
        f3.setVisibility(View.INVISIBLE);
        f4.setVisibility(View.INVISIBLE);
        f5.setVisibility(View.INVISIBLE);
        if (list.size() > 0) {
            ImageButton f11 = f1.findViewById(R.id.outside_button);
            TextView f111 = f1.findViewById(R.id.movie_name);
            f1.setVisibility(View.VISIBLE);
            MovieObject o = list.get(0);
            f111.setText(o.getTitle().toUpperCase(Locale.ROOT));
        }
        if (list.size() > 1) {
            Log.e("teset", "tsjfs3");
            ImageButton f22 = f2.findViewById(R.id.outside_button);
            TextView f222 = f2.findViewById(R.id.movie_name);
            f2.setVisibility(View.VISIBLE);
            MovieObject o = list.get(1);
            f222.setText(o.getTitle().toUpperCase(Locale.ROOT));
        }
        if (list.size() > 2) {
            Log.e("teset", "tsjfs3");
            ImageButton f33 = f3.findViewById(R.id.outside_button);
            TextView f333 = f3.findViewById(R.id.movie_name);
            f3.setVisibility(View.VISIBLE);
            MovieObject o = list.get(2);
            f333.setText(o.getTitle().toUpperCase(Locale.ROOT));
        }
        if (list.size() > 3) {
            Log.e("teset", "tsjfs4");
            ImageButton f44 = f4.findViewById(R.id.outside_button);
            TextView f444 = f4.findViewById(R.id.movie_name);
            f4.setVisibility(View.VISIBLE);
            MovieObject o = list.get(3);
            f444.setText(o.getTitle().toUpperCase(Locale.ROOT));
        }
        if (list.size() > 4) {
            Log.e("teset", "tsjfs5");
            ImageButton f55 = f5.findViewById(R.id.outside_button);
            TextView f555 = f5.findViewById(R.id.movie_name);
            f5.setVisibility(View.VISIBLE);
            MovieObject o = list.get(4);
            f555.setText(o.getTitle().toUpperCase(Locale.ROOT));
        }
    }
}
