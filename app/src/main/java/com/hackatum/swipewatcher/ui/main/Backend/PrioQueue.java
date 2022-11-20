package com.hackatum.swipewatcher.ui.main.Backend;

import android.util.Log;

import java.io.IOException;
import java.nio.file.Watchable;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrioQueue {
	private PriorityQueue<MovieObject> queue;
	private ArrayList<String> watchlist;
	private ArrayList<MovieObject> matchedList;
	private PreferenceList pref;

	public PrioQueue(ArrayList<MovieObject> data, PreferenceList list) {
		queue = new PriorityQueue<>();
		for (MovieObject watchable : data) {
			watchable.setPriority(Math.random());
			queue.add(watchable);
		}
		watchlist = new ArrayList<>();
		pref = list;
	}

	// adds liked object to watchlist and updates priorities
	public void like(MovieObject movie) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Networking.addLiked(movie.getTitle());
					if (Networking.isMatch(movie.getTitle())) {
						matchedList.add(movie);
						//SNACKBAR
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();

		MovieObject liked = movie;
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
			temp.add(current);
		}
		Log.e("test","ololollo");
		queue = temp;
	}

	// removes element from queue
	public void dislike(MovieObject movie) {
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
