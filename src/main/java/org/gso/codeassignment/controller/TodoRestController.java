/**
 * 
 */
package org.gso.codeassignment.controller;

import java.util.List;

import org.gso.codeassignment.entity.Item;
import org.gso.codeassignment.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AhmedSalem
 *
 */
@RestController
@RequestMapping("/todo")
public class TodoRestController {

	@Autowired
	TodoService todoService;

	public void setTodoService(TodoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping("/items")
	public List<Item> getTodoList() {
		List<Item> items = todoService.retrieveItems();
		return items;
	}
	
	@GetMapping("/items/all")
	public List<Item> getAllTodoList() {
		List<Item> items = todoService.retrieveMostRecentPendingItems();
		return items;
	}

	@GetMapping("/items/{id}")
	public Item getTodoItem(@PathVariable(name = "id") Long id) {
		return todoService.getItem(id);
	}

	@PostMapping("/items/new")
	public void saveTodoItem(Item item) {
		todoService.saveItem(item);
		System.out.println("Todo Item Saved Successfully");
	}

	@DeleteMapping("/items/{id}")
	public void deleteTodoItem(@PathVariable(name = "id") Long id) {
		todoService.deleteItem(id);
		System.out.println("Todo Item Deleted Successfully");
	}

	@PutMapping("/items/{id}")
	public void updateEmployee(@RequestBody Item item, @PathVariable(name = "id") Long id) {
		Item myItem = todoService.getItem(id);
		if (myItem != null) {
			todoService.updateItem(myItem);
		}

	}

}
