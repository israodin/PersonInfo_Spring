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
import persons.controller.*;
import persons.model.*;

public class AddPerson extends Request{

    @Override
    public String[] runRequest(PersonsInfoModel model) {
        String [] res =  new  String[0];
        try {
            Person prs;
            prs = new Person(Integer.parseInt(data[1]),data[2],Integer.parseInt(data[3]));
            if(model.addPerson(prs)){
                res = new  String[1];
                res[0]=prs.toString()+"was added to  model";
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return res;
     }
    
}
