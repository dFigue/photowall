package es.bjt.photowall.webservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.bjt.photowall.bussiness.interfaces.UserService;
import es.bjt.photowall.model.User;
import es.bjt.photowall.utils.Utils;

@RestController
@RequestMapping("/UserManager")
public class UserManager 
{
	@Autowired
	private UserService userService;
		
	/**
	 * funcion que devuelve las 10 imagenes con mas votos
	 * @return
	 */
	@RequestMapping(path="/user/{idUser}",produces="application/json",method=RequestMethod.GET)
	public User getUserInfo(@PathVariable(name="idUser") String idUser)
	{
		
		User user = userService.getUserInfoById(idUser);
		return user;
		
	}
	
//	@RequestMapping(path="/userByName/{name}",produces="application/json",method=RequestMethod.GET)
//	public User getUserInfoByName(@PathVariable(name="name") String name)
//	{
//		
//		User user = userService.getUserInfoByName(name);
//		return user;
//		
//	}
	
	@RequestMapping(path="/addUser/{name}",method=RequestMethod.POST)
	public User addUser(@PathVariable(name="name") String name)
	{
		User user = new User();
		user.setIdUser(Utils.generateUID());
		user.setName(name);
		
		userService.saveUser(user);
		
		return user;
				
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	

}
