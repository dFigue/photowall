package es.bjt.photowall.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.bjt.photowall.bussiness.interfaces.PhotoService;
import es.bjt.photowall.model.Photo;

@Controller
public class PhotoWallController {

		
		@Value("${photowall.storage.location}")
		private String IMAGES_HOME;
		
		@Value("${photowall.web.user}")
		private String nameUser;
		
		@Autowired
		private PhotoService photoService;
		
		
				 
		 @RequestMapping("/photowall")
		    public String greeting(Model model) {
		        model.addAttribute("name", "pepe");
		        return "photowallView";
		    }
		
		/**
		 * funcion que devuelve las 10 imagenes con mas votos
		 * @return
		 */
		@RequestMapping(path="/photowall/top10",produces="application/json",method=RequestMethod.GET)
		public List<Photo> getTop10Photos()
		{
			
			List<Photo> collection = photoService.findTop10();
			
			return collection;		
		}
		
		@RequestMapping(path="/photowall/newPhotos",produces="application/json",method=RequestMethod.GET)
		public List<Photo> getNewPhotosFromUser()
		{
			
			List<Photo> collection = photoService.findNewPhotoFromUser(nameUser);
						
			return collection;
			
		}
		
				
		@RequestMapping(path="/getPhoto/{idPhoto}",produces="application/octet-stream",method=RequestMethod.GET)
		public byte[] getPhoto(@PathVariable(name="idPhoto") String idPhoto) throws IOException
		{
			
			Photo photo = photoService.findPhoto(idPhoto);
			
			//TODO Meter las imagenes en una cache de datos con infinispan
			
			String pathToFile = IMAGES_HOME + photo.getUid() + "." + photo.getExtension();
			
			Path path = Paths.get(pathToFile);
			byte[] data = Files.readAllBytes(path);
				
			return data;
			
		}

		
		public PhotoService getPhotoService() {
			return photoService;
		}

		public void setPhotoService(PhotoService photoService) {
			this.photoService = photoService;
		}

		public String getNameUser() {
			return nameUser;
		}

		public void setNameUser(String nameUser) {
			this.nameUser = nameUser;
		}
	
	
}
