/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IsraOdin
 */

public class FileRequestr implements Requestr{

    BufferedReader in;
    public FileRequestr(){}
    public FileRequestr(String fileName){
        try {
            in = new BufferedReader(new  FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println(fileName+" not  found");
        }
    }
    @Override
    public Request getRequest() {
        Request request =  null;
        if(in!=null){
            
                String line;
            try {
                line = in.readLine();
                 if (line!=null && !line.equalsIgnoreCase("exit")){
                     String[] data = line.split(" ");
                     Class<?> cl =  Class.forName("persons.controller."+data[0]);
                     request=(Request)cl.newInstance();
                     request.data = data;
            }
            } catch (IOException ex) {
                System.out.println("Error during reading foile");
            } catch (Exception ex) {
                System.out.println("Wrong request name"); 
            }  
        }
        return request;
    }
    
}
