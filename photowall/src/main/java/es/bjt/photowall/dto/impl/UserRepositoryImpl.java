package es.bjt.photowall.dto.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import es.bjt.photowall.dto.interfaces.UserRepository;
import es.bjt.photowall.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
    MongoTemplate mongoTemplate;

	@Override
	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		
		mongoTemplate.save(user);		
		
		return true;
	}

	@Override
	public User getUserInfoById(String idUser) {
		
		
		Query query = new Query(Criteria.where("idUser").is(idUser));
		
		User result = mongoTemplate.findOne(query, User.class);
		
		return result;
	}
	
	@Override
	public User getUserInfoByName(String name) {
		
		Query query = new Query(Criteria.where("name").is(name));
		
		User result = mongoTemplate.findOne(query, User.class);
		
		return result;
	}

	
}
