/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_4;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcin
 */
public class Samolot extends Thread {
    public int samolotId;
    private int poziomPaliwa;
    private int pasPostojowyId;
    private Lotnisko lotniskoCel;
    private Lotnisko lotniskoBiezace;
    private ArrayList<Lotnisko> listaLotnisk;
    
    public Samolot(ArrayList<Lotnisko> lista, int id)
    {
        listaLotnisk=lista;
        samolotId=id;
        for(Lotnisko lotnisko: listaLotnisk)
        {
            pasPostojowyId=lotnisko.rezerwujPas();
            if(pasPostojowyId>-1)
            {
                lotniskoBiezace=lotnisko;
                break;
            }
        }
    }
    
    public void ustawBiezace(Lotnisko l)
    {
        lotniskoBiezace=l;
        pasPostojowyId=0;
    }
 
    private void wybierzLotnisko()// dzaiła poprawnie
    {
        Random r= new Random();
        do
        {
            lotniskoCel=listaLotnisk.get(r.nextInt(listaLotnisk.size()));
        }while(lotniskoBiezace.podajId()==lotniskoCel.podajId());
    }
    private void startuj()
    {
       // lotniskoBiezace.
        lotniskoBiezace.zwolnijPas(pasPostojowyId);
        lotniskoBiezace=null;
        System.out.println("samolt nr " +this.samolotId+" wystartował");
    }
    private void podroz()
    {
        System.out.println("samolot numer "+this.samolotId+" leci");
    }
    private void laduj()
    {
        
        pasPostojowyId=-1;
        do
        {
           pasPostojowyId=lotniskoCel.rezerwujPas();
           if(pasPostojowyId==-1)
           {
               try {
                   Samolot.sleep(100);
               } catch (InterruptedException ex) {
                   Logger.getLogger(Samolot.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
        }while(pasPostojowyId==-1);
        /*
       boolean zgoda=false;
            // int licznik=0;
            do
            {  
                zgoda=lotniskoCel.pozwolenieLadowania();
                if(!zgoda)
                {
                    try {  
                        Samolot.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Samolot.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     System.out.println("oczrekiwanie na pozwolenie londowNIA");
                }
               
               // licznik++;
               // if(licznik==10)zgoda=true;
                
                
            }while(!zgoda);*/
            
            //postoj samolotu w metodzie
            System.out.println("samolot wylodował"+ this.samolotId);
            
    }
    private void postoj()
    {
        lotniskoBiezace=lotniskoCel;
        lotniskoCel=null;
        try {
                //lotniskoCel.postojSamolotu(this);
                lotniskoBiezace.postojSamolotu(this);
            } catch (InterruptedException ex) {
                Logger.getLogger(Samolot.class.getName()).log(Level.SEVERE, null, ex);
            } 
    }
    public void tankowanie(int i)
    {
        System.out.println("tankuje paliwo");
        poziomPaliwa=i;
    }
    
    @Override
   // @SuppressWarnings("empty-statement")
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        while(true)
        {
            /* w tej metodzie jest wysyłane zaputanie do llotniska czy ma wolne pasy 
            jezeli nie to watek jest wstrzymywany na kilka sekund w klejnej petli tak aby mozna było
            się jeszcze raz odpytac czy są waolne pasy
            jezeli tak tpo watek tez jest wstrzymywany  potem watek tankuje paliwo 
            losuje kolejne lotnisko i odlatuje petal powt\ar\a się jeszcze raz.
            */
            //lotniskoCel=this.wybierzLotnisko();
            this.wybierzLotnisko();
            this.startuj();
            this.podroz();
            this.laduj();
            this.postoj();
            
        }
    }
  
}
