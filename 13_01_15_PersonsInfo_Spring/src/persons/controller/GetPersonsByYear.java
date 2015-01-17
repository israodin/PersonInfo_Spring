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
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.util.List;
import persons.model.*;

public class GetPersonsByYear extends Request{

    @Override
    public String[] runRequest(PersonsInfoModel model) {
       String[]resStr =  new  String[0];
        try {
            List<Person> resList= model.getPersonsYears(Integer.parseInt(data[1]),Integer.parseInt(data[2]));
            resStr = new  String[resList.size()+1];
            resStr[0] =  "persons  born in the  year from "+data[1]+" to "+data[2];
            int ind=1;
            for (Person person : resList) {
                resStr[ind++]=person.toString();
            }
        } catch (NumberFormatException e) {
            
        }
        return resStr;
    }
    
}
