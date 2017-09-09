package es.bjt.photowall.dto.interfaces;

import es.bjt.photowall.model.User;

public interface UserRepository{

	
	public boolean saveUser(User user);	   
	public User getUserInfoById(String idUser);
	public User getUserInfoByName(String name);
}
	
