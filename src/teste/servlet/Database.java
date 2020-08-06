package teste.servlet;

import java.util.ArrayList;
import java.util.List;


public class Database {
	
	private static List<Email> list = new ArrayList<>();

	static {
		
		Email email1 = new Email();
		email1.setEmail("test1@java.com");
		Email email2 = new Email();
		email2.setEmail("test2@java.com");
		list.add(email1);
		list.add(email2);
		
	}
	
    public void add(Email email) {
    	list.add(email);
    }
    
    public List<Email> getEmails(){ 
        return Database.list;
    }
    
}