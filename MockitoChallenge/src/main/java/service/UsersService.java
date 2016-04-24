package service;

import java.util.ArrayList;
import java.util.List;

import model.*;

public class UsersService {
	
	private List<User> _users;
	
	public UsersService() {
		_users = new ArrayList<User>();
	}
	
	public String getRandomText() {
		return Long.toString(System.nanoTime());
	}
	
	public boolean add(User userEntity) {
		try {
			if (_users.add(userEntity)) {
				userEntity.generateSalt(getRandomText());
				return true;
			}
		}
		catch (Exception e) {
		}
		return false;
	}
	
	public User get(int i) {
		return _users.get(i);
	}
	
	public int getSize() {
		return _users.size();
	}
	
}