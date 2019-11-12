package com.tracks.repo;

import java.util.List;

import com.tracks.model.Tracks;


public interface TrackDAL {
	List<Tracks> findAll();

	Tracks findByName(String name);
	Tracks findById(String id);
	void delete(String id);
	Tracks save(Tracks t);
	Tracks update(String id,Tracks t);
}
