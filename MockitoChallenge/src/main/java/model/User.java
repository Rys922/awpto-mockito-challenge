package model;

import java.security.NoSuchAlgorithmException;

import service.*;

public class User {
	
	private String _name, _password, _salt;
	private IHashingInterface _hashing;
	
	public User(String name, String password, IHashingInterface hashing) {
		_name = name;
		_password = password;
		_hashing = hashing;
	}
	
	public void generateSalt(String randomText) throws NoSuchAlgorithmException {
		if (randomText.length() == 0) {
			throw new IllegalArgumentException();
		}
		_salt = _hashing.getHash(_name + randomText);
	}
	
	public String getName() {
		return _name;
	}
	
	public String getPassword() {
		return _password;
	}
	
	public String getSalt() {
		return _salt;
	}
	
	public String getHashedPassword() throws NoSuchAlgorithmException {
		return _hashing.getHash(getSalt() + getPassword());
	}
	
	public boolean comparePassword(String hashedPasswordToCompare) throws NoSuchAlgorithmException {
		return getHashedPassword().equals(hashedPasswordToCompare);
	}
	
}