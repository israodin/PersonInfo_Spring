/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons.controller;

/**
 *
 * @author IsraOdin
 */
import persons.model.*;
public class RemovePerson extends Request{

    @Override
    public String[] runRequest(PersonsInfoModel model) {
        String [] res =  new  String[1];
        int id = 0;
        try {
            id = Integer.parseInt(data[1]);
            if(model.removePerson(id))
                res[0] = " person with id "+id+" was  removed from  model";
            else
                res[0] = " person with id "+id+" was  not removed  from  model";
        } catch (NumberFormatException e) {
            res[0] = "wrong id "+id;
        }
        return res;
    }
    
    
}
