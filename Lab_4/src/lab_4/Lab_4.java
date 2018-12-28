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
      listaLotnisk.add(new Lotnisko(0,2));
      listaLotnisk.add(new Lotnisko(1,2));
      listaLotnisk.add(new Lotnisko(2,2));
      listaLotnisk.add(new Lotnisko(3,2));
      //pierwsze przypisanie samolotów do lotnisk
      int liczbaSamolotów=2;
      for(int i =0;i<liczbaSamolotów; i++)
      { 
         // int nr=-1;
         // int licznik=0;
         
          listaSamolotow.add(new Samolot(listaLotnisk,i));
          
         
      }
      for(Samolot s: listaSamolotow)
      {
          s.start();
      }
      /*
      Samolot samolot1 = new Samolot(listaLotnisk,1);
      samolot1.ustawBiezace(listaLotnisk.get(0));
      Samolot samolot2= new Samolot(listaLotnisk,2);
      samolot2.ustawBiezace(listaLotnisk.get(1));
      Samolot s3=new Samolot(listaLotnisk,3);
      s3.ustawBiezace(listaLotnisk.get(3));
              
              
              
      samolot1.start();
      samolot2.start();
      s3.start();*/
       
    }
    
}
