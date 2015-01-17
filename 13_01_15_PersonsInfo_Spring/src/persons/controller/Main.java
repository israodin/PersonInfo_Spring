/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons.controller;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import persons.controller.*;
import persons.model.*;
/**
 *
 * @author IsraOdin
 */
public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext ctx = new  FileSystemXmlApplicationContext("beans.xml");
    Runnable test = (Runnable)ctx.getBean("test");
    test.run();
    ctx.close();
    }
    
}
