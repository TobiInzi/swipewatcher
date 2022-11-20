package com.hackatum.swipewatcher;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.hackatum.swipewatcher.ui.main.Backend.LoadData;
import com.hackatum.swipewatcher.ui.main.Backend.PreferenceList;
import com.hackatum.swipewatcher.ui.main.Backend.PrioQueue;
import com.hackatum.swipewatcher.ui.main.MainAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> watchlist;
    public static PreferenceList preflist;
    public static PrioQueue queue; //GetAllData()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preflist = new PreferenceList(0,0,0,"english");
        queue = new PrioQueue(LoadData.getData(this),preflist, this);
        //queue = new PrioQueue(LoadData.getCoupleData(this),preflist, this);
        watchlist = queue.getWatchlist();
        setContentView(R.layout.activity_main);
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

        //ListView listView = (ListView) findViewById(R.id.list);
        //ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.fragment_list,watchlist);
        //listView.setAdapter(arrayAdapter);

        tv.setOnClickListener(view -> {
            swiper.setCurrentItem(0);
            tv.setImageResource(R.drawable.ic_tv_solid3);
            comment.setImageResource(R.drawable.ic_comment_solid);
            friend.setImageResource(R.drawable.ic_user_group_solid);
            list.setImageResource(R.drawable.ic_list_solid);
            settings.setImageResource(R.drawable.ic_gear_solid);
        });
        comment.setOnClickListener(view -> {
            swiper.setCurrentItem(1);
            tv.setImageResource(R.drawable.ic_tv_solid2);
            comment.setImageResource(R.drawable.ic_comment_solid3);
            friend.setImageResource(R.drawable.ic_user_group_solid);
            list.setImageResource(R.drawable.ic_list_solid);
            settings.setImageResource(R.drawable.ic_gear_solid);
        });
        friend.setOnClickListener(view -> {
            swiper.setCurrentItem(2);
            tv.setImageResource(R.drawable.ic_tv_solid2);
            comment.setImageResource(R.drawable.ic_comment_solid);
            friend.setImageResource(R.drawable.ic_user_group_solid3);
            list.setImageResource(R.drawable.ic_list_solid);
            settings.setImageResource(R.drawable.ic_gear_solid);
        });
        list.setOnClickListener(view -> {
            swiper.setCurrentItem(3);
            tv.setImageResource(R.drawable.ic_tv_solid2);
            comment.setImageResource(R.drawable.ic_comment_solid);
            friend.setImageResource(R.drawable.ic_user_group_solid);
            list.setImageResource(R.drawable.ic_list_solid3);
            settings.setImageResource(R.drawable.ic_gear_solid);
        });
        settings.setOnClickListener(view -> {
            swiper.setCurrentItem(4);
            tv.setImageResource(R.drawable.ic_tv_solid2);
            comment.setImageResource(R.drawable.ic_comment_solid);
            friend.setImageResource(R.drawable.ic_user_group_solid);
            list.setImageResource(R.drawable.ic_list_solid);
            settings.setImageResource(R.drawable.ic_gear_solid3);
        });

    }

    public void successful() {
        ImageButton friend = findViewById(R.id.button_double);
        friend.performClick();
    }
}