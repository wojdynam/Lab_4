/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_4;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Marcin
 */

public class ObslugaSamolotu extends Thread {
    private Samolot samolot;
    
    public ObslugaSamolotu(Samolot s)
    {
        samolot=s;
        
    }
    
    

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
    }        
    
}
