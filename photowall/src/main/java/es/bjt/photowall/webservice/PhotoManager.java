package es.bjt.photowall.webservice;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import es.bjt.photowall.bussiness.interfaces.PhotoService;
import es.bjt.photowall.bussiness.interfaces.PhotoViewedService;
import es.bjt.photowall.model.Photo;
import es.bjt.photowall.utils.Utils;

@RestController
@RequestMapping("/PhotoManager")
public class PhotoManager 
{
	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private PhotoViewedService photoViewedService;
	
	
	@Value("${photowall.storage.location}")
	private String IMAGES_HOME;
	
	
	/**
	 * funcion que devuelve las 10 imagenes con mas votos
	 * @return
	 */
	@RequestMapping(path="/top10",produces="application/json",method=RequestMethod.GET)
	public List<Photo> getTop10Photos()
	{
		
		List<Photo> collection = photoService.findTop10();
		
		
		return collection;		
	}
	
	@RequestMapping(path="/newPhotos/{idUser}",produces="application/json",method=RequestMethod.GET)
	public java.util.List<Photo> getNewPhotosFromUser(@PathVariable(name="idUser") String idUser)
	{
		List<Photo> collection = photoService.findNewPhotoFromUser(idUser);
		
		return collection;
		
	}
	
	@RequestMapping(path="/addPhoto/{idUser}",consumes="multipart/form-data",method=RequestMethod.POST)
	public void addFoto(@PathVariable(name="idUser") String idUser, @RequestPart("comment") String comment, @RequestPart("photoName") String photoName, @RequestPart("photo") byte[] photobinary ) throws IOException
	{
		
		
		Photo photo = new Photo();
		
		photo.setComments(comment);
		photo.setNumVotes(0);
		photo.setUid(Utils.generateUID());
		photo.setIdUser(idUser);
		
		int index = photoName.lastIndexOf(".");
		if (index > -1)
		{
			photo.setExtension(photoName.substring(index+1));
		}
		else
		{
			return; //TODO. Dar error de imagen sin extension. No se inserta
		}
		
		
				
		String imagePath = IMAGES_HOME + File.separatorChar + photo.getUid() + "." + photo.getExtension();
		
		Path path = Paths.get(imagePath);
		Files.write(path, photobinary);	
		
		photoService.insertPhoto(photo);
				
	}
	
	@RequestMapping(path="/getPhoto/{idPhoto}",produces="application/octet-stream",method=RequestMethod.GET)
	public byte[] getPhoto(@PathVariable(name="idPhoto") String idPhoto) throws IOException
	{
		
		Photo photo = photoService.findPhoto(idPhoto);
		
		//TODO Meter las imagenes en una cache de datos con infinispan
		
		String pathToFile = IMAGES_HOME + File.separatorChar + photo.getUid() + "." + photo.getExtension();
		
		Path path = Paths.get(pathToFile);
		byte[] data = Files.readAllBytes(path);
			
		return data;
		
	}
	
	@RequestMapping(path="/markPhoto/{idUser}/{idPhoto}",method=RequestMethod.GET)
	public void markPhotoViewed(@PathVariable(name="idUser") String idUser,@PathVariable(name="idPhoto") String idPhoto)
	{
		photoViewedService.markviewed(idUser, idPhoto);	
		
	}
	
	@RequestMapping(path="/vote/{idUser}/{idPhoto}",method=RequestMethod.GET)
	public void votePhoto(@PathVariable(name="idUser") String idUser,@PathVariable(name="idPhoto") String idPhoto)
	{
		photoService.votePhoto(idPhoto,idUser);	
		
	}

	public PhotoService getPhotoService() {
		return photoService;
	}

	public void setPhotoService(PhotoService photoService) {
		this.photoService = photoService;
	}

	public PhotoViewedService getPhotoViewedService() {
		return photoViewedService;
	}

	public void setPhotoViewedService(PhotoViewedService photoViewedService) {
		this.photoViewedService = photoViewedService;
	}
	
	

}
