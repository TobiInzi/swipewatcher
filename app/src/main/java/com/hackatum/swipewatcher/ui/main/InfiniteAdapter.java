package com.hackatum.swipewatcher.ui.main;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.hackatum.swipewatcher.MainActivity;
import com.hackatum.swipewatcher.R;
import com.hackatum.swipewatcher.ui.main.Backend.*;
import com.hackatum.swipewatcher.ui.main.Backend.PrioQueue;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import java.util.Random;

public class InfiniteAdapter extends PagerAdapter {

    public int lastPosition;
    public int currentPosition = 500000;
    private SwipeFragment parent;
    private MainActivity mainActivity;
    private ImageView backgroundImage;
    private View view;
    private ImageView image;
    private Random random = new Random();

    public InfiniteAdapter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Log.e("initiate","initiate item");
        PrioQueue queue = MainActivity.queue;
        MovieObject movie = queue.getQueue().poll();

        if(currentPosition>position){
            Log.e("initiate","like tb called");
            queue.like(movie);
        } else {
            queue.dislike(movie);
        }
        ListFragment.setWatchlist(queue.getWatchlist());
        MovieObject nextMovie = queue.getQueue().peek();
        currentPosition = position;
        LayoutInflater layoutInflater = LayoutInflater.from(mainActivity);
        view = layoutInflater.inflate(R.layout.fragment_content, container, false);

        TextView text = view.findViewById(R.id.content_text);
        text.setText(nextMovie.getTitle().toUpperCase(Locale.ROOT));
        TextView text2 = view.findViewById(R.id.content_text_2);
        text2.setText("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At ...");
        TextView textAge = view.findViewById(R.id.content_fsk);
        textAge.setText(getFSK());
        TextView textType = view.findViewById(R.id.content_type);
        TextView textSeasons = view.findViewById(R.id.content_seasons_dauer);
        if (random.nextDouble() < 0.5) {
            textType.setText("Movie");
            String tmp = "Time 1:" + (Math.abs(random.nextInt()) % 50 + 10);
            textSeasons.setText(tmp);
        } else {
            textType.setText("Series");
            String tmp = (random.nextInt() % 4 + 4) + " Seasons";
            textSeasons.setText(tmp);
        }

        TextView textYear = view.findViewById(R.id.content_year);
        int i = 1970 + (Math.abs(random.nextInt()) % 43);
        String tmp = String.valueOf(i);
        textYear.setText(tmp);
        image = view.findViewById(R.id.content_image);
        setImage();
        image.setImageAlpha(230);
        container.addView(view, 0);
        return view;
    }

    private String getFSK() {
        double next = random.nextDouble();
        if (next < 0.25) {
            return "12";
        }
        if (next < 0.5) {
            return "16";
        }
        if (next < 0.75) {
            return "6";
        }
        return "18";
    }

    @Override
    public int getCount() {
        return 1_000_000_000;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    private void setImage()
    {
        switch((int) (Math.random() * 12)) {
            case 0: {image.setImageResource(R.drawable.movie1); break;}
            case 1: {image.setImageResource(R.drawable.movie2); break;}
            case 2: {image.setImageResource(R.drawable.movie3); break;}
            case 3: {image.setImageResource(R.drawable.movie4); break;}
            case 4: {image.setImageResource(R.drawable.movie5); break;}
            case 5: {image.setImageResource(R.drawable.movie6); break;}
            case 6: {image.setImageResource(R.drawable.movie7); break;}
            case 7: {image.setImageResource(R.drawable.movie8); break;}
            case 8: {image.setImageResource(R.drawable.movie9); break;}
            case 9: {image.setImageResource(R.drawable.movie10); break;}
            case 10: {image.setImageResource(R.drawable.movie11); break;}
            default: {image.setImageResource(R.drawable.movie12); break;}
        }
    }
    // Start the DownloadImage task with the given url
    public class DownloadImage extends AsyncTask<String, Integer, Drawable> {

        @Override
        protected Drawable doInBackground(String... arg0) {
            // This is done in a background thread
            return downloadImage(arg0[0]);
        }

        /**
         * Called after the image has been downloaded
         * -> this calls a function on the main thread again
         */


        /**
         * Actually download the Image from the _url
         * @param _url
         * @return
         */
        private Drawable downloadImage(String _url)
        {
            //Prepare to download image
            URL url;
            BufferedOutputStream out;
            InputStream in;
            BufferedInputStream buf;

            //BufferedInputStream buf;
            try {
                url = new URL(_url);
                in = url.openStream();

            /*
             * THIS IS NOT NEEDED
             *
             * YOU TRY TO CREATE AN ACTUAL IMAGE HERE, BY WRITING
             * TO A NEW FILE
             * YOU ONLY NEED TO READ THE INPUTSTREAM
             * AND CONVERT THAT TO A BITMAP
            out = new BufferedOutputStream(new FileOutputStream("testImage.jpg"));
            int i;

             while ((i = in.read()) != -1) {
                 out.write(i);
             }
             out.close();
             in.close();
             */

                // Read the inputstream
                buf = new BufferedInputStream(in);

                // Convert the BufferedInputStream to a Bitmap
                Bitmap bMap = BitmapFactory.decodeStream(buf);
                if (in != null) {
                    in.close();
                }
                if (buf != null) {
                    buf.close();
                }

                return new BitmapDrawable(bMap);

            } catch (Exception e) {
                Log.e("Error reading file", e.toString());
            }

            return null;
        }

    }
}
