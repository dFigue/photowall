package es.bjt.photowall.dto.interfaces;

import java.util.List;

import es.bjt.photowall.model.Photo;

public interface PhotoRepository {
	
	public List<Photo> findTop10();
	public List<Photo> findNewPhotoFromUser(String idUser);
	public Photo findPhoto(String idPhoto);
	public boolean insertPhoto(Photo photo);
	public boolean insertPhotos(List<Photo> photoList);
	public boolean addVotePhoto(String idPhoto, String idUser);
}
