/*
• Politechnika gdańska FTiMS
• Matematyka stosowana III rok
• Algorytmy i struktury danych
• Laboratorium 2: Sortowanie
• Damian Kargol
• 03.03.2019
Niektóre metody z klasy Rekurencja zostały zainspirowane stroną Algorytmy.org
 */
package laborki02;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author Lenovo
 */
public class Laborki02 {



/**
* @param args
*/
public static void main(String[] args) throws FileNotFoundException, IOException {
    
    int n;
    int k=0;
    Scanner odczyt = new Scanner(System.in);
    System.out.println("Program sortujący tablice metodą Quicksort, MergeSort, ShellSort i wyświetlający czas działania na wykresie");
    while(true)
    {
        System.out.println("Podaj wielkosc tablicy");
    n = odczyt.nextInt();   
    MakeTab lista = new MakeTab(n);
    MergeSort sort = new MergeSort(lista.tablica);
    sort.mergesort(0, lista.tablica.length - 1);
    sort.time();
    sort.save();
    lista.reset();
    QuickSort quicksort = new QuickSort(lista.tablica);
    quicksort.quicksort(0, lista.tablica.length -1);
    quicksort.save();
    quicksort.time();
//    quicksort.DeleteFile("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\Laborki02\\Czas_QuickSort.txt");
   lista.reset();
   ShellSort shellsort = new ShellSort(lista.tablica);
   shellsort.shellsort();
   shellsort.time();
   shellsort.save();
   Wykres1 wykres = new Wykres1();
        System.out.println("Jeśli chcesz wygenerować wykres z przebiegu programu nacisnij");
        System.out.println("1 - narusuj wykres 2 - wyjdz 3 - skasuj przebieg");
        System.out.println("cokolwiek innego enter dalej xd");
        
             
        k = odczyt.nextInt(); // zmienna do obslugi menu 
    if(k==1)
        wykres.Wykres1("QuickSort","MergeSort","ShellSort");
    if(k==2)
        break;
    if(k==3)
    {
        quicksort.DeleteFile("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\Laborki02\\Czas_QuickSort.txt");
        quicksort.DeleteFile("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\Laborki02\\Czas_ShellSort.txt");
        quicksort.DeleteFile("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\Laborki02\\Czas_MergeSort.txt");
    }
    }
 
  



}
 
}