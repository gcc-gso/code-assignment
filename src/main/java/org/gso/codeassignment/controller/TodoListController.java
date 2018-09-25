package org.gso.codeassignment.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.gso.codeassignment.entity.Item;
import org.gso.codeassignment.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TodoListController {

	@Autowired
	TodoService todoService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println(">>>>>>called");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));

	}

	@RequestMapping(value = "/todolist", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("todolist", todoService.retrieveItems());
		return "todolist";
	}

	@RequestMapping(value = "/todolist/adminList", method = RequestMethod.GET)
	public String adminlist(Model model) {
		model.addAttribute("todolist", todoService.retrieveAdminItems());
		return "todolist";
	}

	@RequestMapping("todolist/show/{id}")
	public String showProduct(@PathVariable Long id, Model model) {
		model.addAttribute("todoItem", todoService.getItem(id));
		return "todoshow";
	}

	@RequestMapping("todolist/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("todo", todoService.getItem(id));
		return "todoform";
	}

	@RequestMapping("todolist/new")
	public String newProduct(Model model) {
		model.addAttribute("todo", new Item());
		return "todoform";
	}

	@RequestMapping(value = "todo", method = RequestMethod.POST)
	public String saveProduct(Item item) {
		todoService.saveItem(item);
		return "redirect:/todolist/show/" + item.getItemId();
	}

	@RequestMapping("todolist/delete/{id}")
	public String delete(@PathVariable Long id) {
		todoService.deleteItem(id);
		return "redirect:/todolist";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

}
