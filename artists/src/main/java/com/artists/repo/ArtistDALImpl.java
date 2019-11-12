package com.artists.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.artists.model.Artists;
@Repository
public class ArtistDALImpl implements ArtistDAL {
	@Autowired
	private MongoTemplate mongo;
	
	@Override
	public List<Artists> findAll() {
		// TODO Auto-generated method stub
		return mongo.findAll(Artists.class);
	}

	@Override
	public Artists findByName(String name) {
		// TODO Auto-generated method stub
		return mongo.findOne(new Query(Criteria.where("name").is(name)), Artists.class);
	}
	
	@Override
	public Artists findById(String id) {
		// TODO Auto-generated method stub
		System.out.println(mongo.findOne(new Query(Criteria.where("id").is(id)), Artists.class) + " findById()");
		return mongo.findOne(new Query(Criteria.where("id").is(id)), Artists.class);
	}
	
	@Override
	public void update(String id, Artists a) {
		// TODO Auto-generated method stub
		mongo.findAndModify(new Query(Criteria.where("id").is(id)), Update.update("albums", a.getAlbums()), Artists.class);
		mongo.findAndModify(new Query(Criteria.where("id").is(id)), Update.update("tracks",a.getTracks()),Artists.class);
	}

	@Override
	public Artists save(Artists a) {
		// TODO Auto-generated method stub
		return mongo.insert(a);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		mongo.findAndRemove(new Query(Criteria.where("id").is(id)), Artists.class);
	}

}
