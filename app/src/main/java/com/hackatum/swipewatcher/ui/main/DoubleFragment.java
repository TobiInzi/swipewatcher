package com.hackatum.swipewatcher.ui.main;

import android.content.ClipData;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.hackatum.swipewatcher.MainActivity;
import com.hackatum.swipewatcher.R;
import com.hackatum.swipewatcher.ui.main.Backend.MovieObject;
import com.hackatum.swipewatcher.ui.main.Backend.PrioQueue;

public class DoubleFragment extends Fragment {

    private MainActivity mainActivity;

    public DoubleFragment(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_double, container, false);
        ListView list = view.findViewById(R.id.movie_list);
        list.setAdapter(new MovieListAdapter());
        return view;
    }

    private class MovieListAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return PrioQueue.matchedList.size();
        }

        @Override
        public MovieObject getItem(int i) {
            return PrioQueue.matchedList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return (long) PrioQueue.matchedList.get(i).getPriority();
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View v = view;

            if (v == null) {
                LayoutInflater vi;
                vi = LayoutInflater.from(mainActivity);
                v = vi.inflate(R.layout.movie_entry, null);
            }

            MovieObject p = getItem(i);

            if (p != null) {
                TextView tt1 = v.findViewById(R.id.movie_name);

                if (tt1 != null) {
                    tt1.setText(p.getTitle());
                }
            }

            return v;
        }
    }
}
