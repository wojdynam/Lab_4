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
public class Lotnisko extends Thread {
    private ArrayList< Boolean> listaPasStartowy;
    private Samolot samolot;//tymczasowe dla testów
    private ArrayList<Samolot> listasamolotow;
 
    public Lotnisko( int n)
    {
        System.out.println("tworzenie obiektu lotniska");
        listaPasStartowy= new ArrayList<>();
        for (int i=0;i<n;i++)
        {
            listaPasStartowy.add(new Boolean(false));
        }
    }
    public void obslugaSamolotu(Samolot s)
    {
        samolot=s;
    }

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        while(true)
        {
            System.out.println("lotniskooo");
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Lotnisko.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
}
