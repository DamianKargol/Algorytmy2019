/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laborki03stos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Lenovo
 */
public class onp {
    
    ArrayList wejscie = new ArrayList(); // tablica dynamiczna sluzaca jako wejscie
    ArrayList wyjscie = new ArrayList(); // tablica dynamiczna sluzaca jako wyjcie
    Stos s = new Stos(); // inicjowanie obiektu stosu
    String dana; // zmienna do przechowywania obecnej wartosci wejscia
    String wiersz; // zmienna przechowująca dane wiersz z pliku
   void ZmienPlikNaONP() throws FileNotFoundException
    {
        // pobieranie danych z pliku odzielonych spacjami
        File plik = new File("rownania.txt");
        Scanner odczyt = new Scanner(plik);
         while (odczyt.hasNextLine()) // petla while bedzie sie wykonywac do konca pliku
        {
            wiersz = odczyt.nextLine(); // wczytanie wierza do stringa
            StringTokenizer stringTokenizer = new StringTokenizer(wiersz, " "); // ustawienie tokena do wylapywania stringa i spacji
        while(stringTokenizer.hasMoreTokens()) // pętla wczytująca stringa odzielonego spacją do kolejnych miejsc w tablicy
        {
            wejscie.add(stringTokenizer.nextToken()); 
            
        }
        //#########################
        //po wczytaniu jednego wiersza do talicy wejsciowej
        // nastepuje konwersja na postfix i zapisanie do pliku "odwrotna notacja polska"
        // aż do konca pliku 
        //
        //#############################
           stworzonp();
           save();
           reset();

        }

      
    }
    void pokazwejscie()
    {
        for(int i =0; i < wejscie.size(); i++)
            System.out.print(wejscie.get(i));
    }
    void wyjsciesize()
    {
        System.out.println(wejscie.size());
    }
    void reset()
    {
        while(s.isempty()==false)
        {
            s.pop();
        }
        wejscie.removeAll(wejscie);
        wyjscie.removeAll(wyjscie);
        
    }
    // Metoda wczytująca plik z notacją postfix
    // i obliczająca rownania
    // zapisuje do piku Wyniki_Onp 
    void wczytajOnp() throws FileNotFoundException
    {
        File plik = new File("Odwrotna notacja Polska.txt");
        Scanner odczyt = new Scanner(plik);
         while (odczyt.hasNextLine()) // petla while bedzie sie wykonywac do konca pliku
        {
            wiersz = odczyt.nextLine();
            StringTokenizer stringTokenizer = new StringTokenizer(wiersz, " ");
        while(stringTokenizer.hasMoreTokens())
        {
            wejscie.add(stringTokenizer.nextToken());
            
        }
         obliczOnp();
         saveWynikiOnp();
         reset();
    }
    }
    //#####################
    // Metoda zmieniająca zapis infix na Postfix
    // ######################
    // znaki operatory działania są zakodowanie ręcznie jako string i sprawdzane
    void stworzonp()
    {
        
        for(int i =0; i < wejscie.size(); i++) // pętla wczytująca eleemnty talibcy wejscie
        {
             dana = (String) wejscie.get(i);
             System.out.println(dana);
             if(dana.equals("=")==true)
             {
                 while(s.isempty()== false)
                 {
                     wyjscie.add(s.top());
                     s.pop();
                 }
               continue;
             }
                
    
                 if(dana.equals(" ")==true)
                     continue;
                 if(dana.equals("(")== true)
                 {
                     s.push("(");
                      continue;
                 }
                  if(dana.equals(")")==true)
                 {
                     while(s.top().equals("(")== false)
                     {
                         wyjscie.add(s.top());
                         s.pop();
                     }
                     if (s.top().equals("(")== true)
                         s.pop();
                      continue;
                   
                 }
                  if(dana.equals("+") ==true)
                  {
                      while(dana.equals((String)s.top())==true || "*".equals((String)s.top())==true|| "/".equals((String)s.top())==true)
                      {
                          System.out.println("dupa");
                          wyjscie.add(s.top());
                          s.pop();
                      }
                      System.out.println("dodam do stosu");
                      s.push((String)dana);
                      continue;
                  }
                  
                   else if(dana.equals("-") ==true)
                  {
                      while(dana.equals((String)s.top())==true || "*".equals((String)s.top())==true || "/".equals((String)s.top())==true)
                      {
                          System.out.println("dupa");
                          wyjscie.add(s.top());
                          s.pop();
                      }
                      System.out.println("dodam do stosu");
                      s.push((String)dana);
                      continue;
                  }
                    else if(dana.equals("*") ==true || dana.equals("/") ==true)
                  {
                      while(dana.equals((String)s.top())==true )
                      {
                          System.out.println("dupa");
                          wyjscie.add(s.top());
                          s.pop();
                      }
                      System.out.println("dodam do stosu");
                      s.push((String)dana);
                      continue;
                  }
                        // jeśli niedopasowało stringa jako operator działania to dodaje jako symbol
                  else
                  {
                      wyjscie.add(dana);
                  }

             
        }
        // Jeśli skończą sie dane wejsciowe wgraj stos do tablicy wyjscie
        System.out.println("tutaj wyjscie");
        while(s.isempty()==false)
        {
            wyjscie.add(s.top());
            s.pop();
        }
        // wypisz wyjscie
          for(int i =0; i< wyjscie.size(); i++)
                      System.out.print(wyjscie.get(i));
    }
    //##########################################
    // METODA OBLICZAJĄCA ROWNANIA Z PLIKU W NOTACJI POSTFIX
    // gdy plik nie zawiera licz tylko symbole program się zakonczy
    // Dzięki rzutowaniu na double oblicza rownież wyrażenia ułamkowe
    void obliczOnp()
    {
        double liczba1;
        double liczba2;
        
        
      
         
        for(int i =0; i < wejscie.size(); i++)
        {
            
            dana = (String) wejscie.get(i);
             System.out.println("tutaj");
             System.out.println(dana);
          
            if (dana.equals("+") == true || dana.equals("-")== true || dana.equals("*") == true || dana.equals("/")== true)
            {
                if(dana.equals("+"))
                {
                    System.out.println("konwertuje");
                    try{
                        // konwertuję stringa na double dzięki temu oblicza wyrazenia ułamkowe
                    liczba1 = (double)Double.parseDouble((String) s.top()); 
                    }catch (java.lang.NumberFormatException e){
                        liczba1 =0; 
                        System.out.println("Podałeś niewłasciwe dane wyłaczam program");
                        System.exit(0);
                    }
                    System.out.println("skonwertowlem");
                    s.pop();
                    liczba2 = (double)Double.parseDouble((String) s.top());
                    s.pop();
                    System.out.println("dodaje");
                    s.push(liczba2+liczba1);
                    continue;
                }
                if(dana.equals("-"))
                {
                    System.out.println("konwertuje");
                     try{
                    liczba1 = (double)Double.parseDouble((String) s.top());
                    }catch (java.lang.NumberFormatException e){
                        liczba1 =0; 
                        System.out.println("Podałeś niewłasciwe dane wyłaczam program");
                        System.exit(0);
                    }
                    System.out.println("skonwertowlem");
                    s.pop();
                    liczba2 = (double)Double.parseDouble((String) s.top());
                    s.pop();
                    System.out.println("dodaje");
                    s.push(liczba2-liczba1);
                    continue;
                }
                if(dana.equals("*"))
                {
                    System.out.println("konwertuje");
                     try{
                    liczba1 = (double)Double.parseDouble((String) s.top());
                    }catch (java.lang.NumberFormatException e){
                        liczba1 =0; 
                        System.out.println("Podałeś niewłasciwe dane wyłaczam program");
                        System.exit(0);
                    }
                    System.out.println("skonwertowlem");
                    s.pop();
                    liczba2 = (double)Double.parseDouble((String) s.top());
                    s.pop();
                    System.out.println("obliczam");
                    s.push(liczba2*liczba1);
                    System.out.println("obliczylem");
                    System.out.println("Gora stosu to" + s.top());
                    continue;
                }
                if(dana.equals("/"))
                {
                    System.out.println("konwertuje");
                     try{
                    liczba1 = (double)Double.parseDouble((String) s.top());
                    }catch (java.lang.NumberFormatException e){
                        liczba1 =0; 
                        System.out.println("Podałeś niewłasciwe dane wyłaczam program");
                        System.exit(0);
                    }
                    System.out.println("skonwertowlem");
                    s.pop();
                    liczba2 = (double)Double.parseDouble((String) s.top());
                    s.pop();
                    System.out.println("dodaje");
                    s.push(liczba2/liczba1);
                    continue;
                }
                    
            }
            // jeśli nie jest to operator działąnia dodaj na stos
             else
            {
                System.out.println("else");
                  s.push(dana);
                  continue;
            }       
        }
        // wypisz szczyt stosu czyli wynik
        System.out.println("WYnik to " + s.top());
        
    }
    void saveWynikiOnp() // metoda zapisująca wyniki postfix do pliku
    {
        
           File file = new File("Wyniki_ONP.txt");
         
            try {
                    Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF8"));
                    PrintWriter zapis = new PrintWriter(out);

                 
                    String tekst1;
                    
                    
                    tekst1 =   (String) s.top();
                    zapis.write(tekst1);
                    
                    String tekst2;
                    tekst2 = "\r\n";
//                       
                    zapis.write(tekst2);
                    zapis.close();

            } catch (IOException e) {
                    e.printStackTrace();
            }
    }
     void save() // metoda zapisująca konwersje znotacji infix na postix
    {
        
           File file = new File("Odwrotna notacja Polska.txt");
         
            try {
                    Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF8"));
                    PrintWriter zapis = new PrintWriter(out);

                 
                    String tekst1;
                    for(int i=0; i<wyjscie.size(); i++)
                    {
                    tekst1 = (String) wyjscie.get(i) + " ";
                    zapis.write(tekst1);
                    }
                    String tekst2;
                    tekst2 = "\r\n";
//                        String wynik1 = "Wyniki z przebiegu doświadczenia.\r\n" + wynik + ".\r\n";
                    zapis.write(tekst2);
                    zapis.close();

            } catch (IOException e) {
                    e.printStackTrace();
            }
    }
     
         public void DeleteFile(String path) // metoda usuwająca pliki resetowania doswiadczenia
{
    try{

        File file = new File(path);

        if(file.delete()){
            System.out.println(file.getName() + " zostal skasowany!");
        }else{
            System.out.println("Operacja kasowania sie nie powiodla.");
        }

    }catch(Exception e){

        e.printStackTrace();

    }
}
    
    
    
    
   
}
