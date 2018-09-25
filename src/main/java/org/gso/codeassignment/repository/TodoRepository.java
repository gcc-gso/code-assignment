/**
 * 
 */
package org.gso.codeassignment.repository;

import java.util.List;

import org.gso.codeassignment.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author AhmedSalem
 *
 */
@Repository
public interface TodoRepository extends JpaRepository<Item, Long> {

	@Query(value = "SELECT * from Item i ORDER BY i.CREATED_ON desc", nativeQuery = true)
	public List<Item> findRecentItems();
	
	@Query(value = "select i.* from item i , users_roles ur where i.user_id = ur.user_id and ur.role_id = 2", nativeQuery = true)
	public List<Item> findAdminItems();

}
