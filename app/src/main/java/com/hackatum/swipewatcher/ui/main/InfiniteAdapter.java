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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class InfiniteAdapter extends PagerAdapter {

    public int lastPosition;
    public int currentPosition;
    private SwipeFragment parent;
    private MainActivity mainActivity;
    private ImageView backgroundImage;
    private View view;
    private ImageView image;
    private MovieObject old = MovieObject.getNext();
    private MovieObject newer;
    private MovieObject[] tiles = new MovieObject[3];

    public InfiniteAdapter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(mainActivity);
        view = layoutInflater.inflate(R.layout.fragment_content, container, false);
        old = newer;
        newer = MovieObject.getNext();
        if (position % 3 == 0) {
            tiles[0] = old;
            tiles[1] = newer;
            tiles[2] = newer;
        } else if (position % 3 == 1) {
            tiles[0] = newer;
            tiles[1] = old;
            tiles[2] = newer;
        } else {
            tiles[0] = newer;
            tiles[1] = newer;
            tiles[2] = old;
        }
        TextView text = view.findViewById(R.id.content_text);
        if (old != null) {
            text.setText(old.getTitle());
        }
        TextView text2 = view.findViewById(R.id.content_text_2);
        if (old != null) {
            //text2.setText(old.getDescription());
            text2.setText("Game of thrrones is a very cool series with 2 or 3 actors tbh fsjafjdsajf djg gadsg fg ag asdb fsa fd");
        }
        image = view.findViewById(R.id.content_image);
        new DownloadImage().execute("https://i.imgur.com/CQzlM.jpg");
        container.addView(view, 0);
        return view;
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

    // You can set a temporary background here
    //image.setImageResource(null);
    /**
     * Simple functin to set a Drawable to the image View
     * @param drawable
     */
    private void setImage(Drawable drawable)
    {
        image.setImageDrawable(drawable);
        image.setImageAlpha(150);
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
        protected void onPostExecute(Drawable image)
        {
            setImage(image);
        }


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
