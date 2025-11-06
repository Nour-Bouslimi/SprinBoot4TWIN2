package com.esprit.Dependency.tpDependencyInjection.services;

import java.util.List;
import com.esprit.Dependency.tpDependencyInjection.dao.IToDoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

	@Autowired
	@Qualifier("toDoDao2")   // ma3neha lawlawya l classe toDoDao2 bch tete5dem hya
	private IToDoDao toDo;

	public List<String> getCoursesList() {
		return toDo.getCoursesList();
	}
}
