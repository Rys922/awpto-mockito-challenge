package service;

import java.security.NoSuchAlgorithmException;

public interface IHashingInterface {

	public String getHash(String input) throws NoSuchAlgorithmException;
	
}