package com.tracks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.tracks.model.Tracks;
import com.tracks.repo.TrackDAL;

@RestController
public class TrackController {
	@Autowired
	private TrackDAL tdal;

	@PostMapping("/tracks")
	public void create(@RequestBody Tracks t) {
		System.out.println("entered track post");
		tdal.save(t);
	}

	@GetMapping("/tracks/{name}")
	public Tracks finde(@PathVariable String name) {
		return tdal.findByName(name);
	}

	@GetMapping("/tracks")
	public List<Tracks> findAll() {
		return tdal.findAll();
	}

	@PutMapping("/tracks/{id}")
	public void update(@PathVariable String id, @RequestBody Tracks t) {
		Tracks b = tdal.findById(id);
		b.getArtists().addAll(t.getArtists());
		tdal.update(id,b);
	}
	@DeleteMapping("/tracks/{id}")
	public void del(@PathVariable String id) {
		tdal.delete(id);
	}
}
