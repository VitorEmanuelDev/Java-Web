package br.com.task.manager.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Database {
	
	private static List<Task> list = new ArrayList<>();
	private static Integer sequentialKey = 1;
	
	static {
		Task task = new Task();
		task.setId(sequentialKey++);
		task.setContent("Sleep before _____");
		Task task2 = new Task();
		task2.setId(sequentialKey++);
		task2.setContent("Talk to ______");
		list.add(task);
		list.add(task2);
	}

	public void adiciona(Task task) {
		task.setId(Database.sequentialKey++);
		Database.list.add(task);
	}
	
	public List<Task> getTasks(){
		return Database.list;
	}

	public void removeTask(Integer id) {
		
		Iterator<Task> it = list.iterator();
		
		while(it.hasNext()) {
			Task emp = it.next();
			
			if(emp.getId() == id) {
				it.remove();
			}
		}
	}

	public Task loofForTaskById(Integer id) {
		for (Task task : list) {
			if(task.getId() == id) {
				return task;
			}
		}
		return null;
	}

}
