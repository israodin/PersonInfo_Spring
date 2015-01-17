/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author IsraOdin
 */

public class ConsoleRequestr extends FileRequestr{
    
    public ConsoleRequestr(){
        in = new  BufferedReader(new  InputStreamReader(System.in));
    }
}
