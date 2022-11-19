package com.hackatum.swipewatcher;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.widget.ImageButton;

import com.hackatum.swipewatcher.ui.main.MainAdapter;
import com.hackatum.swipewatcher.ui.main.MovieObject;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MovieObject.createObjects();
        ViewPager2 swiper = findViewById(R.id.main_swiper);
        MainAdapter adapter = new MainAdapter(this);
        swiper.setAdapter(adapter);
        swiper.setUserInputEnabled(false);
        //ConstraintLayout current = findViewById(R.id.content_main);
        ImageButton tv = findViewById(R.id.button_home);
        ImageButton comment = findViewById(R.id.button_comment);
        ImageButton friend = findViewById(R.id.button_double);
        ImageButton settings = findViewById(R.id.button_settings);
        ImageButton list = findViewById(R.id.button_list);
        tv.setOnClickListener(view -> swiper.setCurrentItem(0));
        comment.setOnClickListener(view -> swiper.setCurrentItem(1));
        friend.setOnClickListener(view -> swiper.setCurrentItem(2));
        list.setOnClickListener(view -> swiper.setCurrentItem(3));
        settings.setOnClickListener(view -> swiper.setCurrentItem(4));
    }
}