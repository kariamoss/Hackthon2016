import java.io.*;
import java.util.*;

/* UTILISATION :
   - Pour compiler : javac ToBits.java
   - Pour lancer le programme avec les fichiers de test fourni : 
       java ToBits <02_3values.in >result.txt

   - Ensuite vous pouvez comparer chaque résultat avec l'attendu :
      diff result.txt 02_3values.ans

    Si la commande n'affiche aucune différence, votre programme fonctionne à priori correctement et vous
    pouvez le soumettre.          

*/
class Value {

    byte[] bits;
    
    public Value(int value) {
	     bits = new byte[32];

	     for(int i=0;i<32;i++) 
          bits[i] = 0;

	     convertToBits(value);

       msb();
       nbOnes();
       
    }

    public void msb() {
      int i=0;
      while(i<32){
        if (bits[i]==1){
          System.out.print(32-i-1);
          return;
        }
        i++;
      }

    }

    public void nbOnes() {
     int  somme=0;
      for (int i = 0; i<32; i++){
        if(bits[i]==1){
          somme++;
        }
      }

      System.out.println(" " + somme);
    }


    private void convertToBits(int value) {	

      for(int i = 0; i < 32; i++) {
             
            if(value - Math.pow(2,31-i) > 0) {
                 
                bits[i] = 1;
                value -= Math.pow(2,31-i);
                 
            }
             
            else if(value - Math.pow(2,31-i) == 0) {
                 
                bits[i] = 1;
                break;
                 
            }
            // //Cette condition n'est pas obligatoire, le tableau de byte est rempli de 0 à la base.
            // else {
                 
            //     bits[i] = 0;
                 
            // }
             
        }

    }
  }

    
class ToBits {    

    public static void main(String[] args) 
    {
	     Locale.setDefault(Locale.ENGLISH);
	
	     Scanner scan = new Scanner(System.in);

       int nB = scan.nextInt();

       System.out.println(nB);

        int a;

       for (int i = 0; i< nB; i++){

          a = scan.nextInt();

          if (a>=1 && a<=(Math.pow(2, 32)-1)) {

            Value value = new Value(a);

          }
       }

	/* A COMPLETER
	   - lire le nombre de valeurs à traiter
	   - pour chaque valeur, la lire et instancier la classe Value
	   - utilser l'instance pour afficher la position du bit de
	   poids fort (à partir de 0) suivi  du nombre de bits à 1.
	 */
	}
    }

