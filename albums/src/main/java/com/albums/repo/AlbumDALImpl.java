package com.albums.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.albums.model.Albums;

@Repository
public class AlbumDALImpl implements AlbumDAL{
	@Autowired
	private MongoTemplate mongo;
	@Override
	public List<Albums> findAll() {
		// TODO Auto-generated method stub
		return mongo.findAll(Albums.class);
	}

	@Override
	public Albums findByProducer(String name) {
		// TODO Auto-generated method stub
		return mongo.findOne(new Query(Criteria.where("by").is(name)), Albums.class);
	}

	@Override
	public Albums findById(String id) {
		// TODO Auto-generated method stub
		return mongo.findOne(new Query(Criteria.where("id").is(id)), Albums.class);
	}

	@Override
	public Albums save(Albums a) {
		// TODO Auto-generated method stub
		System.out.println("album -> " + a);
		return mongo.save(a);
	}

	@Override
	public void update(String id, Albums a) {
		// TODO Auto-generated method stub
		mongo.findAndModify(new Query(Criteria.where("id").is(id)), Update.update("artists", a.getArtists()), Albums.class);
		mongo.findAndModify(new Query(Criteria.where("id").is(id)), Update.update("tracks",a.getTracks()),Albums.class);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		mongo.findAndRemove(new Query(Criteria.where("id").is(id)), Albums.class);
	}

}
