package com.hackatum.swipewatcher.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.hackatum.swipewatcher.MainActivity;
import com.hackatum.swipewatcher.R;

import java.util.PriorityQueue;

/**
 * A placeholder fragment containing a simple view.
 */
public class SwipeFragment extends Fragment {

    private static int oldPosition = 0;
    private static int newPosition;
    private InfiniteAdapter adapter;
    private ViewPager swiper;
    private boolean firstTime = true;
    private MainActivity mainActivity;


    public SwipeFragment(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        swiper = view.findViewById(R.id.watch_swiper);
        adapter = new InfiniteAdapter(mainActivity);
        swiper.setAdapter(adapter);
        swiper.setCurrentItem(500_000_000, false);
        firstTime = false;
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }


    /*public ContentFragment positionChanged(int position) {
        if (position == 0) {
            if (firstTime) {
                currentMain = ContentFragment.getInstance(q.poll());
                currentNext = currentMain;
            } else {
                currentNext = ContentFragment.getInstance(q.poll());
            }
            swiper.setCurrentItem(1, false);
            return currentNext;
        } else if (position == 2) {

            swiper.setCurrentItem(1, false);
        } else {
            currentMain = currentNext;
            return currentMain;
        }
        return null;
    }*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}