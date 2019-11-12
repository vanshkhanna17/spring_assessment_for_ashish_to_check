package com.tracks.repo;

import java.util.List;

import javax.sound.midi.Track;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.stereotype.Repository;

import com.tracks.model.Tracks;

@Repository
public class TrackDALImpl implements TrackDAL {

	@Autowired
	private MongoTemplate mongo;

	@Override
	public List<Tracks> findAll() {
		// TODO Auto-generated method stub
		return mongo.findAll(Tracks.class);
	}

	@Override
	public Tracks findByName(String name) {
		// TODO Auto-generated method stub
		return mongo.findOne(new Query(Criteria.where("title").is(name)), Tracks.class);
	}

	@Override
	public Tracks findById(String id) {
		// TODO Auto-generated method stub
		return mongo.findOne(new Query(Criteria.where("is").is(id)), Tracks.class);
	}

	@Override
	public Tracks save(Tracks t) {
		// TODO Auto-generated method stub
		return mongo.insert(t);
	}

	@Override
	public Tracks update(String id, Tracks t) {
		// TODO Auto-generated method stub
		return mongo.findAndModify(new Query(Criteria.where("id").is(id)), Update.update("artists", t.getArtists()), Tracks.class);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		mongo.findAndRemove(new Query(Criteria.where("id").is(id)), Track.class);
	}
	
}
