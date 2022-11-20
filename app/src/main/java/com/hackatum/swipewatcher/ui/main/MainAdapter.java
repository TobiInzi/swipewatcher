package com.hackatum.swipewatcher.ui.main;

import android.view.Choreographer;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.hackatum.swipewatcher.MainActivity;

public class MainAdapter extends FragmentStateAdapter {

    public MainAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        swipe = new SwipeFragment((MainActivity) fragmentActivity);
        comment = new CommentFragment((MainActivity) fragmentActivity);
        settings = new SettingsFragment((MainActivity) fragmentActivity);
        list = new ListFragment((MainActivity) fragmentActivity);
        doubleF = new DoubleFragment((MainActivity) fragmentActivity);
    }

    public MainAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public MainAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    private Fragment swipe;
    private Fragment comment;
    private Fragment settings;
    private Fragment list;
    private Fragment doubleF;

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return swipe;
        }
        if (position == 1) {
            return comment;
        }
        if (position == 2) {
            return doubleF;
        }
        if (position == 3) {
            return list;
        }
        if (position == 4) {
            return settings;
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
