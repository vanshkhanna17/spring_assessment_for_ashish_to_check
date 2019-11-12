package com.tracks.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Artists {
	@Id
	private String id;
	private String name;
	@DBRef
	private List<Albums> albums;
	@DBRef
	private List<Tracks> tracks;

	public Artists() {
	}
	
	public Artists(String id, String name, List<Albums> albums, List<Tracks> tracks) {
		super();
		this.id = id;
		this.name = name;
		this.albums = albums;
		this.tracks = tracks;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Albums> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Albums> albums) {
		this.albums = albums;
	}

	public List<Tracks> getTracks() {
		return tracks;
	}

	public void setTracks(List<Tracks> tracks) {
		this.tracks = tracks;
	}

}
