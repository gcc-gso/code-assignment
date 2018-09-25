/**
 * 
 */
package org.gso.codeassignment.service;

import java.util.Arrays;
import java.util.HashSet;

import org.gso.codeassignment.entity.Role;
import org.gso.codeassignment.entity.User;
import org.gso.codeassignment.repository.RoleRepository;
import org.gso.codeassignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author AhmedSalem
 *
 */
@Service
public class UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;

	@Autowired
	public UserService(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User saveUser(User user) {
		user.setPassword(user.getPassword());
		user.setEnabled(true);
		Role userRole = roleRepository.findByRole("ADMIN");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		return userRepository.save(user);
	}
}
