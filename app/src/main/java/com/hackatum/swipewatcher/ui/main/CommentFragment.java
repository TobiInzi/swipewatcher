package com.hackatum.swipewatcher.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.imageview.ShapeableImageView;
import com.hackatum.swipewatcher.MainActivity;
import com.hackatum.swipewatcher.R;

import java.util.ArrayList;

public class CommentFragment extends Fragment {

    private MainActivity mainActivity;

    public CommentFragment(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comment, container, false);
        SearchView searchView = view.findViewById(R.id.search_bar);
        searchView.setQueryHint("Search for movies...");



        ConstraintLayout first = view.findViewById(R.id.first_comment);
        ConstraintLayout second = view.findViewById(R.id.second_comment);
        ConstraintLayout third = view.findViewById(R.id.third_comment);
        ConstraintLayout fourth = view.findViewById(R.id.fourth_comment);
        TextView f1 = first.findViewById(R.id.comment_title);
        TextView f2 = second.findViewById(R.id.comment_title);
        TextView f3 = third.findViewById(R.id.comment_title);
        TextView f4 = fourth.findViewById(R.id.comment_title);
        f1.setText("DJFreshHerrmann");
        f3.setText("BurdaForwardLover");
        f4.setText("XxMinecrafterxX");
        TextView f11 = first.findViewById(R.id.comment_text);
        TextView f22 = second.findViewById(R.id.comment_text);
        TextView f33 = third.findViewById(R.id.comment_text);
        TextView f44 = fourth.findViewById(R.id.comment_text);
        //f22.setText("I dont know guys. My boyfriend really liked the movie, but I didn't like it at all.");

        f11.setText("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At ...");
        f22.setText("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat.");
        f33.setText("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna.");
        f44.setText("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam.");
        ShapeableImageView i1 = first.findViewById(R.id.profile_pic);
        ShapeableImageView i2 = second.findViewById(R.id.profile_pic);
        ShapeableImageView i3 = third.findViewById(R.id.profile_pic);

        i1.setImageResource(R.drawable.movie5);
        i2.setImageResource(R.drawable.movie4);
        i3.setImageResource(R.drawable.movie11);
        return view;
    }
}
