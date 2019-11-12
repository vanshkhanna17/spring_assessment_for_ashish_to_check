package com.artists.repo;

import java.util.List;


import com.artists.model.Artists;


public interface ArtistDAL {
	List<Artists> findAll();

	Artists findByName(String name);
	Artists findById(String id);
	void update(String id,Artists a);
	Artists save(Artists a);
	void delete(String id);
}
