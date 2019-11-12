package com.albums.repo;

import java.util.List;

import com.albums.model.Albums;




public interface AlbumDAL {
	List<Albums> findAll();

	Albums findByProducer(String name);
	Albums findById(String id);
	void update(String id,Albums a);
	Albums save(Albums a);
	void delete(String id);
}
