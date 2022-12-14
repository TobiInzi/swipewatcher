package com.hackatum.swipewatcher.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.hackatum.swipewatcher.MainActivity;
import com.hackatum.swipewatcher.R;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    private ArrayAdapter adapter;
    private static ArrayList<String> watchlist = new ArrayList<>();
    private MainActivity mainActivity;

    public ListFragment(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ListView list = view.findViewById(R.id.listview);
        adapter = new ArrayAdapter(mainActivity,R.layout.activity_list_view,R.id.textView, watchlist);
        list.setAdapter(adapter);
        return list;
    }

    public ArrayList<String> getWatchlist() {
        return watchlist;
    }

    public static void setWatchlist(ArrayList<String> w) {
        watchlist = w;
    }
}
