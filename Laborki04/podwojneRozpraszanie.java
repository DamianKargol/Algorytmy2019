/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablicahash;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class podwojneRozpraszanie extends haszuj {
    int k=0;
    podwojneRozpraszanie () throws FileNotFoundException
    {
        super();
    }
    
    int HaszDodatkowy(int klucz, int k)
    {
        h=0;
       
        h = (klucz + k*klucz%7)% tabHasz.length;;
        return h;
    }
    void makeHaszTabRozp (ArrayList slownik)
    {
         System.out.println("której funkcji użyć hasz1 - 1 czy hasz2 - 2");
        wybor = wybor(3);
        // zaczynamy wypełnianie tablicy
         for(int i = 0; i < slownik.size(); i++)
         {
            slowo = (String) slownik.get(i);
            if(wybor ==1)
            h = Hasz1(slowo);
            if(wybor==2)
            h= Hasz2(slowo);    
            System.out.println("wynik klucza to " + h );
            j = h;
            while(true)
            {
              if(tabHasz[j] == "")
              {
                tabHasz[j] = slowo;
                break;
              }
              if(tabHasz[j].equals(slowo) == true)
              { 
                  System.out.println("Wykryto Duplikat");
                  break;
              }
              j = HaszDodatkowy(h,k) % tabHasz.length;
              k++;
              if(j == h) break;
            }
         }
    }
    void setHaszTabRozp(String tekst)
    {
            int c=0;
            slowo = tekst;
            if(wybor ==1)
            h = Hasz1(slowo);
            if(wybor==2)
            h= Hasz2(slowo);
            System.out.println("wynik klucza to " +h);
            j = h;
            System.out.println("slowo do wstawienia to " +tekst);
            while(true)
            {
              if(tabHasz[j] == "")
              {
                  System.out.println("Wstawiam do indeksu " +j + "ilosc petli " + c);
                tabHasz[j] = tekst;
                break;
              }
              if(tabHasz[j].equals(tekst) == true)
              { 
                  System.out.println("Wykryto duplikat");
                  break;
              }
                ;
             j = HaszDodatkowy(h,k) % tabHasz.length;
              k++;
              if(j == h) break;
              c++;
            }
    }
        void getHasztab(String tekst)
        {
            slowo = tekst;
            if(wybor ==1)
            h = Hasz1(slowo);
            if(wybor==2)
            h= Hasz2(slowo);
            System.out.println("wynik klucza dla slowa " + slowo + " = " + h);
            j = h;
            
            int ilosPetliWhile = 0;
            while(true)
            {
                if(tabHasz[j] == "")
              {
                  System.out.println("Brak słowa ilosc petli to " + ilosPetliWhile);
                  break;
              }    
                if(tabHasz[j].equals(slowo)== true)
              {
                    System.out.println(slowo + "ma indeks " + j);
                    System.out.println("Ilosc operacji " + ilosPetliWhile);
                    break;
              }

              j = HaszDodatkowy(h,k) % tabHasz.length;
              k++;
              if(j == h) break;
              ilosPetliWhile++;
            }
        }

}
