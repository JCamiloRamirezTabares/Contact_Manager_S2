package model;

import java.util.ArrayList;
import java.util.List;

public class ContactManager {
	
	private List<Contact> contactList;

	public ContactManager() {
		contactList = new ArrayList<Contact>();
		contactList.add(new Contact("01", "Juan Camilo Ramirez Tabares", "juancaram21@gmail.com"));
	}
	
	public boolean addNewContact(Contact newContact) {
		
		if(contactList.add(newContact)) {
			return true;
		} else {
			return false;
		}
		
	}

	public List<Contact> getContactList() {
		return contactList;
	}
	

}
