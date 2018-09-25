/**
 * 
 */
package org.gso.codeassignment.service.impl;

import java.util.List;
import java.util.Optional;

import org.gso.codeassignment.entity.Item;
import org.gso.codeassignment.repository.TodoRepository;
import org.gso.codeassignment.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author AhmedSalem
 *
 */
@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoRepository todoRepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.gso.codeassignment.service.TodoService#retrieveItems()
	 */
	@Override
	public List<Item> retrieveItems() {

		return todoRepo.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.gso.codeassignment.service.TodoService#getItem(java.lang.Long)
	 */
	@Override
	public Item getItem(Long ItemId) {
		Optional<Item> optItem = todoRepo.findById(ItemId);
		return optItem.get();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.gso.codeassignment.service.TodoService#saveItem(org.gso.codeassignment.
	 * entity.Item)
	 */
	@Override
	public void saveItem(Item Item) {
		todoRepo.save(Item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.gso.codeassignment.service.TodoService#deleteItem(java.lang.Long)
	 */
	@Override
	public void deleteItem(Long ItemId) {
		todoRepo.deleteById(ItemId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.gso.codeassignment.service.TodoService#updateItem(org.gso.codeassignment.
	 * entity.Item)
	 */
	@Override
	public void updateItem(Item Item) {
		todoRepo.save(Item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.gso.codeassignment.service.TodoService#retrieveMostRecentPendingItems()
	 */
	@Override
	public List<Item> retrieveMostRecentPendingItems() {
		return todoRepo.findRecentItems();
	}

	/* (non-Javadoc)
	 * @see org.gso.codeassignment.service.TodoService#retrieveAdminItems()
	 */
	@Override
	public List<Item> retrieveAdminItems() {
		return todoRepo.findAdminItems();
	}

}
