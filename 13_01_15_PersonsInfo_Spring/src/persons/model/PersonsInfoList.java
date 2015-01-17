/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IsraOdin
 */
public class PersonsInfoList implements PersonsInfoModel{
    List<Person> persons;

    /**
     *
     */
    public PersonsInfoList() {
        persons = new ArrayList<Person>();
    }
    
    @Override
    public boolean addPerson(Person person) {
        boolean res =  false ;
        if(!persons.contains(person)){
            res =  true;
            persons.add(person);
        }
        return res;
    }

    @Override
    public boolean removePerson(int id) {
        Person pattern = new  Person(id, null, 0);
        return  persons.remove(pattern);
    }

    @Override
    public Person getPersonId(int id) {
        Person res =  null;
        for (Person prs : persons) {
             if(prs.getId()==id){
                 res = prs;
                 break;
             }   
             
            }
        return res;
    }

    @Override
    public List<Person> getPersonsYears(int minYear, int maxYear) {
        List<Person> res =  new  ArrayList<Person>();
        for (Person prs : persons) {
            int  year = prs.getBirthYear();
            if(year>=minYear && year<=maxYear)
                res.add(prs);
        }
        return res;
    }

    @Override
    public List<Person> getPersonsName(String name) {
        List<Person> res =  new  ArrayList<Person>();
        for (Person prs : persons) {
            String nameP = prs.getName();
            if(nameP.equals(name))
                res.add(prs);
        }
        return res;
    }
    
    
}
