package laborki02;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Random;
import laborki02.QuickSort;

/*
 *Klasa odpowiedzialna za stworzenie randomowej tablicy do maksymalnej wielkosci danych podanych w zadaniu
 *Zapis stworzonej tablicy do plikub 

/**
 *
 * @author Lenovo
 */
public class MakeTab {
int tablica[];

    // Konstruktor klasy tworzący randomową tablice i zapisujący ją do pliku txt
    public MakeTab(int n)
    {
        tablica = new int[n];
        Random random = new Random(); // uzycie klasy random
        for(int i = 0; i < tablica.length; i++) // wypelnienie tablicy danymi
        tablica[i] = (int) random.nextInt(1000000);// dane z podanego zakresu
        //############################################
        // zapis tablicy do pliku
        // kolejne zapisy do pliku analogicznie, brak czasu na metode ogolną
        // ###########################################
         File file = new File("Tablice.txt");
         
            try {
                    Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF8"));
                    PrintWriter zapis = new PrintWriter(out);

                    String tekst = ".\r\n" + "Tablica o dlugości =  " + n + ".\r\n"
                            + "tablica przed posortowaniem " + ".\r\n";
                    zapis.write(tekst);
                    String tekst1 = "";
                    for(int i=0; i<tablica.length; i++)
                    {
                    tekst1 = " " + tablica[i];
                    zapis.write(tekst1);
                    }
                    String tekst2;
                    tekst2 = ".\r\n";
//                        String wynik1 = "Wyniki z przebiegu doświadczenia.\r\n" + wynik + ".\r\n";
                    
                  
                    zapis.write(tekst2);
                    zapis.close();

            } catch (IOException e) {
                    e.printStackTrace();
            }
 
       
    }   public void reset() // klasa resetująca tablice 
        {   
                    Random random = new Random();
        for(int i = 0; i < tablica.length; i++)
        tablica[i] = (int) random.nextInt(1000000);
         File file = new File("Tablice.txt");
         
            try {
                    Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF8"));
                    PrintWriter zapis = new PrintWriter(out);

                    String tekst = ".\r\n" + "Tablica o dlugości =  " + tablica.length + ".\r\n"
                            + "tablica przed posortowaniem " + ".\r\n";
                    zapis.write(tekst);
                    String tekst1 = "";
                    for(int i=0; i<tablica.length; i++)
                    {
                    tekst1 = " " + tablica[i];
                    zapis.write(tekst1);
                    }
                    String tekst2;
                    tekst2 = ".\r\n";
//                        String wynik1 = "Wyniki z przebiegu doświadczenia.\r\n" + wynik + ".\r\n";
                    
                  
                    zapis.write(tekst2);
                    zapis.close();

            } catch (IOException e) {
                    e.printStackTrace();
            }

        }
        public void save() // metoda zapisująca tablice po posortowaniu
    {
        
           File file = new File("Tablice.txt");
         
            try {
                    Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF8"));
                    PrintWriter zapis = new PrintWriter(out);

                    String tekst ="tablica po posortowaniu " + ".\r\n";
                    zapis.write(tekst);
                    String tekst1 = "";
                    for(int i=0; i<tablica.length; i++)
                    {
                    tekst1 = " " + tablica[i];
                    zapis.write(tekst1);
                    }
                    String tekst2;
                    tekst2 = ".\r\n";
//                        String wynik1 = "Wyniki z przebiegu doświadczenia.\r\n" + wynik + ".\r\n";
                    zapis.write(tekst2);
                    zapis.close();

            } catch (IOException e) {
                    e.printStackTrace();
            }
    }
}
