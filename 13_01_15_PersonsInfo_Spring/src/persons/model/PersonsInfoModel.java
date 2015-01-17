/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons.model;

import java.util.List;

/**
 *
 * @author IsraOdin
 */
public interface PersonsInfoModel {

    boolean addPerson(Person person);
    boolean removePerson(int id);
    
    Person getPersonId(int id);
    List<Person> getPersonsYears(int  minYear,int maxYear);
    List<Person> getPersonsName(String name);
}
