package com.hackatum.swipewatcher.ui.main.Backend;

import java.nio.file.Watchable;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrioQueue {
	private PriorityQueue<MovieObject> queue;
	private ArrayList<MovieObject> watchlist;
	private PreferenceList pref;

	public PrioQueue(ArrayList<MovieObject> data, PreferenceList list) {
		queue = new PriorityQueue<>();
		for (MovieObject watchable : data) {
			watchable.setPriority((int) (Math.random() * 10));
			queue.add(watchable);
		}
		watchlist = new ArrayList<>();
		pref = list;
	}

	// adds liked object to watchlist and updates priorities
	public void like() {
		MovieObject liked = queue.poll();
		watchlist.add(liked);
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
		queue = temp;
	}

	// removes element from queue
	public void dislike() {
		MovieObject disliked = queue.poll();
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
			if (current.getFSK() <= age) {
				temp.add(current);
			}

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

	public ArrayList<MovieObject> getWatchlist() {
		return watchlist;
	}

	public void setWatchlist(ArrayList<MovieObject> watchlist) {
		this.watchlist = watchlist;
	}

}
