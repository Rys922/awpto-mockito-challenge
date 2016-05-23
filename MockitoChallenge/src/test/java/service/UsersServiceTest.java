package service;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import model.User;

public class UsersServiceTest {

	@Mock UsersService _usersService;
	@Mock User w;
	
	@Before
    public void setup() {
		MockitoAnnotations.initMocks(this);
		_usersService = new UsersService();
		IHashingInterface _hashing = new MD5();
		w = Mockito.spy(new User("a", "b", _hashing));
    }
	
	@Test
	public void test() throws NoSuchAlgorithmException {
		_usersService.add(w);
		Mockito.verify(w, Mockito.times(1)).generateSalt(Mockito.anyString());
	}

}