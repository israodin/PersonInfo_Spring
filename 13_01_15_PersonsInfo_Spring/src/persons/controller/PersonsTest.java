/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons.controller;
import persons.controller.*;
import persons.model.*;
import persons.view.*;
/**
 *
 * @author IsraOdin
 */
public class PersonsTest  implements Runnable{

    private Requestr requester;
    private PersonsInfoModel model;
    private PersonInfoView view;

    public PersonsTest(Requestr requester, PersonsInfoModel model, PersonInfoView view) {
        this.requester = requester;
        this.model = model;
        this.view = view;
    }
    
    
    @Override
    public void run() {
        Request request;
        String [] result;
        while ((request=requester.getRequest())!=null) {
            result = request.runRequest(model);
            view.show(result);
        }
    }
    
}
