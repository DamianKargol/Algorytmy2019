/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablicahash;

import java.awt.Container;
import java.awt.FileDialog;
import java.awt.Frame;
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
import javax.swing.JFrame;

/** Podstawowa Klasa haszuj z podstawowymi metodami służaca do dziediczenia przez kolejne klasy
 *
 * 
 */
public class haszuj extends JFrame{
    String tabHasz[] = new String [20000];
    int h,j; // zmienne przechowująca wartosc klucza haszującego
    int  wybor; // zmienna obsługująca wybór funkcji haszującej jeśli =1 działa 1 funkcja jesli =2 działa 2 funkcja 
    String slowo;
   int zliczam=0;
    public ArrayList<String> slownik = new ArrayList<String>();
    // Konstruktor wczytująca plik txt z okna dialogowego do arraylisty
    haszuj() throws FileNotFoundException 
    {
        Frame a = new Frame ("Okno wyboru pliku");
        a.setBounds(20,20,400,500);
       
       
        FileDialog fd =new FileDialog(a,"Wczytaj",FileDialog.LOAD);
        // Ewentualnie: FileDialog fd =new FileDialog(a,"Zapisz",FileDialog.SAVE);
        fd.setVisible(true);
        
        String katalog=fd.getDirectory();
        String plik=fd.getFile();
        System.out.println("Wybrano plik: " + plik);
        System.out.println("w katalogu: "+ katalog);
System.out.println("Ścieżka: "+ katalog + plik);
//       super("Statystyka");
//        this.setBounds(400, 400, 400, 400);
//        this.setDefaultCloseOperation(3); // wylacza ramke gdy X
//        Container kontener = this.getContentPane(); // panel przechowujacy przyciski wyswietlenia itp
//        
//
//         FileDialog fd =new FileDialog(this,"Wczytaj",FileDialog.LOAD);
//       // Ewentualnie: FileDialog fd =new FileDialog(a,"Zapisz",FileDialog.SAVE);
//         fd.setVisible(true);
//         
//         String katalog=fd.getDirectory();
//         String plik=fd.getFile();
//         System.out.println("Wybrano plik: " + plik);
//         System.out.println("w katalogu: "+ katalog);
//         System.out.println("Ścieżka: "+ katalog + plik);
              File plikWygrane = new File(plik);
        Scanner odczyt = new Scanner(plikWygrane);
        
        // Pętla wczytująca slowa do arrayListy
        while (odczyt.hasNextLine()) // petla while bedzie sie wykonywac do konca pliku
        {
            slownik.add(odczyt.nextLine());
                      
        }
        
                  // Zerujemy tablicę haszowaną
            for(int i = 0; i < tabHasz.length; i++) 
                tabHasz[i] = "";
    }  //  koniec wczytaj slownik
    
    // metoda czyszcząca tablice rozproszoną
    void wyczyscHaszTab()
    {
        // Zerujemy tablicę haszowaną
            for(int i = 0; i < tabHasz.length; i++) 
                tabHasz[i] = "";
    }
    int Hasz1(String slowo) // 1 funkcja z zadania
    {
        h=0;
        for(int i=0; i < slowo.length(); i++)
        h +=( int ) slowo.charAt(i);
        return h % tabHasz.length;
    }
    int Hasz2(String slowo) // 2 funkcja z zadania
    {
        h= 5381;
        for(int i=0; i < slowo.length(); i++)
          h = ((h*33) + ( int ) slowo.charAt(i))% tabHasz.length;
        return  h % tabHasz.length;
    }
  
    //metoda wyboru z obsługa wyjątków 
    int wybor(int n) 
    {
        Scanner odczyt = new Scanner(System.in);
        do{
            try{
            n = odczyt.nextInt(); // zmienna do obslugi menu
            if(n==1 || n==2) break;
        }catch(java.util.InputMismatchException e){
            
            odczyt.nextLine();
        }
            System.out.println("błąd podaj poprawne wartości");
        }while(n!=1 || n!=2);
            return n;
    }
    //######################################
    // Metoda tworząca tablice haszującą
    // tworzą ją zapomcą wcześniej wybranego słownika z pliku ktore jest zapisany do tablicy dynamicznej 
    void makeHaszTab (ArrayList slownik)
    {
        System.out.println("której funkcji użyć hasz1 - 1 czy hasz2 - 2");
        wybor = wybor(3); // przypisanie zmiennej wybór ktora ustala nam na jakiej funkcji haszującej będziemy operować 

         // zaczynamy wypełnianie tablicy
         for(int i = 0; i < slownik.size(); i++)
         {
            slowo = (String) slownik.get(i);
            if(wybor ==1)
            h = Hasz1(slowo);
            if(wybor==2)
            h= Hasz2(slowo);    
//            System.out.println("wynik klucza to " + h );
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
              j = (j + 1) % tabHasz.length; // sondowanie liniowe
              if(j == h) break;
            }
         }
        

    }// koniec makeHaszTab
    
    // metoda dodająca pojedyncze słowo do obecnej tablicy haszującej ma zapamiętany wybor funkcji haszującej
        void setHaszTab(String tekst)
    {
            zliczam =0;
            slowo = tekst;
            if(wybor ==1)
            h = Hasz1(slowo);
            if(wybor==2)
            h= Hasz2(slowo);
//            System.out.println("wynik klucza to " +h);
            j = h;
//            System.out.println("slowo do wstawienia to " +tekst);
            while(true)
            {
              if(tabHasz[j] == "")
              {
//                  System.out.println("Wstawiam do indeksu " +j + "ilosc petli " + zliczam);
                tabHasz[j] = tekst;
                break;
              }
              if(tabHasz[j].equals(tekst) == true)
              { 
                  System.out.println("Wykryto duplikat");
                  break;
              }
                ;
              j = (j + 1) % tabHasz.length;
              if(j == h) break;
              zliczam++;
            }
    }
        // metodą pokazująca indeks wskazanego pojedynczego slowa
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

              j = (j + 1) % tabHasz.length;
              if(j == h) break;
              ilosPetliWhile++;
            }
        }
        
        // metoda pomoniczna pokazująca slowo w zadanym indeksie
        void getIndek(int n)
        {
            System.out.println("pozycja na danym ideksie to " + tabHasz[n]);
        }
        
        // metoda usuwające plik z tablicą haszującą 
     public void DeleteFile(String path) // metoda usuwająca plik 
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
     void pokazTabHasz()
     {
         for(int i =0; i< tabHasz.length; i++)
         System.out.println(tabHasz[i]);
     }
     // metoda zapisujaca nową tablice haszującą 
    void SaveHasztab()
    {
        
                   File file = new File("Slownik_zDostepemRozproszonym.txt");
         
            try {
                    Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF8"));
                    PrintWriter zapis = new PrintWriter(out);
                    String tekst1;
                    for(int i=0; i<tabHasz.length; i++)
                    {
                    tekst1 =tabHasz[i] +  "\r\n";
                    zapis.write(tekst1);
                    }

                    zapis.close();

            } catch (IOException e) {
                    e.printStackTrace();
            }
    }
}
