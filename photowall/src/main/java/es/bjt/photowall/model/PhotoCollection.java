package es.bjt.photowall.model;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {
	
	private List<Photo> photos;
	
	public PhotoCollection() {
		photos = new ArrayList<Photo>();
	}

	

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	
 
}
