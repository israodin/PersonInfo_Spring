
package persons.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 *
 * @author IsraOdin
 */
public class PersonInfoMaps extends CommonCollectionMethods implements PersonsInfoModel{

    HashMap<Integer, Person> personsID;
    TreeMap<Integer, List<Person>> personsYear;
    HashMap<String, List<Person>> personsName;
    
    public PersonInfoMaps(String fileName) throws FileNotFoundException,ClassNotFoundException,IOException{
        super(fileName);
        personsID =  new  HashMap<Integer,Person>();
        personsYear = new TreeMap<Integer,List<Person>>();
        personsName =  new  HashMap<String,List<Person>>();
        restore();
    }

    
    @Override
    public boolean addPerson(Person person) {
        boolean res  =  false;
        int id =  person.getId();
        if(!personsID.containsKey(id)){
            personsID.put(id, person);
            addPersonsYear(person);
            addPersonsName(person);
            res = true;
        }
        return res;
        
    }

    private void addPersonsYear(Person person) {
        int year = person.getBirthYear();
        List<Person> persons = personsName.get(year);
        if(persons==null){
            persons =new  ArrayList<Person>();
            personsYear.put(year, persons);
        }
        persons.add(person);
    }

    private void addPersonsName(Person person) {
        String name =  person.getName();
        List<Person> persons = personsName.get(name);
        if(persons==null){
            persons =  new  ArrayList<Person>();
            personsName.put(name, persons);
        }
        persons.add(person);
    }
  

    @Override
    public Person getPersonId(int id) {
       return personsID.get(id);
    }

    @Override
    public List<Person> getPersonsYears(int minYear, int maxYear) {
       List<Person> res = new  ArrayList<Person>();
        NavigableMap<Integer,List<Person>> map = personsYear.subMap(maxYear, true, maxYear, true);
        mapToList(map,res);
        return res;
    }
    private void mapToList(NavigableMap<Integer, List<Person>> map, List<Person> res) {
        if(map!=null){
            Collection<List<Person>> lists = map.values();
            for (List<Person> list : lists) 
                res.addAll(list);
        }
    }
    @Override
    public List<Person> getPersonsName(String name) {
        List<Person> res = new  ArrayList<Person>();
        List<Person> tmp = personsName.get(name);
        if(tmp!=null)
            res = tmp;
        return res;
    }
  @Override
    public boolean removePerson(int id) {
        boolean res =  false;
        Person prs = personsID.remove(id);
        if(prs!=null){
            removePersonsYear(prs);
            removePersonsName(prs);
            res=true;
        }
        return res;
    }

    private void removePersonsYear(Person prs) {
        int year =  prs.getBirthYear();
        personsYear.get(year).remove(prs);
    }

    private void removePersonsName(Person prs) {
        String name = prs.getName();
        personsName.get(name).remove(prs);
    }

    
}
