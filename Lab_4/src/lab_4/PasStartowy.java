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
public class PasStartowy {
    private int numer;
    private boolean status;
    
    public PasStartowy(int i)
    {
        numer=i;
        status=false;
    }
    public void rezerwujPas()
    {
        status=true;
    }
    public void zwolnijPas()
    {
        status=false;
    }
            
    public boolean podajStatus()
    {
        return status;
    }
    public int podajNumer()
    {
        return numer;
    }
    
}
