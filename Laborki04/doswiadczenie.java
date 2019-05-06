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
public class doswiadczenie extends podwojneRozpraszanie {
    int rozmiar=0;
    double srednia;
      public ArrayList<String> tempSlownik = new ArrayList<String>();
      public ArrayList<Integer> tabZliczam = new ArrayList<Integer>();
     doswiadczenie() throws FileNotFoundException
     {
        super();
      
     }
     void tabHaszSize(int n)
     {
         rozmiar =n;
         tempSlownik.removeAll(tempSlownik);
        for (int i = 0; i<n; i++)
            tempSlownik.add(slownik.get(i));
        
         System.out.println("Wielkość slownika " + tempSlownik.size());
         
     }
     
     void test()
     {
         makeHaszTab(tempSlownik);
        
         for(int i = slownik.size()-1; i>= slownik.size()- 1001; i--)
         {
             setHaszTab(slownik.get(i));
             tabZliczam.add(zliczam);
         }
         Integer sum = 0;
 
     }
     void Srednia()
     {
         int suma=0;
        for( int i=0; i< tabZliczam.size(); i++)
            suma+= tabZliczam.get(i);
        srednia = (double)suma/tabZliczam.size();
         System.out.println("Srednia ilośc operacji przy wstawieniu 1000 slow " + srednia);    
     }
     
     
    
}
