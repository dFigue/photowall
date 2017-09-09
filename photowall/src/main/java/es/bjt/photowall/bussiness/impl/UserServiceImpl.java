package es.bjt.photowall.bussiness.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.bjt.photowall.bussiness.interfaces.UserService;
import es.bjt.photowall.dto.interfaces.UserRepository;
import es.bjt.photowall.model.User;

@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.saveUser(user);
	}

	@Override
	public User getUserInfoById(String idUser) {
		// TODO Auto-generated method stub
		return userRepository.getUserInfoById(idUser);
	}
	
	@Override
	public User getUserInfoByName(String name) {
		// TODO Auto-generated method stub
		return userRepository.getUserInfoByName(name);
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	

}
