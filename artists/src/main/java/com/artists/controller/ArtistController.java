package com.artists.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.artists.model.Artists;
import com.artists.repo.ArtistDAL;

@RestController
public class ArtistController {
	@Autowired
	private ArtistDAL Adal;

	@PostMapping("/artists")
	public void create(@RequestBody Artists al) {
		Adal.save(al);
	}

	@GetMapping("/artists/{name}")
	public Artists finde(@PathVariable String name) {
		return Adal.findByName(name);
	}

	@PutMapping("/artists/{id}")
	public void update(@PathVariable String id, @RequestBody Artists a) {
		Artists b = Adal.findById(id);
		System.out.println(b);
		System.out.println(a);
		System.out.println(a.getAlbums() + " a -> albums");
		if (a.getAlbums() != null)
			b.getAlbums().addAll(a.getAlbums());
		System.out.println(a.getTracks() + " a -> tracks");
		if (a.getTracks() != null)
			b.getTracks().addAll(a.getTracks());
		Adal.update(id, b);
	}

	@GetMapping("/artists")
	public List<Artists> findAll() {
		return Adal.findAll();
	}

	@DeleteMapping("/artists/{id}")
	public void del(@PathVariable String id) {
		Adal.delete(id);
	}
}
