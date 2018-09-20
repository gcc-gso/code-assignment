# code-assignment
Java Developer Code Assignment

Clone this repository, complete the following assingment and submit a pull request.

### Write a Spring Boot based REST API for 'TODO list' application with following endpoints

1. List todo items - most recent and pending first:  
  * URL: http://localhost:8080/todo/items
  * Input: None
  * Output: List<Item>
  * Authorized Role: USER
   
2. Get todo item:  
 * URL: http://localhost:8080/todo/items/{itemId}
 * Input: itemId
 * Output: Item
 * Authorized Role: USER
   
3. Add todo item: 
* URL: http://localhost:8080/todo/items
* Input: Item
* Output: None
* Authorized Role: USER
   
4. Remove todo item: 
* URL: http://localhost:8080/todo/items/{itemId}
* Input: itemId
* Output: None
* Authorized Role: USER
   
5. Update todo item as done: 
* URL: http://localhost:8080/todo/items/{itemId}
* Input: None
* Output: None
* Authorized Role: USER
   
6. List all todo items - most recent and pending first: 
* URL: http://localhost:8080/todo/items/all
* Input: None
* Output: List<Item>
* Authorized Role: ADMIN

**Write integration tests covering all 6 endpoints.**

TODO Item and Comment definition is :-

```
public class Item implements Serializable{
	private Integer itemId;
	private String todo;
	private Boolean done;
	private Integer userId; // created by
	private Date createdOn;

	// getters and setters ...
}

```

* Items should be saved to database. You can use embedded H2 database.
* Users with role **USER can access endpoints 1-5** to manage **their own personal** TODO items.
* Users with role **ADMIN can access endpoint 6** to list TODO items from all users.
* Application has following users.
  * Ahmad with role (USER, ADMIN)
  * Belal with role USER 
* You can use in memory user store of Spring Security for users and roles.
* Create a simple UI to 
  * Show logged in User
  * List Todo Items of logged in User
  * Option to Add new item, Remove Item and Mark the Item as Done
  * List All Items (for ADMIN only)
  
