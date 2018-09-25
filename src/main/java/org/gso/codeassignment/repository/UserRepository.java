/**
 * 
 */
package org.gso.codeassignment.repository;

import org.gso.codeassignment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author AhmedSalem
 *
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}