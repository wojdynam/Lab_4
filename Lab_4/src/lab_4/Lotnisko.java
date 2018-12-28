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
public class Lotnisko  {
    private int lotniskoId;
  //private PasStartowy pas = new PasStartowy(1);
  private ArrayList<PasStartowy> listaPasStartowy;
  public Lotnisko(int k,int n)
  {
      lotniskoId=k;
      listaPasStartowy = new ArrayList<PasStartowy>();
      for(int i=0;i<n;i++ )
      {
          listaPasStartowy.add(new PasStartowy(i));
      }
      //System.out.println("budowa obiektu lotnisko z liczbą pasów = "+listaPasStartowy.size());
  }
  public int podajId()
  {
      return lotniskoId;
  }
  public void zwolnijPas(int i)
  {
      for(PasStartowy p: listaPasStartowy)
     {
         if(p.podajNumer()==i)
         {
             p.zwolnijPas();
             System.out.println("zwalnianie pasa numer "+p.podajNumer()+"status :"+p.podajStatus()); 
            break;
         }
     }
    
  }
 
  //Samolot samolot;
  public int rezerwujPas()
  {
     // System.out.println("lotnisko pozwolenie lodowania");
     // System.out.println(pas.podajStatus());
      int numerPasa =-1;
     for(PasStartowy p: listaPasStartowy)
     {
        if(!p.podajStatus())
         {
            p.rezerwujPas();
            numerPasa=p.podajNumer();
            break;
         }
     }
     /* 
      
    if(!pas.podajStatus())  
    {
        pas.rezerwujPas();
        return true;
    }else
    {
        return false;
    }*/
    return numerPasa;
  }
 // @SuppressWarnings("empty-statement")
   public  void postojSamolotu(Samolot s) throws InterruptedException
  {
      System.out.println("samolot parkuje "+s.samolotId);
      
      synchronized(s){s.wait(1000);}
      
      
  }
    
    
}
