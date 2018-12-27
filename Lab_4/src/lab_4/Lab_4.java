/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_4;

/**
 *
 * @author Marcin
 */
import java.util.ArrayList;

public class Lab_4 {

    /**
     * @param args the command line arguments
     */
    public  static ArrayList<Lotnisko> listaLotnisk;
    public static ArrayList<Samolot> listaSamolotow;
    public static void main(String[] args) {
        // TODO code application logic here
        listaLotnisk= new ArrayList<Lotnisko>();
        listaSamolotow = new ArrayList<Samolot>();
        for(int i=0;i<4;i++)
        {
            listaLotnisk.add(new Lotnisko(2));
        }
        for(int i=0;i<2;i++)
        {
           listaSamolotow.add(new Samolot(listaLotnisk));
        }
        for(Samolot s:listaSamolotow) 
        {
            s.start();
        }
        for(Lotnisko l:listaLotnisk)
        {
            //l.start();
            
        }
        //poczatkowe przypisanie samolotów do lotnisk
        listaLotnisk.get(0).obslugaSamolotu(listaSamolotow.get(0));
        listaLotnisk.get(1).obslugaSamolotu(listaSamolotow.get(1));
        
       
    }
    
}
