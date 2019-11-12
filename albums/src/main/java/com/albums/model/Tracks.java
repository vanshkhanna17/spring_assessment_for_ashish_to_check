package com.albums.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Tracks {
	@Id
	private String id;
	private String title;
	@DBRef
	private List<Artists> artists;

	public Tracks() {
	}

	public Tracks(String id, String title, List<Artists> artists) {
		super();
		this.id = id;
		this.title = title;
		this.artists = artists;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Artists> getArtists() {
		return artists;
	}

	public void setArtists(List<Artists> artists) {
		this.artists = artists;
	}

	@Override
	public String toString() {
		return "Tracks [id=" + id + ", title=" + title + ", artists=" + artists + "]";
	}

}
