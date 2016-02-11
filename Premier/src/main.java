import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        for (int i = 0; i < n; i++){
            int nombre = scan.nextInt();

            System.out.println(verificationParfait(nombre) + " " +
                    verificationTriangle(nombre) + " " +
                    verificationCube(nombre) + " " +
                    verificationKapri10(nombre) + " " +
                    verificationKapri2(nombre));

        }


    }

    private static int verificationKapri10(int nombre) {

        int nombreCarre = nombre*nombre;

        if(nombreCarre < 10){
            return 0;
        }

        String nombreStr = Integer.toString(nombreCarre);
        String[]tab = nombreStr.split("");
        String[]tab2 = new String[tab.length-1];

        for(int i = 1; i< tab.length; i++){
            tab2[i-1] = tab[i];
        }

        for (int longueur = 1; longueur < tab2.length; longueur++) {

            String gauche = "";
            String droite = "";

            for (int i = 0; i < longueur; i++) {
                gauche += tab2[i];
            }

            for (int i = longueur; i < tab2.length; i++) {
                droite += tab2[i];
            }

            int nbgauche = Integer.parseInt(gauche);
            int nbdroite = Integer.parseInt(droite);

            int somme = nbdroite + nbgauche;


            if(somme == nombre){
                return 1;
            }

        }

            return 0;

    }

    private static int verificationKapri2(int nombre) {

        if(nombre%2 == 0 && verificationParfait(nombre) == 1){
            return 1;
        }

        return 0;

    }

    private static int verificationCube(int nombre) {
        int i = 1;
        int somme = 0;

        while(somme < nombre){
            somme += (i*i*i);
            i+=2;
        }

        if(somme == nombre){
            return 1;
        }else{
            return 0;
        }

    }

    private static int verificationTriangle(int nombre) {
        int i = 1;
        int somme = 0;

        while(somme < nombre){
            somme += i;
            i++;
        }

        if(somme == nombre){
            return 1;
        }else{
            return 0;
        }

    }

    private static int verificationParfait(int nombre) {
        int somme = 0;

        for (int i = nombre/2; i > 0; i--) {
            if(nombre%i == 0){
                somme = somme+i;
            }
        }

        if(somme == nombre){
            return 1;
        }else{
            return 0;
        }

    }

}
