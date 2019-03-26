/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laborki02;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/** Klasa tworząca wykres z przeprowadzonych doświadczeń
 * dane odzielone przecinkami pobiera z pliku
 * 
 */
public class Wykres1 {
    
        public void Wykres1(String metoda,String metoda2,String metoda3) throws FileNotFoundException, IOException
                
    {
   
    ////////////////// otworzenie pliku txt/////////////////////////////////////
        File plik = new File("Czas_QuickSort.txt");
        Scanner odczyt = new Scanner(plik);
        //////////////   Potrzebne tablice dynamiczne do zapisu danych z pliku 
        ArrayList<Integer> tabTime = new ArrayList<Integer>();
         ArrayList<Integer> tabSize = new ArrayList<Integer>();
         // Wczytywanie danych do tablic
        while (odczyt.hasNextInt()) // petla while bedzie sie wykonywac do konca pliku
        {
            tabTime.add(odczyt.nextInt());
            odczyt.findInLine(" , ");
            tabSize.add(odczyt.nextInt());
        }
            //##############################################################
            // Rozpoczęcie tworzenia wykresu za pomocą biblioteki JfreeChart////
            //##############################################################
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int c=2; //zmienna do obslugi tworzenia wykresu
        int x,y; // zmienne do porownywania tablic
        String pomiar = "pomiar" ;
        //#########################################################
        ////////////////  Pętla wczytująca dane do wykresu //////////
        //##########################################################
        for(int i =0; i< tabTime.size(); i++)
        {
            if(i>=1) //1 warunek
            {
                    //  Przypisanie elementow do zmiennych
                x = (int)tabSize.get(i);
                y = (int)tabSize.get(i-1);
                if(x==y) // jeśli wielkość tablicy ta sama zapisz ją jako kolejny pomiar
                {
                    pomiar = pomiar + tabSize.get(i);
                    dataset.setValue(tabTime.get(i), metoda, tabSize.get(i) + "pomiar"  +c);
//                    dataset.setValue(tabTime.get(i), metoda2, tabSize.get(i) + "pomiar"  +c);
                    c++; // licznik nabiję kolejny pomiar tej samej wielkości tablicy
                    continue; // przeskok o kolejną iteracje
                }
            }
            // wczytanie danych gdy wielkość tablicy jest inna 
            dataset.setValue(tabTime.get(i), metoda, tabSize.get(i));
            c=2; // zmienna resetuję się gdy zmieniono wielkość
            
        }
        //############################################
        // Reszta wczytywań analogicznie
        // brak czasu na zaimplementowanie metody aby nie powtarzać podonych linijek kodu
        //############################################
        odczyt.nextLine();
                File plik1 = new File("Czas_MergeSort.txt");
        odczyt = new Scanner(plik1);
        // usuwanie danych z talic aby ponowić instrukcje
        tabTime.removeAll(tabTime);
        tabSize.removeAll(tabSize);
        System.out.println("wielkosc tabTime " + tabTime.size());
        while (odczyt.hasNextInt()) // petla while bedzie sie wykonywac do konca pliku
        {
            tabTime.add(odczyt.nextInt());
            odczyt.findInLine(" , ");
            tabSize.add(odczyt.nextInt());
        }
        
        for(int i =0; i< tabTime.size(); i++)
        {
            if(i>=1)
            {

                x = (int)tabSize.get(i);
                y = (int)tabSize.get(i-1);
                if(x==y)
                {
                    pomiar = pomiar + tabSize.get(i);
                    dataset.setValue(tabTime.get(i), metoda2, tabSize.get(i) + "pomiar"  +c);
//                    dataset.setValue(tabTime.get(i), metoda2, tabSize.get(i) + "pomiar"  +c);
                    
                    c++;
                    continue;
                }
            }
            dataset.setValue(tabTime.get(i), metoda2, tabSize.get(i));
            c=2;
            
        }
                odczyt.nextLine();
                File plik3 = new File("Czas_ShellSort.txt");
        odczyt = new Scanner(plik3);
        tabTime.removeAll(tabTime);
        tabSize.removeAll(tabSize);
        System.out.println("wielkosc tabTime " + tabTime.size());
        while (odczyt.hasNextInt()) // petla while bedzie sie wykonywac do konca pliku
        {
            tabTime.add(odczyt.nextInt());
            odczyt.findInLine(" , ");
            tabSize.add(odczyt.nextInt());
        }
        
        for(int i =0; i< tabTime.size(); i++)
        {
            if(i>=1)
            {

                x = (int)tabSize.get(i);
                y = (int)tabSize.get(i-1);
                if(x==y)
                {
                    pomiar = pomiar + tabSize.get(i);
                    dataset.setValue(tabTime.get(i), metoda3, tabSize.get(i) + "pomiar"  +c);
//                    dataset.setValue(tabTime.get(i), metoda2, tabSize.get(i) + "pomiar"  +c);
                    
                    c++;
                    continue;
                }
            }
            dataset.setValue(tabTime.get(i), metoda3, tabSize.get(i));
            c=2;
            
        }
        JFreeChart chart = ChartFactory.createBarChart3D( "Wykres czasu w zaleznosci od wielkosci tablicy",
        "Tab Size", " Time nanoTime", dataset, PlotOrientation.VERTICAL, true, true, false );
        ChartFrame frame1=new ChartFrame("Wykreśik",chart);
        frame1.setVisible(true);
        frame1.setSize(500,400);
        frame1.setDefaultCloseOperation(1);
    }
    public void Wykres1(int wartosci, String rodzaj, String nazwa )
    {
        
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(6, rodzaj, nazwa);
        
        JFreeChart chart = ChartFactory.createBarChart3D( "Wykres typu Bar 3D",
        "X - Lable", "Y - Lable", dataset, PlotOrientation.VERTICAL, true, true, false );
        ChartFrame frame1=new ChartFrame("XYArea Chart",chart);
        frame1.setVisible(true);
        frame1.setSize(500,400);
    }


  
    

}

