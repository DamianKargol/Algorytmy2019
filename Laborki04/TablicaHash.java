/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablicahash;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class TablicaHash {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        doswiadczenie d = new doswiadczenie(); // inicjowanie obiektu
            Scanner odczyt = new Scanner(System.in);
            Scanner odczyt1 = new Scanner(System.in);
        
      
      
        // Prostoe Menu
        int m;
        while(true)
        {
        System.out.println("Menu");
        System.out.println("1 - Stworz tablice Rozproszoną  w oparciu o sondowanie Liniowe");
        System.out.println("2 - Stwórz tablice Rozproszoną w oparaciu o  sondowanie z podwojnym rozpraszaniem");
        System.out.println("3 - Doświadczenia mierzące średnią ilosć operacji z wstawienia  100 słow do tablicy");
        m = odczyt.nextInt();
        if(m==1)
        {
           
            d.makeHaszTab(d.slownik);
             while(true)
            {
                System.out.println("");
                System.out.println("Wstaw słowo - 1 || Wyszukaj - 2 || 3 - Wyjdź");
                int m1= odczyt.nextInt();
                    if(m1==1)
                    {
                        System.out.println("Podaj słowo");
                        String tekst = odczyt1.nextLine();
                        
                        d.setHaszTab(tekst);
                    }
                           if(m1==2)
                    {
                        System.out.println("Podaj słowo");
                        String tekst = odczyt1.nextLine();
                        d.getHasztab(tekst);
                    }
                    if(m1==3) 
                        break;
                    }    
            
        }
        
        if(m==2)
        {
           
            d.makeHaszTabRozp(d.slownik);
             while(true)
            {
                System.out.println("");
                System.out.println("Wstaw słowo - 1 || Wyszukaj - 2 || 3 - Wyjdź");
                int m1= odczyt.nextInt();
                    if(m1==1)
                    {
                        System.out.println("Podaj słowo");
                        String tekst = odczyt1.nextLine();
                        
                        d.setHaszTabRozp(tekst);
                    }
                           if(m1==2)
                    {
                        System.out.println("Podaj słowo");
                        String tekst = odczyt1.nextLine();
                        d.getHasztabRozp(tekst);
                    }
                    if(m1==3) 
                        break;
                    }    
            
        }
        
        if(m==3)
        {
            while(true)
            {
            System.out.println("");
            System.out.println("Podaj wielkosć tablicy Haszującej");
            int n = odczyt.nextInt();
                    d.tabHaszSize(n);
                    d.test();
                    d.Srednia();
                    System.out.println("Nacisnij 0 aby wyjsc 1 kontynuuj");
                    m = odczyt.nextInt();
                    if(m==0)
                        break;
            }
        }
        
        System.out.println("Nacisnij 0 aby wyjsc 1 konynuuj");
         m = odczyt.nextInt();
         if (m==0) 
             break;
    }
              d.SaveHasztab();
              System.exit(3);
    }
}
