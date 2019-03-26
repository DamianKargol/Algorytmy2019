/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laborki02;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

/**
 *
 * @author Lenovo
 */
class ShellSort {
    int tablica[];
    int przestawiam = 0;
    long start;
long stop;
    public ShellSort(int _tablica[]) 
    {
        tablica = _tablica;
    }
    
    // Wyznaczamy wartość początkowego przesunięcia
public void shellsort()
{
   int h,i,j,x;
   int N = tablica.length;
  for(h = 1; h < N; h = 3 * h + 1);
  h /= 9;

// start sortowania
start = System.nanoTime();
  while(h>0)
  {
    for(j = N - h - 1; j >= 0; j--)
    {
      x = tablica[j];
      i = j + h;
      while((i < N) && (x > tablica[i]))
      {
        tablica[i - h] = tablica[i];
        
        i += h;
      }
      tablica[i - h] = x; 
      przestawiam++;
    }
    h /= 3;
  }
  stop = System.nanoTime();
}
public void time()
    {
        long czas = stop - start;
        System.out.println("czas wykonania ShellSort " + czas +" nanosekundy");
         File file = new File("Czas_ShellSort.txt");
        try {
                    Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF8"));
                    PrintWriter zapis = new PrintWriter(out);

                    String tekst = czas + " , " + tablica.length + "\r\n";
                    zapis.write(tekst);

                    zapis.close();

            } catch (IOException e) {
                    e.printStackTrace();
            }
    }
    public void get() // wyświetl tablice
    {
        System.out.println("");
        System.out.println("Tablica po posortowaniu:");
        for(int i=0; i<tablica.length; i++)
        System.out.print(tablica[i]+" "); 
        System.out.println("");
        System.out.println("Przestawienia " + przestawiam);
    }
        public void save()
    {
        
           File file = new File("Tablice.txt");
         
            try {
                    Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF8"));
                    PrintWriter zapis = new PrintWriter(out);

                    String tekst ="tablica po posortowaniu Shell Sort "  +"Przestawień = " + przestawiam + ".\r\n";
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
}
