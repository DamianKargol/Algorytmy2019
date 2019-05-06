/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablicahash;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class TablicaHash {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
//        haszuj slowa = new haszuj();
//        slowa.makeHaszTab(slowa.slownik);
//        Scanner odczyt = new Scanner(System.in);
//        String tekst = odczyt.nextLine();
//        slowa.setHaszTab(tekst);
//         Scanner odczyt1 = new Scanner(System.in);
//        String tekst1 = odczyt1.nextLine();
//        slowa.getHasztab(tekst1);
//        
//        slowa.getIndek(odczyt.nextInt());
//        
//        slowa.SaveHasztab();
        
//        podwojneRozpraszanie podwojne = new podwojneRozpraszanie();
//        podwojne.makeHaszTab(podwojne.slownik);
//        Scanner odczyt = new Scanner(System.in);
//        String tekst = odczyt.nextLine();
//        podwojne.setHaszTab(tekst);
//        Scanner odczyt1 = new Scanner(System.in);
//        String tekst1 = odczyt1.nextLine();
//        podwojne.getHasztab(tekst1);
        doswiadczenie d = new doswiadczenie();
        d.tabHaszSize(5000);
        d.test();
        d.Srednia();
        d.SaveHasztab();
    }
    
}
