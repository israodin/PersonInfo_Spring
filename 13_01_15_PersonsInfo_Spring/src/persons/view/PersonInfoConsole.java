/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons.view;

/**
 *
 * @author IsraOdin
 */
public class PersonInfoConsole implements PersonInfoView{

    private boolean flShowing = true;
    public PersonInfoConsole(){}
    public PersonInfoConsole(boolean flShowing){
        this.flShowing = flShowing;
    }
    @Override
    public String show(String[] lines) {
        if(flShowing)
            for (int i = 0; i < lines.length; i++) {
                System.out.println(lines[i]);
                
            }
        return null;
    }
    
}
