
package persons.controller;

/**
 *
 * @author IsraOdin
 */
import org.omg.CORBA.DATA_CONVERSION;
import persons.model.*;
public class GetPersonById extends Request{
   

    @Override
    public String[] runRequest(PersonsInfoModel model) {
       String [] resStr =  new  String[2];
        resStr[0]="person with  id "+data[1];
        try {
            Person person = model.getPersonId(Integer.parseInt(data[1]));
            if (person!=null) {
                resStr[1]=person.toString();
            }else
                resStr[1] = "not found!";
        } catch (NumberFormatException e) {
        }
  return resStr;
  }
    
}
