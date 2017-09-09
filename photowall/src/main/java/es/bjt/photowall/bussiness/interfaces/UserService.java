package es.bjt.photowall.bussiness.interfaces;

import es.bjt.photowall.model.User;

public interface UserService 
{
	
	public boolean saveUser(User user);	   
	public User getUserInfoById(String idUser);
	public User getUserInfoByName(String name);

}
