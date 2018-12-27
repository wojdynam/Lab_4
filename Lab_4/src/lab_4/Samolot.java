/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_4;

import java.util.ArrayList;

/**
 *
 * @author Marcin
 */
public class Samolot extends Thread {
    private ArrayList<Lotnisko> listaLotnisk;
    private Lotnisko lotniskoCel;
    public Samolot(ArrayList l)
    {
       listaLotnisk=l; 
       System.out.println("powołanie obiektu Samolot");
    }
    private void wybierzLotnisko()
    {
        lotniskoCel=listaLotnisk.get(1);
        System.out.println("samolot numer : "+this.getId()+" losuje lotnisko");
    }
    

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        while(true)
        {
           wybierzLotnisko();
           lotniskoCel.obslugaSamolotu(this);
           System.out.println(lotniskoCel.isAlive());
           
        }
    }
    
    
}
