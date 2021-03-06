package TaskManager.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Database {
	
	private static List<Task> List = new ArrayList<>();
	private static List<User> UserList = new ArrayList<>();
	private static Integer sequentialkey = 1;
	
	static {
		Task task = new Task();
		task.setId(sequentialkey++);
		task.setDescription("Estudar Java");
		Task task2 = new Task();
		task2.setId(sequentialkey++);
		task2.setDescription("Assistir Bacurau");
		List.add(task);
		List.add(task2);
		
		User user1 = new User();
		user1.setLogin("Vitor");
		user1.setPassword("12345");
		User user2 = new User();
		user2.setLogin("Visitor");
		user2.setPassword("54321");
		
		UserList.add(user1);
		UserList.add(user2);
	}

	public void add(Task task) {
		task.setId(Database.sequentialkey++);
		Database.List.add(task);
	}
	
	public List<Task> getTask(){
		return Database.List;
	}

	public void removeTask(Integer id) {
		
		Iterator<Task> it = List.iterator();
		
		while(it.hasNext()) {
			Task emp = it.next();
			
			if(emp.getId() == id) {
				it.remove();
			}
		}
	}

	public Task lookForTaskById(Integer id) {
		for (Task task : List) {
			if(task.getId() == id) {
				return task;
			}
		}
		return null;
	}

	public User userExists(String login, String password) {
		for(User user : UserList) {
			if(user.isEqual(login, password)) {
				return user;
			}
		}
		return null;
	}

}
