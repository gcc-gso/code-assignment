package org.gso.codeassignment.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author AhmedSalem
 *
 */
@Entity
@Table(name = "ITEM")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;
	@Column(name = "TODO")
	private String todo;
	@Column(name = "DONE")
	private Boolean done;
	@Column(name = "USER_ID")
	private Integer userId; // created by
	
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
	@Column(name = "CREATED_ON")
	private Date createdOn;

	/**
	 * 
	 */
	public Item() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param itemId
	 * @param todo
	 * @param done
	 * @param userId
	 * @param createdOn
	 */
	public Item(Long itemId, String todo, Boolean done, Integer userId, Date createdOn) {
		super();
		this.itemId = itemId;
		this.todo = todo;
		this.done = done;
		this.userId = userId;
		this.createdOn = createdOn;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

}
