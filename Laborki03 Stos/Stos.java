package laborki03stos;

import java.util.ArrayList;
import java.util.List;

/*
 * #############################################
 *  Implementacja Stosu jak tablice dynamiczną 
 * #############################################
 */

/**
 *
 * @author Lenovo
 */
public class Stos {
    ArrayList stos; // tablica dynamiczna ktora bedzie naszym stosem
    int licznik=0;
    Stos() //  konstruktor tworzocy stos jako tablice
    {
         stos = new ArrayList();
    }
    boolean  isempty() // sprwadzenie czy stos pusty
    {
        if (licznik ==0)
            return true;
        else 
            return false;
        
    }
    Object top() // zwroc zawartosc na szczycie stosu
    {
        
       
        if(licznik >0)
        {
            return   stos.get(licznik-1);
        }
        else 
            return null;
        
        
    }
 
    void push(int liczba) // dodaj do stosu 
            // rzutowanie wszystkiego na String zapobiega dalszemu problemowi konwersji danych
    {
        if(licznik == 30) // ustawiony limit stosu na 30
            System.out.println("Stos jest pełen");
        if(licznik < 30)
        {
            stos.add(Integer.toString( liczba));
            licznik++;
        }
        
    }
        void push(double liczba)
    {
        if(licznik == 30) // ustawiony limit stosu na 30
            System.out.println("Stos jest pełen");
        if(licznik < 30)
        {
            stos.add(Double.toString( liczba));
            licznik++;
        }
        
    }
        void push(String liczba)
    {
        if(licznik == 30) // ustawiony limit stosu na 30
            System.out.println("Stos jest pełen");
        if(licznik < 30)
        {
            stos.add(liczba);
            licznik++;
        }
        
    }
        void push(char liczba)
    {
        if(licznik == 30) // ustawiony limit stosu na 30
            System.out.println("Stos jest pełen");
        if(licznik < 30)
        {
            stos.add(liczba);
            licznik++;
        }
        
    }
    void pop() // pokaz z gory i usun ostatni
    {
        
        
        if(licznik > 0)
        {     
            stos.get(licznik-1);
            stos.remove(--licznik);
        }
        
    }
    void size() // wielkosc stosu
    {
        System.out.println("wielkość stosu to " +licznik);
    }
}
