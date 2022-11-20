package com.hackatum.swipewatcher.ui.main.Backend;

import android.util.Log;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.hackatum.swipewatcher.MainActivity;
import com.hackatum.swipewatcher.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PrioQueue {
	private PriorityQueue<MovieObject> queue;
	private ArrayList<String> watchlist;
	public static ArrayList<MovieObject> matchedList = new ArrayList<>();
	private PreferenceList pref;
	private MainActivity mainActivity;

	public PrioQueue(ArrayList<MovieObject> data, PreferenceList list, MainActivity mainActivity) {
		queue = new PriorityQueue<>();
		for (MovieObject watchable : data) {
			watchable.setPriority(Math.random());
			queue.add(watchable);
		}
		watchlist = new ArrayList<>();
		pref = list;
		this.mainActivity = mainActivity;
	}

	public void remove(MovieObject o) {
		queue.remove(o);
	}

	// adds liked object to watchlist and updates priorities
	public void like(MovieObject movie) {
		if (movie == null) {
			return;
		}
		ArrayList<String> likedOther = new ArrayList<>();
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					boolean in = Networking.addLiked(movie.getTitle());
					if (in) {
						matchedList.add(movie);
						Snackbar.make(mainActivity, mainActivity.findViewById(R.id.main_swiper), "You have a match!", Snackbar.LENGTH_LONG).setAction("Take a look", new View.OnClickListener() {
							@Override
							public void onClick(View view) {
								mainActivity.successful();
							}
						}).show();
					}

					for (String s : Networking.getLiked()) {
						if (!watchlist.contains(s)) {
							likedOther.add(s);
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();

		MovieObject liked = movie;
		if (liked == null) {
			return;
		}
		watchlist.add(liked.getTitle());
		ArrayList<String> actors = liked.getActors();
		PriorityQueue<MovieObject> temp = new PriorityQueue<>();
		int size = queue.size();
		for (int i = 0; i < size; i++) {
			MovieObject current = queue.poll();
			ArrayList<String> current_actors = current.getActors();
			for (String actor : actors) {
				if (current_actors.contains(actor)) {
					current.higherPrio();
				}
			}


			for (String s : likedOther) {
				if (current.getTitle().equals(s)) {
					current.setPriority(6969420);
				}
			}

			temp.add(current);
		}
		Log.e("test","ololollo");
		queue = temp;
	}

	// removes element from queue
	public void dislike(MovieObject movie) {
		if (movie == null) {
			return;
		}

		MovieObject disliked = movie;
		ArrayList<String> actors = disliked.getActors();
		PriorityQueue<MovieObject> temp = new PriorityQueue<>();
		int size = queue.size();
		for (int i = 0; i < size; i++) {
			MovieObject current = queue.poll();
			ArrayList<String> current_actors = current.getActors();
			for (String actor : actors) {
				if (current_actors.contains(actor)) {
					current.lowerPrio();
				}
			}
			temp.add(current);
		}
		queue = temp;
	}

	// change preferences
	public void makePreferences() {
		PriorityQueue<MovieObject> temp = new PriorityQueue<>();
		int genre = pref.getGenre();
		int mov_ser = pref.getMovie_series_whatever();
		int age = pref.getFsk();
		int size = queue.size();
		for (int i = 0; i < size; i++) {
			MovieObject current = queue.poll();

		}
		queue = temp;
	}

	// Getters and Setters
	public PriorityQueue<MovieObject> getQueue() {
		return queue;
	}

	public void setQueue(PriorityQueue<MovieObject> queue) {
		this.queue = queue;
	}

	public ArrayList<String > getWatchlist() {
		return watchlist;
	}

	public void setWatchlist(ArrayList<String> watchlist) {
		this.watchlist = watchlist;
	}

	public ArrayList<MovieObject> getMatchedList() {return matchedList;}

}
