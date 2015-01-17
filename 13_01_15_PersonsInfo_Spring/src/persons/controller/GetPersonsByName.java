/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons.controller;

import java.util.List;
import persons.model.*;


/**
 *
 * @author IsraOdin
 */
public class GetPersonsByName extends Request{

    @Override
    public String[] runRequest(PersonsInfoModel model) {
        List<Person> resList =  model.getPersonsName(data[1]);
        String[] resStr = new  String[resList.size()+1];
        resStr[0]="persons with  name "+data[1];
        int ind =1;
        for(Person person : resList) {
                resStr[ind++]=person.toString();
            }
        return resStr;
    }
    
}
