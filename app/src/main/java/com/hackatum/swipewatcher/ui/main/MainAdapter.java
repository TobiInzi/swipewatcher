package com.hackatum.swipewatcher.ui.main;

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
    }

    public MainAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public MainAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    private Fragment swipe;

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return swipe;
        }
        if (position == 1) {
            return new CommentFragment();
        }
        if (position == 2) {
            return new DoubleFragment();
        }
        if (position == 3) {
            return new ListFragment();
        }
        if (position == 4) {
            return new SettingsFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
