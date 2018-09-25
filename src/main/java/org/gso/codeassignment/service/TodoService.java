/**
 * 
 */
package org.gso.codeassignment.service;

import java.util.List;

import org.gso.codeassignment.entity.Item;

/**
 * @author AhmedSalem
 *
 */
public interface TodoService {

	public List<Item> retrieveItems();
	public List<Item> retrieveAdminItems();
	
	public List<Item> retrieveMostRecentPendingItems();

	public Item getItem(Long ItemId);

	public void saveItem(Item Item);

	public void deleteItem(Long ItemId);

	public void updateItem(Item Item);

}
