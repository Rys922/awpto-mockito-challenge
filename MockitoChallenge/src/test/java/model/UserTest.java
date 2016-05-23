package model;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import service.IHashingInterface;
import service.MD5;

public class UserTest {

	private User _user;
	User mockedUser;
	
	@Before
	public void setup() throws NoSuchAlgorithmException {
		IHashingInterface hashing = new MD5();
		_user = new User("student", "studentii", hashing);
		_user.generateSalt("Rys");
		
		mockedUser = Mockito.mock(User.class);
		Mockito.when(mockedUser.getSalt()).thenReturn(hashing.getHash(_user.getName() + "Rys"));
	}
	
	@Test
	public void testUserName() {
		assertEquals("student", _user.getName());
	}
	
	@Test
	public void testUserPassword() {
		assertEquals("studentii", _user.getPassword());
	}
	
	@Test
	public void testUserSalt() {
		assertEquals(mockedUser.getSalt(), _user.getSalt());
	}

}