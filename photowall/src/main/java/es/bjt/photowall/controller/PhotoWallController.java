package es.bjt.photowall.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.bjt.photowall.model.Photo;
import es.bjt.photowall.model.PhotoCollection;

@Controller
public class PhotoWallController {

	
	
	//TODO cargar por propiedades
		private static String IMAGES_HOME = "/home/david/Descargas/images/database";
		private final String idUser="PhotoWall"; //TODO Recuperar el usuario y añadir en el arranque
		
		
		 @RequestMapping(value="/photowall",method = RequestMethod.GET)
	     public String home(){
	        return "photowallView";
	     }
		
		/**
		 * funcion que devuelve las 10 imagenes con mas votos
		 * @return
		 */
		@RequestMapping(path="/photowall/top10",produces="application/json",method=RequestMethod.GET)
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
		
		@RequestMapping(path="/photowall/newPhotos",produces="application/json",method=RequestMethod.GET)
		public PhotoCollection getNewPhotosFromUser()
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
