package de.telran.contacts.repository;

import de.telran.contacts.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

// TODO implement the class via what ever you want, eg. HashMap or ArrayList under the hood.
// AND TESTS!!!
@Repository
public class InMemoryContactRepo implements IContactRepo {

//    HashMap<Integer, Contact> source;
//    ArrayList< Contact> source;

    private HashMap<Integer, Contact> contactsMap = new HashMap<Integer, Contact>();

    @Override
    public void save(Contact contact) {
        int newId = contactsMap.keySet().stream().mapToInt(k -> k).max().getAsInt()+1;
        for(Integer key : contactsMap.keySet()){
            if(contact.getId() != key){
                contactsMap.put(newId, contact);
            }
        }
    }

    @Override
    public Contact find(int id) {
        return contactsMap.get(id);
    }

    @Override
    public Contact remove(int id) {
        return contactsMap.remove(id);
    }

    @Override
    public List<Contact> findAll() {
        List<Contact> contactsList = new ArrayList<>();
        return contactsList = contactsMap.values().stream().collect(Collectors.toList());
    }
}
