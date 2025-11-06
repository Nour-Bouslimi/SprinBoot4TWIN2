package com.esprit.Dependency.tpDependencyInjection.controller;

import java.util.List;
import com.esprit.Dependency.tpDependencyInjection.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller //ky nebda bch nconsommi fy wost lprojet ne5dem b @Controller si non b @RestController
public class ToDoController {
	@Autowired
	ToDoService toDoService;

	public List<String> getCoursesList() {
		return toDoService.getCoursesList();
	}
}
