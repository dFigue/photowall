package es.bjt.photowall.webservice;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import es.bjt.photowall.model.Photo;
import es.bjt.photowall.model.PhotoCollection;
import es.bjt.photowall.utils.Utils;

@RestController
@RequestMapping("/PhotoManager")
public class PhotoManager 
{
	
	//TODO cargar por propiedades
	private static String IMAGES_HOME = "/home/david/Descargas/images/database";
	
	
	/**
	 * funcion que devuelve las 10 imagenes con mas votos
	 * @return
	 */
	@RequestMapping(path="/top10",produces="application/json",method=RequestMethod.GET)
	public PhotoCollection getTop10Photos()
	{
		
		PhotoCollection collection = new PhotoCollection();
		
		Photo photo = new Photo();
		
		photo.setComments("Mi primera foto");
		photo.setNumVotes(321);
		photo.setUid("UID");
		photo.setIdUser("MiUser");
		
		collection.getPhotos().add(photo);
		
		photo = new Photo();
		
		photo.setComments("Mi primera foto");
		photo.setNumVotes(321);
		photo.setUid("23423423");
		photo.setIdUser("MiUser");
		
		collection.getPhotos().add(photo);
		
		photo = new Photo();
		
		photo.setComments("");
		photo.setNumVotes(321);
		photo.setUid("U456343ID");
		photo.setIdUser("MiUser");
		
		collection.getPhotos().add(photo);
		
		return collection;		
	}
	
	@RequestMapping(path="/newPhotos/{idUser}",produces="application/json",method=RequestMethod.GET)
	public PhotoCollection getNewPhotosFromUser(@PathVariable(name="idUser") String idUser)
	{
		PhotoCollection collection = new PhotoCollection();
		
		Photo photo = new Photo();
		
		photo.setComments("Mi primera foto");
		photo.setNumVotes(321);
		photo.setUid("UID");
		photo.setIdUser(idUser);
		
		collection.getPhotos().add(photo);
		
		return collection;
		
	}
	
	@RequestMapping(path="/addPhoto/{idUser}",consumes="multipart/form-data",method=RequestMethod.POST)
	public void addFoto(@PathVariable(name="idUser") String idUser, @RequestPart("comment") String comment, @RequestPart("photo") byte[] photobinary ) throws IOException
	{
		
		
		Photo photo = new Photo();
		
		photo.setComments(comment);
		photo.setNumVotes(0);
		photo.setUid(Utils.generateUID());
		photo.setIdUser(idUser);
		
		System.out.println(photo);
		
		String imagePath = IMAGES_HOME + photo.getUid();
		
		Path path = Paths.get(imagePath);
		Files.write(path, photobinary);	
		
		
		//TODO Persistir en BBDD
		
	}
	
	@RequestMapping(path="/getPhoto/{idPhoto}",produces="application/octet-stream",method=RequestMethod.GET)
	public byte[] getPhoto(@PathVariable(name="idPhoto") String idPhoto) throws IOException
	{
		
		//TODO Localizar imagen y leer
		//TODO Meter las imagenes en una cache de datos con infinispan
		
		String pathToFile = "/home/david/Descargas/descarga2.jpg";
		
		Path path = Paths.get(pathToFile);
		byte[] data = Files.readAllBytes(path);
	
		
		return data;
		
	}
	
	

}
