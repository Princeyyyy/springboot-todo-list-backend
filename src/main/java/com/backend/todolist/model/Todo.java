package com.backend.todolist.model;


import jakarta.persistence.*;

@Entity
@Table(name = "_todoitems")
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "title")
	private String name;
	@Column(name = "completed")
	private boolean completed;

	public Todo() {
	}

	public Todo(String name, boolean completed) {
		this.name = name;
		this.completed = completed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
}
