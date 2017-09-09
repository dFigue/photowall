package es.bjt.photowall.bussiness.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.bjt.photowall.bussiness.interfaces.PhotoService;
import es.bjt.photowall.dto.interfaces.PhotoRepository;
import es.bjt.photowall.model.Photo;

@Component
public class PhotoServiceImpl implements PhotoService {
	
	@Autowired
	private PhotoRepository photoRepository;
	
	
	
	@Override
	public List<Photo> findTop10() {
		// TODO Auto-generated method stub
		return photoRepository.findTop10();
	}

	@Override
	public List<Photo> findNewPhotoFromUser(String idUser) {
		// TODO Auto-generated method stub
		return photoRepository.findNewPhotoFromUser(idUser);
	}

	@Override
	public Photo findPhoto(String idPhoto) {
		// TODO Auto-generated method stub
		return photoRepository.findPhoto(idPhoto);
	}

	@Override
	public boolean insertPhoto(Photo photo) {
		// TODO Auto-generated method stub
		return photoRepository.insertPhoto(photo);
	}

	@Override
	public boolean insertPhotos(List<Photo> photoList) {
		// TODO Auto-generated method stub
		return photoRepository.insertPhotos(photoList);
	}
	
	@Override
	public boolean votePhoto(String idPhoto, String idUser) {
		// TODO Auto-generated method stub
		return photoRepository.addVotePhoto(idPhoto,idUser);
	}
	
	
	
	
	public PhotoRepository getPhotoRepository() {
		return photoRepository;
	}

	public void setPhotoRepository(PhotoRepository photoRepository) {
		this.photoRepository = photoRepository;
	}
	
	
	

}
