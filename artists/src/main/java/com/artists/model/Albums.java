package com.artists.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Albums {
	@Id
	private String id;
	private String title;
	private String by;
	@DBRef
	private List<Tracks> tracks;
	@DBRef
	private List<Artists> artists;

	public Albums() {
	}

	public Albums(String id, String title, String by, List<Tracks> tracks, List<Artists> artists) {
		super();
		this.id = id;
		this.title = title;
		this.by = by;
		this.tracks = tracks;
		this.artists = artists;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBy() {
		return by;
	}

	public void setBy(String by) {
		this.by = by;
	}

	public List<Tracks> getTracks() {
		return tracks;
	}

	public void setTracks(List<Tracks> tracks) {
		this.tracks = tracks;
	}

	public List<Artists> getArtists() {
		return artists;
	}

	public void setArtists(List<Artists> artists) {
		this.artists = artists;
	}

}
