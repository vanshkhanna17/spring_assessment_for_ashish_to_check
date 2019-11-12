package com.albums.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.albums.model.Albums;
import com.albums.repo.AlbumDAL;

@RestController
public class AlbumController {

	@Autowired
	private AlbumDAL adal;

	@PostMapping("/albums")
	public void create(@RequestBody Albums al) {
		System.out.println(" album controller -> " + al);
		adal.save(al);
	}

	@GetMapping("/albums/{name}")
	public Albums finde(@PathVariable String name) {
		return adal.findByProducer(name);
	}

	@GetMapping("/albums")
	public List<Albums> findAll() {
		return adal.findAll();
	}

	@PutMapping("/albums/{id}")
	public void update(@PathVariable String id, @RequestBody Albums album) {
		Albums b = adal.findById(id);
		if (album.getArtists() != null)
			b.getArtists().addAll(album.getArtists());
		if (album.getTracks() != null) {
			if(b.getTracks() == null) {
				b.setTracks(album.getTracks());
			}else {
			b.getTracks().addAll(album.getTracks());
		}
		}
		adal.update(id, b);
	}

	@DeleteMapping("/albums/{id}")
	public void del(@PathVariable String id) {
		adal.delete(id);
	}
}
