/*
• Politechnika gdańska FTiMS
• Matematyka stosowana III rok
• Algorytmy i struktury danych
• Laboratorium 3: Stos i notacja postfix
• Damian Kargol
• 03.03.2019

 */
package laborki03stos;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class Laborki03Stos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
       int n;
         Scanner odczyt = new Scanner(System.in);
         onp p = new onp();
        System.out.println("Co chcesz zrobić");
        System.out.println("1 - jeśli chcesz usunąć poprzednie wyniki");
         n = odczyt.nextInt();
         if(n ==1)
         {
             p.DeleteFile("Wyniki_ONP.txt");
             p.DeleteFile("Odwrotna notacja Polska.txt");
         }
      
        
     
     while(true)
     {
          System.out.println("1 - zmienić plik z notacji infix na postfix");
        System.out.println("2 - Obliczyć wiersze pliku z notacją postfix");
         n = odczyt.nextInt(); 
         if(n==1)
         {
             p.ZmienPlikNaONP();
             
         }
         if(n==2)
         {
             System.out.println("Upewnij się czy w pliku 'Odwrotna notacja Polska' znajduję się poprawne rownania do obliczenia");
             p.wczytajOnp();
            
         }
         System.out.println("3 - wyjdz  | 1 - kontynuuj");
         n = odczyt.nextInt(); 
         if(n==3)
             System.exit(0);
     }

        
        

    }
    
}
