/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons.controller;

import persons.model.*;

/**
 *
 * @author IsraOdin
 */
public abstract class Request {
    protected String [] data;
    public abstract String[] runRequest(PersonsInfoModel model);
}
