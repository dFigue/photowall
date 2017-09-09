package es.bjt.photowall.dto.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import es.bjt.photowall.dto.interfaces.PhotoRepository;
import es.bjt.photowall.model.Photo;
import es.bjt.photowall.model.PhotoViewedByUser;

@Repository
public class PhotoRepositoryImpl implements PhotoRepository {
	
	@Autowired
    MongoTemplate mongoTemplate;

	@Override
	public List<Photo> findTop10() {
				
		Query query = new Query();
		query.with(new Sort(Sort.Direction.DESC,"numVotes"));
		query.limit(10);
		
		
		List<Photo>  result = mongoTemplate.find(query, Photo.class);
		
			
		return result;
	}

	@Override
	public List<Photo> findNewPhotoFromUser(String idUser) {
		Query queryPhotosViewed = new Query();
				
		queryPhotosViewed.addCriteria(Criteria.where("userId").is(idUser));
				
		List<PhotoViewedByUser>  resultPhotosViewed = mongoTemplate.find(queryPhotosViewed, PhotoViewedByUser.class);
		
		List<String> listOfIds = new ArrayList<String>();
		
		for (PhotoViewedByUser photoViewed : resultPhotosViewed) {
			
			listOfIds.add(photoViewed.getPhotoUID());
			
		}
		
		Query query = new Query();
		
		query.with(new Sort(Sort.Direction.ASC,"numVotes"));
		query.addCriteria(Criteria.where("uid").nin(listOfIds));
		query.limit(10);
				
		List<Photo>  result = mongoTemplate.find(query, Photo.class);
		
			
		return result;
	}

	@Override
	public Photo findPhoto(String idPhoto) {
		// TODO Auto-generated method stub
		
		
		Query query = new Query();
		query.addCriteria(Criteria.where("uid").is(idPhoto));
		
		Photo result = mongoTemplate.findOne(query, Photo.class);
		
		return result;
	}

	@Override
	public boolean insertPhoto(Photo photo) {
		
		mongoTemplate.save(photo);
		
		return true;
	}

	@Override
	public boolean insertPhotos(List<Photo> photoList) {
		// TODO Auto-generated method stub
		
		mongoTemplate.insertAll(photoList);
		return true;
	}
	
	@Override
	public boolean addVotePhoto(String idPhoto, String idUser)
	{
		
		Photo photo = findPhoto(idPhoto);
		photo.setNumVotes(photo.getNumVotes() + 1);
		
		insertPhoto(photo);		
		
		return true;
	}
	

}
