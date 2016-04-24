package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import service.IHashingInterface;
import service.MD5;

public class UserTest {

	private User _user;
	
	@Before
	public void setup() {
		IHashingInterface hashing = new MD5();
		_user = new User("student", "studentii", hashing);
	}
	
	@Test
	public void testUserName() {
		assertEquals("student", _user.getName());
	}

}