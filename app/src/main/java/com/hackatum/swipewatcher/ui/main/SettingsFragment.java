package com.hackatum.swipewatcher.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.hackatum.swipewatcher.MainActivity;
import com.hackatum.swipewatcher.R;

public class SettingsFragment extends Fragment {


    private MainActivity mainActivity;
    public SettingsFragment(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        LinearLayout f1 = view.findViewById(R.id.first_setting);
        LinearLayout f2 = view.findViewById(R.id.second_setting);
        LinearLayout f3 = view.findViewById(R.id.third_setting);
        LinearLayout f4 = view.findViewById(R.id.fourth_setting);
        LinearLayout f5 = view.findViewById(R.id.fifth_setting);
        LinearLayout f6 = view.findViewById(R.id.sixt_setting);

        TextView f11 = f1.findViewById(R.id.settings_text);
        TextView f22 = f2.findViewById(R.id.settings_text);
        TextView f33 = f3.findViewById(R.id.settings_text);
        TextView f44 = f4.findViewById(R.id.settings_text);
        TextView f55 = f5.findViewById(R.id.settings_text);
        TextView f66 = f6.findViewById(R.id.settings_text);

        f11.setText("Account");
        f22.setText("Notification");
        f33.setText("Appearance");
        f44.setText("Privacy & Security");
        f55.setText("Help and Support");
        f66.setText("About");

        ImageView f111 = f1.findViewById(R.id.settings_image);
        ImageView f222 = f2.findViewById(R.id.settings_image);
        ImageView f333= f3.findViewById(R.id.settings_image);
        ImageView f444 = f4.findViewById(R.id.settings_image);
        ImageView f555 = f5.findViewById(R.id.settings_image);
        ImageView f666 = f6.findViewById(R.id.settings_image);

        f111.setImageResource(R.drawable.ic_user_solid);
        f222.setImageResource(R.drawable.ic_bell_regular);
        f333.setImageResource(R.drawable.ic_eye_regular);
        f444.setImageResource(R.drawable.ic_lock_solid);
        f555.setImageResource(R.drawable.ic_headphones_solid);
        f666.setImageResource(R.drawable.ic_circle_info_solid);

        ImageButton f1111 = f1.findViewById(R.id.settings_button);
        ImageButton f2222 = f2.findViewById(R.id.settings_button);
        ImageButton f3333 = f3.findViewById(R.id.settings_button);
        ImageButton f4444 = f4.findViewById(R.id.settings_button);
        ImageButton f5555 = f5.findViewById(R.id.settings_button);
        ImageButton f6666 = f6.findViewById(R.id.settings_button);
        View.OnClickListener o = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mainActivity, "Not implemented yet!", Toast.LENGTH_SHORT).show();
            }
        };
        f1111.setOnClickListener(o);
        f2222.setOnClickListener(o);
        f3333.setOnClickListener(o);
        f4444.setOnClickListener(o);
        f5555.setOnClickListener(o);
        f6666.setOnClickListener(o);
        return view;
    }
}
