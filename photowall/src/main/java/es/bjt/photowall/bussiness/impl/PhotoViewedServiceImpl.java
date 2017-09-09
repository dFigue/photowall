package es.bjt.photowall.bussiness.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.bjt.photowall.bussiness.interfaces.PhotoViewedService;
import es.bjt.photowall.dto.interfaces.PhotoViewebByUserRepository;

@Component
public class PhotoViewedServiceImpl implements PhotoViewedService {
	
	@Autowired
	private PhotoViewebByUserRepository photoViewedRepository;
	
	
	@Override
	public boolean markviewed(String idUser, String idPhoto) {
		// TODO Auto-generated method stub
		return photoViewedRepository.markviewed(idUser, idPhoto);
	}

	

	public PhotoViewebByUserRepository getPhotoViewedRepository() {
		return photoViewedRepository;
	}

	public void setPhotoViewedRepository(PhotoViewebByUserRepository photoViewedRepository) {
		this.photoViewedRepository = photoViewedRepository;
	}
	
	
}
