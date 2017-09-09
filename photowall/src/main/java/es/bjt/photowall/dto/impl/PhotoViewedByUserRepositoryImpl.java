package es.bjt.photowall.dto.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import es.bjt.photowall.dto.interfaces.PhotoViewebByUserRepository;
import es.bjt.photowall.model.PhotoViewedByUser;

@Repository
public class PhotoViewedByUserRepositoryImpl implements PhotoViewebByUserRepository {
	
	@Autowired
    MongoTemplate mongoTemplate;

	@Override
	public boolean markviewed(String idUser, String idPhoto)
	{
		// TODO Auto-generated method stub
		
		PhotoViewedByUser view = new PhotoViewedByUser();
		view.setPhotoUID(idPhoto);
		view.setUserId(idUser);
		
		mongoTemplate.save(view);
		
		return true;
	}

}
