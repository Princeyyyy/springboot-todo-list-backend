package com.backend.todolist.repository;

import com.backend.todolist.model.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
	Page<Todo> findByCompletedContaining(boolean country, Pageable pageable);
}
