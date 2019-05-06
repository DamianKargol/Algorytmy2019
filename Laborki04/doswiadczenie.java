/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablicahash;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/** Klasa doswiadczenie która Dziediczy po klasie podwojneRozpraszanie
 *  Klasa na której będziemy operować 
 *  Posiada dodatkowe metody potrzebne do wykonania doświadczenia 
 * 
 */
public class doswiadczenie extends podwojneRozpraszanie {
    int rozmiar=0;
    double srednia;
    // tymczasowa lista słów na której będziemy operowac
      public ArrayList<String> tempSlownik = new ArrayList<String>(); 
      // tablica dynamiczna która przechowują nam liczbe operacji wstawiania
      public ArrayList<Integer> tabZliczam = new ArrayList<Integer>(); 
     doswiadczenie() throws FileNotFoundException
     {
        super(); // odwłoanie sie do klasy nadrzędnej
      
     }
     // Metoda tworzy nam podaną wielkość tablicy ze słowami z wczytanego wcześniej pliku 
     void tabHaszSize(int n)  
     {
         rozmiar =n; // iloć słów do wczytania 
         tempSlownik.removeAll(tempSlownik);
         // wczytuje podaną ilość słó
        for (int i = 0; i<n; i++) 
            tempSlownik.add(slownik.get(i));
        
         System.out.println("Wielkość slownika " + tempSlownik.size());
         
     }
     // Metoda wykonująca test wstawiania do obecnej tablicy rozproszonej 1000 ostatnich slow z pliku
     void test() 
     {
         wyczyscHaszTab(); // funkcja czysci nam tablice rozproszoną przed nastepnym testem
         makeHaszTab(tempSlownik);  // metoda wypelnia tablice rozproszoną wslazaną wczesniej ilością slow
        
         for(int i = slownik.size()-1; i>= slownik.size()- 1001; i--) // pętla wstawia do tablicy rozproszonej 1000 ostanich slow z pliku
         {
             setHaszTab(slownik.get(i));
             tabZliczam.add(zliczam);
         }
         Integer sum = 0;
 
     }
     // Metoda obliczająca średnią ilośc operacji podczas wstawiania slow do tablicy
     // za pomocą tablicy dynamicznej tabZliczam
     void Srednia()
     {
         int suma=0;
         // pętla licząca sumę elementów w tablicy tabZliczam
        for( int i=0; i< tabZliczam.size(); i++) 
            suma+= tabZliczam.get(i);
        srednia = (double)suma/tabZliczam.size(); // szybkie policzenia średniej 
         System.out.println("Srednia ilośc operacji przy wstawieniu 1000 slow " + srednia);    
         tabZliczam.removeAll(tabZliczam); // zeruje tablicy aby była gotowa na nastepne dosiwadczenie 
     }
     
     
    
}
