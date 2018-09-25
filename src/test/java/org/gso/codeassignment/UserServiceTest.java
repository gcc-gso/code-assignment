/**
 * 
 */
package org.gso.codeassignment;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.HashSet;

import org.gso.codeassignment.entity.Role;
import org.gso.codeassignment.entity.User;
import org.gso.codeassignment.repository.RoleRepository;
import org.gso.codeassignment.repository.UserRepository;
import org.gso.codeassignment.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author AhmedSalem
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Mock
	private UserRepository mockUserRepository;
	@Mock
	private RoleRepository mockRoleRepository;

	private UserService userServiceUnderTest;
	private User user;

	@Before
	public void setUp() {
		initMocks(this);
		userServiceUnderTest = new UserService(mockUserRepository, mockRoleRepository);
		// user =
		// User.builder().id(1).name("Gustavo").lastName("Ponce").email("test@test.com").build();
		HashSet<Role> roles = new HashSet<Role>();
		roles.add(new Role(10, "Admin"));
		user = new User(10l, "Ahmed", "Salem", "test@test.com", "1600", true, false, roles);

		Mockito.when(mockUserRepository.save(any())).thenReturn(user);
		Mockito.when(mockUserRepository.findByEmail(anyString())).thenReturn(user);
	}

	@Test
	public void testFindUserByEmail() {
		// Setup
		final String email = "test@test.com";

		// Run the test
		final User result = userServiceUnderTest.findUserByEmail(email);

		// Verify the results
		assertEquals(email, result.getEmail());
	}

	@Test
	public void testSaveUser() {
		// Setup
		final String email = "test@test.com";

		HashSet<Role> roles = new HashSet<Role>();
		roles.add(new Role(20, "Admin"));
		User inuser = new User(20l, "Ahmed", "Salem", email, "1600", true, false, roles);

		// Run the test
		User result = userServiceUnderTest.saveUser(inuser);

		// Verify the results
		assertEquals(email, result.getEmail());
	}

}
